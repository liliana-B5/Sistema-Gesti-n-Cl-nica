/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liliana B.
 */
public class HistorialPaciente {
     private PacienteLLBN paciente;
    private List<AtencionMedica> atenciones;

    public HistorialPaciente(PacienteLLBN paciente) {
        this.paciente = paciente;
        this.atenciones = new ArrayList<>();
    }

    public void setAtenciones(List<AtencionMedica> atenciones) {
        this.atenciones = atenciones; 
    }

  
     public void setPaciente(PacienteLLBN  paciente) {
        this.paciente = paciente;
    }

    public PacienteLLBN  getPaciente() {
        return paciente;
    }
    
     public void setPaciente(List<AtencionMedica>  atenciones) {
        this.atenciones = atenciones;
    }

    public List<AtencionMedica>  getAtenciones() {
        return atenciones;
    }

}
