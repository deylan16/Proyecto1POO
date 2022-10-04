/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto.Funciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author deyla
 */
public class EstructuraPartidos {
    static private ArrayList<Equipo> equipos = new ArrayList<Equipo>();
    static public ArrayList<Partido> partidosFaseGrupos = new ArrayList<Partido>();

    public EstructuraPartidos() {
        //equipos = new ArrayList<Equipo>();
        //partidosFaseGrupos = new ArrayList<Partido>();
        //iniciaFaseGrupos();
        
    }
    
    
    public Equipo buscaEquipo(String equipo){
        for (Object equipo2:equipos) {
            Equipo equipo3 = (Equipo)equipo2;
            if(equipo3.getNombre().equals(equipo)){
                return equipo3;
            }
        }
        return null;
    }
    
    static public Partido demePartidoEquipo(int indice){ 
        //System.out.println(partidosFaseGrupos.get(0));
        return partidosFaseGrupos.get(indice);
        
    }
    
    static public String infoPartido(String opcion,String Fase,int Ipartido)    {
        if(Fase == "Grupos"){
            
            if(opcion == "Local"){
                return demePartidoEquipo(Ipartido).getLocal().getNombre();
            }
            else if(opcion == "Visita"){
                return demePartidoEquipo(Ipartido).getVisita().getNombre();               
              } 
            else if(opcion == "MarcadorVisita"){
                return Integer.toString(demePartidoEquipo(Ipartido).getMarcadorLocal());               
              } 
            else if(opcion == "MarcadorLocal"){
                return Integer.toString(demePartidoEquipo(Ipartido).getMarcadorLocal());               
              } 
            else if(opcion == "Hora"){
                return demePartidoEquipo(Ipartido).getHora();               
              } 
            else if(opcion == "Fecha"){
                return demePartidoEquipo(Ipartido).getFecha();               
              } 
            else if(opcion == "Estadio"){
                return demePartidoEquipo(Ipartido).getEstadio();               
              } 
            else if(opcion == "MarcadorVisitaReal"){
                
                return Integer.toString(demePartidoEquipo(Ipartido).getMarcadorVisitaReal());               
              } 
            else if(opcion == "MarcadorLocalReal"){
                return Integer.toString(demePartidoEquipo(Ipartido).getMarcadorLocalReal());               
              } 
            else if(opcion == "GanadorReal"){
                return demePartidoEquipo(Ipartido).getGanadorReal().getNombre();               
            } 
            else if(opcion == "GanadorAdivinanza"){
                if (Datos.getUsuarioActual().getApuestasGrupos()[Ipartido][0] == Datos.getUsuarioActual().getApuestasGrupos()[Ipartido][1]) return null;
        
                if (Integer.parseInt(Datos.getUsuarioActual().getApuestasGrupos()[Ipartido][0]) > Integer.parseInt(Datos.getUsuarioActual().getApuestasGrupos()[Ipartido][1]))
                    return demePartidoEquipo(Ipartido).getLocal().getNombre();
                return demePartidoEquipo(Ipartido).getVisita().getNombre();
                //Datos.getUsuarioActual().getApuestasGrupos()[partido][0]
                //return demePartidoEquipo(Ipartido).getGanadorAdivinanza().getNombre();               
            } 
        }
        else{
            return "no";
        }
        return "no";
        
        
    }
    
