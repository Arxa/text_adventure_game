/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author arxa
 */
public class InsertDescriptions 
{
    private static String descriptions[];
    private static String string = "";
    private static String result = "";
        private static Scanner s = null;
    
    //Improts room descritpions from text file
    public static String[] readDescriptions()
    {
        try 
        {
            s = new Scanner(new BufferedReader(new FileReader("Descriptions.txt")));
            while (s.hasNext()) 
            {
                string = string + s.nextLine();
            }
        } 
        catch (final IOException ex) 
        {
            ex.printStackTrace();
        } 
        finally 
        {
            if (s != null) 
            {
                s.close();
            }
        }
        
        string = string.replaceAll("\\\\n",System.lineSeparator());
        descriptions = string.split("\\*");
        return descriptions;
    }
    
 
}

