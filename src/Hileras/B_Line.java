/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hileras;

import Enemigos.Boss;
import Enemigos.Enemy;
import Enemigos.Enemy_GUI;
import Enemigos.Type_B;
import Fabrica_Enemigos.A_Creator;
import Fabrica_Enemigos.B_Creator;
import Fabrica_Enemigos.Boss_Creator;
import Threads.BasicMove;
import Ventanas.Gestor2;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

/**
 *
 * @author dcama
 */
public class B_Line implements Line 
{
    private Enemy Head;
    private int len;
    private int lenmax;
    private int enmx;
    private int enmy;
    private int sup;
    private int inf;
    private B_Creator fabrica;
    private Boss_Creator fabricab;
    private Image current;
    private Gestor2 gestor;
    private Line next;
    private BasicMove move;
    private Enemy_GUI GUI;
    private String type;
    private int lvl;
    @Override
    public void setHead() 
    {
        this.Head=null;
    }

    @Override
    public void setLen() 
    {
        this.len=0;
    }

    @Override
    public void setMaxlen() 
    {
        this.lenmax=7;
    }

    @Override
    public void setEnmx() 
    {
        this.enmx=660;
    }

    @Override
    public void setEnmy() 
    {
        this.enmy=200;
    }

    @Override
    public void setSup() 
    {
         this.sup=910;
    }
    @Override
    public void setCurrent() 
    {
        this.current=Toolkit.getDefaultToolkit().getImage("Resources/Current Icons/ClaseB.png");
    }

    @Override
    public boolean isEmpty() 
    {
         if(this.len==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void adder(Enemy enm) 
    {
         if(isEmpty()==true)
        {
            this.Head=(Enemy) enm;
            len++;
        }
        else
        {
            Enemy temp= this.Head;
            while(temp!=null)
            {
                if(temp.getNext()==null)
                {
                    if(enm.getClass()==Type_B.class)
                    {
                        temp.setNext(enm);
                        ((Type_B)temp.getNext()).setPrev(temp);
                        len++;
                        break;
                    }
                    else if(enm.getClass()==Boss.class)
                    {
                       temp.setNext(enm);
                       ((Boss)temp.getNext()).setPrev(temp);
                       len++;
                       break; 
                    }
                }
                else
                {
                    temp=temp.getNext();

                }
            }
        }
    }

    @Override
    public Image getCurrent() 
    {
        return this.current;
    }

    @Override
    public void createLine() 
    {
        Random r= new Random();
      int ind=r.nextInt(7);
      while(len<lenmax)
      {
          if(len==ind)
          {
          Enemy enm=GUI.buildEnemy(fabricab,this.enmx,this.enmy,this.sup,this.gestor,this.lvl);
          enm.setPunt();
          this.adder(enm);
          enmx-=100;
          inf-=100;
          }
          else
          {
          Enemy enm=GUI.buildEnemy(fabrica,this.enmx,this.enmy,this.sup,this.gestor,this.lvl);
          this.adder(enm);
          enmx-=100;
          inf-=100;
          }
      }
    }

    @Override
    public void Render(Graphics g, Canvas c) 
    {
       Enemy temp=this.Head;
       while(temp!=null)
       {
           g.setFont(new Font("Helvetica",Font.BOLD,30));
           g.drawString(Integer.toString(temp.getHealth()),(temp.getX()+20),(temp.getY()-10));
           g.drawImage(temp.getFace(),temp.getX(),temp.getY(),c);
           temp=(Enemy) temp.getNext();
           
       }
    }

    @Override
    public int getEnmy() 
    {
        return this.enmy;
    }

    @Override
    public int getEnmx() 
    {
        return this.enmx;
    }

    @Override
    public Enemy getHead() 
    {
        return this.Head;
    }

    @Override
    public int getSup() 
    {
        return this.sup;
    }
    @Override
    public void Init(Gestor2 gest, int lvl) 
    {
        this.setCurrent();
        this.setEnmx();
        this.setEnmy();
        this.setHead();
        this.setLen();
        this.setMaxlen();
        this.setSup();
        this.setFactory();
        this.setGestor(gest);
        this.setType();
        this.next=null;
        this.move=new BasicMove(this,gestor);
        this.lvl=lvl;    }

    @Override
    public void setFactory() 
    {
        this.fabrica=new B_Creator();
        this.fabricab= new Boss_Creator();
        this.GUI= new Enemy_GUI();
    }

    @Override
    public void eliminate(int x) 
    {
        
    }
    @Override
    public void setGestor(Gestor2 gest) 
    {
        this.gestor=gest;
    }

    @Override
    public void setNext(Line l) 
    {
        this.next=l;
    }

    @Override
    public Line getNext() 
    {
        return this.next;
    }

    @Override
    public Object getMove()
    {
        return this.move;
    }

    @Override
    public void setType() 
    {
        this.type="B Type";
    }

    @Override
    public String getType() 
    {
        return this.type;
    }

    @Override
    public int getLen() 
    {
        return this.len;
    }
    
}
