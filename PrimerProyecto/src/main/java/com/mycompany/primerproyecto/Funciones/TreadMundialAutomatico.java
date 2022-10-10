/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto.Funciones;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deyla
 */
public class TreadMundialAutomatico extends Thread {
    
    @Override
    public void run(){
        while(Datos.partidoActual< 64){
            try {
                sleep(10);
                String[] resultados =Funciones.generarMaracadorheuristica(Datos.partidoActual);
                String marcador1 = resultados[0];
                String marcador2 = resultados[1];
                Usuario usuario3 = null; 
                for (Object Usuario2 : Datos.getUsuarios()) {
                    Usuario usuario= (Usuario)(Usuario2);
                    if(usuario.getNombre().equals("Admin")){
                        usuario3 = usuario;
                        break;
                    } 

                }
                usuario3.setApuestasGrupos(marcador1, marcador2, Datos.partidoActual);
                int marcadorpenales = 0;
                if (Datos.partidoActual > 47){
                        if (marcador1 == marcador2){

                            marcadorpenales = (new Random()).nextInt(1);
                            
                        }}
                
                EstructuraPartidos.actualiceMarcadorReal(marcador1, marcador2);
                if (Datos.partidoActual > 47){
                    if(EstructuraPartidos.infoPartido("MarcadorLocalReal","Grupos",Datos.partidoActual).equals(EstructuraPartidos.infoPartido("MarcadorVisitaReal","Grupos",Datos.partidoActual))){
                        String ganadorEmpate = "";
                        
                        if (marcadorpenales != 0){
                            EstructuraPartidos.actualiceEmpatePartido(Datos.partidoActual, EstructuraPartidos.infoPartido("Visita","Grupos",Datos.partidoActual));
                            usuario3.setGanadoresEmpate( 1, Datos.partidoActual);
                        }else{
                            EstructuraPartidos.actualiceEmpatePartido(Datos.partidoActual, EstructuraPartidos.infoPartido("Local","Grupos",Datos.partidoActual));
                            usuario3.setGanadoresEmpate( 0, Datos.partidoActual);
                         
                        }
                        
                        
                        }
                    }



                Datos.partidoActual += 1;
                if(Datos.partidoActual == 56){
                    EstructuraPartidos.actualiceEquiposPartido(57,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 48) ,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 49) );
                    EstructuraPartidos.actualiceEquiposPartido(56,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 50) ,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 51) );
                    EstructuraPartidos.actualiceEquiposPartido(59,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 52) ,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 53) );
                    EstructuraPartidos.actualiceEquiposPartido(58,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 54) ,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 55) );
                }
                if(Datos.partidoActual == 60){
                    EstructuraPartidos.actualiceEquiposPartido(60,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 57) ,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 56) );
                    EstructuraPartidos.actualiceEquiposPartido(61,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 59) ,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 58) );

                }
                if(Datos.partidoActual == 62){
                    EstructuraPartidos.actualiceEquiposPartido(63,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 60) ,EstructuraPartidos.infoPartido("GanadorReal", "Grupos", 61) );
                    EstructuraPartidos.actualiceEquiposPartido(62,EstructuraPartidos.infoPartido("PerdedorReal", "Grupos", 60) ,EstructuraPartidos.infoPartido("PerdedorReal", "Grupos", 61) );

                }
                if(Datos.partidoActual == 48){
                    
                    String primeroA = new EstructuraPartidos().MejoresGrupo("A")[0].getNombre();
                    String segundoA  = new EstructuraPartidos().MejoresGrupo("A")[1].getNombre();

                    String primeroB = new EstructuraPartidos().MejoresGrupo("B")[0].getNombre();
                    String segundoB  = new EstructuraPartidos().MejoresGrupo("B")[1].getNombre();

                    String primeroC = new EstructuraPartidos().MejoresGrupo("C")[0].getNombre();
                    String segundoC  = new EstructuraPartidos().MejoresGrupo("C")[1].getNombre();

                    String primeroD = new EstructuraPartidos().MejoresGrupo("D")[0].getNombre();
                    String segundoD  = new EstructuraPartidos().MejoresGrupo("D")[1].getNombre();

                    String primeroE = new EstructuraPartidos().MejoresGrupo("E")[0].getNombre();
                    String segundoE  = new EstructuraPartidos().MejoresGrupo("E")[1].getNombre();

                    String primeroF = new EstructuraPartidos().MejoresGrupo("F")[0].getNombre();
                    String segundoF  = new EstructuraPartidos().MejoresGrupo("F")[1].getNombre();

                    String primeroG = new EstructuraPartidos().MejoresGrupo("G")[0].getNombre();
                    String segundoG  = new EstructuraPartidos().MejoresGrupo("G")[1].getNombre();

                    String primeroH = new EstructuraPartidos().MejoresGrupo("H")[0].getNombre();
                    String segundoH  = new EstructuraPartidos().MejoresGrupo("H")[1].getNombre();
                    EstructuraPartidos.actualiceEquiposPartido(48,primeroA ,segundoB );
                    EstructuraPartidos.actualiceEquiposPartido(49,primeroC ,segundoD );
                    EstructuraPartidos.actualiceEquiposPartido(52,primeroE ,segundoF );
                    EstructuraPartidos.actualiceEquiposPartido(53,primeroG ,segundoH );
                    EstructuraPartidos.actualiceEquiposPartido(50,primeroB ,segundoA );
                    EstructuraPartidos.actualiceEquiposPartido(51,primeroD ,segundoC );
                    EstructuraPartidos.actualiceEquiposPartido(54,primeroF ,segundoE );
                    EstructuraPartidos.actualiceEquiposPartido(55, primeroH,segundoG );
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TreadMundialAutomatico.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }
    }
    
}
