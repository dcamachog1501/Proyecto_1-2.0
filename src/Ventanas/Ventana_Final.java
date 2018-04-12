/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Daniel Camacho
 */
public class Ventana_Final extends JFrame
{
    private String title;
    private Image back;
    private Image icono;
    private Color color;
    private Font fuentem;
    private Gestor2 gestor; 
    
    public Ventana_Final(String title,Font Fuente,Image back,Image Icono, Color Btn, Gestor2 gest)
    {
        this.gestor = gest;
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
    }
}
