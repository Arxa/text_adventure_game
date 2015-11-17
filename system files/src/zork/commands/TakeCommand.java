/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.commands;

import zork.other.ApplyCommands;
import zork.other.Initialization;
import zork.other.Inventory;
import zork.other.Output;
import zork.interfaces.IWords;
import zork.interfaces.ITakable;
import zork.interfaces.IVerbsWithNoun;


/**
 *
 * @author Arxa
 */
public class TakeCommand implements IVerbsWithNoun
{
    private static boolean itemFound1,itemFound2;
    
    public TakeCommand(IWords w) 
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
                for (ITakable p : Initialization.getTakableItems())
                {
                    if ( p.getTakableStringItem().toLowerCase().contains(ApplyCommands.getSecondCommand().toLowerCase()) )
                    {
                        itemFound2 = true;
                        if (p.isStucked()==false)
                        {
                            if (p.isTaken()==false)
                            {
                                p.setTakenStatus(true);
                                p.printTakenOK();
                                if (p.getTakableStringItem().equalsIgnoreCase("coins")) 
                                {
                                    Inventory.addGoldAmount(p.getCoinsAmount());
                                }
                                else Inventory.getBag().add(p);
                                
                            }
                            else Output.printDoneAlready();
                        }
                     else p.printItsStucked();
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
        return "take";
    }
    
}
