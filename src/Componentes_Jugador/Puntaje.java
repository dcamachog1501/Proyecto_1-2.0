/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes_Jugador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     if(this.len==0)
     {
         this.Head=pl;
         len++;
     }
     else
     {
        Player temp=this.Head;
        while(temp.getNext()!=null)
        {
            temp=temp.getNext();
        }
        temp.setNext(pl);
        len++;
     }
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
   public void createPunt() throws FileNotFoundException, IOException
   {
        FileReader file= new FileReader("Resources/Puntaje/Puntaje.txt");
        BufferedReader reader = new BufferedReader(file);
        int ind=0;
        String line=reader.readLine();
        while(ind<lenmax)
        {
            Player p= new Player();
            String[] stringarray = line.split(",");
            p.setName(stringarray[0]);
            int punt=Integer.parseInt(stringarray[1]);
            p.setPunt(punt);
            this.add(p);
            line=reader.readLine();
            ind++;
            
           
        }
        reader.close();
   }
   public Player getHead()
   {
       return this.Head;
   }
   public Player getPos(int x)
   {
    int ind=0;
    Player temp=getHead();
    while(ind!=x)
    {
       temp=temp.getNext();
       ind++;
    }
    return temp; 
   }
   public void save(Player newP)
   {
     Player temp=this.Head;
     while(temp!=null)
     {
         if(newP.getPunt()>temp.getPunt())
         {
             temp.setPunt(newP.getPunt());
             temp.setName(newP.getName());
             break;
         }
         temp=temp.getNext();
     }
     PrintWriter writer=null;
        try 
        {
            writer = new PrintWriter("Resources/Puntaje/Puntaje.txt");
        } catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Puntaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    writer.print("");
    temp= this.Head;
    boolean cond=true;
    while(temp!=null)
    {
//        if(cond==true)
//        {
//            writer.println("\n");
//            cond=false;
//        }
        
        {
        String puntaje=temp.getName()+","+temp.getPunt();
        System.out.println(puntaje);
        writer.println(puntaje);
        temp=temp.getNext();
        }
    }
    writer.close();
   }
    
}
