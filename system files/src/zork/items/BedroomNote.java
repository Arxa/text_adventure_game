/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.items;

import zork.interfaces.IExaminable;
import zork.interfaces.IReadable;
import zork.interfaces.IWords;

/**
 *
 * @author arxa
 */
public class BedroomNote implements IReadable, IExaminable
{
    private static boolean readStatus;
    private static boolean examineStatus;

    public BedroomNote(IWords w) 
    {
        readStatus = false;
        examineStatus = false;
        w.addWord(getStringItem());
    }
    
    //-------------IReadable-----------------\\
    @Override
    public boolean isRead()
    {
        return getReadStatus();
    }
    
    @Override
    public String getReadableStringItem()
    {
        return "note";
    }
    
    @Override
    public void setReadStatus(boolean s)
    {
        readStatus = s;
    }
    @Override
    public void printReadOk()
    {
        System.out.println("\n'I hided my key under the pillow.'\n");
    }
    
    //-------------IExaminable-----------------\\
    @Override
    public boolean isExamined()
    {
        return examineStatus;
    }
    @Override
    public String getExaminableStringItem()
    {
        return "note";
    }
    @Override
    public void setExamineStatus(boolean e)
    {
        examineStatus = e;
    }
    @Override
    public void printExamination()
    {
        System.out.println("\nThere is something written on it..\n");
    }
    
    
    
    public static String getStringItem()
    {
        return "Note";
    }
    
    public static boolean getExamineStatus() 
    {
        return examineStatus;
    }

    public static boolean getReadStatus() 
    {
        return readStatus;
    }
    
    
}
