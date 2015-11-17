/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.items;

import zork.other.Room;
import zork.interfaces.IWords;
import zork.interfaces.IExaminable;
import zork.interfaces.IMovable;

/**
 *
 * @author Arxa
 */
public class HallPainting implements IMovable,IExaminable
{
    private static boolean moveStatus;
    private static boolean examineStatus;

    public HallPainting(Room a, IWords w) 
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
        return "painting";
    }
    
    @Override
    public boolean isStable()
    {
        return false;
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
        System.out.printf("\nYou moved the %s .\n",getStringItem());
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
        return "painting";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("\nIt's a peaceful scenery of some green hills with some waterfalls too.\nMaybe it's nearby to this castle... \n");
    }
    
    
    //-------------Static-----------------\\
    public static void printItemRevealed()
    {
        System.out.println("\nThere is a build-in safe in the wall!\n");
    }
    
    public static String getStringItem()
    {
        return "Painting";
    }
    
    public static boolean getExamineStatus() 
    {
        return examineStatus;
    }
    
    public static boolean getMoveStatus() 
    {
        return moveStatus;
    }
}
