/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Manager.LevelManager;
import Threads.Level_Verifier;
import Threads.Setup;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Daniel Camacho
 */
public class Ventana_Datos extends JFrame
{
 //Variables que almacenan los datos del jugador 
  private Image PlayerNav;
  private String PlayerNam;
  
  
  //Indice para recorrer las listas de naves 
  private  int ind=0;
  
  
  //Naves disponibles en el juego(dependiendo del tamaño se utilizan en diferentes partes del juego)
  private final Image Back1=Toolkit.getDefaultToolkit().getImage("Resources/Backgrounds/Back.png");
  private  final Image Nav1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave1.png");
  private  final Image Nav2=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave2.png");
  private  final Image Nav3=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave3.png");
  private  final Image Nav4=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave4.png");
  private  final Image Nav1_1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave1_1.png");
  private  final Image Nav2_1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave2_1.png");
  private  final Image Nav3_1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave3_1.png");
  private  final Image Nav4_1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave4_1.png");
  private final Image Right=Toolkit.getDefaultToolkit().getImage("Resources/Iconos/right.png");
  private final Image Left=Toolkit.getDefaultToolkit().getImage("Resources/Iconos/left.png");
  private Setup Inicio;
  private Level_Verifier Level;
  private Thread LevelT;
  private boolean cond;
  
  
  //Arrays que contienen las diferentes naves 
  private  Image navselector[]=new Image[]{Nav1,Nav2,Nav3,Nav4};
  private  Image navselector2[]=new Image[]{Nav1_1,Nav2_1,Nav3_1,Nav4_1};
  
  
  //Label que permite ver y seleccionar la nave a gusto 
  private  JLabel Nav=new JLabel(new ImageIcon(navselector[ind]));
  
  
  //Textfield para ingresar el nombre del jugador 
  private JTextField Nombre= new JTextField(30);
  
  
  //Botones para rotar las naves en el label 
  private JButton right=new JButton(new ImageIcon(Right));
  private JButton left=new JButton(new ImageIcon(Left)); 
  
  private String title;
  private Image back;
  private Image icono;
  private Color color;
  private Font fuentem;
  private Gestor2 gest;
  private Image back2;
  public Ventana_Datos(String title,Font Fuente,Image back,Image Icono, Color Btn,Gestor2 gest)
  {
    this.title=title;
    this.back=back;
    this.color=Btn;
    this.icono=Icono;
    this.color=Btn;
    this.fuentem=Fuente;
    this.gest=gest;
    this.Level=new Level_Verifier(gest);
    Init();
  }
  /**
   * Metodo para cambiar la nave que se muestra en el selector
   */
  public  void changeLbl()
  {
     Nav.setIcon(new ImageIcon(navselector[ind]));
  }
  /**
   * Metodo para iniciar el Thread principal del juego.
   */
  public void initJuego()
 {
     Inicio= new Setup(gest);
     //LevelT= new Thread(Level);
     Inicio.start();
    //LevelT.start();
     gest.getGame().gameStarter();
 }
  
  /**
   * Metodo para fijar la nave que va a utilizar el jugador en la partida
   */
  public void setNav()
  {
      PlayerNav=navselector2[ind];
  }
  /**
   * Metodo para guardar el nombre del jugador 
   */
  public void setName()
  {
      PlayerNam=Nombre.getText();
  }
  /**
   * Metodo que retorna la nave que seleccionó el jugador 
   * @return 
   */
  public Image getNav()
  {
      return PlayerNav;
  }
  public Setup getSet()
  {
      return Inicio;
  }
  
