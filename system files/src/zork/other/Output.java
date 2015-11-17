/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import zork.commands.HelpCommand;
import zork.interfaces.ITakable;



/**
 *
 * @author Arxa
 */
public class Output 
{
    public static void delayGame(int t)
    {
        try 
        {
            Thread.sleep(t);
        }      
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void printGameWon()
    {
        System.out.println("\nYou won the Game !!\nCongrats !!\n\nFor winning my game, I am inviting you and your friends to my awesome Party !!\n");
    }
    
    public static void printTunnelLight()
    {
        System.out.println("North of the tunnel, you can see a weak light...");
    }
    
    public static void printRevealGoldDoor()
    {
        System.out.println("\nNow that you have killed the Werewolf, you can see a golden Door \nand a digital Box in the room.\nThe Werewolf was guarding this Door?\n");
    }
    
    public static void printPreDrinkMessage()
    {
        System.out.println("\nYou have to open it first!\n");
    }
    
    public static void printHint1()
    {
        System.out.println("\nHINT: Examining the items could be very helpful\n");
    }
    
    public static void printHint2()
    {
        System.out.println("\nHINT: To exit a room go to the opposite way you went\n");
    }
    
    public static void gameOver()
    {
        delayGame(7000);
        System.out.println("\n\t\tGAME OVER\t\t\n");
        Save.clearTempFile();
        delayGame(1000);
        System.out.println("It's ok that you lost, really..\nTo comfort you, I am inviting you to my Party!\n");
        delayGame(5000);
        System.exit(0);
    }
    
    public static void printAllBagItems()
    {
        System.out.println("\n\t\tBAG ITEMS\t\t\n");
        printGold();
        printBag();
    }
    
    public static void printGold()
    {
        System.out.printf("Gold Coins: %d\n",Inventory.getGoldAmount());
    }
    
    public static void printBag()
    {
        for (ITakable p : Inventory.getBag())
        {
            System.out.println(" - "+p.getBagStringItem());
        }
    }
    
    public static void printNoSave()
    {
        System.out.println("\nSorry, a saved checkpoint couldn't be found.\nA new game mode has been launched.\n");
    }
    
    public static void printWelcomeMessage()
    {
        System.out.println("\n\n\t\tWELCOME TO MZORK\t\t\n\nAN ADVENTURE GAME DEVELOPED BY ARXA\n\nENJOY AND HAVE FUN :)\n\n");
        printHelpHint();
        printHint1();
    }
    
    public static void printSaveQuestion()
    {
        System.out.println("\n\nPress 1 to load from your last checkpoint");
        System.out.println("Press 0 to start a new game");
    }
    
    public static void printWrongSyntax()
    {
        System.out.println("\nSYNTAX ERROR: [ Check your syntax and your Available Commands (>help) ]\n");
    }
    
    public static void printWriteProperEnglish()
    {
        System.out.println("\nPlease write some proper English to understand..\n");
    }
    
    public static void printHelpHint()
    {
        System.out.printf("\nMISSION: Find your friends!\n\nHey! Remember that you can type 'help' whenever needed to check your commands!\n\n");
        Initialization.currentRoom.printDescription();
    }
    
    public static void printHelp()
    {
        System.out.println("\nAVAILABLE COMMANDS\n");
        for (String p : HelpCommand.getHelpArray())
            System.out.println(p);
    }
    
    public static void printCantDo()
    {
        System.out.println("\nYou can't do that!\n");
    }
    
    public static void printDoneAlready()
    {
        System.out.println("\nYou have already done that.\n");
    }
    
    public static void printNoItem()
    {
        System.out.println("\nThere is no such thing around you.\n");
    }
    
    public static void printNoExit()
    {
        System.out.println("\nCan't go that way.\n");
    }
    
    public static void printPromt()
    {
        System.out.printf("\n> ");
    }
    
    public static void printGameSaved()
    {
        System.out.printf("\nGame saved.\n");
    }
}
