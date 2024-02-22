package Player;

import Casino.Colours;

import java.util.Scanner;

public class Player implements Colours {
    private double balance;
    private int multiplier;
    private double currentStake;
    Scanner scanner;

    public Player(){
        setBalance(50000);
        scanner = new Scanner(System.in);
        setCurrentStake(5);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public double getCurrentStake() {
        return currentStake;
    }

    public void setCurrentStake(double currentStake) {
        this.currentStake = currentStake;
    }

    public void showBalance(){
        String formattedResponce = String.format("%23s", "Your balance is: ");
        System.out.println("--------------------------------------");
        System.out.println(formattedResponce + this.balance);
        System.out.println("--------------------------------------");
    }
    public void showCurrentStake(){
        String formattedResponce = String.format("%23s", "Your stake is: ");
        System.out.println("--------------------------------------");
        System.out.println(formattedResponce + getCurrentStake());
        System.out.println("--------------------------------------");
        System.out.println();
    }
}
