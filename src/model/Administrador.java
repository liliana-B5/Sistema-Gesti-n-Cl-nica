/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

public class Administrador extends Persona {
    public Administrador(String nombre, String apellido, String ci, int edad, LocalDate fechanac) {
        super(nombre, apellido, ci, edad, fechanac);
    }

    @Override
    public String getRol() {
        return "administrador";
    }
}
