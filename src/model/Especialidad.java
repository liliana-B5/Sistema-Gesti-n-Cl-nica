/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Especialidad {
    private int id_especialidad;
    private String nombre;
    private int numero_consultorio;
    private double valor_especialidad;

    public Especialidad(int id_especialidad, String nombre, int numero_consultorio, double valor_especialidad) {
        this.id_especialidad = id_especialidad;
        this.nombre = nombre;
        this.numero_consultorio = numero_consultorio;
        this.valor_especialidad = valor_especialidad;
    }
   
      public Especialidad(String nombre) {
        this.nombre = nombre;
    }

    
    // Ggtters y setters
       public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }
    
    
    public double getValor_especialidad() {
        return valor_especialidad;
    }
     public void setValor_especialidad(double valor_especialidad) {
        this.valor_especialidad = valor_especialidad;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
        public int getNumero_consultorio() {
        return numero_consultorio;
    }

    public void setNumero_consultorio(int numero_consultorio) {
        this.numero_consultorio = numero_consultorio;
    }
    
  
    
     @Override
    public String toString() {
        return nombre;
    }
    
}
