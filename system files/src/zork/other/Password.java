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
public class Password 
{
    private static Scanner s = new Scanner(System.in);
    private static String input;
    private static boolean status=false;
    
    public static boolean checkPassword(String pass)
    {
        input = s.nextLine();
        
        if (input.equals(pass))
        {
            System.out.println("\n\nPassword Correct");
            status = true;
        }
        else
        {
            System.out.println("\n\nWrong Password!");
            status = false;
        }
        return status;
    }
}
