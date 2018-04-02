/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import Ventanas.Gestor2;
import java.awt.*;

/**
 *
 * @author Daniel Camacho 
 */
public interface Enemy 
{
    public void setType();
    public void setFace();
    public void setHealth();
    public void setDir();
    public void setNext(Object enm);
    public void setInf(int inf);
    public void setSup(int sup);
    public void setSpeed();
    public void setPunt();
    public void setX(int x);
    public void setY(int y);
    public int getSup();
    public int getInf();
    public Enemy getNext();
    public int getX();
    public int getY();
    public Image getFace();
    public void chnX();
    public void chnY();
    public void chnDir();
    public int getPunt();  
    public void Init(int x,int y,int sup,int inf, Gestor2 gest,int lvl);
    public int getHealth();
    public void chnHealth(int x);
    public int getSpeed();
    public void setGest(Gestor2 gest);
}