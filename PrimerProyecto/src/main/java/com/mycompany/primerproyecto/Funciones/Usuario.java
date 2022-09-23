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
    private String ApuestasGrupos[][];

    public Usuario(String Usuario, String Nombre, String Contraseña) {
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Contraseña = Contraseña;
        this.ApuestasGrupos = new String[48][2];
    }

    public String[][] getApuestasGrupos() {
        return ApuestasGrupos;
    }

    public void setApuestasGrupos(String marcador1,String marcador2,int partido) {
        this.ApuestasGrupos[partido][0] = marcador1;
        this.ApuestasGrupos[partido][1] = marcador2;
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
