/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.primerproyecto.Interfaz;

import com.mycompany.primerproyecto.Funciones.Datos;
import static com.mycompany.primerproyecto.Funciones.Datos.getUsuarioActual;
import com.mycompany.primerproyecto.Funciones.EstructuraPartidos;
import com.mycompany.primerproyecto.Funciones.Funciones;
import java.util.Random;
import javax.swing.SpinnerDateModel;


/**
 *
 * @author deyla
 */
public class VentanaApuesta extends javax.swing.JFrame {
    public int partido;
    public String ruta = "C:\\Users\\jecheverria\\Desktop\\escudos";
    /**
     * Creates new form VentanaApuesta
     */
    public VentanaApuesta(int partido) {
       
        
        this.partido = partido;
        initComponents();
        cbGanadorPenales.addItem(new EstructuraPartidos().infoPartido("Local","Grupos",this.partido));
        cbGanadorPenales.addItem(new EstructuraPartidos().infoPartido("Visita","Grupos",this.partido));
        cbGanadorPenales.setSelectedIndex(Datos.getUsuarioActual().getGanadoresEmpateIndex(partido));
        if(Datos.partidoActual> partido){
            tfAdivinanza1.setEditable(false);
            tfAdivinanza2.setEditable(false);
            cbGanadorPenales.setEditable(false);
            btAleatorio.setEnabled(false);
            btHeuristica.setEnabled(false);
            int contador = 0;
            System.out.println("************");
            System.out.println(Datos.getUsuarioActual().getApuestasGrupos()[partido][0]);
            System.out.println(Datos.getUsuarioActual().getApuestasGrupos()[partido][1]);
            System.out.println(EstructuraPartidos.infoPartido("MarcadorLocalReal","Grupos",this.partido));
            System.out.println(EstructuraPartidos.infoPartido("MarcadorVisitaReal","Grupos",this.partido));
            System.out.println("************");
            if (Datos.partidoActual > 47){
                if(EstructuraPartidos.infoPartido("MarcadorLocalReal","Grupos",this.partido).equals(EstructuraPartidos.infoPartido("MarcadorVisitaReal","Grupos",this.partido))){
                    lbTituloGanadorEmpate.setText("Gano en penales");
                    lbGanadorEmpate.setText(EstructuraPartidos.infoPartido("GanadorPenales","Grupos",this.partido));
                    cbGanadorPenales.setSelectedIndex(Datos.getUsuarioActual().getGanadoresEmpateIndex(partido));
                    
                }
            }
            if(!"-".equals(Datos.getUsuarioActual().getApuestasGrupos()[partido][0]) && !"-".equals(Datos.getUsuarioActual().getApuestasGrupos()[partido][1])){
                System.out.println("holka");
                if (EstructuraPartidos.infoPartido("GanadorAdivinanza","Grupos",this.partido) == EstructuraPartidos.infoPartido("GanadorReal","Grupos",this.partido)){
                    System.out.println("holka1");
                    contador += 5;
                }
                String reallocal = EstructuraPartidos.infoPartido("MarcadorLocalReal","Grupos",this.partido);
                String realvisita = EstructuraPartidos.infoPartido("MarcadorVisitaReal","Grupos",this.partido);
                if(reallocal.equals(Datos.getUsuarioActual().getApuestasGrupos()[partido][0])&&  realvisita.equals(Datos.getUsuarioActual().getApuestasGrupos()[partido][1])){
                    System.out.println("holka2");
                    contador += 5;
                }
                lbPuntosObtenidos.setText("+" + Integer.toString(contador));
            }
            else{
                lbPuntosObtenidos.setText("No tiene puntos ");
            }
            
        }
        if(partido> 47){
            cbGanadorPenales.setVisible(true);
        }
        else{
            cbGanadorPenales.setVisible(false);
        }
        System.out.println("****");
        System.out.println(EstructuraPartidos.infoPartido("MarcadorVisitaReal","Grupos",Datos.partidoActual));
        if(EstructuraPartidos.infoPartido("MarcadorVisitaReal","Grupos",this.partido) == null){
            
            this.lbMarcadorReal2.setText("-");
            
        }else{
            this.lbMarcadorReal2.setText(EstructuraPartidos.infoPartido("MarcadorVisitaReal","Grupos",this.partido));
        }
        if( EstructuraPartidos.infoPartido("MarcadorLocalReal","Grupos",this.partido) == null){
            this.lbMarcadorReal1.setText("-");
        }else{
            this.lbMarcadorReal1.setText(EstructuraPartidos.infoPartido("MarcadorLocalReal","Grupos",this.partido));
        }
        if(Datos.getUsuarioActual().getApuestasGrupos()[partido][0] == null){
            tfAdivinanza1.setText("-");
        }else{
             tfAdivinanza1.setText(Datos.getUsuarioActual().getApuestasGrupos()[partido][0]);
        }
        if(Datos.getUsuarioActual().getApuestasGrupos()[partido][1] == null){
            tfAdivinanza2.setText("-");
        }else{
             tfAdivinanza2.setText(Datos.getUsuarioActual().getApuestasGrupos()[partido][1]);
        }
        
        
    }
    /*if (Datos.partidoActual > 47){
                if (marcador_local == marcador_visita){
                    System.out.println("Empate");
                    int marcadorpenales = (new Random()).nextInt(2);
                    System.out.println(marcadorpenales);
                    if(marcadorpenales == 1){
                        partidosFaseGrupos.get(Datos.partidoActual).setGanadorPorEmpate( partidosFaseGrupos.get(Datos.partidoActual).getVisita().getNombre()); 
                    }else{
                        partidosFaseGrupos.get(Datos.partidoActual).setGanadorPorEmpate( partidosFaseGrupos.get(Datos.partidoActual).getLocal().getNombre()); 
                    }
                }
            }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbEscudo1 = new javax.swing.JLabel();
        lbEscudo2 = new javax.swing.JLabel();
        lbNombre1 = new javax.swing.JLabel();
        lbNombre2 = new javax.swing.JLabel();
        lbMarcadorReal1 = new javax.swing.JLabel();
        lbMarcadorReal2 = new javax.swing.JLabel();
        lbEstadio = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        lbMarcadorQuiniela = new javax.swing.JLabel();
        lbMarcadorReal = new javax.swing.JLabel();
        tfAdivinanza2 = new javax.swing.JTextField();
        tfAdivinanza1 = new javax.swing.JTextField();
        btSubir = new javax.swing.JButton();
        btAleatorio = new javax.swing.JButton();
        btHeuristica = new javax.swing.JButton();
        cbGanadorPenales = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lbtituloObtenidos = new javax.swing.JLabel();
        lbPuntosObtenidos = new javax.swing.JLabel();
        lbTituloGanadorEmpate = new javax.swing.JLabel();
        lbGanadorEmpate = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 0, 0));

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));

        lbEscudo1.setBackground(new java.awt.Color(102, 0, 0));
        lbEscudo1.setForeground(new java.awt.Color(102, 0, 0));
        lbEscudo1.setIcon(new javax.swing.ImageIcon(this.ruta+new EstructuraPartidos().infoPartido("Local","Grupos",this.partido)+".png"));

        lbEscudo2.setBackground(new java.awt.Color(102, 0, 0));
        lbEscudo2.setIcon(new javax.swing.ImageIcon(this.ruta+new EstructuraPartidos().infoPartido("Visita","Grupos",this.partido)+".png"));

        lbNombre1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbNombre1.setForeground(new java.awt.Color(204, 204, 0));
        lbNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombre1.setText(new EstructuraPartidos().infoPartido("Local","Grupos",this.partido));

        lbNombre2.setBackground(new java.awt.Color(102, 0, 0));
        lbNombre2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbNombre2.setForeground(new java.awt.Color(204, 204, 0));
        lbNombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombre2.setText(new EstructuraPartidos().infoPartido("Visita","Grupos",this.partido));

        lbMarcadorReal1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lbMarcadorReal1.setForeground(new java.awt.Color(204, 204, 0));
        lbMarcadorReal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMarcadorReal1.setText(new EstructuraPartidos().infoPartido("MarcadorLocalReal","Grupos",this.partido));

        lbMarcadorReal2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lbMarcadorReal2.setForeground(new java.awt.Color(204, 204, 0));
        lbMarcadorReal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMarcadorReal2.setText(new EstructuraPartidos().infoPartido("MarcadorVisitaReal","Grupos",this.partido));

        lbEstadio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbEstadio.setForeground(new java.awt.Color(204, 204, 0));
        lbEstadio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEstadio.setText(new EstructuraPartidos().infoPartido("Estadio","Grupos",this.partido));

        lbFecha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(204, 204, 0));
        lbFecha.setText(new EstructuraPartidos().infoPartido("Fecha","Grupos",this.partido));

        lbHora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbHora.setForeground(new java.awt.Color(204, 204, 0));
        lbHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHora.setText(new EstructuraPartidos().infoPartido("Hora","Grupos",this.partido));

        lbMarcadorQuiniela.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbMarcadorQuiniela.setForeground(new java.awt.Color(204, 204, 0));
        lbMarcadorQuiniela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMarcadorQuiniela.setText("Marcador Quiniela");

        lbMarcadorReal.setBackground(new java.awt.Color(204, 204, 0));
        lbMarcadorReal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbMarcadorReal.setForeground(new java.awt.Color(204, 204, 0));
        lbMarcadorReal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMarcadorReal.setText("Marcador Real");

        tfAdivinanza2.setColumns(1);
        tfAdivinanza2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        tfAdivinanza2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfAdivinanza2.setText("0");

        tfAdivinanza1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        tfAdivinanza1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfAdivinanza1.setText("0");

        btSubir.setText("Subir");
        btSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubirActionPerformed(evt);
            }
        });

        btAleatorio.setText("Aleatorio");
        btAleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAleatorioActionPerformed(evt);
            }
        });

        btHeuristica.setText("Heuristica");
        btHeuristica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHeuristicaActionPerformed(evt);
            }
        });

        cbGanadorPenales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGanadorPenalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbEscudo2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(lbNombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbMarcadorReal2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btHeuristica)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbGanadorPenales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btSubir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(btAleatorio)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lbNombre1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbEscudo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbMarcadorReal1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(189, 189, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbMarcadorQuiniela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(lbEstadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(tfAdivinanza1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfAdivinanza2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbMarcadorReal, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                            .addContainerGap()))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(lbMarcadorReal2)
                .addGap(26, 26, 26)
                .addComponent(lbNombre2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEscudo2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(cbGanadorPenales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSubir)
                    .addComponent(btAleatorio)
                    .addComponent(btHeuristica))
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbMarcadorReal)
                    .addGap(27, 27, 27)
                    .addComponent(lbMarcadorReal1)
                    .addGap(27, 27, 27)
                    .addComponent(lbNombre1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbEscudo1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addComponent(lbMarcadorQuiniela)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfAdivinanza2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                        .addComponent(tfAdivinanza1))
                    .addGap(34, 34, 34)
                    .addComponent(lbEstadio)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFecha)
                        .addComponent(lbHora))
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));

        lbtituloObtenidos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbtituloObtenidos.setForeground(new java.awt.Color(204, 204, 0));
        lbtituloObtenidos.setText("Puntos Obtenidos");

        lbPuntosObtenidos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbPuntosObtenidos.setForeground(new java.awt.Color(204, 204, 0));

        lbTituloGanadorEmpate.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbTituloGanadorEmpate.setForeground(new java.awt.Color(204, 204, 0));

        lbGanadorEmpate.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbGanadorEmpate.setForeground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtituloObtenidos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbPuntosObtenidos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTituloGanadorEmpate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbGanadorEmpate, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(lbtituloObtenidos)
                .addGap(88, 88, 88)
                .addComponent(lbPuntosObtenidos)
                .addGap(88, 88, 88)
                .addComponent(lbTituloGanadorEmpate)
                .addGap(88, 88, 88)
                .addComponent(lbGanadorEmpate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubirActionPerformed
        Datos.getUsuarioActual().setApuestasGrupos(tfAdivinanza1.getText(), tfAdivinanza2.getText(), partido);
        Datos.getUsuarioActual().setGanadoresEmpate(cbGanadorPenales.getSelectedIndex(), partido);
        if(Datos.Admin){
            System.out.println(tfAdivinanza1.getText());
            EstructuraPartidos.actualiceMarcadorReal(tfAdivinanza1.getText(), tfAdivinanza2.getText());
            if (Datos.partidoActual > 47){
                if(EstructuraPartidos.infoPartido("MarcadorLocalReal","Grupos",this.partido).equals(EstructuraPartidos.infoPartido("MarcadorVisitaReal","Grupos",this.partido))){
                    
                    EstructuraPartidos.actualiceEmpatePartido(partido, (String)cbGanadorPenales.getSelectedItem());
                    Datos.getUsuarioActual().setGanadoresEmpate(cbGanadorPenales.getSelectedIndex(), partido);
                }
            }
            
                
            
            Datos.partidoActual += 1;
            /*System.out.println("###############");
            System.out.println(Datos.partidoActual);
            System.out.println("###############");*/
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
                /*System.out.println("###############++++");
                System.out.println("Grupo A");
                //EstructuraPartidos.partidosFaseGrupos.get(58).set;
                System.out.println(new EstructuraPartidos().MejoresGrupo("A")[0].getNombre());
                System.out.println(new EstructuraPartidos().MejoresGrupo("A")[1].getNombre());
                System.out.println("Grupo B");
                System.out.println(new EstructuraPartidos().MejoresGrupo("B")[0].getNombre());
                System.out.println(new EstructuraPartidos().MejoresGrupo("B")[1].getNombre());
                System.out.println("Grupo C");
                System.out.println(new EstructuraPartidos().MejoresGrupo("C")[0].getNombre());
                System.out.println(new EstructuraPartidos().MejoresGrupo("C")[1].getNombre());
                System.out.println("Grupo D");
                System.out.println(new EstructuraPartidos().MejoresGrupo("D")[0].getNombre());
                System.out.println(new EstructuraPartidos().MejoresGrupo("D")[1].getNombre());
                System.out.println("Grupo E");
                System.out.println(new EstructuraPartidos().MejoresGrupo("E")[0].getNombre());
                System.out.println(new EstructuraPartidos().MejoresGrupo("E")[1].getNombre());
                System.out.println("Grupo F");
                System.out.println(new EstructuraPartidos().MejoresGrupo("F")[0].getNombre());
                System.out.println(new EstructuraPartidos().MejoresGrupo("F")[1].getNombre());
                System.out.println("Grupo G");
                System.out.println(new EstructuraPartidos().MejoresGrupo("G")[0].getNombre());
                System.out.println(new EstructuraPartidos().MejoresGrupo("G")[1].getNombre());
                System.out.println("Grupo H");
                System.out.println(new EstructuraPartidos().MejoresGrupo("H")[0].getNombre());
                System.out.println(new EstructuraPartidos().MejoresGrupo("H")[1].getNombre());
                System.out.println("###############+++");
                System.out.println("###############++++");
                System.out.println("Grupo A");*/
                //EstructuraPartidos.partidosFaseGrupos.get(58).set;
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
                System.out.println("###############+++");
            }
            
        
        }
        setVisible(false);
        dispose();

        System.out.println("holoaaaa");
        
    }//GEN-LAST:event_btSubirActionPerformed

    private void btAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAleatorioActionPerformed
        String[] resultados = Funciones.generarMaracadorAleatorio();
        tfAdivinanza1.setText(resultados[0]);
        tfAdivinanza2.setText(resultados[1]);
        if (Datos.partidoActual > 47){
                if (tfAdivinanza2.getText().equals(tfAdivinanza1.getText())){
                    System.out.println("Empate");
                    int marcadorpenales = (new Random()).nextInt(9);
                    System.out.println(marcadorpenales);
                    if(marcadorpenales >= 5){
                        cbGanadorPenales.setSelectedIndex(1);
                    }
                    else{
                        cbGanadorPenales.setSelectedIndex(0);
                    }
                    
                }
            }
        
        
    }//GEN-LAST:event_btAleatorioActionPerformed

    private void btHeuristicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHeuristicaActionPerformed
        String[] resultados =Funciones.generarMaracadorheuristica(partido);
        tfAdivinanza1.setText(resultados[0]);
        tfAdivinanza2.setText(resultados[1]);
        if (Datos.partidoActual > 47){
                if (tfAdivinanza2.getText() == tfAdivinanza1.getText()){
                    System.out.println("Empate");
                    int marcadorpenales = (new Random()).nextInt(1);
                    System.out.println(marcadorpenales);
                    cbGanadorPenales.setSelectedIndex(marcadorpenales);
                }
            }
    }//GEN-LAST:event_btHeuristicaActionPerformed

    private void cbGanadorPenalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGanadorPenalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGanadorPenalesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaApuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaApuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaApuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaApuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaApuesta(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAleatorio;
    private javax.swing.JButton btHeuristica;
    private javax.swing.JButton btSubir;
    private javax.swing.JComboBox<String> cbGanadorPenales;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbEscudo1;
    private javax.swing.JLabel lbEscudo2;
    private javax.swing.JLabel lbEstadio;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbGanadorEmpate;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbMarcadorQuiniela;
    private javax.swing.JLabel lbMarcadorReal;
    private javax.swing.JLabel lbMarcadorReal1;
    private javax.swing.JLabel lbMarcadorReal2;
    private javax.swing.JLabel lbNombre1;
    private javax.swing.JLabel lbNombre2;
    private javax.swing.JLabel lbPuntosObtenidos;
    private javax.swing.JLabel lbTituloGanadorEmpate;
    private javax.swing.JLabel lbtituloObtenidos;
    private javax.swing.JTextField tfAdivinanza1;
    private javax.swing.JTextField tfAdivinanza2;
    // End of variables declaration//GEN-END:variables
}
