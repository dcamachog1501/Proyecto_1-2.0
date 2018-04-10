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
import java.awt.BorderLayout;
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
          Enemy enm=GUI.buildEnemy(fabricab,this.enmx,this.enmy,this.sup,1,this.gestor,this.lvl,3);
          enm.setPunt();
          this.adder(enm);
          enmx-=100;
          inf-=100;
          }
          else
          {
          Enemy enm=GUI.buildEnemy(fabrica,this.enmx,this.enmy,this.sup,1,this.gestor,this.lvl,3);
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
       Enemy temp= this.getHead();
       int ind=0;
       while(temp!=null)
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
                    this.Head=(Enemy) temp.getNext();
                    if(temp.getNext().getClass()==Type_B.class)
                    {
                        ((Type_B)temp.getNext()).setPrev(null);
                    }
                    else if(temp.getNext().getClass()==Boss.class)
                    {
                        ((Boss)temp.getNext()).setPrev(null);
                    }
                    gestor.getGame().addMarc(temp.getPunt());
                    gestor.getGame().updateMarcs();
                    temp=this.Head;
                    ind=0;
                    while(temp!=null)
                    {
                      if(ind<x)
                      {
                          temp.newx(-50);
                          temp=temp.getNext();
                          ind+=1;
                      }
                      else
                      {
                          temp.newx(50);
                          temp=temp.getNext();
                          ind+=1;
                      }
                    }
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
                     temp=this.Head;
                     ind=0;
                     while(temp!=null)
                        {
                          if(ind<x)
                          {
                              temp.newx(-50);
                              temp=temp.getNext();
                              ind+=1;
                          }
                          else
                          {
                              temp.newx(50);
                              temp=temp.getNext();
                              ind+=1;
                          }
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
                    temp=this.Head;
                    ind=0;
                    while(temp!=null)
                    {
                      if(ind<x)
                      {
                          temp.newx(-50);
                          temp=temp.getNext();
                          ind+=1;
                      }
                      else
                      {
                          temp.newx(50);
                          //temp.setInf(temp.getInf()+50);
                          temp=temp.getNext();
                          ind+=1;
                      }
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
    public void Swap (Enemy e,Enemy e2)
    {
     
        
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx"+this.getLen()+"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
     if(this.len>1)
     {
      Enemy temp=e;
      Enemy temp2=e2;
      Enemy temp3=temp.getNext();
      Enemy temp4=null;
      try
      {
      temp4=temp2.getNext();
      }
      catch(Exception er)
      {
          
      }
      Enemy temp5=null;
      Enemy temp6=null;
      int Navx1=temp.getX();
      int Navx2=temp2.getX();
      if(temp!=null)
      {
         if(temp.getClass()==Type_B.class)
         {
             temp5=((Type_B)temp).getPrev();
         }
         else if(temp.getClass()==Boss.class)
         {
             temp5=((Boss)temp).getPrev();
         }
      }
      if(temp2!=null)
      {
          if(temp2.getClass()==Type_B.class)
         {
             temp6=((Type_B)temp2).getPrev();
         }
         else if(temp2.getClass()==Boss.class)
         {
             temp6=((Boss)temp2).getPrev();
         }
      }
      if(temp4!=null&&temp.getX()==temp4.getX())
      {
          temp2.setNext(temp3);
          if(temp3!=null)
          {
            if(temp3.getClass()==Type_B.class)
            {
             ((Type_B)temp3).setPrev(temp2);
            }
            else if(temp3.getClass()==Boss.class)
            {
             ((Boss)temp3).setPrev(temp2);
            }
          }
          temp.setNext(temp2);
          if(temp2!=null)
          {
            if(temp2.getClass()==Type_B.class)
            {
             ((Type_B)temp2).setPrev(temp);
            }
            else if(temp2.getClass()==Boss.class)
            {
             ((Boss)temp2).setPrev(temp);
            }
          }
          if(temp6!=null)
          {
            temp6.setNext(temp);
          }
          if(temp!=null)
          {
            if(temp.getClass()==Type_B.class)
            {
             ((Type_B)temp).setPrev(temp6);
            }
            else if(temp.getClass()==Boss.class)
            {
             ((Boss)temp).setPrev(temp6);
            }
          }
    }
      else if(temp6!=null&&temp.getX()==temp6.getX())
      {
          temp2.setNext(temp);
          if(temp2!=null)
          {
            if(temp2.getClass()==Type_B.class)
            {
             ((Type_B)temp2).setPrev(temp5);
            }
            else if(temp2.getClass()==Boss.class)
            {
             ((Boss)temp2).setPrev(temp5);
            }
          }
          if(temp5!=null)
          {
          temp5.setNext(temp2);
          }
          if(temp!=null)
          {
            if(temp.getClass()==Type_B.class)
            {
             ((Type_B)temp).setPrev(temp2);
            }
            else if(temp.getClass()==Boss.class)
            {
             ((Boss)temp).setPrev(temp2);
            }
          }
          temp.setNext(temp4);
          if(temp4!=null)
          {
            if(temp4.getClass()==Type_B.class)
            {
             ((Type_B)temp4).setPrev(temp);
            }
            else if(temp4.getClass()==Boss.class)
            {
             ((Boss)temp4).setPrev(temp);
            }
          }
    }
    else
      {
       temp.setNext(temp4);
       if(temp!=null)
          {
            if(temp.getClass()==Type_B.class)
            {
             ((Type_B)temp).setPrev(temp6);
            }
            else if(temp.getClass()==Boss.class)
            {
             ((Boss)temp).setPrev(temp6);
            }
          }
       if(temp6!=null)
       {
       temp6.setNext(temp);
       }
       if(temp4!=null)
          {
            if(temp4.getClass()==Type_B.class)
            {
             ((Type_B)temp4).setPrev(temp);
            }
            else if(temp4.getClass()==Boss.class)
            {
             ((Boss)temp4).setPrev(temp);
            }
          }
       temp2.setNext(temp3);
       if(temp2!=null)
          {
            if(temp2.getClass()==Type_B.class)
            {
             ((Type_B)temp2).setPrev(temp5);
            }
            else if(temp2.getClass()==Boss.class)
            {
             ((Boss)temp2).setPrev(temp5);
            }
          }
       if(temp5!=null)
       {
       temp5.setNext(temp2);
       }
       if(temp3!=null)
          {
            if(temp3.getClass()==Type_B.class)
            {
             ((Type_B)temp3).setPrev(temp2);
            }
            else if(temp3.getClass()==Boss.class)
            {
             ((Boss)temp3).setPrev(temp2);
            }
          }
      }
    if(((Boss)temp).getPrev()==null)
    {
        this.Head=temp;
    }
    else if(((Type_B)temp2).getPrev()==null)
    {
        this.Head=temp2;
    }
    temp.setX(Navx2);
    temp2.setX(Navx1);
    this.refine();
     }
    }
    public void refine()
    {
        Enemy temp=this.Head;
        try
        {
        int x= temp.getX();
        while(temp!=null)
        {
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            System.out.println(temp);
                    
            temp.setX(x);
            x-=100;
            temp=temp.getNext();
        }
        }
        catch(Exception e)
        {
            
        }
        
          
    }
    public void destroy()
    {
        Enemy temp= this.Head;
        while(this.Head!=null)
        {
            if(this.Head.getNext()==null)
            {
                this.Head=null;
                this.len=0;
            }
            if(temp.getNext()==null)
            {
                temp=null;
            }
            else if(temp.getNext().getNext()==null)
            {
                temp.setNext(null);
                temp=this.Head;
            }
            else
            {
                temp=temp.getNext();
            }
        }
    }    
}
