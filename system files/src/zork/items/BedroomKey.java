/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.items;

import zork.interfaces.IExaminable;
import zork.interfaces.ITakable;
import zork.interfaces.IWords;

/**
 *
 * @author arxa
 */
public class BedroomKey implements ITakable, IExaminable
{
    private static boolean takenStatus;
    private static boolean examineStatus;

    public BedroomKey(IWords w) 
    {
        takenStatus = false;
        examineStatus = false;
        w.addWord(getStringItem());
    }
    
    //-------------ITakable-----------------\\
    @Override
    public boolean isTaken()
    {
        return takenStatus;
    }

    @Override
    public String getTakableStringItem()
    {
        return "key";
    }
    @Override
    public boolean isStucked()
    {
        return false;
    }
    @Override
    public void setTakenStatus(boolean s)
    {
        BedroomKey.takenStatus = s;
    }
    @Override
    public void printItsStucked()
    {
        System.out.println("\nYou can't take this.\n");
    }
    @Override
    public void printTakenOK()
    {
        System.out.printf("\nYou have added %s to your bag. \n",specialInfo());
    }
    @Override
    public String getBagStringItem()
    {
        return "Silver Key";
    }
    
    @Override
    public boolean isWeapon()
    {
        return false;
    }
    
    @Override
    public boolean isKey()
    {
        return true;
    }
    
    @Override
    public int getCoinsAmount()
    {
        return 0;
    }
    
    
    
    //-------------IExaminable-----------------\\
    @Override
    public boolean isExamined()
    {
        return examineStatus;
    }
    @Override
    public String getExaminableStringItem()
    {
        return "key";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("\nIt's very shinny.\n");
    }
    
    
    //-------------Static-----------------\\
    public static boolean getExamineStatus() 
    {
        return examineStatus;
    }

    public static boolean getTakenStatus() 
    {
        return takenStatus;
    }
    
    public static String specialInfo()
    {
        return "a Silver Key";
    }
    
    public static String getStringItem()
    {
        return "Key";
    }
}
    

