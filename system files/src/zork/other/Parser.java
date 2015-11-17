/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.other;

import zork.Zork;
import zork.grammar.Nouns;
import zork.grammar.VerbsWithNoun;
import zork.grammar.OneVerbs;

/**
 *
 * @author Arxa
 */
public class Parser 
{
    private static int count1,count2,count3,count4,i;
    private static boolean proccess,doneParsing,syntaxOk;
    private static Object[] NextCommand = new Object[1];
    private static Object[] CurrentCommand= new Object[1];
    
    
/*  STAGE 2: The input string is being grammatically identified
    Returns a tokenized array of the command (if input's grammar is OK)
    My Grammar: -> VerbsithNoun + Noun  (CORRECT)
                -> OneVerbs             (CORRECT)             */
    public static String[] translate(String command)
    {
        command=command.trim();
        String[] tokens = command.split("\\s+");
        count1 = 0;
        count2 = 0;
        count3 = 0;
        count4 = 0;
        proccess = false;
        syntaxOk=true;
        i=0;
        while (i<tokens.length)
        {
            
            for (String x : VerbsWithNoun.getVerbsWithNoun()) 
            {
                if (x.toLowerCase().equals(tokens[i].toLowerCase()))
                {
                    proccess = true;
                    CurrentCommand[0] = VerbsWithNoun.class;
                    if ( (NextCommand[0]!=CurrentCommand[0]) && (count1!=0) )
                    {
                        count1=1;
                        syntaxOk=false;
                        Output.printWrongSyntax();
                        break;
                    }
                    NextCommand[0] = Nouns.class;
                    doneParsing=false;
                    
                }
            }
            
            for (String x : OneVerbs.getOneVerbs()) 
            {
                if (x.toLowerCase().equals(tokens[i].toLowerCase()))
                {
                    proccess = true;
                    CurrentCommand[0] = OneVerbs.class;
                    if (NextCommand[0]!=CurrentCommand[0] && count2!=0)
                    {
                        count2=1;
                        syntaxOk=false;
                        Output.printWrongSyntax();
                        break;
                    }
                    NextCommand[0] = Zork.class;
                    doneParsing=true;
                    
                }
            }
            
            for (String x : Nouns.getNouns()) 
            {
                if (x.toLowerCase().equals(tokens[i].toLowerCase()))
                {
                    proccess = true;
                    CurrentCommand[0] = Nouns.class;
                    if (NextCommand[0]!=CurrentCommand[0] && count3!=0)
                    {
                        count3=1;
                        syntaxOk=false;
                        Output.printWrongSyntax();
                        break;
                    }
                    NextCommand[0] = Zork.class;
                    doneParsing=true;
                    
                }
            }
            
            if (proccess==false) 
            {
                syntaxOk=false;
                doneParsing=true;
                Output.printWriteProperEnglish();
                break;
            } 
            i++;
        }
        
        if (doneParsing==false) 
        {
            syntaxOk=false;
            Output.printWrongSyntax();
        }
        return tokens;
    }

    public static boolean isSyntaxOk() 
    {
        return syntaxOk;
    }
    
}
