/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica_Enemigos;

import Enemigos.Enemy;
import Enemigos.Type_D;
import Enemigos.Type_E;
import Ventanas.Gestor2;

/**
 *
 * @author dcama
 */
public class E_Creator implements Enemy_Creator
{

    @Override
    public Enemy createEnemy(int x, int y, int sup, int dir, Gestor2 gest, int lvl, int h) 
    {
        Type_E enm= new Type_E();
        enm.Init(x,y,sup,dir,gest,lvl,h);
        return enm;
    }
}
