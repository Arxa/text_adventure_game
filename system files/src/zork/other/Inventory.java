/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import zork.interfaces.ITakable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arxa
 */
public class Inventory 
{
    private static int goldAmount=10;
    private static List<ITakable> bag = new ArrayList<>();

    public static List<ITakable> getBag() 
    {
        return bag;
    }
    
    public static int getGoldAmount() 
    {
        return goldAmount;
    }

    public static void addGoldAmount(int coins) 
    {
        Inventory.goldAmount += coins;
    }
    
}
