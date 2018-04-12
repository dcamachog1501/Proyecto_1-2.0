/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Enemigos.Enemy;
import Hileras.E_Line;
import Ventanas.Gestor2;

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
//       E_Line c= new E_Line();
//       c.Init(g, 5);
//       c.createLine();
//       Enemy temp=c.getHead();
//       while(temp!=null)
//       {
//           System.out.println(temp);
//           temp=temp.getNext();
//       }
    }
}
    
