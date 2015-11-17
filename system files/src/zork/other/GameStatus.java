/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import zork.commands.QuitCommand;
import zork.grammar.Nouns;
import zork.grammar.OneVerbs;
import zork.items.BedroomDesk;
import zork.items.BedroomKey;
import zork.items.BedroomNote;
import zork.items.BedroomPillow;
import zork.items.HallPainting;
import zork.items.MatHatch;
import zork.items.CastleMat;
import zork.items.HallSafe;
import zork.items.HallSafePaper;
import zork.items.KitchenBottle;
import zork.items.KitchenChest;
import zork.items.KitchenMachete;
import zork.items.LibraryBox;
import zork.items.LibraryCrossbow;
import zork.items.LibraryDoor;
import zork.items.LibraryWerewolf;
import zork.items.TunnelCavetroll;
import static zork.other.Initialization.castleHall;
import static zork.other.Initialization.castleLibrary;
import static zork.other.Initialization.castleTunnel;
import static zork.other.Initialization.waterfalls;



/**
 *
 * @author Arxa
 */
public class GameStatus 
{
    private static int matVar=0,portraitVar=0,safeVar=0,hatchVar=0,macheteVar=0,noteVar=0,pillowkeyVar=0,werewolfVar=0,
            deadwolfVar=0,wolfVar=0,trollVar=0,lightVar=0;
    private static boolean hatchAnswer;
    private static boolean drinkOk;
    
