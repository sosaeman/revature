import java.util.Scanner;
import java.util.regex.Pattern;

public class Week3ExcerciseOne {
    
    public static void main(String[] args) {
        startGame();
    }

//----------------------------------------------
    static double getRandom(){
        return Math.random() * 10 ;
    };
//--------------------------------------------

    static void startGame( ){
        int randomNumber = (int)getRandom();
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess a number between 0 and 10");
        Pattern pattern = Pattern.compile("[^0-9]");
       guess: while(sc.hasNext()){
            if(sc.hasNext(pattern)){
                System.out.println("not a number");
                sc.next();
            }
              while(sc.hasNextInt()){
                int guessNumber=sc.nextInt();
                System.out.println(guessNumber);
                  if(guessNumber == randomNumber){
                      System.out.println("Your are correct\n" + "Your Number:"+guessNumber+ "\nRandom Number:"+randomNumber);
                      break guess;
                  }else if(guessNumber<randomNumber){
                      System.out.println("TOO LOW");
                  }else if(guessNumber>randomNumber && !(guessNumber >= 11)){
                      System.out.println("TOO HIGH");
                  } else{
                      System.out.println("Enter a number between 1 and 10");
                  }
                 }; 
        };
            sc.close();
        };
}
