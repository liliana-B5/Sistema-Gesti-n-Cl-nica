/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Factura;
import model.PacienteLLBN;


public class FacturaController {
     private Conexion conexion;
    
     public FacturaController() {
        conexion = new Conexion();
    }
    
    
    public boolean guardarFactura(Factura factura) {
        String sql = "INSERT INTO factura_consulta_medica (nro_factura, paciente_ci, "
                + "fecha, descripcion_consulta, especialidad_id, medico_id, total) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            Object[] params = {
                factura.getNroFactura(),
                factura.getPaciente_ci(),
                factura.getFecha(),
                factura.getDescripcion_consulta(),
                factura.getEspecialidad_id(),
                factura.getMedico_id(),
                factura.getTotal()
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

    public int obtenerUltimoNumeroFactura() {
        String sql = "SELECT MAX(nro_factura) AS max_nro FROM factura_consulta_medica";
        try {
            ResultSet rs = conexion.ejecutarConsulta(sql, new Object[]{});
            if (rs.next()) {
                return rs.getInt("max_nro");
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
        return 0; // Si no hay facturas, se retorna 0
    }

        public List<Factura> obtenerTodasFacturas() {
        String sql = "SELECT nro_factura, paciente_ci, fecha, descripcion_consulta,"
                + " especialidad_id, medico_id, total " +
                     "FROM factura_consulta_medica";

        List<Factura> facturas = new ArrayList<>();

        try {
            ResultSet rs = conexion.ejecutarConsulta(sql);
            while (rs.next()) {
                Factura factura = new Factura();
                factura.setNroFactura(rs.getInt("nro_factura"));
                factura.setPaciente_ci(rs.getString("paciente_ci"));
                 //  java.sql.Date a java.time.LocalDate
                java.sql.Date sqlDate = rs.getDate("fecha");
                if (sqlDate != null) {
                    factura.setFecha(sqlDate.toLocalDate());
                }
                factura.setDescripcion_consulta(rs.getString("descripcion_consulta"));
                factura.setEspecialidad_id(rs.getInt("especialidad_id"));
                factura.setMedico_id(rs.getInt("medico_id"));
                factura.setTotal(rs.getDouble("total"));
                facturas.add(factura);
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

        return facturas;
    }
        
        public boolean eliminarFactura(int nroFactura) {
            String sql = "DELETE FROM factura_consulta_medica WHERE nro_factura = ?";

            try {
                Object[] params = { nroFactura };
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
}
