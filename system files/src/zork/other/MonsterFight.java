/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import java.util.Scanner;
import zork.interfaces.IKillable;
import zork.interfaces.ITakable;

/**
 *
 * @author arxa
 */
public class MonsterFight 
{
    private static Scanner s = new Scanner(System.in);
    private static String weaponChoice;
    private static String realWeapon;
    
    //When user decides to kill a monster, he chooses his weapon.The suitability of the weapon is checked also.
    public static boolean fightMonster(IKillable m)
    {
        int input = 0;
        boolean death,validInput;
        int i=1;
        System.out.println("\n\t\tCHOOSE A WEAPON FROM YOUR BAG:\t\t\n");
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
                    weaponChoice = s.nextLine();
                    weaponChoice = weaponChoice.trim();
                    input=Integer.parseInt(weaponChoice);
                    validInput=true;
                }
                catch(NumberFormatException ex)
                { 
                    System.out.println("\nYOU HAVE TO FIGHT, CHOOSE A WEAPON");
                    validInput=false;
                }  
            }while(validInput==false);
        }while( (input>Inventory.getBag().size() || input<=0) == true || validInput == false);
        
        realWeapon = Inventory.getBag().get(input-1).getBagStringItem();
        
        if (!Inventory.getBag().get(input-1).isWeapon()) 
        {
            System.out.printf("\n%s is not a weapon.\n",Inventory.getBag().get(input-1).getBagStringItem());
            death = true;
        }
        else 
        {
            if (m.getDeathlyItems().equalsIgnoreCase(realWeapon))
            {
                m.printHowMonsterDied(realWeapon);
                death = false;
            }
            else 
            {
                m.printOnlyWeapons();
                death=true;
            }
        }
        return death;
    }
    
}
