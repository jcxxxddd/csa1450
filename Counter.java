public class Counter{

    private char letter;
    private int occurences;
    
    public Counter(char newLetter, int newOccurences)
    {
        letter = newLetter;
        occurences = newOccurences;    
    }

    public Counter(int charIndex, int startingOccurences)
    {
        this((char)charIndex, startingOccurences);
    }

    public Counter(Counter counter)
    {
        this(counter.letter, counter.occurences);
    }

    public void addToValue(int valueToAdd)
    {
        occurences += valueToAdd;
    }

    public int getOccurences()
    {
        return occurences;
    }

    public void setOccurences(int value)
    {
        occurences = value;
    }

    public char getLetter()
    {
        return letter;
    }

    public void setLetter(char character)
    {
        letter = character;
    }

}