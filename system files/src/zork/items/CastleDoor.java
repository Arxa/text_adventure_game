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

/**
 *
 * @author arxa
 */
public class CastleDoor implements IOpenable,IExaminable
{
    private static boolean openStatus;
    private static boolean examineStatus;

    public CastleDoor(Room a, IWords w) 
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
        return true;
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
        System.out.printf("\nYou opened the %s .\n",getStringItem());
    }
        
    @Override
    public String getOpenableStringItem()
    {
        return "gate";
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
       return "gate";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("\nIt's an Old Black Iron Gate with some weird symbols on it.\n");
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
        return "Gate";
    }
}
