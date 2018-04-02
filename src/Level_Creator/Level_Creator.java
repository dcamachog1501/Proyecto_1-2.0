/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level_Creator;

import Ventanas.Gestor2;
import Level_Creator.Level;

/**
 *
 * @author dcama
 */
public class Level_Creator 
{
  Gestor2 gestor;
  public Level_Creator(Gestor2 gest)
  {
      this.gestor=gest;
  }
  public Level createLevel(int x)
    {
        Level l= new Level(x,gestor);
        l.generateLevel();
        return l;
    }
}
