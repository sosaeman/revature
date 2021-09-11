

public class ExcerciseTwo {
    public static void main(String[] args) {
        System.out.println(getAlphabetArray());
        // StringBuilder
        // System.out.println(getAA());

    }

    public static char[] getAlphabetArray(){
        char alpha = 'a';
        int i = 0;
        char[] alphaArr = new char[26] ;
         do{
             alphaArr[i]= alpha;
             alpha++;
             i++;
         }
         while(alpha <= 'z');
       return alphaArr;  
     };
//Testing out StringBuilder
 public static StringBuilder getAA(){
     int i =1;
    StringBuilder alpha = new StringBuilder();
    for(char letter = 'a';letter<='z';letter++){     
       //  alpha.append(Character.toString(letter));
         alpha.append(letter);
        alpha.append(i);
        i++;
    }
    return alpha;
 };
}
