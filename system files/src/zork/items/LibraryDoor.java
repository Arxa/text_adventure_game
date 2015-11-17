/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.items;

import zork.interfaces.IExaminable;
import zork.interfaces.IOpenable;
import zork.interfaces.IWords;

/**
 *
 * @author arxa
 */
public class LibraryDoor implements IOpenable, IExaminable
{
    private static boolean openStatus;
    private static boolean examineStatus;

    public LibraryDoor(IWords w) 
    {
        openStatus = false;
        examineStatus = false;
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
        System.out.printf("\nYou opened the %s .\nA northern passage through the Door has been revealed!\n",getStringItem());
    }
        
    @Override
    public String getOpenableStringItem()
    {
        return "door";
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
       return "door";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("\nPure gold.\n");
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
    
    public static String getStringItem()
    {
        return "Door";
    }
    
}
