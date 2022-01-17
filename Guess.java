
//Joel Fletcher
//1/17/22/
//CS145
//Guess


//This program is a game! It is a guessing game in which the user will guess a number and the program will say if the guess is too high or too low.
import java.lang.Math.*;
import java.util.*;


//

public class Guess{
   final static int max = 100;
   
   static int totalgames=0;
   static int totalguesses=0;
   static int bestgame=9999; //I initialized this at 9999 as per instructions.
   static Scanner scanner = new Scanner(System.in);
   static Random random = new Random();
   
   //This is my main method which calls the other methods to run the program. 
   public static void main(String args[]) {
      int val = random.nextInt(max) +1 ;
      boolean go = true;
      while(go){
         introduce();
         System.out.println();
         gameplay();
         System.out.println(" Grats bruh, you tryna play again?" );
         System.out.println();
         String again = scanner.next();
         go = again.toLowerCase().charAt(0) == 'y' ;
      }
      report(); 
    	   
   } 
   
  // THis method introduces the game to the user.
   public static void introduce(){
      System.out.println("This program allows you to play a guessing game."); 
      System.out.println("I will think of a number between 1 and " + max + " and will allow you to guess until you get it.");
      System.out.println("For each guess, I will tell you whether the right answer is higher or lower than your guess." );
   
   }//end of introduce
   
  // This method runs each individual game.
   public static void gameplay(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("I'm thinking of a number between 1 and 100... ");
      int lastguess = 0;  
      int attempts = 0;
      int val= random.nextInt(max)+1;
      
      while(lastguess != val){ // This while loop prompts the user for input.
         System.out.print("Your guess? ");
         int userinput = scanner.nextInt();
         if (userinput > val){
            System.out.println("I'm sorry Hero, you missed! Aim lower! ");
         }
         else if(userinput < val){
            System.out.println("I'm sorry Hero, you missed! Aim higher!");
         
         }
         attempts++;
         lastguess=userinput;
      }//end of while loop
      
      System.out.println("You got it right in " + attempts + " guesses!");
      totalgames++;
      totalguesses+=attempts;
      if(attempts<bestgame){ //This checks to see if this is the best game.
         bestgame=attempts;
      }
  
   }//end of gameplay
   
   //This reports the statistics to the user at the end of the game.
   public static void report(){
      System.out.println("Overall results");
      System.out.println("total games: " + totalgames);
      System.out.println("total guesses: " + totalguesses);
      System.out.println("guesses/game: " + (totalguesses * 1.0)/(totalgames * 1.0));
      System.out.println("best game: " + bestgame);
   
   }//end of report
     
}