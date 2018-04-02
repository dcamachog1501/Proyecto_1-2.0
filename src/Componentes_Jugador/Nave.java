/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes_Jugador;

import Ventanas.Gestor2;
import java.awt.*;

/**
 *
 * @author Daniel Camacho
 */
public class Nave 
{
   private Gestor2 gestor;

   //Coordenadas de la nave
    private  int Navx=460;
    private  int Navy=605;
    
   public Nave(Gestor2 gest)
   {
       this.gestor=gest;
   }
   public void render(Graphics g)
   {
    g.drawImage(gestor.getDatos().getNav(),Navx,Navy,gestor.getGame().getCanvas());
   }
   public int getNavx()
   {
       return Navx;
   }
   public int getNavy()
   {
       return Navy;
   }
   public void chnNavx(int x)
   {
       Navx=x;
   }
}
