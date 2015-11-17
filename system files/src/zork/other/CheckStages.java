/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import java.util.Arrays;
import java.util.List;
import zork.interfaces.IDirections;

/**
 *
 * @author arxa
 */
public class CheckStages 
{
    private static List<IDirections> directions = Arrays.asList(GameObjects.northDirection,GameObjects.eastDirection,GameObjects.southDirection,GameObjects.westDirection);
    private static boolean printD = true;

    // Checks the direction given and changes Room if possible
    public static void checkHall(String secondCommand)
    {
        boolean found=false;
        for (IDirections p : getDirections())
        {
            if (secondCommand.equalsIgnoreCase(p.getStringItem()))
            {
                found=true;
                p.checkDirections();
            }
        }
        if (found==false) 
        {
            setPrintD(false);
        }
                             
        if (getPrintD() == true) Initialization.currentRoom.printDescription();     
    }   
    
    
    public static List<IDirections> getDirections() 
    {
        return directions;
    }

    public static boolean getPrintD() 
    {
        return printD;
    }

    public static void setPrintD(boolean printD) 
    {
        CheckStages.printD = printD;
    }
}
