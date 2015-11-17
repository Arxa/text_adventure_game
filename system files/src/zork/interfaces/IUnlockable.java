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
public interface IUnlockable 
{
    public boolean isUnlocked();
    public void setUnlockStatus(boolean s);
    public void printItemUnlocked();
    public String getUnlockableStringItem();
    public String getRightKey();
}
