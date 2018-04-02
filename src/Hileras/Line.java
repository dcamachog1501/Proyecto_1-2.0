/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hileras;
import Enemigos.Basic;
import Enemigos.Enemy;
import Ventanas.Gestor2;
import java.awt.*;

/**
 *
 * @author Daniel Camacho
 */
public interface Line 
{
    public void setHead();
    public void setLen();
    public void setMaxlen();
    public void setEnmx();
    public void setEnmy();
    public void setSup();
    public void setInf();
    public void setCurrent();
    public boolean isEmpty();
    public void adder(Object enm);
    public Image getCurrent();
    public void createLine();
    public void Render(Graphics g,Canvas c);
    public int getEnmy();
    public int getEnmx();
    public Enemy getHead();
    public int getSup();
    public int getInf();
    public void Init(Gestor2 gest,int lvl);
    public void setFactory();
    public void eliminate(int x);
    public void setGestor(Gestor2 gest);
    public void setNext(Line l);
    public Line getNext();
    public Object getMove();
    public void setType();
    public String getType();
    public int getLen();
}
