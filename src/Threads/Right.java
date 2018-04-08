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
 *
 * @author Daniel Camacho
 */
public class Right implements Runnable
{
private final Gestor2 gestor;
private Boolean cond;

public Right(Gestor2 gest)
{
    this.gestor=gest;
    this.cond=false;
}
    

    @Override
    public void run() 
    {
      while(true)
      {
      if(cond==true)
      {
        if(gestor.getDatos().getNave().getNavx()<920)
                {
                 gestor.getDatos().getNave().chnNavx(gestor.getDatos().getNave().getNavx()+5);
                 try
                 {
                  Thread.sleep(10);
                 }
                 catch(Throwable e)
                 {
                     e.printStackTrace();
                 }
                }
        else
                {
                gestor.getDatos().getNave().chnNavx(920);
                }
      }
      else
      {
          try 
          {
              Thread.sleep(0);
          } 
          catch (Throwable e) 
          {
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
