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
public interface IMovable 
{
    public boolean isMoved();
    public String getMovableStringItem();
    public boolean isStable();
    public void setMoveStatus(boolean s);
    public void printItsStable();
    public void printMoveOk();
    
}
