package dictionary;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary
{
    private final HashMap<String, String> words = new HashMap<>();

    public Dictionary()
    {
        File file = new File("/Users/chanarosenbluth/IdeaProjects/Dictionary/dictionary.txt");
        try
        {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] entry = line.split(" ", 2);
                if (entry.length == 1)
                {
                    words.put(entry[0], "");
                }
                else
                {
                    words.put(entry[0], entry[1]);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean isWord (final String lookupWord)
    {
        return getDefinition(lookupWord) != null;
    }

    public String getDefinition (final String lookupWord)
    {
        String lookupWordUpperCase = lookupWord.toUpperCase();
        return words.get(lookupWordUpperCase);
    }
}
