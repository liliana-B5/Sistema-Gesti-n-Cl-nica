package model;
import java.time.LocalDate;
import javax.swing.JOptionPane;
public class Medico extends Persona {
    private int id_medico;
    private Especialidad especialidad;

    public Medico(String nombre, String apellido, String ci, int edad, LocalDate fechanac, int id_medico, Especialidad especialidad) {
        super(nombre, apellido, ci, edad, fechanac);
        this.id_medico = id_medico;
        this.especialidad = especialidad;
    }

    // Constructor para crear un objeto Medico sin id_medico ni especialidad inicializados
    public Medico(String nombre, String apellido, String cedula, int edad, LocalDate fechanac) {
        super(nombre, apellido, cedula, edad, fechanac);
        this.id_medico = 0; 
        this.especialidad = null; 
    }
    
     // Constructor sin argumentos
    public Medico() {
        super();
        this.id_medico = 0;
        this.especialidad = null;
    }
    
  
        //CONTRUCTOR PARA EL HISTORIAL DEL PPACIENTE
    public Medico(String nombre, String apellido, String cedula, Especialidad especialidad) {
        super(nombre, apellido, cedula, 0, null); // Edad y fecha de nacimiento no necesarias aquí
        this.id_medico = 0;
        this.especialidad = especialidad;
    }
    
      
    @Override
    public String getRol() {
        return "medico";
    }
       
  
    public String  getCi() {
        return ci;
    }

    public void setCi(String  ci) {
        this.ci = ci;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }


    
    
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}