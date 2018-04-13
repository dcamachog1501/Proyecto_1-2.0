/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Fabrica_Hileras.A_Line_Creator;
import Hileras.A_Line;
import Hileras.Hileras_GUI;
import Manager.LevelManager;
import Threads.BasicMove;
import Threads.Left;
import Threads.Right;
import Threads.Setup;
import Threads.Shoot;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *Clase encargada del de desarrollo de ventanas de juego.
 * @author Daniel Camacho
 */
public class Ventana_Juego extends JFrame
{
    //Canvas en el que se desarrolla el juego 
    private  Canvas canv;
    
    
    //Marcador del juego 
    private int marc;
    
    
    // Datos escritos que se proyectan en el marcador
    private String marcs;
    
    
    //Label que proyecta el marcador 
    private JLabel Punt;
    private JLabel Punt2;
    private JLabel Punt4;
    private JLabel Punt5;
    private JLabel Punt7;
   
    //KeyListeners encargados de recibir los inputs del usuario
    private final Teclado0 tec0;
    private final Teclado2 tec2;
    
    //Atributos de la ventana
    private final String title;
    private final Font fuentet;
    private final Image icono;
    private final Color color;
    private final Font fuentem;
    private final Gestor2 gest;
    //Thread que permite el movimiento continuo de los enemigos.
    private Thread mover;
    private BasicMove move;
    
    private boolean cond;
    
    private LevelManager LManager;
    private Thread r;
    private Right right;
    private Thread l;
    private Left left;
    private Thread s;
    private Shoot shoot;
    private boolean condr;
    private boolean condl;
    private Setup set;
    Ventana_Juego(String title,Font FuenteT,Image Icono, Color Btn,Font FuenteM,Gestor2 gest,LevelManager lvl,Setup set)
    {
       this.LManager=lvl;
       this.tec0=new Teclado0();
       this.tec2= new Teclado2();
       this.title=title;
       this.fuentem=FuenteM;
       this.fuentet=FuenteT;
       this.icono=Icono;
       this.color=Btn;
       this.gest=gest;
       this.marc=0;
       this.marcs=String.format("%013d",marc);
       this.Punt= new JLabel(marcs);
       this.Punt2= new JLabel();
       this.Punt4= new JLabel();
       this.Punt5= new JLabel();
       this.Punt7= new JLabel();
       this.set=set;

       
       this.cond=false;
       this.move=LManager.getCurrent().getMove();
       this.right=new Right(gest);
       this.left= new Left(gest);
       this.shoot= new Shoot(gest,set);
       this.condr= true;
       this.condl=true;
       Init();
    }
  public LevelManager getLManager()
  {
      return LManager;
  }
  public Teclado2 getTec()
  {
      return tec2;
  }
  /**
   * Metodo para agregar puntos al marcador 
   * @param x cantidad entera de puntos a agregar 
   */
  public void addMarc(int x)
  {
      marc+=x;
  }
  /**
   * Metodo para actualizar el marcador.
   */
  public void updateMarcs()
    {
        marcs=String.format("%013d",marc);
        Punt.setText(marcs);
    }
  /**
   * Metodo para obtener el canvas de la ventana
   * @return objeto de tipo canvas 
   */
  public Canvas getCanvas()
    {
        return canv;
    }
  
