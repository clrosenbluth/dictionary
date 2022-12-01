package dictionary;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    private final HashMap<String, String> words = new HashMap<>();

    public Dictionary() {
        InputStream input = Dictionary.class.getResourceAsStream("/dictionary.txt");
        try {

            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] entry = line.split(" ", 2);

                if (entry.length == 1) {
                    words.put(entry[0], "");
                } else {
                    words.put(entry[0], entry[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isWord(final String lookupWord)
    {
        return getDefinition(lookupWord) != null;
    }

    public String getDefinition(final String lookupWord) {
        String lookupWordUpperCase = lookupWord.toUpperCase();
        return words.get(lookupWordUpperCase);
    }
}
