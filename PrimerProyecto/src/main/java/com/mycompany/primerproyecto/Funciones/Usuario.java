/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto.Funciones;

/**
 *
 * @author deyla
 */
public class Usuario {
    private String Usuario;
    private String Nombre;
    private String Contraseña;
    private int puntos;
    private String ApuestasGrupos[][];
    private int ganadoresEmpate[];

    
    public Usuario() {}

    public Usuario(String Usuario, String Nombre, String Contraseña) {
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Contraseña = Contraseña;
        this.ApuestasGrupos = new String[62][2];
        this.ganadoresEmpate = new int[62];
    }

    public String[][] getApuestasGrupos() {
        return ApuestasGrupos;
    }
    public int getPuntos(){
        return this.puntos;
    }

    public void setApuestasGrupos(String marcador1,String marcador2,int partido) {
        this.ApuestasGrupos[partido][0] = marcador1;
        this.ApuestasGrupos[partido][1] = marcador2;
    }

    public int[] getGanadoresEmpate() {
        return ganadoresEmpate;
    }
    public int getGanadoresEmpateIndex(int i) {
        return ganadoresEmpate[i];
    }

    public void setGanadoresEmpate(int ganador,int partido) {
        this.ganadoresEmpate[partido] = ganador;
    }
    public void setPuntos(int P){
        this.puntos = P;
    }
    

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    

    
    
    
}
