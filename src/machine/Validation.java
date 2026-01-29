package machine;

import java.io.BufferedReader;
import java.io.IOException;

public class Validation {
    public static int readInteger(BufferedReader bf)throws IOException {
        int intInput=0;
        while (true){
            try {
                intInput=Integer.parseInt(bf.readLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("Not a number, try again using numbers");
            }
        }
        return intInput;
    }
    public static int readNonNegativeInt(int number,BufferedReader bf)throws IOException {
        while (true) {
            if (number >= 0) return number;
            System.out.println("I cant count negatives, try again");
            number=readInteger(bf);
        }
    }
}