    //Funcion que retorna un equipo que elige de forma aleatoria   
    public Equipo rifa(Equipo uno,Equipo dos){
      Random rand = new Random();
      int int_random = rand.nextInt(2);
      if (int_random == 0)
        return uno;
      else
        return dos;
    } 
    //Funciin que busca el partido en que ambos equipos jugaron
    //Retorna el equipo ganador de tal partido
    public Equipo equipo_ganador(Equipo uno, Equipo dos){
       for(Partido partido : partidosFaseGrupos){
           //Los equipos pueden ser visita o local
           if (partido.getVisita()== uno || partido.getLocal() == uno & partido.getVisita()== dos || partido.getLocal() == dos )
               //Si el partido quedo empatado 
               //Se genera una rifa 
               if (partido.estaEmpatado()){
                   return rifa(uno,dos);
               }
               else
               {
                   //Si no estaba empatado se retorna el ganador
                   return partido.getGanador();
               }
        }
       return null;
   } 
    //Funcion que retorna el equipo con mayor diferencia de goles positiva
    public Equipo equipo_dif_goles_pos(Equipo uno, Equipo dos){
        //Si tienen la misma diferencia de goles 
        if(uno.getGolesAfavor() == dos.getGolesAfavor()){
            //Se llama la funcion para ver cual equipo metio mas goles
            return equipo_mas_goles(uno, dos);}
        if(uno.getGolesAfavor() < dos.getGolesAfavor())
            return dos;
        else
            return uno;
    }
    
    //Funcion que retorna cual equipo tiene mas goles a favor
    public Equipo equipo_mas_goles(Equipo uno,Equipo dos){
        //Si tienen el mismo numero de goles a favor
        if(uno.getGolesAfavor() == dos.getGolesAfavor()){
            //Se llama a la funcion para ver cual fue el resultado del partido entre ambos equipos
            return equipo_ganador(uno,dos);}
        if(uno.getGolesAfavor() < dos.getGolesAfavor())
            return dos;
        else
            return uno;
    }  
    
    //Funcion que desempata todo un grupo
    //Retorna los dos equipos con mayor diferencia de goles positiva
    public Equipo[] desempate_4equipos_diferencia_goles(Equipo uno,Equipo dos, Equipo tres, Equipo cuatro){
        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        equipos.add(uno);
        equipos.add(dos);
        equipos.add(tres);
        equipos.add(cuatro);
        int len = equipos.size();
        //Metodo de ordenamiento 
        //Los dos mejores equipos quedan en la pos 3 y 2
        for (var i = 0; i < len ; i++) {
            for(var j = 0 ; j < len - i - 1; j++){
                if (equipos.get(j).getDiferencia_de_goles()> equipos.get(j + 1).getDiferencia_de_goles()) { 
                    Equipo temp = equipos.get(j);
                    equipos.set(j, equipos.get(j+1));
                    equipos.set(j + 1, temp);
        }
       }
      }
      //Si los equipos tienen la misma diferencia de goles 
      if(equipos.get(0).getDiferencia_de_goles() == equipos.get(1).getDiferencia_de_goles()       //Si el equipo en primera, segunda y tercera pos estan empates de puntos
         & equipos.get(1).getDiferencia_de_goles()==equipos.get(2).getDiferencia_de_goles()
         & equipos.get(2).getDiferencia_de_goles()==equipos.get(3).getDiferencia_de_goles()){
          System.out.println("Existe un empate de diferencia de goles entre el primero, segundo, tercero y cuarto equipo");
          //Se retorna los la funcion para desempatar por el numero de goles anotados
          return desempate_4equipos_mas_goles(equipos.get(0),equipos.get(1),
                                             equipos.get(2),equipos.get(3));
      }
      //Si la segunda posicion y la tercera posicion tienen la misma diferencia de goles
      if(equipos.get(1).getDiferencia_de_goles() == equipos.get(2).getDiferencia_de_goles()){
          //Se saca el equipo con mas goles anotados
          Equipo equipo_con_mas_goles = equipo_mas_goles(equipos.get(1),equipos.get(2));
          //Pasa a ser nuestra segunda posicion (pasa a la siguiente fase)
          equipos.set(2, equipo_con_mas_goles);
          System.out.println("Existe un empate de diferencia de goles entre el segundo y tercer equipo");}

   
   return new Equipo[]{equipos.get(3), equipos.get(2)};}

