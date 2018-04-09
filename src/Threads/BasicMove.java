
package Threads;

import Componentes_Jugador.Bullet;
import Enemigos.Enemy;
import Hileras.A_Line;
import Hileras.B_Line;
import Hileras.Basic_Line;
import Hileras.Line;
import Ventanas.Gestor2;
import java.util.Random;
/**
 *
 * @author Daniel Camacho 
 */
public class BasicMove implements Runnable
{
    private Line hilera;
    private Enemy temp;
    private Gestor2 gestor;
    private int cont;
    public BasicMove()
    {
        
    }
    public BasicMove(Line hilera,Gestor2 gest)
    {
        this.hilera=hilera;
        this.gestor=gest;
        this.cont=0;
    }
    @Override
    public void run() 
    {
        
        while(true)
        {
         if(hilera.getClass()==Basic_Line.class||hilera.getClass()==A_Line.class)
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
            temp=hilera.getHead();
            if(temp!=null)
            {
                while(temp.getNext()!=null)
                {
                    temp=temp.getNext();
                }
            }
            if(gestor.getGame().getLManager().getCurrent().getHead()==null)
            {
                System.out.println("-----------------NEXT ROUND----------------");
                gestor.getGame().getLManager().nextLine();
                gestor.getGame().updateScreen();
                updateHil();
            }
            else if(temp.getX()<=10)
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
            updateHil();
            Thread.sleep(gestor.getGame().getLManager().getCurrent().getHead().getSpeed());
            } 
        catch (Throwable e) 
            {
                e.printStackTrace();
            }
         }
         
         
         else if(hilera.getClass()==B_Line.class)
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
            temp=hilera.getHead();
            if(temp!=null)
            {
                while(temp.getNext()!=null)
                {
                    temp=temp.getNext();
                }
            }
            if(gestor.getGame().getLManager().getCurrent().getHead()==null)
            {
                System.out.println("-----------------NEXT ROUND----------------");
                gestor.getGame().getLManager().nextLine();
                gestor.getGame().updateScreen();
                updateHil();
            }
            else if(temp.getX()<=10)
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
                if(cont==5)
                {
                chnBoss(hilera);
                cont=0;
                }
                else
                {
                 cont++;
                }
                while(temp!=null)
                {
                    temp.chnX();
                    temp=(Enemy) temp.getNext();
                }
                
                    
            }
        try {
            updateHil();
            Thread.sleep(gestor.getGame().getLManager().getCurrent().getHead().getSpeed());
            } 
        catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
         }
         else
         {
             try
             {
                 Thread.sleep(0);
             }
             catch(InterruptedException e)
             {
                 e.printStackTrace();
             }
         }
        }
      }
    public void updateHil()
    {
        this.hilera=gestor.getGame().getLManager().getCurrent();
    }
    public void chnBoss(Line h)
    {
        Enemy temp=h.getHead();
        Enemy temp2=h.getHead();
        int ind=0;
        while(temp!=null)
        {
            if(temp.isBoss())
            {
                break;
            }
            else
            {
                temp=temp.getNext();
                ind++;
            }
        }
        Random r= new Random();
        int indr=r.nextInt(h.getLen());
        int ind2=0;
        while(ind==indr)
        {
            indr=r.nextInt(h.getLen());
        } 
        while(ind2!=indr)
        {
            temp2=temp2.getNext();
            ind2++;
        }
        ((B_Line)h).Swap(temp, temp2);
    }     
}

