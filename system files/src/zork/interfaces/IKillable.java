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
public interface IKillable 
{
    public boolean isKilled();
    public void setKillStatus(boolean s);
    public String getKillableStringItem();
    public void printDeathMessage();
    public String getDeathlyItems();
    public void setEngage(boolean s);
    public void printOnlyWeapons();
    public void printHowMonsterDied(String weapon);
}
