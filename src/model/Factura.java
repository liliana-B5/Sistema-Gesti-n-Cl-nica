package model;


import java.text.DecimalFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;
public class Factura{
 
    private int nro_factura;
    private String paciente_ci;
    private LocalDate fecha;
    private String descripcion_consulta;
    private int especialidad_id;
    private int medico_id;
    private double total;
    private double subtotal;
    private double iva;
     private String pacienteNombre;
    

    public Factura(int nro_factura, String paciente_ci, LocalDate fecha, String descripcion_consulta, 
                   int especialidad_id, int medico_id, double total) {
        this.nro_factura = nro_factura;
        this.paciente_ci = paciente_ci;
        this.fecha = fecha;
        this.descripcion_consulta = descripcion_consulta;
        this.especialidad_id = especialidad_id;
        this.medico_id = medico_id;
        this.total = total;
    }
    
    
    public Factura(int nro_factura, String paciente_ci, LocalDate fecha, String descripcion_consulta, int especialidad_id, int medico_id, double total, String pacienteNombre) {
        this.nro_factura = nro_factura;
        this.paciente_ci = paciente_ci;
        this.fecha = fecha;
        this.descripcion_consulta = descripcion_consulta;
        this.especialidad_id = especialidad_id;
        this.medico_id = medico_id;
        this.total = total;
        this.pacienteNombre = pacienteNombre;
    }
    public Factura() {
    }

    public int getNroFactura() {
        return nro_factura;
    }

    public void setNroFactura(int nroFactura) {
        this.nro_factura = nroFactura;
    }

    public String getPaciente_ci() {
        return paciente_ci;
    }

    public void setPaciente_ci(String paciente_ci) {
        this.paciente_ci = paciente_ci;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion_consulta() {
        return descripcion_consulta;
    }

    public void setDescripcion_consulta(String descripcion_consulta) {
        this.descripcion_consulta = descripcion_consulta;
    }

    public int getEspecialidad_id() {
        return especialidad_id;
    }

    public void setEspecialidad_id(int especialidad_id) {
        this.especialidad_id = especialidad_id;
    }
    
     public int getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

  
    
}