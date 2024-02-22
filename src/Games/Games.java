package Games;

import Casino.Colours;
import Player.Player;

import java.util.Scanner;

abstract public class Games implements Colours, GameMainFunctionallity{

    final private int MINIMUM_STAKE = 5;
    final private int MAXIMUM_STAKE = 50000;
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

    public int getMINIMUM_STAKE() {
        return MINIMUM_STAKE;
    }

    public int getMAXIMUM_STAKE() {
        return MAXIMUM_STAKE;
    }

    public void setCurrentStakeConstant() {
        double number;
        player.showBalance();
        System.out.println("Make your Stake (The minimum/maximum stake are 5/50k):");
        number = scanner.nextDouble();

        if (number < getMINIMUM_STAKE()) {
            if (player.getCurrentStake() != -1) {
                System.out.println("The minimum stake is " + getMINIMUM_STAKE() + " !");
                setCurrentStakeConstant();
            }
        }
        else if (number > getMAXIMUM_STAKE()){
            System.out.println("The maximum stake is " + getMAXIMUM_STAKE() + " !");
            setCurrentStakeConstant();
        }
        else player.setCurrentStake(number);
    }

    public boolean checkStake(){
            if (player.getBalance() < player.getCurrentStake())  {
                System.out.println("Insufficient on the balance sheet");
                return false;
            }
            else return true;

        }

    public boolean doStake(){
        if (checkStake()){
            player.setBalance(player.getBalance() - player.getCurrentStake());
            return true;
        }
        else {
            return false;
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
