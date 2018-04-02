/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica_Hileras;

import Hileras.Line;
import Ventanas.Gestor2;

/**
 *
 * @author dcama
 */
public interface Line_Creator 
{
    public Line createLine(Gestor2 gest,int lvl);
}
