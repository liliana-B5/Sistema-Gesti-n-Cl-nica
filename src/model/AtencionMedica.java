package model;
import java.time.LocalDate;
import javax.swing.JOptionPane;
public  class AtencionMedica{
      private int id_atencion;
    private PacienteLLBN paciente;
    private Medico medico;
    private LocalDate fecha_atencion;
    private String sintomas;
    private String diagnostico;

    public AtencionMedica() {
        this.fecha_atencion = LocalDate.now();
    }

    public AtencionMedica(int id_atencion, PacienteLLBN paciente, Medico medico, String sintomas, String diagnostico) {
        this.id_atencion = id_atencion;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha_atencion = LocalDate.now();
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
    }
    
    public AtencionMedica(PacienteLLBN paciente, Medico medico, LocalDate fecha_atencion, String sintomas, String diagnostico) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha_atencion = fecha_atencion;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
    }
    
 
    
 // nuev constructor solo id_atencion
    public AtencionMedica(int id_atencion) {
        this.id_atencion = id_atencion;
        this.fecha_atencion = LocalDate.now();
    }

    public int getId_atencion() {
        return id_atencion;
    }

    public void setId_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }

    public PacienteLLBN getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteLLBN paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getFecha_atencion() {
        return fecha_atencion;
    }

    public void setFecha_atencion(LocalDate fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

  

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    

}

    
           

    

    

