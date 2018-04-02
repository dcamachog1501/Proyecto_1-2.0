/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import Ventanas.Gestor2;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author dcama
 */
public class Boss implements Enemy 
{
   private Enemy next;
   private Image face;
   private int enx;
   private int eny;
   private int health;
   private int dir=1;
   private int sup;
   private int inf;
   private int punt;
   private String type;
   private int speed;
   private Gestor2 gestor;
   private int lvl;
   
   @Override
   public void Init(int x, int y,int sup,int inf, Gestor2 gest,int lvl)
   {
      setType();
      setFace();
      setHealth();
      setDir();
      setInf(inf);
      setSup(sup);
      setSpeed();
      setPunt();
      setX(x);
      setY(y);
      setGest(gest);
      this.lvl=lvl;
   }
    @Override
    public void setType() 
    {
        this.type="Boss";
    }

    @Override
    public void setFace() 
    {
        this.face=Toolkit.getDefaultToolkit().getImage("Resources/Enemigos/Boss.png");
    }

    @Override
    public void setHealth() 
    {
        this.health=2;
    }

    @Override
    public void setDir() 
    {
        this.dir=1;
    }

    @Override
    public void setNext(Object enm) 
    {
        this.next=(Enemy) enm;
    }

    @Override
    public void setInf(int inf) 
    {
        this.inf=inf;
    }

    @Override
    public void setSup(int sup) 
    {
        this.sup=sup;
    }

    @Override
    public void setSpeed() 
    {
        this.speed=300;
    }

    @Override
    public void setPunt() 
    {
        this.punt=1000;
    }

    @Override
    public void setX(int x) 
    {
        this.enx=x;
    }

    @Override
    public void setY(int y) 
    {
        this.eny=y;
    }
   @Override
     public int getSup()
    {
        return sup;
    }
   @Override
    public int getInf()
    {
        return inf;
    }
   @Override
    public Enemy getNext()
    {
        return this.next;
    }
   @Override
    public int getX()
    {
        return this.enx;
    }
   @Override
    public int getY()
    {
        return this.eny;
    }
   @Override
    public Image getFace()
    {
        return this.face;
    }
   @Override
    public void chnX()
    {
        if(dir==1)
        {
          this.enx-=50;
        }
        else
        {
            this.enx+=30;
        }
    }
   @Override
    public void chnY()
    {
        this.eny+=25;
    }
   @Override
    public void chnDir()
    {
        if(dir==1)
        {
            dir=0;
        }
        else
        {
            dir=1;
        }
    }
   @Override
    public int getPunt()
    {
       return punt; 
    }

    @Override
    public int getHealth() 
    {
        return this.health;
    }

    @Override
    public void chnHealth(int x) 
    {
        this.health-=x;
    }
    @Override
    public int getSpeed()
    {
        return this.speed;
    }
    @Override
    public void setGest(Gestor2 gest) 
    {
        this.gestor=gest;
    }
}
