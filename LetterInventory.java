public class LetterInventory{

    // Joel Fletcher
    // cs145 parsons
    public static void main(String[] args)
    {
        System.out.println("test");
        LetterInventory li = new LetterInventory("hellllK]Hlllo");
        System.out.println(li.toString());
        System.out.println("Number of l is: " + li.get('l'));
        System.out.println("Number of L is: " + li.get('L'));
    }

    // Array of counters to hold the letters and occurence total
    private Counter[] inventory;

    // Default size (26 letters) and ascii starting index (97) to grab lowercase letters
    private static final int inventorySize = 26;
    private static final int alphabetStartingIndex = 97;

    // keeps track of total size of inventory
    private int totalCharacterCount = 0;

    // Default Constructor creates new empty inventory with all chars and 0 occurences
    public LetterInventory(){
        inventory = new Counter[inventorySize];
        for(int i = 0; i < inventorySize; i++)
            inventory[i] = new Counter(i+alphabetStartingIndex,0);
    }

    // Primary construct takes in a string and creates inventory based on that
    public LetterInventory (String input)
    {
        // Call default constructor to initialize array
        this();

        // Convert string to all lowercase to avoid case issues
        input = input.toLowerCase();

        // Run through each character in the string and try to add to inventory
        for(int i=0; i < input.length(); i++)
            try{
                addOccurrenceOfLetter(input.charAt(i));}
            catch(IllegalArgumentException e){
                System.out.println("Unable to add all characters from string: " + e.getMessage());}
    }

    // Outputs a simple string representation of our inventory
    public String toString()
    {
        // Wrap output with square brackets
        String output = "[";

        // Add the letter to output string equal to the number of occurences
        for(Counter counter: inventory)
            for(int i = 0; i < counter.getOccurences(); i++)
                output += counter.getLetter();

        return output + "]";
    }

    // Gets the number of occurences of this letter in the inventory
    public int get(char letter)
    {
        // Convert char to lowercase 
        letter = Character.toLowerCase(letter);

        // Get index by subracting out the starting index of the character in ascii table ('a' starts at 65)
        int counterIndex = letter - alphabetStartingIndex;

        // Check if it's now a valid index for our inventory, if it return occurence total if not throw excep
        if(validIndex(counterIndex))
            return inventory[counterIndex].getOccurences();
        else
            throw new IllegalArgumentException("Unable to find letter: '" + letter + "'" + ", has ascii index: " + (int)letter);
    }

    // Sets the number of occurences of this letter in the inventory to given value
    public void set(char letter, int value)
    {
        // Convert char to lowercase 
        letter = Character.toLowerCase(letter);
        
        // Get index by subracting out the starting index of the character in ascii table ('a' starts at 65)
        int counterIndex = letter - alphabetStartingIndex;

        // Check if it's now a valid index for our inventory, if it is modify occurence total
        if(validIndex(counterIndex))
        {
            totalCharacterCount += (value - inventory[counterIndex].getOccurences());
            inventory[counterIndex].setOccurences(value);
        }
        else
            throw new IllegalArgumentException("Unable to find letter: '" + letter + "'" + ", has ascii index: " + (int)letter);
    }

    // Outputs a new inventory equal to the sum of current inventory and the passed one
    public LetterInventory add(LetterInventory letterInventory)
    {
        // Create new LetterInventory
        LetterInventory output = new LetterInventory();

        // Add the occurences from both inventories into new one
        for(int i = alphabetStartingIndex; i < inventorySize + alphabetStartingIndex; i++)
        {
            output.addOccurrenceOfLetter((char)i, get((char)i) + letterInventory.get((char)i));
        }

        return output;
    }

    // Outputs a new inventory equal to the difference of current inventory and the passed one
    public LetterInventory subtract(LetterInventory letterInventory)
    {
        // Create new LetterInventory
        LetterInventory output = new LetterInventory();

        // Add the occurences from both inventories into new one
        for(int i = alphabetStartingIndex; i < inventorySize + alphabetStartingIndex; i++)
        {
            output.addOccurrenceOfLetter((char)i, get((char)i) - letterInventory.get((char)i));
            if(output.get((char)(i)) < 0)
                return null;
        }

        return output;
    }

    // Returns the sum of all counts in inventory
    public int size(){
        return totalCharacterCount;
    }

    // Returns whether inventory is empty or not
    public boolean isEmpty(){
        return totalCharacterCount == 0;
    }


    ////////////////////////////////
    //// Custom Helper Functions ///
    ////////////////////////////////

    // Attempts to add a character to our inventory, throws exception if invalid character
    public void addOccurrenceOfLetter(char letter)
    {
        addOccurrenceOfLetter(letter,1);
    }

    // Attempts to add a character to our inventory, throws exception if invalid character
    public void addOccurrenceOfLetter(char letter, int occurences)
    {
        set(letter, get(letter) + occurences);
    }

    // Helper function to easily convert from integer to character based on ascii number
    public int get(int asciiNumber)
    {
        return get((char)(asciiNumber));
    }

    // Helper function to make sure we are getting counter from a valid index in inventory
    public boolean validIndex(int index)
    {
        return (index >=0 && index < 26);
    }
}