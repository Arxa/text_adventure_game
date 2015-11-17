/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import zork.commands.BagCommand;
import zork.grammar.Nouns;
import zork.grammar.VerbsWithNoun;
import zork.grammar.OneVerbs;
import zork.directions.SouthDirection;
import zork.directions.WestDirection;
import zork.directions.NorthDirection;
import zork.directions.EastDirection;
import zork.items.KitchenChest;
import zork.items.KitchenTable;
import zork.items.HallPainting;
import zork.items.MatHatch;
import zork.items.CastleMat;
import zork.items.HallSafe;
import zork.items.KitchenMachete;
import zork.items.CastleDoor;
import zork.items.KitchenBottle;
import zork.commands.ExamineCommand;
import zork.commands.DrinkCommand;
import zork.commands.SaveCommand;
import zork.commands.HelpCommand;
import zork.commands.LookCommand;
import zork.commands.QuitCommand;
import zork.commands.GoCommand;
import zork.commands.KillCommand;
import zork.commands.MoveCommand;
import zork.commands.OpenCommand;
import zork.commands.ReadCommand;
import zork.commands.TakeCommand;
import zork.commands.UnlockCommand;
import zork.items.BedroomBed;
import zork.items.BedroomDesk;
import zork.items.BedroomKey;
import zork.items.BedroomNote;
import zork.items.BedroomPillow;
import zork.items.HallSafePaper;
import zork.items.LibraryBox;
import zork.items.LibraryCrossbow;
import zork.items.LibraryDoor;
import zork.items.LibraryWerewolf;
import zork.items.StarterKatana;
import zork.items.TunnelCavetroll;

/**
 *
 * @author Arxa
 */
public class GameObjects 
{
    public static OneVerbs oneVerb = new OneVerbs(); 
    public static VerbsWithNoun verbsWithNoun = new VerbsWithNoun(); 
    public static Nouns noun = new Nouns();
    
    // ONEWORD COMMANDS
    public static QuitCommand exit = new QuitCommand(oneVerb);
    public static LookCommand look = new LookCommand(oneVerb);
    public static HelpCommand help = new HelpCommand(oneVerb);
    public static SaveCommand save = new SaveCommand(oneVerb);
    public static BagCommand bag = new BagCommand(oneVerb);
    // VERB COMMANDS
    public static MoveCommand move = new MoveCommand(verbsWithNoun);
    public static GoCommand go = new GoCommand(verbsWithNoun);
    public static OpenCommand open = new OpenCommand(verbsWithNoun);
    public static TakeCommand take = new TakeCommand(verbsWithNoun);
    public static ExamineCommand examine = new ExamineCommand(verbsWithNoun);
    public static DrinkCommand drink = new DrinkCommand(verbsWithNoun);
    public static ReadCommand read = new ReadCommand(verbsWithNoun);
    public static KillCommand kill = new KillCommand(verbsWithNoun);
    public static UnlockCommand unlock = new UnlockCommand(verbsWithNoun);
    // OUTSIDECASTLE ITEMS  
    public static CastleDoor castleDoor = new CastleDoor(Initialization.outsideCastle,noun);
    public static CastleMat castleMat = new CastleMat(Initialization.outsideCastle,noun);
    public static MatHatch matHatch = new MatHatch(noun);
    // CASTLEHALL ITEMS
    public static HallPainting hallPainting = new HallPainting(Initialization.castleHall,noun);
    public static HallSafe hallSafe = new HallSafe(noun);
    public static HallSafePaper hallSafePaper = new HallSafePaper(noun);
    // CASTLEKITCHEN ITEMS
    public static KitchenTable kitchenTable = new KitchenTable(Initialization.castleKitchen,noun);
    public static KitchenBottle kitchenBottle = new KitchenBottle(Initialization.castleKitchen,noun);
    public static KitchenChest kitchenChest = new KitchenChest(Initialization.castleKitchen,noun);
    public static KitchenMachete kitchenMachete = new KitchenMachete(noun);
            
    // CASTLEBEDROOM ITEMS
    public static BedroomBed bedroomBed = new BedroomBed(Initialization.castleBedroom,noun);
    public static BedroomPillow bedroomPillow = new BedroomPillow(Initialization.castleBedroom,noun);
    public static BedroomKey bedroomKey = new BedroomKey(noun);
    public static BedroomDesk bedroomDesk = new BedroomDesk(Initialization.castleBedroom,noun);
    public static BedroomNote bedroomNote = new BedroomNote(noun);
    // CASTLELIBRARY ITEMS
    public static LibraryWerewolf libraryWerewolf = new LibraryWerewolf(Initialization.castleLibrary,noun);
    public static LibraryDoor libraryDoor  = new LibraryDoor(noun);
    public static LibraryBox libraryBox  = new LibraryBox(noun);
    public static LibraryCrossbow libraryCrossbow  = new LibraryCrossbow(noun);
    // CASTLETUNNEL ITEMS
    public static TunnelCavetroll tunnelCavetroll  = new TunnelCavetroll(Initialization.castleTunnel,noun);
    
    // STARTER ITEMS
    public static StarterKatana katana = new StarterKatana();
    // DIRECTIONS
    public static NorthDirection northDirection = new NorthDirection(noun);
    public static EastDirection eastDirection = new EastDirection(noun);
    public static SouthDirection southDirection = new SouthDirection(noun);
    public static WestDirection westDirection = new WestDirection(noun);
    
}
