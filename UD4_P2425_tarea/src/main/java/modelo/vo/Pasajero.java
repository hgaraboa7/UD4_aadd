/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.vo;

import java.util.Date;

/**
 *
 * @author hector.garaboacasas
 */
public class Pasajero {

    private Date fecha_nacimiento;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private int hijos;
    private boolean antecedentes;
    private int num_vuelo;

    public Pasajero(Date fecha_nacimiento, String nombre, String apellido, String nacionalidad, int hijos, boolean antecedentes, int num_vuelo) {
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.hijos = hijos;
        this.antecedentes = antecedentes;
        this.num_vuelo = num_vuelo;
    }

    public int getNum_vuelo() {
        return num_vuelo;
    }

    public void setNum_vuelo(int num_vuelo) {
        this.num_vuelo = num_vuelo;
    }

    @Override
    public String toString() {
        return nombre + ", " + apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public boolean isAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(boolean antecedentes) {
        this.antecedentes = antecedentes;
    }

}
