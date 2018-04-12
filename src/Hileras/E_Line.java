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
import Enemigos.Type_E;
import Fabrica_Enemigos.Boss_Creator;
import Fabrica_Enemigos.D_Creator;
import Fabrica_Enemigos.E_Creator;
import Threads.BasicMove;
import Ventanas.Gestor2;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.Random;

/**
 *
 * @author dcama
 */
public class E_Line implements Line 
{
    private Enemy Head;
    private Enemy Tail;
    private int len;
    private int lenmax;
    private int enmx;
    private int enmy;
    private int sup;
    private E_Creator fabrica;
    private Boss_Creator fabricab;
    private Image current;
    private Gestor2 gestor;
    private Line next;
    private BasicMove move;
    private Enemy_GUI GUI;
    private String type;
    private Enemy boss;
    private int lvl;
    @Override
    public void setHead() 
    {
        this.Head=null;
    }
    public void setTail()
    {
        this.Tail=null;
    }
    @Override
    public void setLen() 
    {
        this.len=0;
    }
    @Override
    public void setMaxlen() 
    {
        this.lenmax=5;
    }
    @Override
    public void setEnmx() 
    {
        this.enmx=660;
    }

    @Override
    public void setEnmy() 
    {
        this.enmy=150;
    }

    @Override
    public void setSup() 
    {
        this.sup=910;
    }

