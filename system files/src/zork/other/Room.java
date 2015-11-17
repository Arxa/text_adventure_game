/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arxa
 */
public class Room 
{
    private String description;
    private final Room[] stagesArray = new Room[4];
    private List<String> includedItems = new ArrayList<>();

    public Room() 
    {
        
    }
    
    public Room(String descr) 
    {
        setDescription(descr);
    }
    
    //Sets available directions for a Room
    public void setStages(Room north,Room east,Room south,Room west) 
    {
        this.stagesArray[0]=north;
        this.stagesArray[1]=east;
        this.stagesArray[2]=south;
        this.stagesArray[3]=west;
    }

    public Room[] getStagesArray() 
    {
        return stagesArray;
    }
    
    public void printDescription()
    {
        System.out.printf(this.getDescription());
    }
    
    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public List<String> getIncludedItems() 
    {
        return includedItems;
    }
            
            
}
