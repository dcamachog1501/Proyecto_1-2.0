/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes_Jugador;

/**
 *
 * @author Daniel Camacho
 */
public class Puntaje 
{
    private Player Head;
    private int len;
    private int lenmax;
    public void Init()
    {
        this.Head=null;
        this.len=0;
        this.lenmax=5;
    }
    public void add(Player pl)
    {
     Player temp=this.Head;
     while(temp.getNext()!=null)
     {
         temp=temp.getNext();
     }
     temp.setNext(pl);
    }
    public void modify(int ind, Player pl)
    {
        int cont=0;
        Player temp=this.Head;
        while(true)
        {
           if(cont+1==ind) 
           {
               pl.setNext(temp.getNext().getNext());
               temp.setNext(pl);
               break;
           }
           temp=temp.getNext();
           cont++;
        }
    }
    public Player getPlayer(int ind)
    {
       int cont=0;
       Player temp=this.Head;
       while(true)
       {
          if(cont==ind)
          {
              return temp;
          }
          temp=temp.getNext();
          cont++;
          
       }
    }
   public void createPunt()
   {
       
   }
    
}
