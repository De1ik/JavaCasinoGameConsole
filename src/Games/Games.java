package Games;

import Casino.Colours;
import Player.Player;

import java.util.Scanner;

abstract public class Games implements Colours{
    private int isGame;
    private final Player player;
    private final Scanner scanner;
    public Games(Player player){
        scanner = new Scanner(System.in);
        this.player = player;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Player getPlayer() {
        return player;
    }

    public int getIsGame() {
        return isGame;
    }

    public void setIsGame(int game) {
        isGame = game;
    }


    public void setCurrentStakeConstant(boolean message) {
        int MINIMUM_STAKE = 5;
        double number;
        player.showBalance();
        System.out.println("Make your Stake (The minimum stake is 5):");
//        if (message) {
//            System.out.println("-1 <- Go back");
//        }
        number = scanner.nextDouble();

        if (number < MINIMUM_STAKE) {
            if (player.getCurrentStake() != -1) {
                System.out.println("The minimum stake is " + MINIMUM_STAKE + " !");
                setCurrentStakeConstant(message);
            }
        }
        else player.setCurrentStake(number);
    }

    public boolean checkStake(){
            if (player.getBalance() < player.getCurrentStake()) {
                System.out.println("Insufficient on the balance sheet");
                return false;
            }
            else return true;

        }

    public void doStake(){
        if (player.getCurrentStake() == 0){
            System.out.println("Set the amount of the stake");
            setCurrentStakeConstant(false);
        }
        else if (checkStake()){
            player.setBalance(player.getBalance() - player.getCurrentStake());
        }
        else {
            setCurrentStakeConstant(true);
        }
    }

    public void increaseBalance(){
        player.setBalance(player.getBalance() + (player.getCurrentStake() * player.getMultiplier()));
    }

    public void winnerMessage(){
        System.out.println(Green+"Congratulate you won!");
        System.out.println("Your Stake was: " + player.getCurrentStake());
        System.out.println("Current Multiplier is: "+player.getMultiplier());
        System.out.println("You won "+ player.getCurrentStake() * player.getMultiplier() +" money!");
        System.out.println("Your Balance is: " + player.getBalance() + Reset);
    }

    public void loseMessage(){
        System.out.println(Red+"Unfortunately you lose!");
        System.out.println("Your Stake was: "+ player.getCurrentStake());
        System.out.println("Current Multiplier is: "+player.getMultiplier());
        System.out.println("You lose "+ player.getCurrentStake()+" money :( ");
        System.out.println("Your Balance is: " + player.getBalance() + Reset);
    }
}
