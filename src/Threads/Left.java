/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Ventanas.Gestor2;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase de tipo Thread encargada de modificar las coordenadas en x de la nave
 * @author Daniel Camacho
 */
public class Left implements Runnable 
{
private final Gestor2 gestor;
private int Navx;
private boolean cond;

public Left(Gestor2 gest)
{
    this.gestor=gest;
    this.Navx=gestor.getDatos().getNave().getNavx();
    this.cond=false;
}
    

    @Override
    public void run() 
    {
      while(true)
      {
        if(cond==true)
        {
            if(gestor.getDatos().getNave().getNavx()>0)
                    {
                     gestor.getDatos().getNave().chnNavx(gestor.getDatos().getNave().getNavx()-5);
                     try
                     {
                      Thread.sleep(10);
                     }
                     catch(Exception e)
                     {
                         e.printStackTrace();
                     }
                    }
            else
                    {
                    gestor.getDatos().getNave().chnNavx(0);
                    }
        }
        else
            {
                try {
                    Thread.sleep(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
      }
    }
    public void chnCond()
    {
        if(cond==true)
        {
            cond=false;
        }
        else
        {
            cond=true;
        }
    }
}
