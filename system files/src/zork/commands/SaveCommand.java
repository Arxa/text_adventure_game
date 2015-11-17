/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.commands;

import zork.other.Output;
import zork.other.Save;
import zork.interfaces.IOneWords;
import zork.interfaces.IWords;

/**
 *
 * @author arxa
 */
public class SaveCommand implements IOneWords
{
    public SaveCommand(IWords w) 
    {
        w.addWord(getStringCommand());
    }
    
    @Override
    public void doCommand()
    {
        Save.clearSaveFile();
        Save.saveGame();
        Output.printGameSaved();
    }
    @Override
    public String getStringCommand()
    {
        return "save";
    }
}
