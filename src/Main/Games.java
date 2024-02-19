package Main;

import java.util.Scanner;

abstract class Games implements Colours{
    private boolean isGame;
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

    public boolean getIsGame() {
        return isGame;
    }

    public void setIsGame(boolean game) {
        isGame = game;
    }


    public boolean checkStake(){
        int MINIMUM_STAKE = 5;
        if (player.getCurrentStake() < MINIMUM_STAKE) {
            if (player.getCurrentStake() != -1) {
                System.out.println("QWERTREWQW");
                System.out.println("The minimum stake is " + MINIMUM_STAKE + " !");
            }
            return false;
        }
        else if (player.getCurrentStake() > player.getBalance()) {
            System.out.println("Insufficient on the balance sheet");
            return false;
        }
        else return true;

    }
    public void doStake(){
        System.out.println("Make your Stake (The minimum stake is 5):");
        System.out.println("-1 <- Go back");
        player.setCurrentStake(scanner.nextDouble());

        if (checkStake()){
            player.setBalance(player.getBalance() - player.getCurrentStake());
        }
        else if (player.getCurrentStake() != -1){
            doStake();
        }


    }

    void increaseBalance(){
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
