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
public interface IDrinkable 
{
    public boolean isDrunk();
    public String getDrinkableStringItem();
    public void setDrinkStatus(boolean s);
    public void printDrinkOk();
    public boolean isToBeOpenedFirst();
}
