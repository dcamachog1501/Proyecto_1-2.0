/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level_Creator;

import Fabrica_Hileras.A_Line_Creator;
import Fabrica_Hileras.Basic_Line_Creator;
import Hileras.Hileras_GUI;
import Hileras.Line;
import Ventanas.Gestor2;
import java.util.Random;

/**
 *
 * @author Daniel Camacho
 */
public class Level 
{
    private Line Head;
    private int len;
    private int lenmax;
    private int current;
    private Gestor2 gestor;
    private Hileras_GUI GUI;
    private Basic_Line_Creator basic;
    private A_Line_Creator atype;
    public Level(int x,Gestor2 gest)
    {
      this.current=x;
      this.Head=null;
      this.len=0;
      this.lenmax=3;
      this.gestor=gest;
      this.GUI= new Hileras_GUI();
      this.basic= new Basic_Line_Creator();
      this.atype= new A_Line_Creator();
    }
    public Line getLine()
    {
        Line l=null;
        if(current>=0 && current<3)
        {
          Random r= new Random();
          int rnd=r.nextInt(2);
          if(rnd==0)
          {
             l=GUI.buildHilera(this.basic, this.gestor,this.current);
          }
          else if(rnd==1)
          {
             l=GUI.buildHilera(this.atype,this.gestor,this.current);
          }
          
        }
        return l;
    }
    public void adder()
    {
        Line enm=this.getLine();
        if(this.Head==null)
        {
            this.Head=enm;
            len++;
        }
        else
        {
          Line temp=this.Head;
          while(temp.getNext()!=null)
          {
              temp=temp.getNext();
          }
          temp.setNext(enm);
          len++;
        }
    }
    public void generateLevel()
    {
      while(len<lenmax)
      {
          this.adder();
      }
    }
    public Line getHead()
    {
        return this.Head;
    }
    public int getLen()
    {
        return this.len;
    }
    public void chnLen(int x)
    {
        this.len-=x;
    }
}
