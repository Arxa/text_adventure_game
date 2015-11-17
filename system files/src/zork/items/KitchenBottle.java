/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.items;

import zork.other.Room;
import zork.interfaces.IOpenable;
import zork.interfaces.IWords;
import zork.interfaces.IExaminable;
import zork.interfaces.IDrinkable;

/**
 *
 * @author Arxa
 */
public class KitchenBottle implements IOpenable, IDrinkable, IExaminable
{
    private static boolean openStatus;
    private static boolean examineStatus;
    private static boolean drinkStatus;

    public KitchenBottle(Room a, IWords w) 
    {
        openStatus = false;
        examineStatus = false;
        a.getIncludedItems().add(getStringItem());
        w.addWord(getStringItem());
    }
    
    //-------------IOpenable-----------------\\
    @Override
    public boolean isOpened()
    {
        return getOpenStatus();
    }

    @Override
    public boolean isLocked()
    {
        return false;
    }
    
    @Override
    public void setOpenStatus(boolean s) 
    {
        openStatus = s;
    }
    
    @Override
    public void printItsLocked()
    {
        System.out.printf("\nThe %s is locked.\n",getStringItem());
    }
    
    @Override
    public void printOpenOk()
    {
        System.out.printf("\nYou opened the %s.\n",getStringItem());
    }

    
    @Override
    public String getOpenableStringItem()
    {
        return "bottle";
    }
    
    
    //-------------IDrinkable-----------------\\
    @Override
    public boolean isDrunk()
    {
        return getDrinkStatus();
    }
        
    @Override
    public String getDrinkableStringItem()
    {
        return "bottle";
    }
    @Override
    public void setDrinkStatus(boolean s)
    {
        drinkStatus=s;
    }
    @Override
    public void printDrinkOk()
    {
        System.out.println("\n(You drank a bottle of strong mexican tequila) \nWow it's very strong...\nYou are getting dizzy..\n");
    }
    
    @Override
    public boolean isToBeOpenedFirst()
    {
        return true;
    }
    
    
    
    
    //-------------IExaminable-----------------\\
    @Override
    public boolean isExamined()
    {
        return getExamineStatus();
    }
    @Override
    public String getExaminableStringItem()
    {
       return "bottle";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("\nAaaah..It appears to be mexican tequila! Awesome!\n");
    }

    
    
    //-------------Static-----------------\\
    public static boolean getExamineStatus() 
    {
        return examineStatus;
    }
    
    public static boolean getOpenStatus() 
    {
        return openStatus;
    }

    public static boolean getDrinkStatus() 
    {
        return drinkStatus;
    }
    
   
    public static String getStringItem()
    {
        return "Bottle";
    }
    
    
}
    

