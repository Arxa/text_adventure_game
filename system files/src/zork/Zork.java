/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork;

import zork.commands.QuitCommand;
import zork.other.ApplyCommands;
import zork.other.GameStatus;
import zork.other.Initialization;
import zork.other.Input;
import zork.other.Parser;

/**
 *
 * @author arxa
 */
public class Zork 
{
    private static String inputCommand;
    private static String[] parsedCommand;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Initialization.initialize();
        do 
        {
            do
            {
                inputCommand = Input.CommandReader(); //Stage 1: User input
                parsedCommand = Parser.translate(inputCommand); //Stage 2: Identify grammar
            }while(Parser.isSyntaxOk()==false);
            ApplyCommands.applyCommands(parsedCommand); // Stage 3: Apply command
            GameStatus.ProcessGame(); // Synchronize game environment
        }while (QuitCommand.isExitGame()==false);
        System.exit(0); 
    }
}
