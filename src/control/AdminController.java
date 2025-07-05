/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.sql.ResultSet;
import java.sql.SQLException;

import BD.Conexion;
import java.util.ArrayList;
import java.util.List;
import model.Especialidad;
import model.Farmacos;
import model.Medico;

/**
 *
 * @author liliana B.
 */
public class AdminController {
      private Conexion conexion;
    
     public AdminController() {
        conexion = new Conexion();
    }
    
     //BUSCAR MEDICOS POR CEDULA
     public Medico buscarMedicoPorCedula(String cedula) {
    Medico medico = null;
    String sql = "SELECT p.nombre, p.apellido, p.edad " +
                 "FROM Persona p " +
                 "WHERE p.cedula = ? AND p.rol = 'medico'";

    try {
        Object[] params = {cedula};
        ResultSet rs = conexion.ejecutarConsulta(sql, params);

        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int edad = rs.getInt("edad");

            //bjeto Medico con los datos obtenidos
            medico = new Medico(nombre, apellido, cedula, edad, null); 
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

    return medico;
}
 
     //ASIGNAR ESPECIALIDAD AL MEDICO
  public boolean asignarEspecialidad(Medico medico) {
        String sql = "INSERT INTO Medico (cedula, especialidad_id) VALUES (?, ?)";

        try {
            Object[] params = {
                medico.getCi(), 
                medico.getEspecialidad().getId_especialidad()
            };

            int result = conexion.ejecutarActualizacionP(sql, params);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
  
    //REGISTRAR NUEVA ESPECIALIDAD 
        public boolean registrarEspecialidad(Especialidad especialidad) {
        String sql = "INSERT INTO Especialidad (nombre, numero_consultorio,"
                + " valor_especialidad) VALUES (?, ?, ?)";
        try {
            Object[] params = {
                especialidad.getNombre(),
                especialidad.getNumero_consultorio(),
                especialidad.getValor_especialidad()
            };

            int result = conexion.ejecutarActualizacionP(sql, params);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        
      //registrar medicmentos
         public boolean registrarFarmaco(Farmacos farmaco) {
        String sql = "INSERT INTO Farmaco (nombre_medicamento, cantidad,"
                + " presentacion, descripcion) VALUES (?, ?, ?, ?)";
        try {
            Object[] params = {
                farmaco.getNombreMedicamento(),
                farmaco.getCantidad(),
                farmaco.getPresentacion(),
                farmaco.getDescripcion()
            };
            int result = conexion.ejecutarActualizacionP(sql, params);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

      //lisrar medicamentos
      public List<String> listarNombresFarmacos() {
        List<String> nombres = new ArrayList<>();
        String sql = "SELECT nombre_medicamento FROM Farmaco";
        try {
            ResultSet rs = conexion.ejecutarConsulta(sql);
            while (rs.next()) {
                nombres.add(rs.getString("nombre_medicamento"));
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
        return nombres;
    }
}
