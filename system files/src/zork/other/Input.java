/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import java.util.Scanner;

/**
 *
 * @author Arxa
 */
public class Input 
{
    private static String command;
    private static Scanner s = new Scanner(System.in);
    
    
    // STAGE 1: Reads the user's input
    public static String CommandReader()
    {
        Output.printPromt();
        setCommand(s.nextLine());
        return getCommand();
    }
    
    public static String getCommand() 
    {
        return command;
    }

    public static void setCommand(String command) 
    {
        Input.command = command;
    }
    
}
