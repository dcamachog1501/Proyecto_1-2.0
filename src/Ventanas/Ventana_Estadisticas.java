/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dcama
 */
public class Ventana_Estadisticas extends JFrame
{
    private String title;
    private Image back;
    private Image icono;
    private Color color;
    private Font fuentem;
    private Gestor2 gest;
    private Image back2;
    public Ventana_Estadisticas()
    {
        
    }
    public Ventana_Estadisticas(String title,Font Fuente,Image back,Image Icono, Color Btn, Image back2,Gestor2 gest)
    {
        this.title=title;
        this.back=back;
        this.color=Btn;
        this.icono=Icono;
        this.color=Btn;
        this.fuentem=Fuente;
        this.gest=gest;
        this.back2=back2;
        Init();
    }
    public void Init()
    {
        setTitle(title);
        setSize(1050,700);
        setResizable(false);
        setUndecorated(true);
        setIconImage(icono);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,Color.BLACK));

        JPanel Panel1= new JPanel();
        Panel1.setBackground(Color.DARK_GRAY);
        Panel1.setPreferredSize(new Dimension(200,1000));
        Panel1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4,Color.BLACK));
        Panel1.setLayout(null);
        add(Panel1,BorderLayout.WEST);

        JPanel Panel2= new JPanel();
        Panel2.setBackground(Color.DARK_GRAY);
        Panel2.setPreferredSize(new Dimension(225,1000));
        Panel2.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0,Color.BLACK));
        Panel2.setLayout(null);
        add(Panel2,BorderLayout.EAST);

        JPanel Panel3= new JPanel();
        Panel3.setBackground(Color.DARK_GRAY);
        Panel3.setPreferredSize(new Dimension(200,2000));
        Panel3.setLayout(null);
        add(Panel3,BorderLayout.CENTER);

        JLabel Label1= new JLabel();
        Label1.setOpaque(true);
        Label1.setBackground(color);
        Label1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4,Color.BLACK));
        Label1.setBounds(0,0,25,700);
        Panel3.add(Label1);

        JLabel Label2= new JLabel();
        Label2.setOpaque(true);
        Label2.setBackground(color);
        Label2.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0,Color.BLACK));
        Label2.setBounds(593,0,25,700);
        Panel3.add(Label2);
        //Titulo principal de la ventana
        JLabel Label3= new JLabel("GALAXY'S BEST PILOTS");
        Label3.setFont(fuentem.deriveFont(Font.PLAIN, 40));
        Label3.setForeground(Color.GREEN);
        Label3.setBounds(60,0,1000,100);
        Panel3.add(Label3);

         JLabel Label4= new JLabel("1.     --");
        Label4.setFont(fuentem.deriveFont(Font.PLAIN, 40));
        Label4.setForeground(Color.GREEN);
        Label4.setBounds(40,100,1000,100);
        Panel3.add(Label4);

         JLabel Label5= new JLabel("2.     --");
        Label5.setFont(fuentem.deriveFont(Font.PLAIN, 40));
        Label5.setForeground(Color.GREEN);
        Label5.setBounds(40,200,1000,100);
        Panel3.add(Label5);

         JLabel Label6= new JLabel("3.     --");
        Label6.setFont(fuentem.deriveFont(Font.PLAIN, 40));
        Label6.setForeground(Color.GREEN);
        Label6.setBounds(40,300,1000,100);
        Panel3.add(Label6);

         JLabel Label7= new JLabel("4.     --");
        Label7.setFont(fuentem.deriveFont(Font.PLAIN, 40));
        Label7.setForeground(Color.GREEN);
        Label7.setBounds(40,400,1000,100);
        Panel3.add(Label7);

         JLabel Label8= new JLabel("5.     --");
        Label8.setFont(fuentem.deriveFont(Font.PLAIN, 40));
        Label8.setForeground(Color.GREEN);
        Label8.setBounds(40,500,1000,100);
        Panel3.add(Label8);
        //Boton para volver al menu principal 
        JButton Menu= new JButton("MAIN MENU");
        Menu.setForeground(Color.GREEN);
        Menu.setBackground(color);
        Menu.setFont(fuentem.deriveFont(Font.PLAIN,20));
        Menu.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
        Menu.setFocusPainted(false);
        Menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Menu.setBounds(20,550, 200, 70);
        Menu.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
                gest.gestInicial();
            }

        });
        Panel1.add(Menu);
        //Boton para salir del juego 
        JButton Abort = new JButton("ABORT");
        Abort.setForeground(Color.GREEN);
        Abort.setBackground(color);
        Abort.setFont(fuentem.deriveFont(Font.PLAIN,20));
        Abort.setBorder(BorderFactory.createMatteBorder(4,0,4,4,Color.BLACK));
        Abort.setFocusPainted(false);
        Abort.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Abort.setBounds(0,75, 200, 70);
        Abort.addActionListener(new ActionListener()
        {


            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        }
        );
        Panel2.add(Abort);

        JLabel Back3=new JLabel();
        Back3.setIcon(new ImageIcon(back2));
        Back3.setBounds(0,0,200,700);
        Back3.setBorder(BorderFactory.createMatteBorder(0,0,0,4,Color.BLACK));
        Panel1.add(Back3);

        JLabel Back4=new JLabel();
        Back4.setIcon(new ImageIcon(back2));
        Back4.setBounds(0,0,250,700);
        Back4.setBorder(BorderFactory.createMatteBorder(0,4,0,0,Color.BLACK));
        Panel2.add(Back4);
    }
}
