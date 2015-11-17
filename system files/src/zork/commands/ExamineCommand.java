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
import zork.interfaces.IExaminable;
import zork.interfaces.IVerbsWithNoun;
/**
 *
 * @author Arxa
 */
public class ExamineCommand implements IVerbsWithNoun
{
    private static boolean itemFound1,itemFound2;
    
    public ExamineCommand(IWords w) 
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
                for (IExaminable p : Initialization.getExaminableItems())
                {
                    if ( p.getExaminableStringItem().toLowerCase().contains(ApplyCommands.getSecondCommand().toLowerCase()) )
                    {
                        itemFound2 = true;
                            
                            
                            p.setExamineStatus(true);
                            p.printExamination();     
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
        return "examine";
    }
}
