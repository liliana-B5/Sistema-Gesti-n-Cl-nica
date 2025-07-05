package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * * @author (lilina Buestan
 */
public  class PacienteLLBN extends Persona{

    protected String direccion;
    protected String correo;
    protected String  celular;
    protected int nro;

    
    public PacienteLLBN(String nombre, String apellido, int edad, String ci, String celular, String direccion, String correo, LocalDate fechanac) {
        super(nombre, apellido, ci, edad, fechanac);
        this.direccion = direccion;
        this.correo = correo;
        this.celular = celular;
    }
                //CONTRUCTOR PARA EL HISTORIAL DEL PPACIENTE
    public PacienteLLBN(String nombre, String apellido, String ci, int edad) {
        super(nombre, apellido, ci, edad, null);
        this.direccion = "";
        this.correo = "";
        this.celular = "";
    }
    
    public PacienteLLBN() {
        
    }


    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public void setDirec(String direccion) {
        this.direccion = direccion;
    }

    public String getDirec() {
        return direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setcel(String  celular) {
        this.celular = celular;
    }

    public String  getcel() {
        return celular;
    }



    public LocalDate fch() {
        String date = JOptionPane.showInputDialog(null, "Fecha de nacimiento dd/MM/yyyy : ");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, dateTimeFormatter);// format dateTimeFormatter = (2000-05-10)
        } catch (DateTimeParseException e) {
            return null;
        }
        return localDate;
    }

   public int calcularEdad() {
        LocalDate today = LocalDate.now();
        return Period.between(fechanac, today).getYears();
    }

    @Override
    public String toString() {
        return "PACIENTE, Nª=" + nro + super.toString() + ",\nDireccion: " + direccion
                + ",\nE-mail: " + correo + ", \nTelefono celular: " + celular;
    }

    @Override
    public String getRol() {
        return "paciente";
    }
}
