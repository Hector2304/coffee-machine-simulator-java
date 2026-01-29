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
            System.out.println("Pleas do not use negative numbers");
            number=readInteger(bf);
        }
    }
    public static String readNoBlankLine(BufferedReader bf)throws IOException {
        while (true) {
            String input = bf.readLine();
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }
            System.out.println("Try Again");
        }
    }
    public static String goodOption(String option,BufferedReader bf)throws IOException{
        while (true){
            if (option.equals("buy")||option.equals("fill")||option.equals("take")||option.equals("remaining")
                    ||option.equals("exit")){
                return option;
            }
            System.out.println("Not an option, the options are: buy, fill, take");
            option=readNoBlankLine(bf);
        }
    }
    /*
    public static int integerCoffeeOptions(int integer, BufferedReader bf)throws IOException{
        //Validation.readNonNegativeInt(integer,bf);
        while (true){
            if (!(integer<1||integer>3)){
                return integer;
            }
            System.out.println("Not an option, the options are: 1 - espresso, 2 - latte, 3 - cappuccino");
            integer=Validation.readInteger(bf);
        }
    }
    */
    public static String buyOptions(String option,BufferedReader bf)throws IOException{
        while (true){
            if (option.equals("1")||option.equals("2")||option.equals("3")||option.equals("back")){
                return option;
            }
            System.out.println("Not an option, the options are: 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
            option=readNoBlankLine(bf);
        }
    }
}