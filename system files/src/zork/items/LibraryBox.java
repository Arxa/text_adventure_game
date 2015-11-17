/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.items;

import zork.interfaces.IExaminable;
import zork.interfaces.IMovable;
import zork.interfaces.IOpenable;
import zork.interfaces.IUnlockable;
import zork.interfaces.IWords;
import zork.other.Password;

/**
 *
 * @author arxa
 */
public class LibraryBox implements IOpenable, IMovable, IExaminable
{
    private static boolean examineStatus;
    private static boolean moveStatus;
    private static boolean openStatus;
    private static boolean lockStatus;
    private static boolean unlockStatus;

    public LibraryBox(IWords w) 
    {
        moveStatus = false;
        examineStatus = false;
        openStatus = false;
        lockStatus = true;
        unlockStatus = false;
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
        return "box";
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
        System.out.println("Nothing happened.");
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
        return "box";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("A High-Tech digital security box.");
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
        System.out.printf("\nEnter password: \n");
        if (Password.checkPassword(getRightKey()))
        {
            setOpenStatus(true);
            setLockStatus(true);
            printOpenOk();
        }
    }
    
    @Override
    public void printOpenOk()
    {
        System.out.printf("\nYou opened the %s .\n",getStringItem());
        printItemRevealed();
    }

    @Override
    public String getOpenableStringItem()
    {
        return "box";
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
        System.out.println("\nYou found a fully loaded CrossBow inside !!!\n");
    } 
    
    public static String getStringItem()
    {
        return "Box";
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
    
    public static String getRightKey()
    {
        return "420";
    }
    
}
