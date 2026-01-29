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
    /*
   public void ingredientsNeeded(int cups){
        System.out.println("For "+cups+" of coffee you will need:");
        System.out.println(cups*(getWaterMl())+ " ml of water\n" +
                cups*(getMilkMl())+ " ml of milk\n" +
                cups*(getCoffeBeansG())+ " g of coffee beans");
    }*/
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
class Machine{
    protected int waterMl;
    protected int milkMl;
    protected int coffeBeansG;
    public Machine(int waterC, int milkC, int beansC){
        setWaterMl(waterC);
        setMilkMl(milkC);
        setCoffeBeansG(beansC);
    }
    public void makingCoffee(CoffeeCup coffeeCup, int cups){
        int maxByWater = getWaterMl() / coffeeCup.getWaterMl();
        int maxByMilk = getMilkMl() / coffeeCup.getMilkMl();
        int maxByBeans = getCoffeBeansG() / coffeeCup.getCoffeBeansG();
        int left;

        int maxCups = Math.min(maxByWater,
                Math.min(maxByMilk, maxByBeans));

        if (maxCups == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxCups > cups) {
            left=(maxCups-cups);
            System.out.println("Yes, I can make that amount of coffee (and even "+left+ " more than that)");
        } else {
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        }

    }
    //Getters Setters
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
        int machineWater;
        int machineMilk;
        int machineBeans;
        try (BufferedReader bf=new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Write how many ml of water the coffee machine has:");
            machineWater=Validation.readInteger(bf);
            machineWater=Validation.readNonNegativeInt(machineWater,bf);
            System.out.println("Write how many ml of milk the coffee machine has:");
            machineMilk=Validation.readInteger(bf);
            machineMilk=Validation.readNonNegativeInt(machineMilk,bf);
            System.out.println("Write how many grams of coffee beans the coffee machine has:");
            machineBeans=Validation.readInteger(bf);
            machineBeans=Validation.readNonNegativeInt(machineBeans,bf);
            System.out.println("Write how many cups of coffee you will need: ");
            cupsUser=Validation.readInteger(bf);
            cupsUser=Validation.readNonNegativeInt(cupsUser,bf);


            CoffeeCup coffeeCup=new CoffeeCup();
            Machine machine = new Machine(machineWater,machineMilk,machineBeans);
            machine.makingCoffee(coffeeCup,cupsUser);
        }catch (IOException e){
            System.out.println("Input error");
        }
    }
}