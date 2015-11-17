/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import java.io.File;
import java.util.Scanner;


/**
 *
 * @author arxa
 */
public class FirstSaveCommand 
{
    private static boolean saveExists;
    private static String saveAnswer;
    private static Scanner s = new Scanner(System.in);

    // At the beggining of game, asks user to load  game or not, and gets an answer
    public static void doProcessing()
    {
        checkSaveExists();
        Output.printSaveQuestion();
        getSaveCommand();
        if (getSaveAnswer().equals("1"))
        {
            if (getSaveExists()==true)
            {
                Load.loadGame();
            }
            else
            {
                Output.printNoSave();
                Output.printWelcomeMessage();
            }
        }
        else if (getSaveAnswer().equals("0"))
        {
            Save.clearSaveFile();
            Save.clearTempFile();
            Output.printWelcomeMessage();
        }
    }
    
    public static void getSaveCommand()
    {
        do
        {
            setSaveAnswer(s.nextLine());
        }while( (getSaveAnswer().equals("1") || getSaveAnswer().equals("0")) == false );
    }
    
    public static void checkSaveExists()
    {
        
        File file = new File("SaveLog.txt");

        if (file.length() == 0) 
        {
            setSaveExists(false);
        } 
        else 
        {
            setSaveExists(true);
        }
        
    }    
    
    public static boolean getSaveExists() 
    {
        return saveExists;
    }

    public static void setSaveExists(boolean saveExists) 
    {
        FirstSaveCommand.saveExists = saveExists;
    }
    
    public static String getSaveAnswer() 
    {
        return saveAnswer;
    }
    
    public static void setSaveAnswer(String saveAnswer) 
    {
        FirstSaveCommand.saveAnswer = saveAnswer;
    }
}  
    

