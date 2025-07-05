/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BD.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.AtencionMedica;
import model.Especialidad;
import model.Farmacos;
import model.HistorialPaciente;
import model.Medico;
import model.PacienteLLBN;
import model.Receta;


public class MedicoController {
     private Conexion conexion;
      private Map<String, Especialidad> especialidadesMap;
    private Map<String, Medico> medicosMap;
    
     public MedicoController() {
        conexion = new Conexion();
        especialidadesMap = new HashMap<>();
        medicosMap = new HashMap<>();
    }
     
    //obtener las especialidades
    public List<Especialidad> obtenerEspecialidades() {
        List<Especialidad> especialidades = new ArrayList<>();
        String sql = "SELECT * FROM Especialidad";
        try {
            ResultSet rs = conexion.ejecutarConsulta(sql, new Object[]{});
            while (rs.next()) {
                Especialidad especialidad = new Especialidad(
                    rs.getInt("id_especialidad"),
                    rs.getString("nombre"),
                    rs.getInt("numero_consultorio"),
                    rs.getDouble("valor_especialidad")
                );
                especialidades.add(especialidad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return especialidades;
    }

    
         //obtener medico segun especialidad
    public List<Medico> obtenerMedicosPorEspecialidad(int especialidadId) {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT m.id_medico, p.nombre, p.apellido, p.cedula, p.edad, p.fechanac, e.id_especialidad, e.nombre AS nombre_especialidad, e.numero_consultorio, e.valor_especialidad " +
                     "FROM Medico m " +
                     "JOIN Persona p ON m.cedula = p.cedula " +
                     "JOIN Especialidad e ON m.especialidad_id = e.id_especialidad " +
                     "WHERE e.id_especialidad = ?";
        try {
            ResultSet rs = conexion.ejecutarConsulta(sql, new Object[]{especialidadId});
            while (rs.next()) {
                Especialidad especialidad = new Especialidad(
                    rs.getInt("id_especialidad"),
                    rs.getString("nombre_especialidad"),
                    rs.getInt("numero_consultorio"),
                    rs.getDouble("valor_especialidad")
                );

                Medico medico = new Medico(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("cedula"),
                    rs.getInt("edad"),
                    rs.getDate("fechanac").toLocalDate(),
                    rs.getInt("id_medico"),
                    especialidad
                );
                medicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return medicos;
    }
        //llenar cobo de los nombres de especidades medicas
      public void llenarComboEspecialidades(JComboBox<String> combo) {
        combo.removeAllItems();
        especialidadesMap.clear();
        List<Especialidad> especialidades = obtenerEspecialidades();
        for (Especialidad especialidad : especialidades) {
            String item = especialidad.getNombre();
            combo.addItem(item);
            especialidadesMap.put(item, especialidad);
        }
    }

      //llenar como de nombres de medicos
    public void llenarComboMedicosPorEspecialidad(JComboBox<String> combo, String nombreEspecialidad) {
        combo.removeAllItems();
        medicosMap.clear();
        Especialidad especialidad = especialidadesMap.get(nombreEspecialidad);
        if (especialidad != null) {
            List<Medico> medicos = obtenerMedicosPorEspecialidad(especialidad.getId_especialidad());
            for (Medico medico : medicos) {
                String item = medico.getNombre() + " " + medico.getApellido() + " (Consultorio#: " + medico.getId_medico() + ")";
                combo.addItem(item);
                medicosMap.put(item, medico);
            }

            // Agregar mensaje de depuración
            System.out.println("Médicos encontrados para " + nombreEspecialidad + ": " + medicos.size());
        } else {
            System.out.println("No se encontró la especialidad: " + nombreEspecialidad);
        }
    }

    public Especialidad getEspecialidadSeleccionada(String nombreEspecialidad) {
        return especialidadesMap.get(nombreEspecialidad);
    }

    public Medico getMedicoSeleccionado(String nombreCompletoMedico) {
        return medicosMap.get(nombreCompletoMedico);
    }

    //Rregistrar la atencion medica
       public boolean registrarAtencionMedica(AtencionMedica atencion) {
        String sql = "INSERT INTO atencion_medica (paciente_ci, medico_ci, fecha_atencion, sintomas,  diagnostico) VALUES (?, ?, ?, ?, ?)";
        Object[] params = {
            atencion.getPaciente().getCi(),
            atencion.getMedico().getCi(),
            java.sql.Date.valueOf(atencion.getFecha_atencion()),
            atencion.getSintomas(),
            atencion.getDiagnostico()
        };
        
        try {
            int filasAfectadas = conexion.ejecutarActualizacionP(sql, params);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
       
    //agregar medicamento en la receta
     public boolean registrarReceta(Receta receta, int idAtencion) {
          if (receta.getFarmaco() != null) {
         // Registrar con farmaco_id
            String sql = "INSERT INTO receta (id_atencion, farmaco_id,medicamento ,unidades, dosis, dias) VALUES (?, ?,?, ?, ?, ?)";
            Object[] params = {
                idAtencion,
                receta.getFarmaco().getIdFarmaco(),
                receta.getMedicamento(),
                receta.getUnidades(),
                receta.getDosis(),
                receta.getDias()
            };

            try {
                int filasAfectadas = conexion.ejecutarActualizacionP(sql, params);
                return filasAfectadas > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
             }
        } else {
            // Registrar solo con medicamento
            if (receta.getMedicamento() == null || receta.getMedicamento().isEmpty()) {
                throw new IllegalArgumentException("Medicamento no puede ser null o vacío cuando farmaco es null");
            }

            String sql = "INSERT INTO receta (id_atencion, medicamento, unidades, dosis, dias) VALUES (?, ?, ?, ?, ?)";
            Object[] params = {
                idAtencion,
                receta.getMedicamento(),
                receta.getUnidades(),
                receta.getDosis(),
                receta.getDias()
            };

            try {
                int filasAfectadas = conexion.ejecutarActualizacionP(sql, params);
                return filasAfectadas > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
     
     public int obtenerUltimoIdAtencion() {
        String sql = "SELECT MAX(id_atencion) AS last_id FROM atencion_medica";
        try {
            ResultSet rs = conexion.ejecutarConsulta(sql, new Object[]{});
            if (rs.next()) {
                return rs.getInt("last_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
     
     //obtener nombre del medicamento  
     public Farmacos buscarFarmacoPorNombre(String nombre) {
            String sql = "SELECT * FROM Farmaco WHERE nombre_medicamento = ?";
        Object[] params = { nombre };

        try {
            ResultSet rs = conexion.ejecutarConsulta(sql, params);
            if (rs.next()) {
                int id_farmaco = rs.getInt("id_farmaco");
                String nombre_medicamento = rs.getString("nombre_medicamento");
                String cantidad = rs.getString("cantidad");
                String presentacion = rs.getString("presentacion");
                String descripcion = rs.getString("descripcion");
                return new Farmacos(id_farmaco, nombre_medicamento, cantidad, presentacion, descripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
     
     //historial de atenciones del paciente
    public HistorialPaciente obtenerHistorialAtenciones(String cedula) {
          HistorialPaciente historial = null;
          List<AtencionMedica> atenciones = new ArrayList<>();

          String sql = "SELECT p.cedula, p.nombre, p.apellido, p.edad, pa.direccion, pa.correo, pa.celular, " +
                       "am.id_atencion, am.fecha_atencion, am.diagnostico, am.sintomas,  " +
                       "m.cedula AS medico_cedula, pm.nombre AS medico_nombre, pm.apellido AS medico_apellido, " +
                       "e.nombre AS especialidad_nombre " +
                       "FROM Persona p " +
                       "JOIN Paciente pa ON p.cedula = pa.cedula " +
                       "LEFT JOIN atencion_medica am ON p.cedula = am.paciente_ci " +
                       "LEFT JOIN Medico m ON am.medico_ci = m.cedula " +
                       "LEFT JOIN Persona pm ON m.cedula = pm.cedula " +
                       "LEFT JOIN Especialidad e ON m.especialidad_id = e.id_especialidad " +
                       "WHERE p.cedula = ? " +
                       "ORDER BY am.fecha_atencion DESC";

          try {
              ResultSet rs = conexion.ejecutarConsulta(sql, new Object[]{cedula});
              boolean primerRegistro = true;

              while (rs.next()) {
                  if (primerRegistro) {
                      PacienteLLBN paciente = new PacienteLLBN(
                             rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getInt("edad"),
                            rs.getString("cedula"),
                            rs.getString("celular"),
                            rs.getString("direccion"),
                            rs.getString("correo"),
                            null // Asumiendo que la fecha de nacimiento no es necesaria aquí
                      );                

                      historial = new HistorialPaciente(paciente);
                      primerRegistro = false;
                  }

                  if (rs.getInt("id_atencion") != 0) {  // Verificar si hay una atención médica
                      Especialidad especialidad = new Especialidad(rs.getString("especialidad_nombre"));

                      Medico medico = new Medico(
                          rs.getString("medico_nombre"),
                          rs.getString("medico_apellido"),
                          rs.getString("medico_cedula"),
                          0,  // Edad no se usa aquí
                          null,  // Fecha de nacimiento no se usa aquí
                          0,  // ID de médico no se usa aquí
                          especialidad
                      );

                      AtencionMedica atencion = new AtencionMedica(
                         
                          null,  // Paciente no es necesario aquí
                          medico,
                          rs.getDate("fecha_atencion").toLocalDate(),
                          rs.getString("sintomas"),
                          rs.getString("diagnostico")
                      );
                      atenciones.add(atencion);
                  }
              }

              if (historial != null) {
                  historial.setAtenciones(atenciones);
              }

          } catch (SQLException e) {
              e.printStackTrace();
          }

          return historial;
      }
}

