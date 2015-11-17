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
public class MatHatch implements IOpenable,IExaminable
{
    private static boolean openStatus;
    private static boolean examineStatus;

    public MatHatch (IWords w) 
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
    public void setOpenStatus(boolean openStatus) 
    {
        MatHatch.openStatus = openStatus;
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
        return "hatch";
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
        return "hatch";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("\nA wooden hatch-door built on the ground.\n");
    }

    

    //-------------Static-----------------\\
    public static void setOpenedStatus(boolean s)
    {
        openStatus = s;
    }
    
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
        return "Hatch";
    }
    
    public static String printGiveRightAnswer()
    {
        return "\nGive me a right answer!!! --> [y/n] --<\n";
    }
    
    public static void printJumpTravel()
    {
        String x=".";
        for (int i=0;i<200;i++)
        {
            System.out.println("."+x);
            x+="¦°¤";
        }
        System.out.println("WOOAAAAAAAAAAAAAAAAAAAAAA\nAAAAAAAAAAAAAAAAAA\nAAAAAAAAAAAA\n....\n....\n....\n....OMG....!!\n..\n..\n..\n.\n.\n\n");
    }
    
    public static void printJumpQuestion()
    {
        System.out.println("\nJump in? [y/n]\n");
    }
    
    public static void printNoJump()
    {
        System.out.println("\nYou coward! (The hatch is closed again..)\n");
    }
}
