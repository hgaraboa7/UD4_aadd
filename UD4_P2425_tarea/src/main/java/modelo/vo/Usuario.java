/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hector.garaboacasas
 */
public class Usuario {
    
    private String nombre;
    private String pass;
    
     private List<Avion> listaVuelos;

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
        this.listaVuelos=new ArrayList<>();
    }

    public List<Avion> getListaCasos() {
        return listaVuelos;
    }

    @Override
    public String toString() {
        return  nombre ;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setListaCasos(List<Avion> listaCasos) {
        this.listaVuelos = listaCasos;
    }
    
    
    
}
