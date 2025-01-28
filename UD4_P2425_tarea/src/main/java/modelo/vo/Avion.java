/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hector.garaboacasas
 */
public class Avion {
    
    private int num_vuelo;
    private int num_pasajeros;
    private Date fecha_vuelo;
    private String localizacion;
    private String origen;
    private String destino;
   
    private String detalles;
    
    private String nombre_usuario;

    public Avion(int num_vuelo, int num_pasajeros, Date fecha_vuelo, String origen, String destino,String nombre_usuario) {
        this.num_vuelo = num_vuelo;
        this.num_pasajeros = num_pasajeros;
        this.fecha_vuelo = fecha_vuelo;
        this.origen = origen;
        this.destino = destino;
        this.listaPasajeros=new ArrayList<>();
        this.nombre_usuario=nombre_usuario;
        
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
    private List<Pasajero> listaPasajeros;

    public List<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }

    public void setListaPasajeros(List<Pasajero> listaPasajeros) {
        this.listaPasajeros = listaPasajeros;
    }
    

    public int getNum_vuelo() {
        return num_vuelo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public void setNum_vuelo(int num_vuelo) {
        this.num_vuelo = num_vuelo;
    }

    public int getNum_pasajeros() {
        return num_pasajeros;
    }

    public void setNum_pasajeros(int num_pasajeros) {
        this.num_pasajeros = num_pasajeros;
    }

    public Date getFecha_vuelo() {
        return fecha_vuelo;
    }

    public void setFecha_vuelo(Date fecha_vuelo) {
        this.fecha_vuelo = fecha_vuelo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    
    
    
}
