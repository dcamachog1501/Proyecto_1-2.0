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
public class Type_B implements Enemy
{
    private Enemy next;
    private Enemy prev;
    private Image face;
    private int enx;
    private int eny;
    private int health;
    private int dir=1;
    private int sup;
    private int punt;
    private String type;
    private int speed;
    private Gestor2 gestor;
    private int lvl;
    private Boolean Boss;
    @Override
    public void setType() 
    {
        this.type="Type B";
    }

    @Override
    public void setFace() 
    {
       this.face=Toolkit.getDefaultToolkit().getImage("Resources/Enemigos/ClaseB.png");
    }

    @Override
    public void setHealth() 
    {
        if(lvl<2)
        {
            this.health=2;
        }
        else if(lvl>2 && lvl<7)
        {
            this.health=3;
        }
        else if(lvl>=7)
        {
            this.health=4;
        }
        
    }

    @Override
    public void setDir() 
    {
        this.dir=1;    
    }

    @Override
    public void setNext(Enemy enm) 
    { 
        this.next=enm;
    }
    public void setPrev(Enemy enm)
    {
        this.prev=enm;
    }
    @Override
    public void setSup(int sup) 
    {
        this.sup=sup;
    }

    @Override
    public void setSpeed() 
    {
        this.speed=150;
    }

    @Override
    public void setPunt() 
    {
        this.punt=200;
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
        return this.sup;
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
          this.enx-=25;
        }
        else
        {
            this.enx+=25;
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
        return this.punt;
    }

    @Override
    public void Init(int x, int y, int sup, Gestor2 gest, int lvl) 
    {
      this.lvl=lvl;
      setGest(gest);
      setType();
      setFace();
      setHealth();
      setDir();
      setSup(sup);
      setSpeed();
      setPunt();
      setX(x);
      setY(y);
      this.Boss=false;
    }

    @Override
    public int getHealth() 
    {
        return this.health;
    }

    @Override
    public void chnHealth(int x) 
    {
         this.health=this.health-x;
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

    @Override
    public Boolean isBoss() 
    {
        return this.Boss;
    }

    @Override
    public void newx(int x) 
    { 
       this.enx+=x; 
    }
    public Enemy getPrev()
    {
        return this.prev;
    }
}