    //Funcion que desempata segun el equipo que tiene mas goles a favor 
    //Retorna dos equipos con mayor numero de goles anotados
    public Equipo[] desempate_4equipos_mas_goles(Equipo uno,Equipo dos, Equipo tres, Equipo cuatro){
        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        equipos.add(uno);
        equipos.add(dos);
        equipos.add(tres);
        equipos.add(cuatro);
        int len = equipos.size();
        //Metodo de ordenamiento 
        //Los dos mejores equipos segun goles a favor quedan en la pos 3 y 2
        for (var i = 0; i < len ; i++) {
            for(var j = 0 ; j < len - i - 1; j++){
                if (equipos.get(j).getGolesAfavor()> equipos.get(j + 1).getGolesAfavor()) { 
                    Equipo temp = equipos.get(j);
                    equipos.set(j, equipos.get(j+1));
                    equipos.set(j + 1, temp);
        }
       }
      }
      //Si los equipos tienen la cantidad de goles a favor  
      if(equipos.get(0).getGolesAfavor() == equipos.get(1).getGolesAfavor()       //Si el equipo en primera, segunda y tercera pos estan empates de puntos
        & equipos.get(1).getGolesAfavor()==equipos.get(2).getGolesAfavor()
        & equipos.get(2).getGolesAfavor()==equipos.get(3).getGolesAfavor()){
        //SE realiza una rifa
        //NO es neceario ver los resultados de sus partidos
        //Este caso se genera si todos los partidos tienen la misma cantidad de puntos y goles 
        //Por lo que sus partidos tambien tendran los mismos resultados (Todos ganaron al menos una vez o todos empates) 
        System.out.println("Existe un empate de goles anotados entre el primero, segundo, tercero y cuarto equipo");
        Equipo ganador_rifa1 = rifa(equipos.get(0),equipos.get(1));
        Equipo ganador_rifa2 = rifa(equipos.get(2),equipos.get(3));
        return new Equipo[]{ganador_rifa1, ganador_rifa2};
      
      }
      //Si el segundo y tercer equipo tienen el mismo  numero de goles a favor 
      if(equipos.get(1).getGolesAfavor() == equipos.get(2).getGolesAfavor()){
          //Se busca el resultado de su partido y se retorna el ganador de tal partido 
            System.out.println("Existe un empate de goles anotados entre el segundo y tercer equipo");
            //Busca el ganador del partido entre los dos equipos y lo coloca en el segundo lugar
            equipos.set(2,equipo_ganador(equipos.get(2),equipos.get(1)));
      }

   
   return new Equipo[]{equipos.get(3), equipos.get(2)};}

          
    public  Equipo[] MejoresGrupo2(Equipo uno,Equipo dos, Equipo tres, Equipo cuatro){
        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        equipos.add(uno);
        equipos.add(dos);
        equipos.add(tres);
        equipos.add(cuatro);
        
      
      int len = equipos.size();
    
      for (var i = 0; i < len ; i++) {
        for(var j = 0 ; j < len - i - 1; j++){
        if (equipos.get(j).getPuntos() > equipos.get(j + 1).getPuntos()) { 
          Equipo temp = equipos.get(j);
          equipos.set(j, equipos.get(j+1));
          equipos.set(j + 1, temp);
        }
       }
      }
      //Si los equipos tienen el mismo numero de puntos
      if(equipos.get(0).getPuntos() == equipos.get(1).getPuntos()       
         & equipos.get(1).getPuntos()==equipos.get(2).getPuntos()
         & equipos.get(2).getPuntos()==equipos.get(3).getPuntos()){
          System.out.println("Existe un empate entre el primero, segundo, tercero y cuarto equipo");
          return desempate_4equipos_diferencia_goles(equipos.get(0),equipos.get(1),
                                                       equipos.get(2),equipos.get(3));
      }
      //Si el segundo lugar y tercer lugar tienen el mismo numero de puntos
      if(equipos.get(1).getPuntos() == equipos.get(2).getPuntos()){
            System.out.println("Existe un empate entre el segundo y tercer equipo");
            //Se llama una funcion que retorna el equipo con mayor diferencia de goles positiva
            Equipo equipo_mayor_dif_goles_positiva = equipo_dif_goles_pos(equipos.get(1),equipos.get(2));
            equipos.set(2, equipo_mayor_dif_goles_positiva);
      }
      return new Equipo[]{equipos.get(3), equipos.get(2)};
    }
        
    
    public Equipo[] MejoresGrupo(String grupo){
        if(grupo.equals("A")){
            Equipo uno = buscaEquipo("Qatar");
            Equipo dos = buscaEquipo("Ecuador");
            Equipo tres = buscaEquipo("Senegal");
            Equipo cuatro = buscaEquipo("Países Bajos");
            return MejoresGrupo2(uno,dos,tres,cuatro);

        }
        if(grupo.equals("B")){
            Equipo uno = buscaEquipo("Inglaterra");
            Equipo dos = buscaEquipo("Irán");
            Equipo tres = buscaEquipo("Estados Unidos");
            Equipo cuatro = buscaEquipo("Gales");
            return MejoresGrupo2(uno,dos,tres,cuatro);

        }

        if(grupo.equals("C")){
            Equipo uno = buscaEquipo("Argentina");
            Equipo dos = buscaEquipo("Arabia Saudí");
            Equipo tres = buscaEquipo("México");
            Equipo cuatro = buscaEquipo("Polonia");
            return MejoresGrupo2(uno,dos,tres,cuatro);

        }

        if(grupo.equals("D")){
            Equipo uno = buscaEquipo("Francia");
            Equipo dos = buscaEquipo("Australia");
            Equipo tres = buscaEquipo("Dinamarca");
            Equipo cuatro = buscaEquipo("Túnez");
            return MejoresGrupo2(uno,dos,tres,cuatro);

        }

        if(grupo.equals("E")){
            Equipo uno = buscaEquipo("España");
            Equipo dos = buscaEquipo("Costa Rica");
            Equipo tres = buscaEquipo("Alemania");
            Equipo cuatro = buscaEquipo("Japón");
            return MejoresGrupo2(uno,dos,tres,cuatro);

        }

        if(grupo.equals("F")){
            Equipo uno = buscaEquipo("Bélgica");
            Equipo dos = buscaEquipo("Canadá");
            Equipo tres = buscaEquipo("Marruecos");
            Equipo cuatro = buscaEquipo("Croacia");
            return MejoresGrupo2(uno,dos,tres,cuatro);

        }

        if(grupo.equals("G")){
            Equipo uno = buscaEquipo("Brasil");
            Equipo dos = buscaEquipo("Serbia");
            Equipo tres = buscaEquipo("Suiza");
            Equipo cuatro = buscaEquipo("Camerún");
            return MejoresGrupo2(uno,dos,tres,cuatro);

        }

        if(grupo.equals("H")){
            Equipo uno = buscaEquipo("Portugal");
            Equipo dos = buscaEquipo("Ghana");
            Equipo tres = buscaEquipo("Uruguay");
            Equipo cuatro = buscaEquipo("Corea del Sur");
            return MejoresGrupo2(uno,dos,tres,cuatro);

        }
        return null;
    }
    
    
    public void iniciaFaseGrupos(){
        equipos.removeAll(equipos);
        equipos.add(new Equipo("Qatar",1441)); 
        equipos.add( new Equipo("Ecuador",1463)); 
        equipos.add( new Equipo("Senegal",1584)); 
        equipos.add( new Equipo("Paises Bajos",1679));
        equipos.add( new Equipo("Inglaterra",1737)); 
        equipos.add( new Equipo("Irán",1558)); 
        equipos.add( new Equipo("Estados Unidos",1635));
        equipos.add( new Equipo("Gales",1582)); 
        equipos.add( new Equipo("Argentina",1770)); 
        equipos.add( new Equipo("Arabia Saudí",1435));
        equipos.add( new Equipo("México",1649)); 
        equipos.add( new Equipo("Polonia",1546)); 
        equipos.add( new Equipo("Francia",1764)); 
        equipos.add( new Equipo("Australia",1483)); 
        equipos.add( new Equipo("Dinamarca",1665)); 
        equipos.add( new Equipo("Túnez",1507)); 
        equipos.add( new Equipo("España",1716)); 
        equipos.add( new Equipo("Costa Rica",1500));
        equipos.add( new Equipo("Alemania",1658)); 
        equipos.add( new Equipo("Japón",1554)); 
        equipos.add( new Equipo("Bélgica",1821)); 
        equipos.add( new Equipo("Canadá",1473)); 
        equipos.add( new Equipo("Marruecos",1558)); 
        equipos.add( new Equipo("Croacia",1632)); 
        equipos.add( new Equipo("Brasil",1837)); 
        equipos.add( new Equipo("Serbia",1549)); 
        equipos.add( new Equipo("Suiza",1621)); 
        equipos.add( new Equipo("Camerún",1484)); 
        equipos.add( new Equipo("Portugal",1678)); 
        equipos.add( new Equipo("Ghana",1393)); 
        equipos.add( new Equipo("Uruguay",1640)); 
        equipos.add( new Equipo("Corea del Sur",1526));
        equipos.add( new Equipo("Por Definir",0));
        
        
        partidosFaseGrupos.removeAll(partidosFaseGrupos);
       
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Senegal"),buscaEquipo( "Paises Bajos"),"21 Noviembre","11:00","Estadio Al Thumama(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Inglaterra"),buscaEquipo( "Irán"),"21 Noviembre","14:00","Estadio Khalifa(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Qatar"),buscaEquipo( "Ecuador"),"21 Noviembre","17:00","Estadio Al Bayt(Jor)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Estados Unidos"),buscaEquipo( "Gales"),"21 Noviembre","20:00","Estadio Ahmed bin Ali(Rayan)"));

        partidosFaseGrupos.add(new Partido(buscaEquipo("Argentina" ),buscaEquipo("Arabia Saudí"),"22 Noviembre","11:00","Estadio Nacional de Luisail"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Dinamarca" ),buscaEquipo("Túnez"),"22 Noviembre","14:00","Estadio Ciudad de la Educacion(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "México"),buscaEquipo("Polonia"),"22 Noviembre","17:00","Estadio 974(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Francia" ),buscaEquipo("Australia"),"22 Noviembre","20:00","Estadio Al Janoub(Al Wakrah)"));

        partidosFaseGrupos.add(new Partido(buscaEquipo( "Marruecos"),buscaEquipo("Croacia"),"23 Noviembre","11:00","Estadio Al Bayt(Jor)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Alemania"),buscaEquipo("Japón"),"23 Noviembre","14:00","Estadio Khalifa(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("España" ),buscaEquipo("Costa Rica"),"23 Noviembre","17:00","Estadio Al Thumama(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Bélgica"),buscaEquipo("Canadá"),"23 Noviembre","20:00","Estadio Ahmed bin Ali(Rayan)"));

        partidosFaseGrupos.add(new Partido(buscaEquipo( "Suiza"),buscaEquipo("Camerún"),"24 Noviembre","11:00","Estadio Al Janoub(Al Wakrah)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Uruguay"),buscaEquipo("Corea del Sur"),"24 Noviembre","14:00","Estadio Ciudad de la Educacion(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Portugal" ),buscaEquipo("Ghana"),"24 Noviembre","17:00","Estadio 974(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Brasil"),buscaEquipo("Serbia"),"24 Noviembre","20:00","Estadio Nacional de Luisail"));

        partidosFaseGrupos.add(new Partido(buscaEquipo(  "Gales"),buscaEquipo("Irán"),"25 Noviembre","11:00","Estadio Ahmed bin Ali(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Qatar" ),buscaEquipo("Senegal"),"25 Noviembre","14:00","Estadio Al Thumama(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Paises Bajos"),buscaEquipo("Ecuador"),"25 Noviembre","17:00","Estadio Khalifa(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Inglaterra"),buscaEquipo("Estados Unidos"),"25 Noviembre","20:00","Estadio Al Bayt(Jor)"));

        partidosFaseGrupos.add(new Partido(buscaEquipo("Túnez" ),buscaEquipo("Australia"),"26 Noviembre","11:00","Estadio Al Janoub(Al Wakrah)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Polonia" ),buscaEquipo("Arabia Saudí"),"26 Noviembre","14:00","Estadio Ciudad de la Educacion(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Francia"),buscaEquipo("Dinamarca"),"26 Noviembre","17:00","Estadio 974(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Argentina" ),buscaEquipo("México"),"26 Noviembre","20:00","Estadio Nacional de Luisail"));

        partidosFaseGrupos.add(new Partido(buscaEquipo("Japón"),buscaEquipo("Costa Rica"),"27 Noviembre","11:00","Estadio Ahmed bin Ali(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Bélgica" ),buscaEquipo("Marruecos"),"27 Noviembre","14:00","Estadio Al Thumama(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Croacia"),buscaEquipo("Canadá"),"27 Noviembre","17:00","Estadio Khalifa(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("España" ),buscaEquipo("Alemania"),"27 Noviembre","20:00","Estadio Al Bayt(Jor)"));

        partidosFaseGrupos.add(new Partido(buscaEquipo("Serbia" ),buscaEquipo("Camerún"),"28 Noviembre","11:00","Estadio Al Janoub(Al Wakrah)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Corea del Sur" ),buscaEquipo("Ghana"),"28 Noviembre","14:00","Estadio Ciudad de la Educacion(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Brasil" ),buscaEquipo("Suiza"),"28 Noviembre","17:00","Estadio 974(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Portugal" ),buscaEquipo("Uruguay"),"28 Noviembre","20:00","Estadio Nacional de Luisail"));

        partidosFaseGrupos.add(new Partido(buscaEquipo("Qatar" ),buscaEquipo("Paises Bajos"),"29 Noviembre","26:00","Estadio Al Bayt(Jor)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Gales"),buscaEquipo("Senegal"),"29 Noviembre","16:00","Estadio Khalifa(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Ecuador" ),buscaEquipo("Inglaterra"),"29 Noviembre","20:00","Estadio Ahmed bin Ali(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Irán" ),buscaEquipo("Estados Unidos"),"29 Noviembre","20:00","Estadio Al Thumama(Doha)"));

        partidosFaseGrupos.add(new Partido(buscaEquipo( "Túnez"),buscaEquipo("Francia"),"30 Noviembre","16:00","Estadio Ciudad de la Educacion(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Australia" ),buscaEquipo("Dinamarca"),"30 Noviembre","16:00","Estadio Al Janoub(Al Wakrah)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Polonia" ),buscaEquipo("Argentina"),"30 Noviembre","20:00","Estadio 974(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Arabia Saudí" ),buscaEquipo("México"),"30 Noviembre","20:00","Estadio Nacional de Luisail"));

        partidosFaseGrupos.add(new Partido(buscaEquipo("Croacia" ),buscaEquipo("Bélgica"),"1 Diciembre","16:00","Estadio Ahmed bin Ali(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Canadá"),buscaEquipo("Marruecos"),"1 Diciembre","16:00","Estadio Al Thumama(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Japón" ),buscaEquipo("España"),"1 Diciembre","20:00","Estadio Khalifa(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Costa Rica"),buscaEquipo("Alemania"),"1 Diciembre","20:00","Estadio Al Bayt(Jor)"));

        partidosFaseGrupos.add(new Partido(buscaEquipo("Corea del Sur" ),buscaEquipo("Portugal"),"2 Diciembre","16:00","Estadio Ciudad de la Educacion(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Ghana"),buscaEquipo("Uruguay"),"2 Diciembre","16:00","Estadio Al Janoub(Al Wakrah)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo( "Camerún"),buscaEquipo("Brasil"),"2 Diciembre","20:00","Estadio Nacional de Luisail"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Serbia"),buscaEquipo("Suiza"),"2 Diciembre","20:00","Estadio 974(Doha)"));
        //48 abajo
        
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"3 Diciembre","16:00","(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"3 Diciembre","20:00","(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"4 Diciembre","16:00","(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"4 Diciembre","20:00","(Jor)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"5 Diciembre","16:00","(Al Wakrah)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"5 Diciembre","20:00","(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"6 Diciembre","16:00","(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"6 Diciembre","20:00","(Lusail)"));
        //56
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"9 Diciembre","16:00","(Rayan)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"9 Diciembre","20:00","(Lusail)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"10 Diciembre","20:00","(Doha)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"10 Diciembre","20:00","(Jor)"));
        //60
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"13 Diciembre","20:00","(Lusail)"));
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"14 Diciembre","20:00","(Jor)"));
        //62
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"17 Diciembre","16:00","(Rayan)"));
        //63
        partidosFaseGrupos.add(new Partido(buscaEquipo("Por Definir"),buscaEquipo("Por Definir"),"18 Diciembre","16:00","(Lusail)"));
        
        
    }
    
    //Se cambia el tipo de funcion para hacer validaciones y retornar int en caso de errores 
    static public int actualiceMarcadorReal(String Marcador1,String marcador2){
        try {
            int marcador_local = Integer.parseInt(Marcador1);
            int marcador_visita = Integer.parseInt(marcador2);
            }
        catch(Exception e) {//Validacion de que la entrada sea un numero
            return -1;
        }
        int marcador_local = Integer.parseInt(Marcador1);
        int marcador_visita = Integer.parseInt(marcador2);
        partidosFaseGrupos.get(Datos.partidoActual).setMarcadorLocalReal(marcador_local);
        partidosFaseGrupos.get(Datos.partidoActual).setMarcadorVisitaReal(marcador_visita);
                    
        //Se almacena cuantos goles hicieron 
        partidosFaseGrupos.get(Datos.partidoActual).getVisita().setGolesAfavor(marcador_visita);
        partidosFaseGrupos.get(Datos.partidoActual).getVisita().setGolesEncontra(marcador_local);
        partidosFaseGrupos.get(Datos.partidoActual).getLocal().setGolesAfavor(marcador_local);
        partidosFaseGrupos.get(Datos.partidoActual).getLocal().setGolesEncontra(marcador_visita);
        
        int puntaje_actual_local = partidosFaseGrupos.get(Datos.partidoActual).getLocal().getPuntos();
        int puntaje_actual_visita = partidosFaseGrupos.get(Datos.partidoActual).getVisita().getPuntos();
        
        if (marcador_local == (marcador_visita)){//En caso de empate
            //Se almacena el puntaje de cada equipo en caos de empate(1pts)
            partidosFaseGrupos.get(Datos.partidoActual).getVisita().setPuntos(puntaje_actual_visita+1);
            partidosFaseGrupos.get(Datos.partidoActual).getLocal().setPuntos(puntaje_actual_local+1);
        }
        if (marcador_local > (marcador_visita)){//En caso de que local sea el ganador
            //Se almacena el puntaje para el equipo local (ganador)(3pts)
            partidosFaseGrupos.get(Datos.partidoActual).getLocal().setPuntos(puntaje_actual_local+3);
            
        }
        else{// En caso que la visita sea ganador
             //Se almacena el puntaje para el equipo visita (ganador)(3pts)
            partidosFaseGrupos.get(Datos.partidoActual).getVisita().setPuntos(puntaje_actual_visita+3);
        

        }
        System.out.println("El ganador es: \n");
        partidosFaseGrupos.get(Datos.partidoActual).getGanador().tostring();

        System.out.println("El perdedor es: \n");
        partidosFaseGrupos.get(Datos.partidoActual).getPerdedor().tostring();
        
    return 0;
    }
    
    
}