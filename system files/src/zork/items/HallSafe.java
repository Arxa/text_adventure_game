/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.items;

import zork.interfaces.IOpenable;
import zork.interfaces.IWords;
import zork.interfaces.IExaminable;

/**
 *
 * @author Arxa
 */
public class HallSafe implements IOpenable,IExaminable
{
    private static boolean moveStatus;
    private static boolean examineStatus;
    
    public HallSafe(IWords w) 
    {
        moveStatus = false;
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
        moveStatus = s;
    }
    
    @Override
    public void printItsLocked()
    {
        System.out.printf("\nThe %s is locked.\n",getStringItem());
    }
    
    @Override
    public void printOpenOk()
    {
        System.out.printf("\nYou opened the %s .\n",getStringItem());
    }
    
    @Override
    public String getOpenableStringItem()
    {
        return "safe";
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
        return "safe";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("\nIt's a high-tech safe vault. Strange that it isn't locked..\n");
    }
    
    
    
    //-------------Static-----------------\\
    public static boolean getExamineStatus() 
    {
        return examineStatus;
    }
    
    public static boolean getOpenStatus() 
    {
        return moveStatus;
    }
    
    public static void safeOpened()
    {
        System.out.println("\nThere is a piece of Paper in there.\n");
    }
    
    public static String getStringItem()
    {
        return "Safe";
    }
}
