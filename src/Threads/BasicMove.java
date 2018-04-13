
package Threads;

import Componentes_Jugador.Bullet;
import Enemigos.Boss;
import Enemigos.Enemy;
import Enemigos.Type_A;
import Enemigos.Type_B;
import Enemigos.Type_E;
import Hileras.A_Line;
import Hileras.B_Line;
import Hileras.Basic_Line;
import Hileras.C_Line;
import Hileras.D_Line;
import Hileras.E_Line;
import Hileras.Line;
import Ventanas.Gestor2;
import java.util.Random;
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
    private int cont;
    private double ang=0;
    private int inX;
    private boolean cond;
    private boolean bool;
    public BasicMove()
    {
        
    }
    public BasicMove(Line hilera,Gestor2 gest)
    {
        this.hilera=hilera;
        this.gestor=gest;
        this.cont=0;
        this.cond=true;
        this.bool=true;
    }
    @Override
    public void run() 
    {
        
        while(bool)
        {
         if(hilera.getClass()==Basic_Line.class||hilera.getClass()==A_Line.class)
         {
            
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
            ((B_Line)hilera).refine();
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
                if(hilera.getLen()>1)
                {
                chnBoss(hilera);
                }
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
         else if(hilera.getClass()==C_Line.class)
         {
           if(gestor.getGame().getLManager().getCurrent().getLen()==0)
            {
                gestor.getGame().getLManager().nextLine();
                gestor.getGame().updateScreen();
                updateHil();
            }
            else if(((C_Line)hilera).getTail().getX()<=10)
            {
                int ind=0;
                int len=hilera.getLen();
                temp= hilera.getHead();
                boolean flag2=false;
                while(ind!=len)
                {
                    temp.chnDir();
                    temp.chnX();
                    temp.chnY();
                    temp=temp.getNext();
                    ind++;
                }
            }
            else if(hilera.getHead().getX()>=hilera.getHead().getSup())
            {
                temp=hilera.getHead();
                int ind=0;
                int len=hilera.getLen();
                while(ind!=len)
                {
                    temp.chnDir();
                    temp.chnX();
                    temp.chnY();
                    temp=temp.getNext();
                    ind++;
                }
            }
            else
            {
                temp=hilera.getHead();
                int ind=0;
                int len=hilera.getLen();
                while(ind!=len)
                {
                    temp.chnX();
                    temp=temp.getNext();
                    ind++;
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
         else if(hilera.getClass()==D_Line.class)
         {
             if(gestor.getGame().getLManager().getCurrent().getLen()==0)
            {
                gestor.getGame().getLManager().nextLine();
                gestor.getGame().updateScreen();
                updateHil();
            }
            else if(((D_Line)hilera).getTail().getX()<=10)
            {
                int ind=0;
                int len=hilera.getLen();
                temp= hilera.getHead();
                boolean flag2=false;
                while(ind!=len)
                {
                    temp.chnDir();
                    temp.chnX();
                    temp.chnY();
                    temp=temp.getNext();
                    ind++;
                }
            }
            else if(hilera.getHead().getX()>=hilera.getHead().getSup())
            {
                temp=hilera.getHead();
                int ind=0;
                int len=hilera.getLen();
                while(ind!=len)
                {
                    temp.chnDir();
                    temp.chnX();
                    temp.chnY();
                    temp=temp.getNext();
                    ind++;
                }
            }
            else
            {
                temp=hilera.getHead();
                int ind=0;
                int len=hilera.getLen();
                while(ind!=len)
                {
                    temp.chnX();
                    temp=temp.getNext();
                    ind++;
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
         else if(hilera.getClass()==E_Line.class)
         {
            if(gestor.getGame().getLManager().getCurrent().getLen()==0)
            {
                gestor.getGame().getLManager().nextLine();
                gestor.getGame().updateScreen();
                updateHil();
            }
            else
            {
                int ind=0;
                int lenl=hilera.getLen();
                Enemy temp=hilera.getHead();
                while(ind!=lenl)
                {
                if(temp.getClass()==Type_E.class)
                {
                ((E_Line)hilera).rotate(ang,((Type_E)temp).getInX(),ind);
                }
                else if(temp.getClass()==Boss.class)
                {
                 ((E_Line)hilera).rotate(ang,((Boss)temp).getInX(),ind);
                }
                ind++;
                temp=temp.getNext();
                }
                this.ang+=0.1;
                try 
                {
                    Thread.sleep(30);
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
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
         verify();
        }
      }
    public void updateHil()
    {
        this.hilera=gestor.getGame().getLManager().getCurrent();
    }
    public void verify()
    {
        if(hilera.getClass()==A_Line.class||hilera.getClass()==B_Line.class||hilera.getClass()==Basic_Line.class)
        {
            Enemy temp=hilera.getHead();
            while(temp!=null)
            {
                if(temp.getY()+10>=gestor.getDatos().getSet().getNave().getNavy())
                {
                                                
                    gestor.endGame();
                    break;
                }
                temp=temp.getNext();
            }
        }
        else if(hilera.getClass()==C_Line.class||hilera.getClass()==D_Line.class||hilera.getClass()==E_Line.class||hilera.getClass()==Basic_Line.class)
        {
            Enemy temp=hilera.getHead();
            int ind=0;
            int lenl=hilera.getLen();
            while(ind!=lenl)
            {
               if(temp.getY()+10>=gestor.getDatos().getSet().getNave().getNavy())
                {
                    gestor.endGame();
                    break;
                }
                temp=temp.getNext();
                ind++;
            }
        }
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
    public void chnBool()
    {
        bool = !bool;
    }
}


