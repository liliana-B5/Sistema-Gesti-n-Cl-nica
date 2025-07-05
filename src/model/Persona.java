package model;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public abstract   class Persona {
 protected String nombre;
    protected String apellido;
    protected String ci;
    protected int edad;
    protected LocalDate fechanac;

    public Persona(String nombre, String apellido, String ci, int edad, LocalDate fechanac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.edad = edad;
        this.fechanac = fechanac;
    }


    public Persona() {
    }

    public String  getCi() {
        return ci;
    }

    public void setCi(String  ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public LocalDate getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
    }

    public abstract String getRol();

    @Override
    public String toString() {
        return String.format("Cedula: %s, Nombre: %s, Apellido: %s, Edad: %d, Fecha de Nacimiento: %s",
            getCi(), getNombre(), getApellido(), getEdad(), getFechanac().toString());
    }
}
