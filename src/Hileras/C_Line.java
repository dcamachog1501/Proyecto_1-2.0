/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hileras;

import Enemigos.Boss;
import Enemigos.Enemy;
import Enemigos.Enemy_GUI;
import Fabrica_Enemigos.A_Creator;
import Fabrica_Enemigos.B_Creator;
import Fabrica_Enemigos.Boss_Creator;
import Fabrica_Enemigos.C_Creator;
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
 * @author Daniel Camacho
 */
public class C_Line implements Line {
    private Enemy Head;
    private Enemy Tail;
    private int len;
    private int lenmax;
    private int enmx;
    private int enmy;
    private int sup;
    private C_Creator fabrica;
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
        this.enmy=300;
    }

    @Override
    public void setSup() 
    {
        this.sup=910;
    }

    @Override
    public void setCurrent() 
    {
     this.current=Toolkit.getDefaultToolkit().getImage("Resources/Current Icons/ClaseC.png");
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
            this.Head=enm;
            this.Tail=enm;
            this.Head.setNext(this.Tail);
            len++;
        }
        else
        {
            Enemy temp=this.Head;
            while(temp.getX()!=this.Tail.getX())
            {
                temp=temp.getNext();
            }
            temp.setNext(enm);
            this.Tail=enm;
            this.Tail.setNext(this.Head);
            len++;
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
          ((Boss)enm).giveHealth();
          this.adder(enm);
          enmx-=100;
          }
          else
          {
          Enemy enm=GUI.buildEnemy(fabrica,this.enmx,this.enmy,this.sup,1,this.gestor,this.lvl,3);
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
        this.lvl=lvl;
    }

    @Override
    public void setFactory() 
    {
        this.fabrica=new C_Creator();
        this.fabricab= new Boss_Creator();
        this.GUI= new Enemy_GUI();
    }

    @Override
    public void eliminate(int x) 
    {
       Enemy temp= this.getHead();
       int ind=0;
       int indr=0;
       int lenl=this.getLen();
       while(true)
       {
           if(x==0)
           {
               if(temp.getHealth()==1)
               {
                   if(temp.isBoss())
                   {
                    this.Head=temp.getNext();
                    this.Tail.setNext(this.Head);
                    gestor.getGame().addMarc(temp.getPunt());
                    gestor.getGame().updateMarcs();
                    temp=this.Head;
                    this.len-=1;
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  "+this.len);
                    ind=0;
                    int indl=0;
                    int len=this.len;
                    while(indl!=len)
                    {
                      if(ind<x)
                      {
                          temp.newx(-50);
                          temp=temp.getNext();
                          ind++;
                          indl++;
                      }
                      else
                      {
                          temp.newx(50);
                          temp=temp.getNext();
                          ind++;
                          indl++;
                      }
                    }
                    if(this.getLen()>0)
                    {
                    Random rnd= new Random();
                    int r= rnd.nextInt(this.getLen());
                    chnBoss(r);
                    }
                    break;
                   }
                   else
                   {
                    this.Head=temp.getNext();
                    this.Tail.setNext(this.Head);
                    gestor.getGame().addMarc(temp.getPunt());
                    gestor.getGame().updateMarcs();
                    temp=this.Head;
                    this.len-=1;
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  "+this.len);
                    ind=0;
                    int indl=0;
                    int len=this.len;
                    while(indl!=len)
                    {
                      if(ind<x)
                      {
                          temp.newx(-50);
                          temp=temp.getNext();
                          ind++;
                          indl++;
                      }
                      else
                      {
                          temp.newx(50);
                          temp=temp.getNext();
                          ind++;
                          indl++;
                      }
                    }
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
               if(temp.getNext().getNext().getX()==this.Head.getX())
               {
                   if(temp.getNext().getHealth()==1)
                   {
                    if(temp.getNext().isBoss())
                    {
                        gestor.getGame().addMarc(temp.getNext().getPunt());
                     gestor.getGame().updateMarcs();
                     this.Tail=temp;
                     this.Tail.setNext(this.Head);
                     temp=this.Head;
                     this.len-=1;
                     System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  "+this.len);
                     int indl=0;
                     int len=this.getLen();
                     ind=0;
                     while(indl!=len)
                        {
                          if(ind<x)
                          {
                              temp.newx(-50);
                              temp=temp.getNext();
                              ind++;
                              indl++;
                          }
                          else
                          {
                              temp.newx(50);
                              temp=temp.getNext();
                              ind++;
                              indl++;
                          }
                        }
                    Random rnd= new Random();
                    int r= rnd.nextInt(this.getLen());
                    chnBoss(r);
                     break;
                    }

                    else
                    {
                     gestor.getGame().addMarc(temp.getNext().getPunt());
                     gestor.getGame().updateMarcs();
                     this.Tail=temp;
                     this.Tail.setNext(this.Head);
                     temp=this.Head;
                     this.len-=1;
                     System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  "+this.len);
                     int indl=0;
                     int len=this.getLen();
                     ind=0;
                     while(indl!=len)
                        {
                          if(ind<x)
                          {
                              temp.newx(-50);
                              temp=temp.getNext();
                              ind++;
                              indl++;
                          }
                          else
                          {
                              temp.newx(50);
                              temp=temp.getNext();
                              ind++;
                              indl++;
                          }
                        }
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
                    temp.setNext(temp.getNext().getNext());
                    temp=this.Head;
                    this.len-=1;
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  "+this.len);
                    int indl=0;
                    int len=this.getLen();
                    ind=0;
                    while(indl!=len)
                    {
                      if(ind<x)
                      {
                          temp.newx(-50);
                          temp=temp.getNext();
                          ind++;
                          indl++;
                      }
                      else
                      {
                          temp.newx(50);
                          //temp.setInf(temp.getInf()+50);
                          temp=temp.getNext();
                          ind++;
                          indl++;
                      }
                    }
                    Random rnd= new Random();
                    int r= rnd.nextInt(this.getLen());
                    chnBoss(r);
                    break;
                   }
                   else
                   {
                    gestor.getGame().addMarc(temp.getNext().getPunt());
                    gestor.getGame().updateMarcs();
                    temp.setNext(temp.getNext().getNext());
                    temp=this.Head;
                    this.len-=1;
                       System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX "+this.len);
                    int indl=0;
                    int len=this.getLen();
                    ind=0;
                    while(indl!=len)
                    {
                      if(ind<x)
                      {
                          temp.newx(-50);
                          temp=temp.getNext();
                          ind++;
                          indl++;
                      }
                      else
                      {
                          temp.newx(50);
                          //temp.setInf(temp.getInf()+50);
                          temp=temp.getNext();
                          ind++;
                          indl++;
                      }
                    }
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
        this.type="Type C";
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
    public Enemy getTail()
    {
        return this.Tail;
    }
    public void chnBoss(int x)
    {
       Enemy temp=this.Head;
       int ind=0;
       while(true)
       {
        if(x==0)
        {
            if(this.getLen()>1)
            {
                Boss b=new Boss();
                b.Init(this.Head.getX(),this.Head.getY(),this.Head.getSup(),this.Head.getDir(),gestor, lvl,3);
                b.setNext(this.Head.getNext());
                this.Tail.setNext(b);
                this.Head=b;
            break;
            }
            else if(this.getLen()==1)
            {
                Boss b=new Boss();
                b.Init(this.Head.getX(),this.Head.getY(),this.Head.getSup(),this.Head.getDir(),gestor, lvl,3);
                this.Tail=b;
                this.Head=b;
                b.setNext(b);
                break;
            }
        }
        else if(ind+1==x)
        {
            if(temp.getNext().getX()==this.Tail.getX())
            {
                Boss b=new Boss();
                b.Init(temp.getNext().getX(),temp.getNext().getY(),temp.getNext().getSup(),temp.getNext().getDir(),gestor, lvl,3);
                b.setNext(temp.getNext().getNext());
                temp.setNext(b);
                this.Tail=b;
                break;
            }
            else
            {
                Boss b=new Boss();
                b.Init(temp.getNext().getX(), temp.getNext().getY(),temp.getNext().getSup(),temp.getNext().getDir(),gestor, lvl,3);
                b.setNext(temp.getNext().getNext());
                temp.setNext(b);
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
}
