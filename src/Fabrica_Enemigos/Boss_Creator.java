/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica_Enemigos;

import Enemigos.Boss;
import Enemigos.Enemy;
import Ventanas.Gestor2;

/**
 *
 * @author dcama
 */
public class Boss_Creator implements Enemy_Creator
{
   @Override
    public Enemy createEnemy(int x, int y, int sup, int inf,Gestor2 gest,int lvl) 
    {
        Boss enm= new Boss();
        enm.Init(x,y,sup,inf,gest,lvl);
        return enm;
    }  
}
