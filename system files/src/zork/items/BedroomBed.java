/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.items;

import zork.interfaces.IExaminable;
import zork.interfaces.IMovable;
import zork.interfaces.IWords;
import zork.other.Room;

/**
 *
 * @author arxa
 */
public class BedroomBed implements IMovable, IExaminable
{
    private static boolean examineStatus;
    private static boolean moveStatus;

    public BedroomBed(Room a, IWords w) 
    {
        moveStatus = false;
        examineStatus = false;
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
        return "bed";
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
        System.out.println("\nIt's too heavy.\n");
    }
    
    @Override
    public void printMoveOk()
    {
        System.out.printf("\nYou moved the %s.\n",getStringItem());
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
        return "bed";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("\nThere is a pillow on the bed.\n");
    }
    
    
    //-------------Static-----------------\\
    public static boolean getExamineStatus() 
    {
        return examineStatus;
    }

    public static boolean getMoveStatus() 
    {
        return moveStatus;
    }
    
    public static String getStringItem()
    {
        return "Bed";
    }
    
}
