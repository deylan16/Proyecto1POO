/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.primerproyecto;

import com.mycompany.primerproyecto.Funciones.EstructuraPartidos;
import com.mycompany.primerproyecto.Funciones.Funciones;
import com.mycompany.primerproyecto.Interfaz.VentanaPrincipal;

/**
 *
 * @author deyla
 */
public class PrimerProyecto {
   

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //int numero1 = (int) Math.random()*3;
        //System.out.println(numero1);
        //Cualquier cosa
        new EstructuraPartidos().iniciaFaseGrupos();
        new VentanaPrincipal().setVisible(true);
    }
}
