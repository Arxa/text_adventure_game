/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.commands;

import zork.interfaces.IKillable;
import zork.interfaces.IVerbsWithNoun;
import zork.interfaces.IWords;
import zork.other.ApplyCommands;
import zork.other.Initialization;
import zork.other.MonsterFight;
import zork.other.Output;

/**
 *
 * @author arxa
 */
public class KillCommand implements IVerbsWithNoun
{
    private static boolean itemFound1,itemFound2;
    private boolean deathResult;
    
    public KillCommand(IWords w) 
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
                for (IKillable p : Initialization.getKillableItems())
                {
                    if ( p.getKillableStringItem().toLowerCase().contains(ApplyCommands.getSecondCommand().toLowerCase()) )
                    {
                        itemFound2 = true;
                        if (p.isKilled()) { Output.printDoneAlready(); break;}
                        deathResult = MonsterFight.fightMonster(p);
                        p.setEngage(true);
                        if (deathResult)
                        {
                            p.printDeathMessage();
                            p.setEngage(true);
                            Output.gameOver();
                        }
                        else
                        {
                            Initialization.currentRoom.getIncludedItems().remove(p);
                            p.setKillStatus(true);
                            p.setEngage(true);
                        } 
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
        return "kill";
    }
}
    

