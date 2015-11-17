/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.interfaces;

/**
 *
 * @author arxa
 */
public interface IOpenable 
{
    public boolean isOpened();
    public String getOpenableStringItem();
    public boolean isLocked();
    public void setOpenStatus(boolean s);
    public void printItsLocked();
    public void printOpenOk();
    
    
}