  public void rem()
  {
      this.removeKeyListener(tec2);
  }
  public void adder()
  {
      this.addKeyListener(tec2);
  }
  public void gameStarter()
  {
      r= new Thread((Runnable) right);
      r.setUncaughtExceptionHandler(
        new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            e.printStackTrace();
                }
            }
      );
      r.start();
      
      l= new Thread((Runnable) left);
      
      l.setUncaughtExceptionHandler(
        new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            e.printStackTrace();
                }
            }
      );
      l.start();
      
      mover= new Thread((Runnable)move);
      
      mover.setUncaughtExceptionHandler(
      new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            e.printStackTrace();
                }
            }
      );
      mover.start();
      
      s= new Thread((Runnable)shoot);
      
      s.setUncaughtExceptionHandler(
      new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            e.printStackTrace();
                }
            }
      );
      s.start();
  }
  public Thread getMover()
  {
      return mover;
  }
  public Font getFontm()
  {
      return this.fuentem;
  }
  public void updateScreen()
  {
      if(LManager.getCurrent()==null)
      {
          System.out.println("CHANGING LEVEL");
          LManager.lvlUP();
          Punt4.setText("CURRENT "+ LManager.getCurrent().getType());
          Punt5.setText("NEXT "+ LManager.getCurrent().getNext().getType());
          Punt7.setText("LEVEL "+LManager.getLeveln());
          Punt2.setIcon(new ImageIcon(LManager.getCurrent().getCurrent()));
      }
      else if(LManager.getCurrent().getNext()==null)
      {
      Punt4.setText("CURRENT "+ LManager.getCurrent().getType());
      Punt5.setText("NEXT LEVEL");
      Punt7.setText("LEVEL "+LManager.getLeveln());
      Punt2.setIcon(new ImageIcon(LManager.getCurrent().getCurrent()));
      }
      else
      {
      Punt4.setText("CURRENT "+ LManager.getCurrent().getType());
      Punt5.setText("NEXT "+ LManager.getCurrent().getNext().getType());
      Punt7.setText("LEVEL "+LManager.getLeveln());
      Punt2.setIcon(new ImageIcon(LManager.getCurrent().getCurrent()));
      }
  }
   public void chanCond()
    {
        if(cond==false)
        {
            cond=true;
        }
        else
        {
            cond=false;
        }
    }
    public boolean getCond()
    {
        return cond; 
    }
    public int getMarc()
    {
        return this.marc;
    }
    public void stopExcecution()
    {
        try 
        {
            right.chnBool();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        try 
        {
            left.chnBool();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        try 
        {
          this.move.chnBool();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        gest.getDatos().getSet().stop();
    }
  /**
   * Metodo que inicializa la ventana
   */
  public void Init()
  {
        canv=new Canvas();
        canv.setPreferredSize(new Dimension(985,720));
        canv.setBackground(Color.DARK_GRAY);
        setTitle(title);
        setSize(1300,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.BLACK));
        setResizable(false);
        setIconImage(icono);
        setFocusable(true);
        addKeyListener(tec0);
        addKeyListener(tec2);

        JPanel fondo=new JPanel();
        fondo.setBackground(Color.DARK_GRAY);
        fondo.setPreferredSize(new Dimension(985,670));
        fondo.add(canv);
        getContentPane().add(canv,BorderLayout.EAST);

        JPanel Panel1= new JPanel();
        Panel1.setPreferredSize(new Dimension(300,1000));
        Panel1.setBackground(Color.BLACK);
        Panel1.setBorder(BorderFactory.createMatteBorder(4,0,0,8,Color.BLACK));
        add(Panel1,BorderLayout.WEST);

        Punt.setBackground(color);
        Punt.setOpaque(true);
        Punt.setBorder(BorderFactory.createMatteBorder(4,0,8,0, Color.BLACK));
        Punt.setBounds(0,0,292,75);
        Punt.setForeground(Color.GREEN);
        Punt.setFont(fuentem.deriveFont(Font.PLAIN,20));
        Panel1.setLayout(null);
        Panel1.add(Punt);

        Punt2.setBackground(Color.BLACK);
        Punt2.setIcon(new ImageIcon(LManager.getCurrent().getCurrent()));
        Punt2.setOpaque(true);
        Punt2.setBounds(12,75,266,250);
        Punt2.setForeground(Color.GREEN);
        Panel1.add(Punt2);

        JLabel Punt3= new JLabel();
        Punt3.setBackground(Color.BLACK);
        Punt3.setOpaque(true);
        Punt3.setBounds(0,325,292,8);
        Panel1.add(Punt3);

        Punt4.setText("CURRENT "+ LManager.getCurrent().getType());
        Punt4.setBounds(5,210,292,292);
        Punt4.setForeground(Color.GREEN);
        Punt4.setFont(fuentem.deriveFont(Font.PLAIN,15));
        Panel1.add(Punt4);

        Punt5.setText("NEXT "+ LManager.getCurrent().getNext().getType());
        Punt5.setBounds(5,280,292,292);
        Punt5.setForeground(Color.GREEN);
        Punt5.setFont(fuentem.deriveFont(Font.PLAIN,15));
        Panel1.add(Punt5);
        //Boton que permite salirse del juego
        JButton Abort= new JButton("Abort");
        Abort.setForeground(Color.GREEN);
        Abort.setBackground(color);
        Abort.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Abort.setFont(fuentet.deriveFont(Font.PLAIN,20));
        Abort.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
        Abort.setFocusPainted(false);
        Abort.setBounds(48,550, 200, 70);
        Abort.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }


        });
        Panel1.add(Abort);

        Punt7.setText("LEVEL "+LManager.getLeveln());
        Punt7.setBounds(5,350,292,292);
        Punt7.setForeground(Color.GREEN);
        Punt7.setFont(fuentem.deriveFont(Font.PLAIN,15));
        Panel1.add(Punt7);

        JLabel Punt6= new JLabel();
        Punt6.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Resources/Backgrounds/Back2.png")));
        Punt6.setBounds(0,330,292,450);
        Panel1.add(Punt6);
        
  }
  //KeyListaner para mover la nave
  private class Teclado0 implements KeyListener
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
             if(condr==true)
             {
             right.chnCond();
             condr=false;
             }
            }
            else if(code==KeyEvent.VK_LEFT)
            {
             if(condl==true)
             {
             left.chnCond();
             condl=false;
            }
        }
        }
        @Override
        public void keyReleased(KeyEvent e) 
        {
            int code= e.getKeyCode();
            if(code==KeyEvent.VK_RIGHT)
            {
             if(condr==false)
             {
             right.chnCond();
             condr=true;
             }
            }
            else if(code==KeyEvent.VK_LEFT)
            {
             if(condl==false)
             {
             left.chnCond();
             condl=true;
             }
            }
        }
  }
 
  //KeyListener para disparar
  private class Teclado2 implements KeyListener
  {
        @Override
        public void keyTyped(KeyEvent e) 
        {
            
        }
        @Override
        public void keyPressed(KeyEvent e) 
        {
            int code= e.getKeyCode();
            if(code==KeyEvent.VK_SPACE)
            {
                gest.getGame().chanCond();
                gest.getDatos().getSet().getBull().stnCond();
                rem();
                
            }
        }
        @Override
        public void keyReleased(KeyEvent e) 
        {
            
        }
      
  
  }
}

