/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.interfaces;

/**
 *
 * @author Arxa
 */
public interface IExaminable 
{
    public boolean isExamined();
    public String getExaminableStringItem();
    public void setExamineStatus(boolean e);
    public void printExamination();
}
