/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica_Enemigos;

import Enemigos.Enemy;
import Enemigos.Type_D;
import Ventanas.Gestor2;

/**
 *
 * @author Daniel Camacho
 */
public class D_Creator implements Enemy_Creator
{

    @Override
    public Enemy createEnemy(int x, int y, int sup, int dir, Gestor2 gest, int lvl, int h) 
    {
        Type_D enm= new Type_D();
        enm.Init(x,y,sup,dir,gest,lvl,h);
        return enm;
    }
    
}
