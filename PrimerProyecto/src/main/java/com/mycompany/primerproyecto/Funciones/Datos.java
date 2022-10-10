/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto.Funciones;
import java.lang.String;
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
    static public int progreso;
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
    
    
public static void ordenar_usuarios_puntos(){
    int len = usuarios.size();
    for (var i = 0; i < len ; i++) {
            for(var j = 0 ; j < len - i - 1; j++){
                if (usuarios.get(j).getPuntos()< usuarios.get(j + 1).getPuntos()) { 
                    Usuario temp = usuarios.get(j);
                    usuarios.set(j, usuarios.get(j+1));
                    usuarios.set(j + 1, temp);
        }
       }
      }
}
 public static String[] to_string_nombres_puntos(){
    ordenar_usuarios_puntos();
    String nombres_puntos[]=new String[usuarios.size()];
    int contador = 0;
    for (Usuario usuario:usuarios){
       if (!"Admin".equals(usuario.getUsuario())){
       if (usuario.getNombre().length() < 15)
       nombres_puntos [contador] = contador+1 + " "+usuario.getNombre()+ " - " + usuario.getPuntos()+"pts";
       else
            nombres_puntos [contador] = contador+1 + " "+usuario.getNombre().substring(0, 11)+ "..."+" - " + usuario.getPuntos()+"pts";

       contador++;}
    } 
                
    return nombres_puntos;
     
 }
 
    
}
