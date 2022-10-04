/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto.Funciones;

/**
 *
 * @author deyla
 */
class Partido {
    private Equipo local;
    private Equipo visita;
    private int marcadorLocal;
    private int marcadorVisita;
    private int marcadorLocalReal;
    private int marcadorVisitaReal;
    private String fecha;
    private String hora;
    private String estadio;
    
    public Partido(Equipo local, Equipo visita, int marcadorLocal, int marcadorVisita) {
        this.local = local;
        this.visita = visita;
        this.marcadorLocal = marcadorLocal;
        this.marcadorVisita = marcadorVisita;
    }
    public Partido(Equipo local, Equipo visita){
        this.local = local;
        this.visita = visita;
    }
    public Partido(){
        
    }

    public Partido(Equipo local, Equipo visita, String fecha,String hora, String estadio) {
        this.local = local;
        this.visita = visita;
        this.fecha = fecha;
        this.hora = hora;
        this.estadio = estadio;
    }

    public Partido(String fecha,String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public Partido(String fecha,String hora, String estadio) {
        this.fecha = fecha;
        this.hora = hora;
        this.estadio = estadio;
    }


    
    

    @Override
    public String toString() {
        return local.getNombre() + " vs. " + visita.getNombre() + "    ("+ marcadorLocal + " - " + marcadorVisita+ ")";
    }
    
    public Equipo getPerdedor(){
        if (marcadorLocal == marcadorVisita) return null;
        
        if (marcadorLocal > marcadorVisita)
            return visita;
        return local;
    }
    
    public Equipo getGanador(){
        if (marcadorLocal == marcadorVisita) return null;
        
        if (marcadorLocal > marcadorVisita)
            return local;
        return visita;
    }
    public Equipo getGanadorAdivinanza(){
        if (marcadorLocal == marcadorVisita) return null;
        
        if (marcadorLocal > marcadorVisita)
            return local;
        return visita;
    }
    public Equipo getGanadorReal(){
        if (marcadorLocalReal == marcadorVisitaReal) return null;
        
        if (marcadorLocalReal > marcadorVisitaReal)
            return local;
        return visita;
    }
    
    public boolean estaEmpatado(){
        return marcadorLocal == marcadorVisita;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisita() {
        return visita;
    }

    public void setVisita(Equipo visita) {
        this.visita = visita;
    }

    public int getMarcadorLocal() {
        return marcadorLocal;
    }

    public void setMarcadorLocal(int marcadorLocal) {
        this.marcadorLocal = marcadorLocal;
    }

    public int getMarcadorVisita() {
        return marcadorVisita;
    }

    public void setMarcadorVisita(int marcadorVisita) {
        this.marcadorVisita = marcadorVisita;
    }

    public int getMarcadorLocalReal() {
        return marcadorLocalReal;
    }

    public void setMarcadorLocalReal(int marcadorLocalReal) {
        this.marcadorLocalReal = marcadorLocalReal;
    }

    public int getMarcadorVisitaReal() {
        return marcadorVisitaReal;
    }

    public void setMarcadorVisitaReal(int marcadorVisitaReal) {
        this.marcadorVisitaReal = marcadorVisitaReal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

   
    
}