  /**
 * Método para hacer rotar las naves en el selector
 * @param num: Indice de nave desplegada
 */
   public  void changeShip(int num)
     {
      if(num==1)
      {
          if(ind==3)
          {
              ind=0;
          }
          else
          {
              ind+=1;
          }
      }
      else if(num==0)
      {
          if(ind==0)
          {
              ind=3;
          }
          else
          {
              ind-=1;
          }
      }
     }
  public void Init()
  {
        setTitle(title);
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
        setResizable(false);
        setIconImage(icono);
        addKeyListener(new Teclado());
        setFocusable(true);

        JPanel Panel1= new JPanel();
        Panel1.setBackground(Color.DARK_GRAY);
        Panel1.setPreferredSize(new Dimension(300,200));
        Panel1.setBorder(BorderFactory.createMatteBorder(4,0,0,0,Color.BLACK));
        Panel1.setLayout(null);
        add(Panel1,BorderLayout.SOUTH);

        JPanel Panel2=new JPanel();
        Panel2.setBackground(Color.DARK_GRAY);
        Panel2.setPreferredSize(new Dimension(300,493));
        Panel2.setLayout(null);
        add(Panel2,BorderLayout.NORTH);

        Nav.setBounds(410,180,128,128);
        Panel2.add(Nav);

        Nombre.setBounds(160,50,200,30);
        Nombre.setFont(fuentem.deriveFont(Font.PLAIN,15));
        Nombre.setForeground(Color.BLACK);
        Nombre.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.GRAY));
        Panel1.add(Nombre);

        JLabel Nickname=new JLabel("Pilot Name:");
        Nickname.setFont(fuentem.deriveFont(Font.PLAIN, 20));
        Nickname.setForeground(Color.GREEN);
        Nickname.setBounds(20, 50, 300, 30);
        Panel1.add(Nickname);
        //Boton para salir del juego 
        JButton Abort= new JButton("Abort");
        Abort.setForeground(Color.GREEN);
        Abort.setBackground(color);
        Abort.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Abort.setFont(fuentem.deriveFont(Font.PLAIN,20));
        Abort.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
        Abort.setFocusPainted(false);
        Abort.setBounds(20,120, 200, 70);
        Abort.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
             System.exit(0);
            }
        });
        Panel1.add(Abort);
        //Boton para jugar
        JButton Play= new JButton("PLAY!");
        Play.setForeground(Color.GREEN);
        Play.setBackground(color);
        Play.setFont(fuentem.deriveFont(Font.PLAIN,20));
        Play.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Play.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
        Play.setFocusPainted(false);
        Play.setBounds(700,30, 250, 140);
        Play.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 setNav();
                 setName();
                 dispose();
                 System.out.println(Nombre.getText());
                 initJuego();

            }
        });
        Panel1.add(Play);
        //Boton para volver al menu principal 
        JButton goback= new JButton("MAIN MENU");
        goback.setForeground(color);
        goback.setBackground(Color.GREEN);
        goback.setCursor(new Cursor(Cursor.HAND_CURSOR));
        goback.setFont(fuentem.deriveFont(Font.PLAIN,20));
        goback.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
        goback.setFocusPainted(false);
        goback.setBounds(375,120, 200, 70);
        goback.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 dispose();
                 gest.gestInicial();
            }

        });
        Panel1.add(goback);

        JLabel Back=new JLabel(new ImageIcon(Back1));
        Back.setBounds(0,0,1000, 200);
        Back.setBorder(BorderFactory.createMatteBorder(4,0,0,0,Color.BLACK));
        Panel1.add(Back);

        right.setOpaque(false);
        right.setContentAreaFilled(false);
        right.setBorderPainted(false);
        right.setBounds(570,220, 64, 64);
        right.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 changeShip(1);
                 changeLbl();
            }

        });
        Panel2.add(right);

        left.setOpaque(false);
        left.setContentAreaFilled(false);
        left.setBorderPainted(false);
        left.setBounds(315,220,64,64);
        left.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
              changeShip(0);
              changeLbl();  
            }

        });
        Panel2.add(left);
        //Titulo principal de la ventana
        JLabel Titulo2=new JLabel("SELECT A SPACESHIP");
        Titulo2.setFont(fuentem.deriveFont(Font.PLAIN, 40));
        Titulo2.setForeground(Color.GREEN);
        Titulo2.setBounds(240, 20, 500, 100);
        Panel2.add(Titulo2);
  }
  
  //KeyListener para cambiar de nave en el selector 
  private class Teclado implements KeyListener
  {
        @Override
        public void keyTyped(KeyEvent e) 
        {
      
        }
        @Override
        public void keyPressed(KeyEvent e) 
        {
            int code= e.getKeyCode();
            if(code==KeyEvent.VK_RIGHT)
            {
               right.doClick();
            }
            else if(code==KeyEvent.VK_LEFT)
            {
                left.doClick(); 
            }
        }
        @Override
        public void keyReleased(KeyEvent e) 
        {
       
        }
  }
}
