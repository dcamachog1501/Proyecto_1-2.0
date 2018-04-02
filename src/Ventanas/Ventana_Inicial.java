/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.*;

/**
 *
 * @author dcama
 */
public class Ventana_Inicial extends JFrame
{
    private String title;
    private Image back;
    private Image icono;
    private Color color;
    private Font fuentem;
    private Gestor2 gest;
    public Ventana_Inicial() 
    {
        
    }
    
    public Ventana_Inicial(String title,Font Fuente,Image back,Image Icono, Color Btn, Gestor2 gest)
    {
        this.gest = gest;
        this.title=title;
        this.fuentem=Fuente;
        this.icono=Icono;
        this.color=Btn;
        this.back=back;
        Init();
      
    }
    public void Init()
    {
      setTitle(title);
      setResizable(false);
      setUndecorated(true);
      setIconImage(icono);
      setSize(600,700);
      setLocationRelativeTo(null);
      getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,Color.BLACK));
      JLabel Uno= new JLabel(new ImageIcon(back));
      Uno.setLayout(new BoxLayout(Uno,BoxLayout.Y_AXIS));
      
      //Titulo principal
      JLabel Title= new JLabel("Invaders");
      Title.setFont(fuentem.deriveFont(Font.PLAIN,80));
      Title.setForeground(Color.GREEN);
      Title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      Uno.add(Title);
     
      //Icono del juego
      JLabel Icon=new JLabel();
      Icon.setIcon(new ImageIcon("Resources/Iconos/Icono2.png"));
      Icon.setHorizontalAlignment(JLabel.CENTER);
      Icon.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      Uno.add(Icon);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      
      //Boton para jugar
      JButton Jugar= new JButton("PLAY!");
      Jugar.setFont(fuentem.deriveFont(Font.PLAIN,20));
      Jugar.setForeground(color);
      Jugar.setBackground(Color.GREEN);
      Jugar.setAlignmentX(JButton.CENTER_ALIGNMENT);
      Jugar.setMaximumSize(new Dimension(300,100));
      Jugar.setFocusPainted(false);
      Jugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Jugar.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
      Jugar.addActionListener(new ActionListener()
        {
       @Override
       public void actionPerformed(ActionEvent e) 
       {
        dispose();
        gest.gestDatos();
       }
        });
      Uno.add(Jugar);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      //Boton para ver los puntajes mas altos
      JButton Estadísticas= new JButton("Records");
      Estadísticas.setFont(fuentem.deriveFont(Font.PLAIN,20));
      Estadísticas.setForeground(color);
      Estadísticas.setBackground(Color.GREEN);
      Estadísticas.setAlignmentX(JButton.CENTER_ALIGNMENT);
      Estadísticas.setMaximumSize(new Dimension(300,100));
      Estadísticas.setFocusPainted(false);
      Estadísticas.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Estadísticas.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
      Estadísticas.addActionListener(new ActionListener()
   {
       @Override
       public void actionPerformed(ActionEvent e) 
       {
        dispose();
        gest.gestStatics();
       }
   });
      Uno.add(Estadísticas);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      //Boton para salir del juego 
      JButton Salir= new JButton("Quit");
      Salir.setFont(fuentem.deriveFont(Font.PLAIN,20));
      Salir.setForeground(color);
      Salir.setBackground(Color.GREEN);
      Salir.setAlignmentX(JButton.CENTER_ALIGNMENT);
      Salir.setMaximumSize(new Dimension(300,100));
      Salir.setFocusPainted(false);
      Salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Salir.addActionListener(new ActionListener()
   {
       @Override
       public void actionPerformed(ActionEvent e) 
       {
        System.exit(0);
       }
   });
      Salir.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
      Uno.add(Salir);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      add(Uno,BorderLayout.CENTER); 
    }
}
