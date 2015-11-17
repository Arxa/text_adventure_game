/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.items;

import zork.interfaces.IKillable;
import zork.interfaces.IWords;
import zork.other.Room;

/**
 *
 * @author arxa
 */
public class LibraryWerewolf implements IKillable
{
    private static boolean killStatus;
    private static boolean engage;

    

    
            
    public LibraryWerewolf(Room a, IWords w) 
    {
        engage = false;
        killStatus=false;
        a.getIncludedItems().add(getStringItem());
        w.addWord(getStringItem());
    }
    
    
    //-------------IKillable-----------------\\
    @Override
    public boolean isKilled()
    {   
        return getKillStatus();
    }
    
    @Override
    public void setKillStatus(boolean s)
    {
        killStatus = s;
    }
    
    
    @Override
    public String getKillableStringItem()
    {
        return "Werewolf";
    }
    
    
    @Override
    public void printDeathMessage()
    {
        System.out.println("\nThe Werewolf has bitten you everywhere..\nYou are bleading badly..\nYou DIED horribly!\n");
    }
    
    @Override
    public String getDeathlyItems()
    {
        return "silver machete";
    }
    
    @Override
    public void setEngage(boolean s)
    {
        engage = s;
    }
    
    @Override
    public void printOnlyWeapons()
    {
        System.out.println("\n\nOnly Silver can kill Werewolfs!");
    }
    
    @Override
    public void printHowMonsterDied(String weapon)
    {
        System.out.printf("\nYou slaughtered the WereWolf with your %s !\nYou are the boss!\n",weapon);
    }
    
    
    //-------------Static-----------------\\
    public static boolean getKillStatus() 
    {
        return killStatus;
    }
    
    public static String getStringItem()
    {
        return "Werewolf";
    }
    
    public static void printMonsterIntro()
    {
        System.out.println("\nOh shit, there is a WereWolf in this Library !!! \nA Werewolf lives in this castle??...\nOh He saw me....\n"
        + "oh my god...\nhe is coming at me!!!\n");
    }
    
    public static boolean getEngage() 
    {
        return engage;
    }
    
    public static void printMosterStillHere()
    {
        System.out.printf("The %s is still here!\nHe is coming close to me!\n",getStringItem());
    }
}
