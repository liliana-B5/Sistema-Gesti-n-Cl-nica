/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author liliana B.
 */
public class Receta {
   private int id_receta;
    private AtencionMedica atencionMedica;
    private Farmacos farmaco; 
    private String medicamento; 
    private int unidades;
    private String dosis;
    private int dias;

    public Receta(int id_receta, AtencionMedica atencionMedica, Farmacos farmaco, String medicamento, int unidades, String dosis, int dias) {
        this.id_receta = id_receta;
        this.atencionMedica = atencionMedica;
        this.farmaco = farmaco;
        this.medicamento = medicamento;
        this.unidades = unidades;
        this.dosis = dosis;
        this.dias = dias;
    }

    public int getId_receta() {
        return id_receta;
    }

    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
    }

    public AtencionMedica getAtencionMedica() {
        return atencionMedica;
    }

    public void setAtencionMedica(AtencionMedica atencionMedica) {
        this.atencionMedica = atencionMedica;
    }

    public Farmacos getFarmaco() {
        return farmaco;
    }

    public void setFarmaco(Farmacos farmaco) {
        this.farmaco = farmaco;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
}