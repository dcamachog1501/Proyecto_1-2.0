/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica_Enemigos;

import Enemigos.Enemy;
import Ventanas.Gestor2;

/**
 *
 * @author dcama
 */
public interface Enemy_Creator
{
    public Enemy createEnemy(int x, int y, int sup, int inf, Gestor2 gest, int lvl);
}
