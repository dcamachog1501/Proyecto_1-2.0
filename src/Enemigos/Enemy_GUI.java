/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import Fabrica_Enemigos.Enemy_Creator;
import Hileras.Line;
import Ventanas.Gestor2;

/**
 *
 * @author Extreme pc
 */
public class Enemy_GUI 
{
    public Enemy buildEnemy(Enemy_Creator enemyfactory, int x, int y,int sup,int dir,Gestor2 gest,int lvl, int h)
    {
        Enemy enm= enemyfactory.createEnemy(x, y, sup,dir,gest,lvl,h);
        return enm;
    }
}