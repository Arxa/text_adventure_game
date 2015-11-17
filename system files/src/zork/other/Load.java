/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arxa
 */
public class Load 
{
    private static List<String> savedCommands = new ArrayList<>();
    private static String inputCommand;
    private static String[] parsedCommand;
    private static String applyCommand;
    
    
    // Loads game from last checkpoint
    public static void loadGame()
    {
        
        try 
        {
            FileReader reader = new FileReader("SaveLog.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                savedCommands.add(line);
            }
            reader.close();
 
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        for (String x : savedCommands)
        {
            
                inputCommand = x;
                parsedCommand = Parser.translate(inputCommand);
                ApplyCommands.applyCommands(parsedCommand);
                GameStatus.ProcessGame();
        }
    }
}
