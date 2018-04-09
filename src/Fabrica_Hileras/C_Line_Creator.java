/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica_Hileras;

import Hileras.C_Line;
import Hileras.Line;
import Ventanas.Gestor2;

/**
 *
 * @author dcama
 */
public class C_Line_Creator implements Line_Creator
{
    @Override
    public Line createLine(Gestor2 gest, int lvl) 
    {
       C_Line hilera=new C_Line();
       hilera.Init(gest,lvl);
       hilera.createLine();
       return hilera;
    }
}