    @Override
    public void setCurrent() 
    {
       this.current=Toolkit.getDefaultToolkit().getImage("Resources/Current Icons/ClaseE.png");
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
      if(isEmpty())
        {
            this.Head=enm;
            this.Tail=enm;
            this.Tail.setNext(enm);
            if(this.Head.getClass()==Type_E.class)
            {
            ((Type_E)this.Head).setPrev(this.Tail);
            }
            else if(this.Head.getClass()==Boss.class)
            {
            ((Boss)this.Head).setPrev(this.Tail);
            }
            this.len++;
        }
        else
        {
            Enemy temp= this.Head;
            int ind=1;
            int lenl=this.len;
            while(true)
            {
                if(ind==lenl)
                {
                    if(enm.getClass()==Type_E.class)
                    {
                        temp.setNext(enm);
                        ((Type_E)temp.getNext()).setPrev(temp);
                        enm.setNext(this.Head);
                        ((Type_E)this.Head).setPrev(enm);
                        this.Tail=enm;
                        this.len++;
                        break;
                    }
                    else if(enm.getClass()==Boss.class)
                    {
                       temp.setNext(enm);
                       ((Boss)temp.getNext()).setPrev(temp);
                       enm.setNext(this.Head);
                       ((Type_E)this.Head).setPrev(enm);
                       this.boss=enm;
                       this.Tail=enm;
                       this.len++;
                       break; 
                    }
                }
                else
                {
                    temp=temp.getNext();
                    ind++;

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
      while(len<lenmax)
      {
          if(len==2)
          {
          Enemy enm=GUI.buildEnemy(fabricab,this.enmx,this.enmy,this.sup,1,this.gestor,this.lvl,3);
          ((Boss)enm).giveHealth();
          this.adder(enm);
          enmx-=100;
          }
          else
          {
          Enemy enm=GUI.buildEnemy(fabrica,this.enmx,this.enmy,this.sup,1,this.gestor,this.lvl,giveHealth());
          this.adder(enm);
          enmx-=100;
          }
      }
    }

    @Override
    public void Render(Graphics g, Canvas c) 
    {
       Enemy temp=this.getHead();
       int ind=0;
       int len=this.getLen();
       
       while(ind!=len)
       {
           g.setFont(new Font("Helvetica",Font.BOLD,30));
           g.drawString(Integer.toString(temp.getHealth()),(temp.getX()+20),(temp.getY()-10));
           g.drawImage(temp.getFace(),temp.getX(),temp.getY(),c);
           temp=temp.getNext();
           ind++; 
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
    public Enemy getTail()
    {
        return this.Tail;
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
        this.setTail();
        this.setLen();
        this.setMaxlen();
        this.setSup();
        this.setFactory();
        this.setGestor(gest);
        this.setType();
        this.next=null;
        this.move=new BasicMove(this,gestor);
        this.lvl=lvl;
    }

    @Override
    public void setFactory() 
    {
        this.fabrica=new E_Creator();
        this.fabricab= new Boss_Creator();
        this.GUI= new Enemy_GUI();
    }

    @Override
    public void eliminate(int x) 
    {
       Enemy temp= this.getHead();
       int ind=0;
       int lenl=this.len;
       while(ind!=lenl)
       {
           if(x==0)
           {
               if(temp.getHealth()==1)
               {
                   if(temp.isBoss())
                   {
                       gestor.getGame().addMarc(temp.getPunt());
                       gestor.getGame().updateMarcs();
                       this.destroy();
                       break;
                   }
                   else
                   {
                    if(temp.getClass()==Type_E.class)
                    {
                        this.Head=(Enemy) temp.getNext();
                    }
                    else if(temp.getNext().getClass()==Type_B.class)
                    {
                        ((Type_B)temp.getNext()).setPrev(null);
                    }
                    else if(temp.getNext().getClass()==Boss.class)
                    {
                        ((Boss)temp.getNext()).setPrev(null);
                    }
                    gestor.getGame().addMarc(temp.getPunt());
                    gestor.getGame().updateMarcs();
                    this.len--;
                    break;
                   }
               }
           
               else
               {
                    temp.chnHealth(1);
                    break;
               }
           }
           else if(ind+1==x)
           {
               if(temp.getNext().getNext() == null){
                   if(temp.getNext().getHealth()==1)
                   {
                    if(temp.getNext().isBoss())
                    {
                        gestor.getGame().addMarc(temp.getNext().getPunt());
                        gestor.getGame().updateMarcs();
                        this.destroy();
                        break;
                    }

                    else
                    {
                     gestor.getGame().addMarc(temp.getNext().getPunt());
                     gestor.getGame().updateMarcs();
                     temp.setNext(null);
                     this.len--;
                     break;
                    }
                   }
                   else
                   {
                       temp.getNext().chnHealth(1);
                       break;
                   }
               }
               else if(temp.getNext().getHealth()==1)
               {
                   if(temp.getNext().isBoss())
                   {
                       gestor.getGame().addMarc(temp.getNext().getPunt());
                       gestor.getGame().updateMarcs();
                       this.destroy();
                       break;
                   }
                   else
                   {
                    gestor.getGame().addMarc(temp.getNext().getPunt());
                    gestor.getGame().updateMarcs();
                    temp.setNext(temp.getNext().getNext());
                    if(temp.getNext().getClass()==Type_B.class)
                    {
                        ((Type_B)temp.getNext()).setPrev(temp);
                    }
                    else if(temp.getNext().getClass()==Boss.class)
                    {
                        ((Boss)temp.getNext()).setPrev(temp); 
                    }
                    this.len--;
                    break;
                   }
               }
           
               else
               {
                    temp.getNext().chnHealth(1);
                    break;
               }
           }
           else
           {
           ind++;
           temp=temp.getNext();
           }
       }
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
    public BasicMove getMove() 
    {
        return this.move;
    }

    @Override
    public void setType() 
    {
        this.type="Type E";
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
    @Override
    public int giveHealth() 
    {
         if(this.lvl<7)
        {
            return 1;
        }
        else if(this.lvl>=7 && this.lvl<9)
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }
    public void destroy()
    {
        
            this.Head=null;
            this.len=0;
           
    }
    public void rotate(double ang, int inX, int indN)
    {
        int ind=0;
        int lenl=this.len;
        int radio=this.boss.getX()-inX;
        int newX=(int) (this.boss.getX()+ cos(ang)*radio);
        int newY=(int) (this.boss.getY()+ sin(ang)*radio);
        Enemy temp=this.getHead();
        while(true)
        {
            if(ind==indN)
            {
            temp.setX(newX);
            temp.setY(newY);
            break;
            }
            temp=temp.getNext();
            ind++;
            
        }
        if(this.Head.getClass()==Type_E.class)
        {
            if(this.Head.getClass()==Boss.class)
            {
                if(this.Tail.getY()>=((this.boss.getY())-10)&& this.Tail.getY()<=((this.boss.getY())+10)
                &&this.Tail.getX()>=((Type_E)this.Tail).getInX()-10&&this.Tail.getX()<=((Type_E)this.Tail).getInX()+10)
                {
                    ind=0;
                    temp=this.Head;
                    while(ind!=lenl)
                    {
                       temp.setY(temp.getY()+10);
                       temp=temp.getNext();
                       ind++;
                    } 
                }
            {
                
            }
            }
            else if(this.Head.getY()>=((this.boss.getY())-10)&& this.Head.getY()<=((this.boss.getY())+10)
            &&this.Head.getX()>=((Type_E)this.Head).getInX()-10&&this.Head.getX()<=((Type_E)this.Head).getInX()+10)
            {
                ind=0;
                temp=this.Head;
                while(ind!=lenl)
                {
                   temp.setY(temp.getY()+10);
                   temp=temp.getNext();
                   ind++;
                }
            }
            
        }
        else if(this.Head.getClass()==Boss.class&& this.getLen()==1)
        {
            this.Head.setY(this.Head.getY()+10);
        }
        
    }
}
