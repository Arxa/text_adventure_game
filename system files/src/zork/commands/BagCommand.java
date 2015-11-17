/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.commands;

import zork.interfaces.IOneWords;
import zork.interfaces.IWords;
import zork.other.Output;

/**
 *
 * @author arxa
 */
public class BagCommand implements IOneWords
{
    public BagCommand(IWords w) 
    {
        w.addWord(getStringCommand());
    }
    
    @Override
    public void doCommand()
    {
        Output.printAllBagItems();
    }
    
    @Override
    public String getStringCommand()
    {
        return "bag";
    }
    
}
