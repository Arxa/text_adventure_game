/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import zork.commands.HelpCommand;
import zork.interfaces.IOpenable;
import zork.interfaces.ITakable;
import zork.interfaces.IExaminable;
import zork.interfaces.IMovable;
import zork.interfaces.IDrinkable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import zork.interfaces.IKillable;
import zork.interfaces.IReadable;
import zork.interfaces.IUnlockable;


/**
 *
 * @author Arxa
 */
public class Initialization 
{
    private static List<Room> rooms = new ArrayList<>();
    
    //Creating Rooms
    public static Room outsideCastle = new Room(InsertDescriptions.readDescriptions()[0]);
    public static Room castleHall = new Room(InsertDescriptions.readDescriptions()[1]);
    public static Room castleKitchen = new Room(InsertDescriptions.readDescriptions()[2]);
    public static Room castleLibrary = new Room(InsertDescriptions.readDescriptions()[3]);
    public static Room castleBedroom = new Room(InsertDescriptions.readDescriptions()[4]);
    public static Room castleTunnel = new Room(InsertDescriptions.readDescriptions()[5]);
    public static Room waterfalls = new Room(InsertDescriptions.readDescriptions()[6]);
    public static Room currentRoom = new Room();
    
    private static List<IOpenable> openableItems = Arrays.asList(GameObjects.castleDoor,GameObjects.matHatch,GameObjects.hallSafe,
            GameObjects.kitchenChest,GameObjects.kitchenBottle,GameObjects.libraryDoor,GameObjects.libraryBox);
    private static List<ITakable> takableItems = Arrays.asList(GameObjects.kitchenMachete,GameObjects.bedroomKey,
            GameObjects.libraryCrossbow);
    private static List<IMovable> movableItems = Arrays.asList(GameObjects.castleMat,GameObjects.hallPainting,GameObjects.kitchenTable,
            GameObjects.bedroomPillow,GameObjects.bedroomDesk,GameObjects.bedroomBed,GameObjects.kitchenChest,
            GameObjects.libraryBox);
    private static List<IExaminable> examinableItems = Arrays.asList(GameObjects.castleDoor,GameObjects.castleMat,GameObjects.matHatch,
            GameObjects.hallPainting,GameObjects.hallSafe,GameObjects.hallSafePaper,
            GameObjects.kitchenTable,GameObjects.kitchenChest,GameObjects.kitchenMachete,GameObjects.kitchenBottle,GameObjects.bedroomDesk,
            GameObjects.bedroomBed,GameObjects.bedroomNote,GameObjects.bedroomKey,GameObjects.bedroomPillow,GameObjects.libraryDoor,
            GameObjects.libraryBox,GameObjects.libraryCrossbow);
    private static List<IDrinkable> drinkableItems = Arrays.asList(GameObjects.kitchenBottle);
    private static List<IReadable> readableItems = Arrays.asList(GameObjects.bedroomNote,GameObjects.hallSafePaper);
    private static List<IKillable> killableItems = Arrays.asList(GameObjects.libraryWerewolf,GameObjects.tunnelCavetroll);
    private static List<IUnlockable> unlockableItems = Arrays.asList(GameObjects.kitchenChest);
    private static List<ITakable> starterItems = Arrays.asList(GameObjects.katana);

    

    

    public static void initialize()
    {
        // SETTING STARTING ROOM
        currentRoom = outsideCastle;
       
        //SETTINGS ROOM EXITS
        outsideCastle.setStages(null,null,null,null);
        castleHall.setStages(castleLibrary,castleBedroom,outsideCastle,castleKitchen);
        castleLibrary.setStages(null,null,castleHall,null);
        castleKitchen.setStages(null,castleHall,null,null);
        castleBedroom.setStages(null,null,null,castleHall);
        castleTunnel.setStages(null,null,castleLibrary,null);
        waterfalls.setStages(null,null,null,null);
        
        //Importing help commands 
        HelpCommand.getHelpArray().add("1. save 'Save your game'");
        HelpCommand.getHelpArray().add("2. bag 'Check your belongings'");
        HelpCommand.getHelpArray().add("3. look 'Take a look around you'");
        HelpCommand.getHelpArray().add("4. quit 'Quit game'\n");
        HelpCommand.getHelpArray().add("5. go <north/east/south/west>");
        HelpCommand.getHelpArray().add("6. open <something>");
        HelpCommand.getHelpArray().add("7. move <something>");
        HelpCommand.getHelpArray().add("8. take <something>");
        HelpCommand.getHelpArray().add("9. examine <something>");
        HelpCommand.getHelpArray().add("10. drink <something>");
        HelpCommand.getHelpArray().add("11. unlock <something>");
        HelpCommand.getHelpArray().add("12. read <something>");
        HelpCommand.getHelpArray().add("13. kill <something>\n");
        
        
        //ADDING ROOMS
        //I think this is needless
        getRooms().add(outsideCastle);
        getRooms().add(castleHall);
        getRooms().add(castleKitchen);
        getRooms().add(castleLibrary);
        getRooms().add(castleBedroom);
        getRooms().add(castleTunnel);
        getRooms().add(waterfalls);
      
        //INITIALIZING BAG
        for(ITakable p : getStarterItems())
        {
            Inventory.getBag().add(p);
        }
        
        //GET ANSWER TO LOAD OR NOT
        FirstSaveCommand.doProcessing();
        
    }

    public static List<IReadable> getReadableItems() 
    {
        return readableItems;
    }
    

    public static List getRooms() 
    {
        return rooms;
    }
    
    public static List<IDrinkable> getDrinkableItems() 
    {
        return drinkableItems;
    }
    
    public static List<IOpenable> getOpenableItems() 
    {
        return openableItems;
    }

    public static List<ITakable> getTakableItems() 
    {
        return takableItems;
    }

    public static List<IMovable> getMovableItems() 
    {
        return movableItems;
    }

    public static List<IExaminable> getExaminableItems() 
    {
        return examinableItems;
    }
    
    public static List<IKillable> getKillableItems() 
    {
        return killableItems;
    }
    
    public static List<ITakable> getStarterItems() 
    {
        return starterItems;
    }

    public static List<IUnlockable> getUnlockableItems() 
    {
        return unlockableItems;
    }
    
}
