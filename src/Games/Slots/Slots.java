package Games.Slots;

import Games.Games;

abstract public class Slots extends Games {
    final private static String[] slotConfig = new String[10];
    private String currentGeneration;
    private final int PRICE_ONE_GAME = 1000;
    private final int SLOTS_LENGTH = 3;


    //constructor
    public Slots(Player.Player player){
        super(player);
        generateConfigSlots();
        currentGeneration = "";
    }

    //METHODS

    public int getPRICE_ONE_GAME() {
        return PRICE_ONE_GAME;
    }
    public String getCurrentGeneration() {
        return currentGeneration;
    }
    public void setCurrentGeneration(){
        for (int i = 0; i < 3; i++){
            currentGeneration = currentGeneration.concat(slotConfig[((int)(Math.random()*10))]);
        }
    }
    public void resetCurrentGeneration(){
        currentGeneration = "";
    }
    private static void generateConfigSlots(){
        for (int i = 0; i < 10; i++){
            if (i < 5) slotConfig[i] = "1";
            else if (i < 8) slotConfig[i] = "2";
            else slotConfig[i] = "3";
        }
    }
    public void showSlot(){
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
