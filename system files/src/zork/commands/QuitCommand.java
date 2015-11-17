/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.commands;

import java.util.Scanner;
import zork.other.Save;
import zork.interfaces.IOneWords;
import zork.interfaces.IWords;

/**
 *
 * @author Arxa
 */
public class QuitCommand implements IOneWords
{
    private static Scanner s = new Scanner(System.in);
    private static boolean exitGame=false;
    private static String answer;
    
    public QuitCommand(IWords w) 
    {
        w.addWord(getStringCommand());
    }
    
    @Override
    public void doCommand()
    {
        Save.clearTempFile();
        if (quitQuestion())
        {
            printParty();
            setExitGame(true);
        }
    }

    @Override
    public String getStringCommand()
    {
        return "quit";
    }
    
    
    public static void setExitGame(boolean exitGame) 
    {
        QuitCommand.exitGame = exitGame;
    }

    public static boolean isExitGame() 
    {
        return exitGame;
    }
    
    public static boolean quitQuestion()
    {
        boolean quit;
        System.out.println("Quit game? [y/n]");
        do
        {
            answer = s.nextLine();
        }while( (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")) ==false);
        if (answer.equalsIgnoreCase("y"))
        {
            quit=true;
        }
        else 
        {
            quit=false;
        }
        return quit;
    }
    
    public void printParty()
    {
        System.out.println("\nWhy you quited?\nYou got bored or something?\nIf that's the case, you should come to my party!\n\n");
    }
}
