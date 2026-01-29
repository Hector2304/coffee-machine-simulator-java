package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Class Coffee Cup
class CoffeeCup{
    protected int waterMl;
    protected int milkMl;
    protected int coffeBeans;
    protected int price;
    public CoffeeCup(int waterMlC, int milkMlC, int coffeBeansC,int priceC){
        setWaterMl(waterMlC);
        setMilkMl(milkMlC);
        setCoffeBeans(coffeBeansC);
        setPrice(priceC);
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

    public int getCoffeBeans() {
        return coffeBeans;
    }

    public void setCoffeBeans(int coffeBeansG) {
        this.coffeBeans = coffeBeansG;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
class Machine{
    protected int waterMl;
    protected int milkMl;
    protected int coffeBeans;
    protected int money;
    protected int disposableCups;
    protected boolean state;
    public Machine(){
        setWaterMl(400);
        setMilkMl(540);
        setCoffeBeans(120);
        setMoney(550);
        setDisposableCups(9);
        setState(true);
    }
    public void machineResources(){
        System.out.println("The coffee machine has:\n" +
                getWaterMl()+ " ml of water\n" +
                getMilkMl()+ " ml of milk\n" +
                getCoffeBeansG()+" g of coffee beans\n" +
                getDisposableCups()+ " disposable cups\n$" +
                getMoney() +" of money");
    }
    public void machineActions(BufferedReader bf)throws IOException{
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String userOption=Validation.readNoBlankLine(bf);
        userOption=Validation.goodOption(userOption,bf);
        switch (userOption){
            case "buy":
                buy(bf);
                break;
            case "fill":
                fillMachine(bf);
                break;
            case "take":
                takeFromMachine();
                break;
            case "remaining":
                machineResources();
                break;
            case "exit":
                exitMachine();
                break;
        }
    }
    public void buy(BufferedReader bf)throws IOException{
        System.out.println("1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeOption=Validation.readNoBlankLine(bf);
        coffeeOption=Validation.buyOptions(coffeeOption,bf);
        switch (coffeeOption){
            case "1":
                CoffeeCup espresso=new CoffeeCup(250,0,16,4);
                makingCoffee(espresso);
                break;
            case "2":
                CoffeeCup latte=new CoffeeCup(350,75,20,7);
                makingCoffee(latte);
                break;
            case "3":
                CoffeeCup cappuccino=new CoffeeCup(200,100,12,6);
                makingCoffee(cappuccino);
                break;
            case "back":
                break;
        }
    }

    public void makingCoffee(CoffeeCup coffeeCup){
        String lacking=lackingResource(coffeeCup);
        if (lacking!=null) {
            System.out.println("Sorry, not enough "+lacking+"!");
        }else {
            setWaterMl(getWaterMl()-coffeeCup.getWaterMl());
            setMilkMl(getMilkMl()-coffeeCup.getMilkMl());
            setCoffeBeans(getCoffeBeansG()-coffeeCup.getCoffeBeans());
            setDisposableCups(getDisposableCups()-1);
            setMoney(getMoney()+coffeeCup.getPrice());
            System.out.println("I have enough resources, making you a coffee!");
        }


    }
    private String lackingResource(CoffeeCup cup) {
        if (getDisposableCups() < 1) return "disposable cups";
        if (getWaterMl() < cup.getWaterMl()) return "water";
        if (getMilkMl() < cup.getMilkMl()) return "milk";
        if (getCoffeBeansG() < cup.getCoffeBeans()) return "coffee beans";
        return null;
    }
    public void fillMachine(BufferedReader bf)throws IOException {
        System.out.println("Write how many ml of water you want to add:");
        int addWater=Validation.readInteger(bf);
        addWater=Validation.readNonNegativeInt(addWater,bf);
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk=Validation.readInteger(bf);
        addMilk=Validation.readNonNegativeInt(addMilk,bf);
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addCoffeeBeans=Validation.readInteger(bf);
        addCoffeeBeans=Validation.readNonNegativeInt(addCoffeeBeans,bf);
        System.out.println("Write how many disposable cups you want to add:");
        int adddisposableCups=Validation.readInteger(bf);
        adddisposableCups=Validation.readNonNegativeInt(adddisposableCups,bf);

        setWaterMl(getWaterMl()+addWater);
        setMilkMl(getMilkMl()+addMilk);
        setCoffeBeans(getCoffeBeansG()+addCoffeeBeans);
        setDisposableCups(getDisposableCups()+adddisposableCups);
    }
    public void takeFromMachine(){
        System.out.println("I gave you $"+ getMoney());
        setMoney(0);
    }
    public  void exitMachine(){
        setState(false);
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
        return coffeBeans;
    }

    public void setCoffeBeans(int coffeBeansG) {
        this.coffeBeans = coffeBeansG;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}

public class CoffeeMachine {
    public static void main(String[] args) {
        try (BufferedReader bf=new BufferedReader(new InputStreamReader(System.in))){
            Machine machine = new Machine();
            while (machine.isState()){
                machine.machineActions(bf);
            }
        }catch (IOException e){
            System.out.println("Input error");
        }
    }
}