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
public class TunnelCavetroll implements IKillable
{
    private static boolean killStatus;
    private static boolean engage;
    
    public TunnelCavetroll(Room a, IWords w) 
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
        return "CaveTroll";
    }
    
    @Override
    public void printDeathMessage()
    {
        System.out.println("\nThe CaveTroll caught you in his hands..\nThe CaveTroll ate your head !\nYou died instantly!\n");
    }
    
    @Override
    public String getDeathlyItems()
    {
        return "crossbow";
    }
    
    @Override
    public void setEngage(boolean s)
    {
        engage = s;
    }
    
    @Override
    public void printOnlyWeapons()
    {
        System.out.println("\nUsing melee weapons got you very close to the CaveTroll..\n.");
    }
    
    @Override
    public void printHowMonsterDied(String weapon)
    {
        System.out.printf("\nYou shot 4 arrows to the CaveTroll with your %s and you killed it !\nNice job!\n",weapon);
    }
    
    
    //-------------Static-----------------\\
    public static boolean getKillStatus() 
    {
        return killStatus;
    }
    
    public static String getStringItem()
    {
        return "CaveTroll";
    }
    
    public static void printMonsterIntro()
    {
        System.out.println("\nOh my god!!\nA big CaveTroll has appeared !\nThe CaveTrool is throwing rocks on me!!\nOuch..ouchhh");
    }
    
    public static boolean getEngage() 
    {
        return engage;
    }
    
    public static void printMosterStillHere()
    {
        System.out.printf("The %s is still here!\nAouchhhhh It keeps throwing rocks to me man!",getStringItem());
    }
}
