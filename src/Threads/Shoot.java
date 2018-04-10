/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Componentes_Jugador.Bullet;
import Enemigos.Enemy;
import Hileras.A_Line;
import Hileras.B_Line;
import Hileras.Basic_Line;
import Hileras.C_Line;
import Hileras.D_Line;
import Ventanas.Gestor2;
import java.awt.event.KeyListener;

/**
 *
 * @author Daniel Camacho
 */
public class Shoot implements Runnable
{
    private final Gestor2 gestor;
    private int Navx;
    private int Navy;
    private Setup set;
    private KeyListener tec2;
    public Shoot(Gestor2 gest)
    {
        this.gestor=gest;
        this.Navx=gestor.getDatos().getSet().getNave().getNavx();
        this.Navy=gestor.getDatos().getSet().getNave().getNavy();
        this.set=gestor.getDatos().getSet();
        this.tec2=gestor.getGame().getTec();
    }        
    @Override
    public void run() 
    {
        gestor.getGame().chanCond();
        set.getBull().stnCond();
        gestor.getGame().rem();
        set.getBull().setBullx(0);
        set.getBull().setBullx(Navx+17);
        while(set.getBull().getBully()>0)
        {
            Enemy temp=null;
            try
            {
            temp=gestor.getGame().getLManager().getCurrent().getHead();
            }
            catch(Exception e)
            {
                
            }
            int ind=0;
            if(temp!=null)
            {
                if(gestor.getGame().getLManager().getCurrent().getClass()==A_Line.class||gestor.getGame().getLManager().getCurrent().getClass()==B_Line.class||gestor.getGame().getLManager().getCurrent().getClass()==Basic_Line.class)
                {
                    while(temp!=null)
                    {
                        Bullet b=set.getBull();
                        if(b.getBullx()<temp.getX()+64&& b.getBullx()+24>temp.getX()
                           && b.getBully()<temp.getY()+64&&b.getBully()+24> temp.getY())
                        {
                            gestor.getGame().getLManager().getCurrent().eliminate(ind);
                            set.getBull().chnCond();
                            set.getBull().setBully(Navy);
                            gestor.getGame().chanCond();
                            gestor.getGame().adder();
                            break;
                        }
                        temp=(Enemy) temp.getNext();
                        ++ind;
                    }
                }
                if(gestor.getGame().getLManager().getCurrent().getClass()==C_Line.class||gestor.getGame().getLManager().getCurrent().getClass()==D_Line.class)
                {
                    ind=0;
                    int indl=0;
                    int len= gestor.getGame().getLManager().getCurrent().getLen();
                    while(indl!=len)
                    {
                        Bullet b= gestor.getDatos().getSet().getBull();
                        if(b.getBullx()<temp.getX()+64&& b.getBullx()+24>temp.getX()
                           && b.getBully()<temp.getY()+64&&b.getBully()+24> temp.getY())
                        {
                            gestor.getGame().getLManager().getCurrent().eliminate(ind);
                            set.getBull().chnCond();
                            set.getBull().setBully(Navy);
                            gestor.getGame().chanCond();
                            gestor.getGame().adder();
                            break;
                        }
                        temp=temp.getNext();
                        indl++;
                        ind++;
                    }
                } 
            }
            if(set.getBull().getCond()==0)
            {
            try {
                set.getBull().chnBully(-25);
                Thread.sleep(10);
                }   
                catch (Throwable e) 
                {
                    e.printStackTrace();
                }
            }
            else
            {
                break;
            }
        }
        if(set.getBull().getCond()==0)
        {
        set.getBull().setBully(Navy);
        gestor.getGame().chanCond();
        gestor.getGame().adder();
        }
    }
    
}
