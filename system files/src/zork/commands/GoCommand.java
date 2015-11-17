/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.commands;

import zork.interfaces.IWords;
import zork.interfaces.IVerbsWithNoun;
import zork.other.ApplyCommands;
import zork.other.CheckStages;

/**
 *
 * @author Arxa
 */
public class GoCommand implements IVerbsWithNoun
{
    public GoCommand(IWords w)
    {
        w.addWord(getStringCommand());
    }
    
    @Override
    public void doCommand()
    {
        CheckStages.checkHall(ApplyCommands.getSecondCommand()); 
    }
    
    @Override
    public String getStringCommand()
    {
        return "go";
    }
}
