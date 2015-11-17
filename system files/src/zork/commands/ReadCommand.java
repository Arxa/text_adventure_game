/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.commands;

import zork.interfaces.IReadable;
import zork.interfaces.IVerbsWithNoun;
import zork.interfaces.IWords;
import zork.other.ApplyCommands;
import zork.other.Initialization;
import zork.other.Output;

/**
 *
 * @author arxa
 */
public class ReadCommand implements IVerbsWithNoun
{
    private static boolean itemFound1,itemFound2;
    
    public ReadCommand(IWords w) 
    {
        w.addWord(getStringCommand());
    }
    
    @Override
    public void doCommand()
    {
        itemFound1 = false;
        itemFound2 = false;
        for (String x : Initialization.currentRoom.getIncludedItems()) 
        {
            if (x.toLowerCase().contains(ApplyCommands.getSecondCommand().toLowerCase())) 
            {
                itemFound1=true;
                for (IReadable p : Initialization.getReadableItems())
                {
                    if ( p.getReadableStringItem().toLowerCase().contains(ApplyCommands.getSecondCommand().toLowerCase()) )
                    {
                        itemFound2 = true;
                        p.setReadStatus(true);
                        p.printReadOk();  
                    }
                }
                if (itemFound2==false) Output.printCantDo();   
            } 
        }
        if (itemFound1==false) Output.printNoItem();
    }     

    @Override
    public String getStringCommand()
    {
        return "read";
    }
    
    
}
