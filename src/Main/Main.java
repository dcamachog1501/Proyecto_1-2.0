/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Componentes_Jugador.Player;
import Componentes_Jugador.Puntaje;
import Enemigos.Enemy;
import Hileras.E_Line;
import Ventanas.Gestor2;
import java.io.IOException;

/**
 *
 * @author dcama
 */
public class Main 
{
    
    
    public static void main(String[] args) throws IOException 
    {
       Gestor2 g = new Gestor2();
       g.Init();
       g.gestInicial();
//       Puntaje p= new Puntaje();
//       p.Init();
//       p.createPunt();
//       Player temp=p.getHead();
//       while(temp!=null)
//       {
//           System.out.println(temp.getName()+" , "+temp.getPunt());
//           temp=temp.getNext();
//       }
//       Player newP= new Player();
//       newP.Init("Negro", 999999999);
//       p.save(newP);
//       temp=p.getHead();
//        System.out.println("----------------------------------------------");
//       while(temp!=null)
//       {
//           System.out.println(temp.getName()+" , "+temp.getPunt());
//           temp=temp.getNext();
//       }
               
    }
}
    
