/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.interfaces;

/**
 *
 * @author Arxa
 */
public interface ITakable 
{
    public boolean isTaken();
    public String getTakableStringItem();
    public boolean isStucked();
    public void setTakenStatus(boolean s);
    public void printItsStucked();
    public void printTakenOK();
    public String getBagStringItem();
    public boolean isWeapon();
    public boolean isKey();
    public int getCoinsAmount();
}
