/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto.Funciones;

import java.util.ArrayList;

/**
 *
 * @author deyla
 */
public class Equipo {
    private int puntos;
    private int golesAfavor;
    private int golesEncontra;
    private String nombre;
    private int puntuacion;
    private ArrayList<Partido> partidos;

    Equipo(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.partidos = new ArrayList<Partido>();
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getGolesAfavor() {
        return golesAfavor;
    }

    public void setGolesAfavor(int golesAfavor) {
        this.golesAfavor = golesAfavor;
    }

    public int getGolesEncontra() {
        return golesEncontra;
    }

    public void setGolesEncontra(int golesEncontra) {
        this.golesEncontra = golesEncontra;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void tostring(){
        System.out.println(nombre+": \n"+ "Goles a favor: "+ golesAfavor+"\n"+ "Goles en contra: "+
                golesEncontra +"\n"+ "Puntos actuales: "+ puntos);
        
    }
    
    
}
