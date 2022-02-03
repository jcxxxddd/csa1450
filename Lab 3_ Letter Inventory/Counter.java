public class Counter{
    public int value;
    public String letter;

    public Counter(int newValue, String newLetter){
        value = newValue;
        letter = newLetter;

    }
    public char getLetter(){
        return letter.charAt(0); //converts letter from a string to a character.

    }
}