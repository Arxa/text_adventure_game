/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author arxa
 */
public class Save 
{
    private static boolean saveStatus;
    
    //Saves a command temporarily (Every command)
    public static void saveCommand(String command)
    {
        try 
        {
            FileWriter writer = new FileWriter("TempSaving.txt", true);
            
            writer.write(command+"\r\n");
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
    }
    
    //Copies temporarily saved commands to pernament saved commands.(Saving Game)
    public static void saveGame()
    {
        InputStream inStream = null;
    	OutputStream outStream = null;
    	try
        {
    	    File file1 =new File("TempSaving.txt");
    	    File file2 =new File("SaveLog.txt");
    	    inStream = new FileInputStream(file1);
    	    outStream = new FileOutputStream(file2); 
    	    byte[] buffer = new byte[1024];
    	    int length;
    	    while ((length = inStream.read(buffer)) > 0)
            {
    	    	outStream.write(buffer, 0, length);
    	    }
 
    	    if (inStream != null) inStream.close();
    	    if (outStream != null) outStream.close();
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
    	}
    }
    
    // Clears all the temporarily saved commands.If user quits or something.
    public static void clearTempFile()
    {
        try 
        {
            FileWriter writer = new FileWriter("TempSaving.txt", false);
            writer.write("");
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    
    // Clears all permanently saved commands. Occurs when user saves game
    public static void clearSaveFile()
    {
        try 
        {
            FileWriter writer = new FileWriter("SaveLog.txt", false);
            writer.write("");
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
}
