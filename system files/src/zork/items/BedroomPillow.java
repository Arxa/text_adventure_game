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
public class BedroomPillow implements IMovable, IExaminable
{
    private static boolean examineStatus;
    private static boolean moveStatus;
    private static boolean takenStatus;

    

    public BedroomPillow(Room a, IWords w) 
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
        return "pillow";
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
        return getExamineStatus();
    }
    @Override
    public String getExaminableStringItem()
    {
        return "pillow";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("\nHmmm..\n");
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
        return "Pillow";
    }
    
    public static boolean getTakenStatus() 
    {
        return takenStatus;
    }
    
    public static String specialInfo()
    {
        return "a Pillow";
    }
    
    public static void printItemRevealed()
    {
        System.out.println("\nThere is a silver Key under the pillow!\n");
    }
    
}
