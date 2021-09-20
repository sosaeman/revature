import java.util.Scanner;

public class Week3ExcerciseOne {
    
    public static void main(String[] args) {
        startGame();
    }
//----------------------------------------------
    static double random(){
        return Math.random() * 10 ;
    };
//--------------------------------------------
    static void startGame( ){
        int randomNumber = (int)random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess a number between 1 and 10");
      guess:  while(sc.hasNextInt()){
           int guessNumber=sc.nextInt();
           System.out.println(guessNumber);
             if(guessNumber == randomNumber){
                 System.out.println("Your are correct\n" + "Your Number:"+guessNumber+ "\nRandom Number:"+randomNumber);
                 break guess;
             }else if(guessNumber<randomNumber){
                 System.out.println("TOO LOW");
             }else if(guessNumber>randomNumber){
                 System.out.println("TOO HIGH");
             }else{
                 System.out.println("Enter a number between 1 and 10");
             }
            };
            sc.close();

        };
}
