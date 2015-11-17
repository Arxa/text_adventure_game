/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.items;

import zork.interfaces.ITakable;

/**
 *
 * @author arxa
 */
public class StarterKatana implements ITakable
{ 
    private static boolean takenStatus;
    private static boolean examineStatus;
    
    
    
    public StarterKatana() 
    {
     
    }
    
    @Override
    public boolean isTaken()
    {
        return takenStatus;
    }

    @Override
    public String getTakableStringItem()
    {
        return "katana";
    }
    @Override
    public boolean isStucked()
    {
        return false;
    }
    @Override
    public void setTakenStatus(boolean s)
    {
        StarterKatana.takenStatus = s;
    }
    @Override
    public void printItsStucked()
    {
        System.out.println("\nYou can't take this.\n");
    }
    @Override
    public void printTakenOK()
    {
        System.out.printf("\nYou have added %s in your bag. \n",getBagStringItem());
    }
    @Override
    public String getBagStringItem()
    {
        return "Black Katana Sword";
    }
    
    @Override
    public boolean isWeapon()
    {
        return true;
    }
    
    @Override
    public boolean isKey()
    {
        return false;
    }
    
    @Override
    public int getCoinsAmount()
    {
        return 0;
    }

}
