/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import BD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import model.Administrador;
import model.Cajero;
import model.Medico;
import model.PacienteLLBN;
import model.Persona;
/**
 *
 * @author liliana B.
 */
public class PacienteController {
     private Conexion conexion;

    public PacienteController() {
        conexion = new Conexion();
    }
    
    //metodo para registrar el paciente
    public boolean registrarPaciente(PacienteLLBN paciente) {
        String sqldatos = "INSERT INTO Persona (cedula, nombre, apellido, rol, "
                + "edad, fechanac) VALUES (?, ?, ?, NULL, ?, ?)";
        Object[] paramsPersona = {paciente.getCi(), paciente.getNombre(), 
            paciente.getApellido(), paciente.getEdad(), java.sql.Date.valueOf(paciente.getFechanac())};

        String sqlPaciente = "INSERT INTO Paciente (cedula, direccion, correo, "
                + "celular) VALUES (?, ?, ?, ?)";
        Object[] paramsPaciente = {paciente.getCi(), paciente.getDirec(),
            paciente.getCorreo(), paciente.getcel()};

        try {
            int resultdatos = conexion.ejecutarActualizacionP(sqldatos, paramsPersona);
            if (resultdatos > 0) {
                int resultPaciente = conexion.ejecutarActualizacionP(sqlPaciente, paramsPaciente);
                return resultPaciente > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //merodo para buscar pacienre
     public PacienteLLBN buscarPacientePorCedula(String cedula) {
        PacienteLLBN paciente = null;
        String sql = "SELECT p.cedula, p.nombre, p.apellido, p.edad, pa.direccion, pa.correo, pa.celular " +
                     "FROM Persona p JOIN Paciente pa ON p.cedula = pa.cedula " +
                     "WHERE p.cedula = ?";
        
        try {
            Object[] params = {cedula};
            ResultSet rs = conexion.ejecutarConsulta(sql, params);
            
            if (rs.next()) {
                paciente = new PacienteLLBN();
                paciente.setCi(rs.getString("cedula"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setDirec(rs.getString("direccion"));
                paciente.setCorreo(rs.getString("correo"));
                paciente.setcel(rs.getString("celular"));
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
        
        return paciente;
    }
    
    
}
