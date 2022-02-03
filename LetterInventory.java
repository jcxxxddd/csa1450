import java.util.ArrayList;

public class LetterInventory{

    public static void main(String[] args){
        System.out.println("test");
        LetterInventory li = new LetterInventory("");
        System.out.println(li.toString());
        System.out.println(li.size());//counts all ocurences of all letters
        //System.out.println(li.get('l'));
        //li.set('l', 6);
        //System.out.println(li.get('l'));
        System.out.println(li.size());
        System.out.println(li.isEmpty());
    }
    
    public ArrayList<Counter> inventory = new ArrayList<Counter>();

    public LetterInventory (String input){
        inventory = new ArrayList<Counter>();
        for(int i=0; i < input.length(); i++){//will run through each char in the string
            boolean found = false;
            for(int j = 0; j < inventory.size(); j++){
                if(String.valueOf(input.charAt(i)).equals(inventory.get(j).letter)){
                    inventory.get(j).value ++;
                    found = true;
                }
            }
            if (!found){
                inventory.add(new Counter(1, String.valueOf(input.charAt(i))));
            }
        }   
    }
    
    public int get(char letter){
        var occurences = 0;
        for( int i = 0; i < inventory.size(); i++){
            if(letter == (inventory.get(i).getLetter())){
                occurences = inventory.get(i).value;
            }
        }
        return occurences;

    }

    public void set(char letter, int value){
        for( int i = 0; i < inventory.size(); i++){
            if(letter == (inventory.get(i).getLetter())){
                inventory.get(i).value = value;
            }
        }

    }
    
    public String toString(){
        String output = "";
        for(int i = 0; i < inventory.size(); i ++){
            for(int j = 0; j < inventory.get(i).value; j++){
                output += inventory.get(i).letter; //adds letter to string output = to nunmber of times of its value

            }

        }

        return output;
    }
    
    public int size(){
        int totalCount = 0;
        for(int i = 0; i < inventory.size(); i ++){
            totalCount += inventory.get(i).value;
        }

        return totalCount;
    }
   
    public boolean isEmpty(){
        boolean empty = true;
        for(int i = 0; i < inventory.size(); i ++){
            if(inventory.get(i).value > 0){
                return false;
            }
        }
        return empty;
    }
}