    public static void ProcessGame()
    {
        if (Initialization.currentRoom==Initialization.outsideCastle)
        {
            if (CastleMat.getMoveStatus()==true)
            {
                
                if (matVar==0)
                {
                    Initialization.outsideCastle.getIncludedItems().add(MatHatch.getStringItem());
                    CastleMat.printItemRevealed();
                    matVar=1;
                }
                if (MatHatch.getOpenStatus()==true)
                {
                    if (hatchVar==0)
                    {
                        MatHatch.printJumpQuestion();
                        hatchVar=1;
                        hatchAnswer = true;
                        OneVerbs.getOneVerbs().add("y");
                        OneVerbs.getOneVerbs().add("n");
                    }
                    else 
                    {
                        
                        if (ApplyCommands.getFirstCommand().toLowerCase().equalsIgnoreCase("y"))
                        {
                            OneVerbs.getOneVerbs().remove("y");
                            OneVerbs.getOneVerbs().remove("n");
                            hatchAnswer = false;
                            hatchVar=0;
                            MatHatch.printJumpTravel();
                            Initialization.outsideCastle.setStages(Initialization.castleHall, null, null, null);
                            CheckStages.checkHall("north");
                            Output.printHint2();
                        }
                        else if (ApplyCommands.getFirstCommand().toLowerCase().equalsIgnoreCase("n"))
                        {
                            OneVerbs.getOneVerbs().remove("y");
                            OneVerbs.getOneVerbs().remove("n");
                            hatchAnswer = false;
                            hatchVar=0;
                            MatHatch.printNoJump();
                            MatHatch.setOpenedStatus(false);
                        }
                        else MatHatch.printGiveRightAnswer();
                    }
                 
                }
            }
            
        }
        
        if (Initialization.currentRoom==Initialization.castleHall)
        {
            Initialization.currentRoom.setDescription("\nYou are walking across the Castle's Hall.\n" +
            "You can see a Painting on the wall.\n");
            if (HallPainting.getMoveStatus()==true)
            {
                if (portraitVar==0)
                {
                    Initialization.castleHall.getIncludedItems().add(HallSafe.getStringItem());
                    HallPainting.printItemRevealed();
                    portraitVar=1;
                }
                
                if (HallSafe.getOpenStatus()==true)
                {
                    if (safeVar==0)
                    {
                        Nouns.getNouns().add("coins");
                        HallSafe.safeOpened();
                        Initialization.castleHall.getIncludedItems().add(HallSafePaper.getStringItem());
                        safeVar=1;
                    }
                    
                }
            }
        }
        
        if (Initialization.currentRoom==Initialization.castleKitchen)
        {
            
            if (KitchenChest.getOpenStatus()==true)
            {
                if (macheteVar==0)
                {
                    Initialization.currentRoom.getIncludedItems().add(KitchenMachete.getStringItem());
                    KitchenChest.printItemRevealed();
                    macheteVar=1;
                }
            }
        }
        
        if (Initialization.currentRoom==Initialization.castleBedroom)
        {
            if (BedroomDesk.getExamineStatus()==true)
            {
                if (noteVar==0)
                {
                    Initialization.currentRoom.getIncludedItems().add(BedroomNote.getStringItem());
                    noteVar=1;
                }
            }
            if (BedroomPillow.getMoveStatus()==true)
            {
                if (pillowkeyVar==0)
                {
                    Initialization.currentRoom.getIncludedItems().add(BedroomKey.getStringItem());
                    BedroomPillow.printItemRevealed();
                    pillowkeyVar=1;
                }
            }
        }
        
        if (Initialization.currentRoom==Initialization.castleLibrary)
        {
            {
                if (LibraryWerewolf.getKillStatus()==false && wolfVar==1 && QuitCommand.isExitGame()==false)
                {
                    LibraryWerewolf.printMosterStillHere();
                }
                
                if(LibraryWerewolf.getKillStatus()==false && LibraryWerewolf.getEngage()==false && wolfVar==0)
                {
                    LibraryWerewolf.printMonsterIntro(); 
                    wolfVar=1;
                }
                
                
                if (deadwolfVar==0)
                {
                    if (LibraryWerewolf.getKillStatus()==true)
                    {
                        Output.printRevealGoldDoor();
                        Initialization.currentRoom.getIncludedItems().add(LibraryDoor.getStringItem());
                        Initialization.currentRoom.getIncludedItems().add(LibraryBox.getStringItem());
                        Initialization.currentRoom.setDescription("You are in the Castle's Library.\nThere is only a golden Door and digital Box here.\n");
                        deadwolfVar=1;
                        if (LibraryBox.getOpenStatus())
                        {
                            Initialization.currentRoom.getIncludedItems().add(LibraryCrossbow.getStringItem());
                        }
                    }
                }
                if (LibraryDoor.getOpenStatus())
                {
                    Initialization.castleLibrary.setStages(castleTunnel,castleHall,null,null);
                }
                if (LibraryBox.getOpenStatus())
                {
                    Initialization.currentRoom.getIncludedItems().add(LibraryCrossbow.getStringItem());
                }   
            }
        }
        
        if (Initialization.currentRoom==Initialization.castleTunnel)
        {
            if (TunnelCavetroll.getKillStatus()==false && trollVar==1 && QuitCommand.isExitGame()==false)
            {
                TunnelCavetroll.printMosterStillHere();
            }
            
            if(TunnelCavetroll.getKillStatus()==false && TunnelCavetroll.getEngage()==false && trollVar==0)
            {
                TunnelCavetroll.printMonsterIntro();
                trollVar=1;
            }
            
            if (TunnelCavetroll.getKillStatus())
            {
                Initialization.castleTunnel.setStages(waterfalls,null,castleLibrary,null);
                if (lightVar==0)
                {
                    Output.printTunnelLight();
                    lightVar=1;
                }
                Initialization.castleTunnel.setDescription("\nYou are walking in a dark secret Tunnel...\nNorth of the tunnel, you can see a weak light...\n");
            }
        }
        
        if (Initialization.currentRoom==Initialization.waterfalls)
        {
            Output.delayGame(14000);
            Output.printGameWon();
            Output.delayGame(10000);
            Save.clearTempFile();
            System.exit(0);
        }
    }
    
    public static boolean canDrinkIt()
    {
        boolean canDrink=false;
        if (KitchenBottle.getOpenStatus())
        {
            canDrink=true;  
        }
        return canDrink; 
    }

    public static boolean getHatchAnswer() 
    {
        return hatchAnswer;
    }
    
}
