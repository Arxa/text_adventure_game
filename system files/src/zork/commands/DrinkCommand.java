/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.commands;

import zork.other.ApplyCommands;
import zork.other.Initialization;
import zork.other.Output;
import zork.interfaces.IWords;
import zork.interfaces.IVerbsWithNoun;
import zork.interfaces.IDrinkable;
import zork.other.GameStatus;

/**
 *
 * @author Arxa
 */
public class DrinkCommand implements IVerbsWithNoun
{
    

    
    private static boolean itemFound1,itemFound2;
    
    public DrinkCommand(IWords w) 
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
                for (IDrinkable p : Initialization.getDrinkableItems())
                {
                    if ( p.getDrinkableStringItem().toLowerCase().contains(ApplyCommands.getSecondCommand().toLowerCase()) )
                    {
                        itemFound2 = true;
                        if (p.isDrunk()==false)
                        {
                            if (GameStatus.canDrinkIt()==true)
                            {
                                p.setDrinkStatus(true);
                                p.printDrinkOk();
                            }
                            else
                            {
                                Output.printPreDrinkMessage();   
                            }
                        }
                        else Output.printDoneAlready();
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
        return "drink";
    }
    
    
}


