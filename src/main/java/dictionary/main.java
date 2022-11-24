package dictionary;

public class main
{
    public static void main(String[] args)
    {
        Dictionary d = new Dictionary();
        String word = "cat";
        System.out.println("is a word? "+ d.isWord(word));
    }
}
