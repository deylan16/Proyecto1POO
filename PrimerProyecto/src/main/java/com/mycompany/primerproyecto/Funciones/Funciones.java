/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto.Funciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deyla
 */
public class Funciones {
    public static int verificaUsuario(String Usuario,String Nombre,String contraseña){
        int esta = -1;
        
        int contador = 0;
        for (Object usuario2 : Datos.getUsuarios()) {
            Usuario arrUsuario2 = (Usuario)usuario2;
            
            if(arrUsuario2.getUsuario().equals(Usuario)){
                esta = contador;
                break;
            }
            contador += 1;
        }
        if(esta >= 0){
            Usuario arrUsuario = (Usuario)Datos.getUsuarios().get(esta);
            if(arrUsuario.getNombre().equals(Nombre) && arrUsuario.getContraseña().equals(contraseña)){
                System.out.println("datos correctos");
                Datos.setUsuarioActual(arrUsuario);
                return esta;
            }else{
                System.out.println("Datos incorrectos");
                return -2;
            }
        }
        else{
           
            Usuario arrUsuario = new Usuario(Usuario,Nombre,contraseña);
            
            Datos.getUsuarios().add(arrUsuario);
            Datos.setUsuarioActual(arrUsuario);
            System.out.println("Agregado");
            return -1;
        }
    }
    public static void GuardarQuinielas(){
        String datos = "";
        ArrayList<Usuario> arr = Datos.getUsuarios();
        for (Usuario usuario : arr) {
            datos += usuario.getUsuario();
            datos += "&";
            datos += usuario.getNombre();
            datos += "&";
            datos += usuario.getContraseña();
            datos += "&";
            
            String ApuestasGrupos[][] = usuario.getApuestasGrupos();
            for (int i = 0; i < ApuestasGrupos.length; i++) {
                String Marcador = "";
                if(ApuestasGrupos[i][0] == null){
                    Marcador += "-";
                }else{
                    Marcador += ApuestasGrupos[i][0];
                }
                
                Marcador += "/";
                if(ApuestasGrupos[i][1] == null){
                    Marcador += "-";
                }else{
                    Marcador += ApuestasGrupos[i][1];
                }
                
                datos += Marcador;
                datos += ",";
                
            }
            
            datos += "&";
            int Empates[] = usuario.getGanadoresEmpate();
            for (int i = 0; i < Empates.length; i++) {
                String Marcador = "";
                if(0 == Empates[i]){
                    Marcador += "0";
                }else{
                    Marcador += "1";
                }
                
                datos += Marcador;
                datos += ",";
                
            }
            datos += "%";
            
        }
        try {
            FileManager.writeFile("Usuarios.txt",datos);
        } catch (IOException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        
    }
    public static void cargarQuinielas(){
        try {
            
            String usuarios = FileManager.readFile("Usuarios.txt");
            if(usuarios.length() != 0){
                String[] UsuariosLista = usuarios.split("%");
                
                for (int i = 0; i < UsuariosLista.length-1; i++) {
                    System.out.println(UsuariosLista[i]);
                    String[] fragmentos = UsuariosLista[i].split("&");
                    Usuario ingresando = new Usuario(fragmentos[0], fragmentos[1], fragmentos[2]);
                    String Apuestas[] = fragmentos[3].split(",");
                    for (int j = 0; j < Apuestas.length; j++) {
                        String[] marcador = Apuestas[j].split("/");
                        ingresando.setApuestasGrupos(marcador[0], marcador[1], j);

                    }
                    String empates[] = fragmentos[4].split(",");
                    for (int j = 0; j < empates.length; j++) {
                        //String[] marcador = empates[j];
                        ingresando.setGanadoresEmpate(Integer.parseInt(empates[j]), j);

                    }
                    Datos.getUsuarios().add(ingresando);
                    
                }
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String[] generarMaracadorAleatorio(){
        int aleatorio = (int) (Math.random()*100)  ;
        int numero1  = 0;
        int numero2 =  0;
        String stringNumero1 = "";
        String stringNumero2 = "";
        String[] result;
        if (aleatorio <= 80){
            
            numero1  = (int) (Math.random()*3);
            numero2 = (int) (Math.random()*3); 
            stringNumero1 = Integer.toString(numero1);
            stringNumero2 = Integer.toString(numero2);
            result = new String[]{stringNumero1,stringNumero2};

            
        }else if(aleatorio <= 95){
            //3-4
            numero1  = (int) (Math.random()*(4-3+1)+4); 
            numero2 = (int) (Math.random()*(4-3+1)+4) ;
            stringNumero1 = Integer.toString(numero1);
            stringNumero2 = Integer.toString(numero2);
            result = new String[]{stringNumero1,stringNumero2};

            
        }else {
            //5-8
            numero1  = (int) (Math.random()*(8-5+1)+8); 
            numero2 = (int) (Math.random()*(8-5+1)+8) ;
            stringNumero1 = Integer.toString(numero1);
            stringNumero2 = Integer.toString(numero2);
            result = new String[]{stringNumero1,stringNumero2};
            
            
        }
        return result;
    }
    public static String[] generarMaracadorheuristica(int partido) {
        Partido partido2 = EstructuraPartidos.demePartidoEquipo(partido);
        int puntuacio1 = partido2.getLocal().getPuntuacion();
        int puntuacio2 = partido2.getVisita().getPuntuacion();
        int numero1 = (int)(Math.random()*puntuacio1); 
        int numero2 = (int) (Math.random()*puntuacio2);
        int numero3 = 0;
        int numero4 = 0;
        if(numero1 > numero2){
            while(true){
                String[] result = generarMaracadorAleatorio();
                numero3 = Integer.parseInt(result[0]);
                numero4 = Integer.parseInt(result[1]);
                if(numero3>numero4){
                    return result;
                }
            }
        }else if(numero1 < numero2){
            while(true){
                String[] result = generarMaracadorAleatorio();
                numero3 = Integer.parseInt(result[0]);
                numero4 = Integer.parseInt(result[1]);
                if(numero3<numero4){
                    return result;
                }
            }
        }else{
            String[] result = generarMaracadorAleatorio();
            return new String[]{result[0], result[0]};
        }
        
        
    }
}

