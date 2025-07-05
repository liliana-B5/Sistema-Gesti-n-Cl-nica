package model;



/**
 *
 * @author liliana B.
 */
public class Farmacos {

   private int id_farmaco;
    private String nombre_medicamento;
    private String cantidad;
    private String presentacion;
    private String descripcion;

    // Constructor con id
    public Farmacos(int id_farmaco, String nombre_medicamento, String cantidad, String presentacion, String descripcion) {
        this.id_farmaco = id_farmaco;
        this.nombre_medicamento = nombre_medicamento;
        this.cantidad = cantidad;
        this.presentacion = presentacion;
        this.descripcion = descripcion;
    }

    // Constructor sin id
    public Farmacos(String nombre_medicamento, String cantidad, String presentacion, String descripcion) {
        this.nombre_medicamento = nombre_medicamento;
        this.cantidad = cantidad;
        this.presentacion = presentacion;
        this.descripcion = descripcion;
    }

    public int getIdFarmaco() {
        return id_farmaco;
    }

    public void setIdFarmaco(int id_farmaco) {
        this.id_farmaco = id_farmaco;
    }

    public String getNombreMedicamento() {
        return nombre_medicamento;
    }

    public void setNombreMedicamento(String nombre_medicamento) {
        this.nombre_medicamento = nombre_medicamento;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Farmacos{" +
               "id_farmaco=" + id_farmaco +
               ", nombre_medicamento='" + nombre_medicamento + '\'' +
               ", cantidad='" + cantidad + '\'' +
               ", presentacion='" + presentacion + '\'' +
               ", descripcion='" + descripcion + '\'' +
               '}';
    }
}