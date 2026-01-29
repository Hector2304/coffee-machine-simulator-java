package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Class Coffee Cup
class CoffeeCup{
    protected int waterMl;
    protected int milkMl;
    protected int coffeBeansG;
    public CoffeeCup(){
        setWaterMl(200);
        setMilkMl(50);
        setCoffeBeansG(15);
    }
    public static void ingredientsNeeded(int cups){
        CoffeeCup coffeeCup=new CoffeeCup();
        System.out.println("For "+cups+" of coffee you will need:");
        System.out.println(cups*(coffeeCup.getWaterMl())+ " ml of water\n" +
                cups*(coffeeCup.getMilkMl())+ " ml of milk\n" +
                cups*(coffeeCup.getCoffeBeansG())+ " g of coffee beans");
    }
    //Getter Setters
    public int getWaterMl() {
        return waterMl;
    }

    public void setWaterMl(int waterMl) {
        this.waterMl = waterMl;
    }

    public int getMilkMl() {
        return milkMl;
    }

    public void setMilkMl(int milkMl) {
        this.milkMl = milkMl;
    }

    public int getCoffeBeansG() {
        return coffeBeansG;
    }

    public void setCoffeBeansG(int coffeBeansG) {
        this.coffeBeansG = coffeBeansG;
    }
}

public class CoffeeMachine {
    public static void main(String[] args) {
        int cupsUser;
        try (BufferedReader bf=new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Write how many cups of coffee you will need: ");
            cupsUser=Validation.readInteger(bf);
            cupsUser=Validation.readNonNegativeInt(cupsUser,bf);
            CoffeeCup.ingredientsNeeded(cupsUser);
        }catch (IOException e){
            System.out.println("Input error");
        }
    }
}