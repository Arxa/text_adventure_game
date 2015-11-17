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
import zork.interfaces.IMovable;
import zork.interfaces.IUnlockable;

/**
 *
 * @author Arxa
 */
public class KitchenChest implements IMovable, IExaminable, IOpenable, IUnlockable
{
    private static boolean examineStatus;
    private static boolean moveStatus;
    private static boolean openStatus;
    private static boolean lockStatus;
    private static boolean unlockStatus;

    public KitchenChest(Room a, IWords w) 
    {
        moveStatus = false;
        examineStatus = false;
        openStatus = false;
        lockStatus = true;
        a.getIncludedItems().add(getStringItem());
        w.addWord(getStringItem());
    }

    //-------------IMovable-----------------\\
    @Override
    public boolean isMoved()
    {
        return getMoveStatus();
    }
    
    @Override
    public String getMovableStringItem()
    {
        return "chest";
    }
    
    @Override
    public boolean isStable()
    {
        return true;
    }
    
    @Override
    public void setMoveStatus(boolean s)
    {
        moveStatus = s;
        
    }
    @Override
    public void printItsStable()
    {
        System.out.println("This is way too heavy for me.");
    }
    
    @Override
    public void printMoveOk()
    {
        System.out.printf("You moved the %s .\n",getStringItem());
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
        return "chest";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("It looks astonishing..I am sure that something very valuable is inside.");
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
        return lockStatus;
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
        System.out.println("Unlocks with: Silver Key\n");
    }
    
    @Override
    public void printOpenOk()
    {
        System.out.printf("\nYou opened the %s .\n",getStringItem());
    }

    
    @Override
    public String getOpenableStringItem()
    {
        return "chest";
    }

    
    
    
    //-------------IUnlockable-----------------\\
    @Override
    public boolean isUnlocked()
    {
        return getUnlockStatus();
    }
    
    @Override
    public void setUnlockStatus(boolean s)
    {
        unlockStatus = s;
    }
    
    @Override
    public void printItemUnlocked()
    {
        System.out.println("\nYou have unlocked the Silver Chest.");
    }
    
    @Override
    public String getUnlockableStringItem()
    {
        return "chest";
    }
    
    @Override
    public String getRightKey()
    {
        return "Silver Key";
    }
    
  
    
    
    //-------------Static-----------------\\
    public static boolean getMoveStatus() 
    {
        return moveStatus;
    }

    public static boolean getExamineStatus() 
    {
        return examineStatus;
    }
     public static boolean getOpenStatus() 
    {
        return openStatus;
    }
    
    public static void printItemRevealed()
    {
        System.out.println("\nInside there is a silver Machete.\n");
    } 
    
    public static String getStringItem()
    {
        return "Chest";
    }

    public static void setLockStatus(boolean s) 
    {
        lockStatus = s;
    }
    
    public static boolean getUnlockStatus() 
    {
        return unlockStatus;
    }
    
    public static void setopenStatus(boolean s) 
    {
        openStatus = s;
    }
}
