package Games.Slots;

import Games.Games;
import Games.GameMainFunctionallity;

abstract public class Slots extends Games implements GameMainFunctionallity {
    final private static String[] slotConfig = new String[10];
    private String currentGeneration;
    private final int SLOTS_LENGTH = 3;


    //constructor
    public Slots(Player.Player player){
        super(player);
        generateGame();
        currentGeneration = "";
    }

    //METHODS

    public String getCurrentGeneration() {
        return currentGeneration;
    }
    public void setCurrentGeneration(){
        for (int i = 0; i < 3; i++){
            currentGeneration = currentGeneration.concat(slotConfig[((int)(Math.random()*10))]);
        }
    }
    public void gameReset(){
        currentGeneration = "";
    }

    @Override
    public void generateGame(){
        for (int i = 0; i < 10; i++){
            if (i < 5) slotConfig[i] = "1";
            else if (i < 8) slotConfig[i] = "2";
            else slotConfig[i] = "3";
        }
    }

    public void showField(){
        System.out.println("-------------------------");
        if (getCurrentGeneration().length() < 3){
            System.out.println("|\t3\t|\t3\t|\t3\t|");
        }
        else{
            System.out.print("|");
            for (int i = 0; i < SLOTS_LENGTH; i++){
                System.out.print("\t"+ getCurrentGeneration().charAt(i) +"\t|");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}
