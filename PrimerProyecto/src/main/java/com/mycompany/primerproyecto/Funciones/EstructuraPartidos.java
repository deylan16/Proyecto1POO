/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto.Funciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    static public String infoPartido(String opcion,String Fase,int Ipartido){
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
    public Equipo[] MejoresGrupo2(Equipo uno,Equipo dos, Equipo tres, Equipo cuatro){
        ArrayList<Integer> puntos = new ArrayList<Integer>();
        puntos.add(uno.getPuntos());
        puntos.add(dos.getPuntos());
        puntos.add(tres.getPuntos());
        puntos.add(cuatro.getPuntos());
        Comparator<Integer> comparador = Collections.reverseOrder();
        puntos.sort(comparador);
        //TODO:
        return new Equipo[]{uno, dos};

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
    
    static public void actualiceMarcadorReal(String Marcador1,String marcador2){
        partidosFaseGrupos.get(Datos.partidoActual).setMarcadorLocalReal(Integer.parseInt(Marcador1));
        partidosFaseGrupos.get(Datos.partidoActual).setMarcadorVisitaReal(Integer.parseInt(marcador2));
        System.out.println("helooooooooooooooooooooooooooooooooooooooo");
        System.out.println(EstructuraPartidos.infoPartido("MarcadorVisitaReal","Grupos",Datos.partidoActual));
    }
    
    
}
