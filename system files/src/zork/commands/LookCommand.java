/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.commands;

import zork.other.Initialization;
import zork.interfaces.IOneWords;
import zork.interfaces.IWords;

/**
 *
 * @author Arxa
 */
public class LookCommand implements IOneWords
{
    public LookCommand(IWords w) 
    {
        w.addWord(getStringCommand());
    }
    
    @Override
    public void doCommand()
    {
        Initialization.currentRoom.printDescription();
    }
    
    @Override
    public String getStringCommand()
    {
        return "look";
    }
}
