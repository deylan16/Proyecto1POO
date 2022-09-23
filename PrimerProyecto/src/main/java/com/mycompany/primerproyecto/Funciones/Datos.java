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
public class Datos {
    static public Usuario usuarioActual;
    static public Usuario usuarioAdmin;
    static public int partidoActual = 0;
    static public boolean Admin = false;

    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    

    public static ArrayList getUsuarios() {
        
        return usuarios;
    }

    public static void setUsuarios(ArrayList usuarios) {
        Datos.usuarios = usuarios;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuarioActual) {
        Datos.usuarioActual = usuarioActual;
    }

    public static Usuario getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public static void setUsuarioAdmin(Usuario usuarioAdmin) {
        Datos.usuarioAdmin = usuarioAdmin;
    }
    
    

 
 
    
}
