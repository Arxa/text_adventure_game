/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import zork.interfaces.IOneWords;
import zork.interfaces.IVerbsWithNoun;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Arxa
 */
public class ApplyCommands 
{
    private static boolean specialWord;
    private static String firstCommand,secondCommand;
    private static int i;
    private static final List<IVerbsWithNoun> verbsWithNoun = Arrays.asList(GameObjects.move,GameObjects.go,GameObjects.open,
    GameObjects.take,GameObjects.examine,GameObjects.drink,GameObjects.read,GameObjects.kill,GameObjects.unlock);
    private static List<IOneWords> oneWords = Arrays.asList(GameObjects.help,GameObjects.exit,GameObjects.look,GameObjects.save,GameObjects.bag);
    
    // STAGE 3: Applies the suitable actions based on the tokenized command received
    public static void applyCommands(String[] command)
    {
        specialWord=true;
        i=1;
        outerloop:
        while (i<=command.length)
        {
            firstCommand=command[0];
            
            for (IVerbsWithNoun p : verbsWithNoun)
            {
                if (firstCommand.equalsIgnoreCase(p.getStringCommand()))
                {
                    specialWord=false;
                    secondCommand=command[1];
                    Save.saveCommand(firstCommand+" "+secondCommand);
                    p.doCommand();
                    break outerloop;
                }      
            }
            
            for (IOneWords p : oneWords)
            {
                if (firstCommand.equalsIgnoreCase(p.getStringCommand()))
                {
                    specialWord=false;
                    if (!firstCommand.equalsIgnoreCase("save")) Save.saveCommand(firstCommand);
                    p.doCommand();
                }                 
            }
            i++;
        }
        if (specialWord==true) Save.saveCommand(firstCommand);
    }

    
    public static String getFirstCommand() 
    {
        return firstCommand;
    }

    public static String getSecondCommand() 
    {
        return secondCommand;
    }
    
}
