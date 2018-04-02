/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Enemigos.Enemy;
import Hileras.Basic_Line;
import Hileras.Line;
import Level_Creator.Level;
import Level_Creator.Level_Creator;
import Threads.Setup;
import Ventanas.Gestor2;
import java.util.Random;

/**
 *
 * @author dcama
 */
public class Main 
{
    
    
    public static void main(String[] args) 
    {
       Gestor2 g = new Gestor2();
       g.Init();
       g.gestInicial();
//        Level_Creator l = new Level_Creator(g);
//        Level v=l.createLevel(0);
//        Line temp=v.getHead();
//        while(temp!=null)
//        {
//            System.out.println(temp);
//            temp=temp.getNext();
//        }
//        System.out.println(v.getLen());
     
        
    }
}
