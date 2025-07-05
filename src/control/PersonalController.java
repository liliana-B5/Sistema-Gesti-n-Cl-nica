
package control;
import BD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Administrador;
import model.Cajero;
import model.Medico;
import model.PacienteLLBN;
import model.Persona;

public class PersonalController {
  
    private Conexion conexion;

    public PersonalController() {
        conexion = new Conexion();
    }

    //metodo para registrar el personal
    public boolean registrarPersona(Persona persona) {
        String sql = "INSERT INTO Persona (cedula, nombre, apellido, rol, edad, "
                + "fechanac) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] params = {persona.getCi(), persona.getNombre(), 
            persona.getApellido(), persona.getRol(), persona.getEdad(), 
            java.sql.Date.valueOf(persona.getFechanac())};
        try {
            int result = conexion.ejecutarActualizacionP(sql, params);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //metodo para registrar el usaurio del personal
    public boolean registrarUsuario(String cedula, String contrasena) {
        String sql = "INSERT INTO Usuario (cedula, contrasena) VALUES (?, ?)";
        Object[] params = {cedula, contrasena};
        try {
            int result = conexion.ejecutarActualizacionP(sql, params);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    //metodo para el login
     public Persona verificarCredenciales(String cedula, String contrasena) {
        String sql = "SELECT p.* FROM Persona p JOIN Usuario u ON p.cedula = u.cedula"
                + " WHERE p.cedula = ? AND u.contrasena = ?";
        try {
            Object[] params = {cedula, contrasena};
            ResultSet rs = conexion.ejecutarConsulta(sql, params);
            if (rs.next()) {
                String rol = rs.getString("rol");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                LocalDate fechanac = rs.getDate("fechanac").toLocalDate();
                
                System.out.println("Rol encontrado: " + rol); 
                switch (rol.toLowerCase()) {
                    case "administrador":
                        return new Administrador(nombre, apellido, cedula, edad, fechanac);
                    case "cajero":
                        return new Cajero(nombre, apellido, cedula, edad, fechanac);
                    case "medico":
                        return new Medico(nombre, apellido, cedula, edad, fechanac);
                    default:
                        return null;
                }
            }else {
                System.out.println("No se encontró el usuario con las credenciales proporcionadas.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     
    
     
      // Método para obtener las personas por rol
    public  List<Persona> obtenerPersonasPorRol(String rol) {
        String sql = "SELECT * FROM Persona WHERE rol = ?";
        List<Persona> personas = new ArrayList<>();
        try {
            Object[] params = {rol};
            ResultSet rs = conexion.ejecutarConsulta(sql, params);
            while (rs.next()) {
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                LocalDate fechanac = rs.getDate("fechanac").toLocalDate();

                switch (rol.toLowerCase()) {
                    case "administrador":
                        personas.add(new Administrador(nombre, apellido, cedula, 
                                edad, fechanac));
                        break;
                    case "cajero":
                        personas.add(new Cajero(nombre, apellido, cedula,
                                edad, fechanac));
                        break;
                    case "medico":
                        personas.add(new Medico(nombre, apellido, cedula,
                                edad, fechanac));
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    // Métodos específicos para cada rol
    public List<Persona> obtenerAdministradores() {
        return obtenerPersonasPorRol("administrador");
    }

    public List<Persona> obtenerCajeros() {
        return obtenerPersonasPorRol("cajero");
    }

    public List<Persona> obtenerMedicos() {
        return obtenerPersonasPorRol("medico");
    }

    public boolean actualizarPersona(Persona persona) {
        String sql = "UPDATE Persona SET nombre = ?, apellido = ?,"
                + " edad = ?, fechanac = ? WHERE cedula = ?";
        boolean actualizado = false;

        try {
            // parámetros de la consulta
            Object[] params = {
                persona.getNombre(),
                persona.getApellido(),
                persona.getEdad(),
                java.sql.Date.valueOf(persona.getFechanac()),
                persona.getCi()
            };

            // Ejecuta la consulta
            int filasAfectadas = conexion.ejecutarActualizacionP(sql, params); 

            // Verifica si se actualizó al menos una fila
            if (filasAfectadas > 0) {
                actualizado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actualizado;
    }
     
}