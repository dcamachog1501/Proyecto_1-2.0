/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica_Hileras;

import Hileras.Basic_Line;
import Ventanas.Gestor2;

/**
 *
 * @author Daniel Camacho
 */
public class Basic_Line_Creator implements Line_Creator 
{
    @Override
    public Basic_Line createLine(Gestor2 gest,int lvl) 
    {
       Basic_Line hilera=new Basic_Line();
       hilera.Init(gest,lvl);
       hilera.createLine();
       return hilera;
    }
    
}
