/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.grammar;

import zork.interfaces.IWords;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arxa
 */
public class Nouns implements IWords
{
    private static List<String> nouns = new ArrayList<>();

    @Override
    public void addWord(String newWord)
    {
        getNouns().add(newWord);
    }
    
    public static List<String> getNouns() 
    {
        return nouns;
    }
}
