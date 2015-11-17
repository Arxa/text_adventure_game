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
public interface IReadable 
{
    public boolean isRead();
    public String getReadableStringItem();
    public void setReadStatus(boolean s);
    public void printReadOk();
    
}
