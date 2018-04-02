
package Threads;

import Componentes_Jugador.Bullet;
import Enemigos.Enemy;
import Hileras.Line;
import Ventanas.Gestor2;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Camacho 
 */
public class BasicMove implements Runnable
{
    private Line hilera;
    private Enemy temp;
    private Gestor2 gestor;
    public BasicMove()
    {
        
    }
    public BasicMove(Line hilera,Gestor2 gest)
    {
        this.hilera=hilera;
        this.gestor=gest;
        
    }
    @Override
    public void run() 
    {
        while(true)
        {
            Enemy temp=(Enemy) hilera.getHead();
            int ind=0;
            while(temp!=null)
            {
                Bullet b= gestor.getDatos().getSet().getBull();
                if(b.getBullx()<temp.getX()+64&& b.getBullx()+24>temp.getX()
                   && b.getBully()<temp.getY()+64&&b.getBully()+24> temp.getY())
                {
                    System.out.println("Killing");
                    hilera.eliminate(ind);
                    break;
                }
                temp=(Enemy) temp.getNext();
                ++ind;
            }
            
            if(gestor.getGame().getLManager().getCurrent().getHead()==null)
            {
                System.out.println("-----------------NEXT ROUND----------------");
                gestor.getGame().getLManager().nextLine();
                gestor.getGame().updateScreen();
                updateHil();
            }
            else if(hilera.getHead().getX()<=hilera.getHead().getInf())
            {
                temp=(Enemy) hilera.getHead();
                while(temp!=null)
                {
                    temp.chnDir();
                    temp.chnX();
                    temp.chnY();
                    temp=(Enemy) temp.getNext();
                }
                
            }
            else if(hilera.getHead().getX()>=hilera.getHead().getSup())
            {
                temp=(Enemy) hilera.getHead();
                while(temp!=null)
                {
                    temp.chnDir();
                    temp.chnX();
                    temp.chnY();
                    temp=(Enemy) temp.getNext();
                    
                }
            }
            else
            {
                temp=(Enemy) hilera.getHead();
                while(temp!=null)
                {
                    temp.chnX();
                    temp=(Enemy) temp.getNext();
                }
                
                    
            }
        try {
            Thread.sleep(gestor.getGame().getLManager().getCurrent().getHead().getSpeed());
            } 
        catch (InterruptedException ex) 
            {
            }
            
        }
      }
    public void updateHil()
    {
        this.hilera=gestor.getGame().getLManager().getCurrent();
    }
}

