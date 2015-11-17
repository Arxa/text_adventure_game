/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import java.util.Scanner;
import zork.interfaces.ITakable;
import zork.interfaces.IUnlockable;
import zork.items.KitchenChest;

/**
 *
 * @author arxa
 */
public class Key 
{
    private static Scanner s = new Scanner(System.in);
    private static String realKey;
    
    //PRINTS ALL ITEMS, USER CHOOSES ITEM TO UNLOCK SOMETHING
    public static void ChooseKey(IUnlockable item)
    {
        String keyChoice;
        int i=1,input=0;
        boolean validInput,unlock;
        System.out.println("\n\t\tCHOOSE A KEY FROM YOU BAG:\t\t\n");
        for (ITakable p : Inventory.getBag())
        {
            System.out.printf("Press %d for: %s\n\n",i,p.getBagStringItem());
            i++;
        }
        do
        {
            do
            {
                try
                {
                    keyChoice = s.nextLine();
                    keyChoice = keyChoice.trim();
                    input=Integer.parseInt(keyChoice);
                    validInput=true;
                }
                catch(NumberFormatException ex)
                { 
                    System.out.println("\nChoose something...");
                    validInput=false;
                }  
            }while(validInput==false);
        }while( (input>Inventory.getBag().size() || input<=0) == true || validInput == false);
        
        realKey = Inventory.getBag().get(input-1).getBagStringItem();
        
        if (!Inventory.getBag().get(input-1).isKey()) 
        {
            System.out.printf("\n%s is not a Key\n",Inventory.getBag().get(input-1).getBagStringItem());
            unlock = false;
        }
        else 
        {
            if (rightKey(item))
            {
                KitchenChest.setLockStatus(false);
                KitchenChest.setopenStatus(true);
                item.printItemUnlocked();
            }
            else
            {
                System.out.println("\nThis is not the right key.");
            }
        }
        
    }
    
    public static boolean rightKey(IUnlockable p)
    {
        if (p.getRightKey().equalsIgnoreCase(realKey))
        {
            return true;
        }
        else return false;
    }
}
