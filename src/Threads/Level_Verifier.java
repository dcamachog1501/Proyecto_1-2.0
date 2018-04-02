/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Hileras.Line;
import Level_Creator.Level;
import Ventanas.Gestor2;

/**
 *
 * @author Extreme pc
 */
public class Level_Verifier implements Runnable
{
private final Gestor2 gestor;
public Level_Verifier(Gestor2 gest)
{
    this.gestor=gest;
}
    @Override
    public void run() 
    {
        while(true)
        {
            if(gestor.getGame().getLManager().getCurrent().getLen()==0)
            {
                System.out.println("-----------------NEXT ROUND----------------");
                gestor.getGame().getLManager().nextLine();
            }
            if(gestor.getGame().getLManager().getCurrent()==null)
            {
                System.out.println("-----------------LEVEL UP!-----------------");
                gestor.getGame().getLManager().lvlUP();
                
            }
        }
    }
    
}
