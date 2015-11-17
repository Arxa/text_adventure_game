/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.commands;

import zork.interfaces.IOneWords;
import zork.interfaces.IWords;
import java.util.ArrayList;
import java.util.List;
import zork.other.Output;

/**
 *
 * @author Arxa
 */
public class HelpCommand implements IOneWords
{
    private static List<String> helpArray = new ArrayList<>();
    
    public HelpCommand(IWords w) 
    {
        w.addWord(getStringCommand());
    }
    
    @Override
    public void doCommand()
    {
        Output.printHelp();
    }
    @Override
    public String getStringCommand()
    {
        return "help";
    }
    
    public static List<String> getHelpArray() 
    {
        return helpArray;
    }
}
