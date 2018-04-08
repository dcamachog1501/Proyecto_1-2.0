/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica_Hileras;

import Hileras.B_Line;
import Hileras.Line;
import Ventanas.Gestor2;

/**
 *
 * @author dcama
 */
public class B_Line_Creator implements Line_Creator
{

    @Override
    public Line createLine(Gestor2 gest, int lvl) 
    {
       B_Line hilera=new B_Line();
       hilera.Init(gest,lvl);
       hilera.createLine();
       return hilera;
    }
    
}
