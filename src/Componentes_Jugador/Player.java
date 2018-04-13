/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes_Jugador;

/**
 *
 * @author dcama
 */
public class Player 
{
 private String name;
 private Player next;
 private int punt;
 
 public void Init(String name,int punt)
 {
     this.name=name;
     this.punt=punt;
     this.next=null;
 }
 public Player getNext()
 {
     return this.next;
 }
 public void setNext(Player pl)
 {
     this.next=pl;
 }
 public void setName(String n)
 {
     this.name=n;
 }
 public void setPunt(int punt)
 {
     this.punt=punt;
 }
 public int getPunt()
 {
     return this.punt;
 }
 public String getName()
 {
     return this.name;
 }
}
