package Games.Roulette;

import Games.Games;
import Games.GameMainFunctionallity;
import Player.Player;
import java.util.HashMap;

abstract class Roulette extends Games {
    final private static int SIZE = 37;
    final private static int HALF_SIZE = SIZE/2;
    final private static int[] numbers = new int[SIZE];
    private static HashMap<Integer, String> colours;
    public Roulette(Player player){
        super(player);
        colours = new HashMap<>();
        createNumb();
        createCol();
    }

    public void createNumb() {
        for (int i = 0; i < SIZE; i++){
            numbers[i] = i;
        }
    }
    public void createCol() {
        int prevRed = 0;
        int prevBlack = 0;
        int randomVal;
        int countRed = 0;
        int countBlack = 0;


        for (int i = 0; i < SIZE; i++){
            randomVal = (int) (Math.random()*3);
            if (((randomVal == 0) && (prevRed != 2) && (countRed != HALF_SIZE)) ||  ((prevBlack == 2) || (countBlack == HALF_SIZE))){
                prevRed++;
                countRed++;
                prevBlack = 0;
                colours.put(numbers[i], "Red");
            }
            else {
                prevBlack += 1;
                countBlack++;
                prevRed = 0;
                colours.put(numbers[i], "Black");
            }
        }
    }

    @Override
    public void showField(){
        int count = 0;
        int box_count = 1;
        separate();
        String formattedNumber = String.format(Green+"%6s%d%5s"+Reset, "", numbers[0], "");
        System.out.println("\tZero Zone\t|"+formattedNumber+"|");
        separate();


        for (int i = 1; i < SIZE; i++){
            if ((count == 3)){
                System.out.println("|");
                count = 0;
                box_count++;
                if ((box_count-1)%4 == 0) separate();
            }
            if (count == 0) {
                if (((box_count+2)%4 == 0) && (i < 12)) System.out.print("\tPast Zone\t|");
                else if (((box_count+2)%4 == 0) && (i < 24)) System.out.print("\tFame Zone\t|");
                else if (((box_count+2)%4 == 0) && (i < 36)) System.out.print("\tFeat Zone\t|");
                else System.out.print("\t\t\t\t|");
            }

            if (colours.get(numbers[i]).equals("Red")) {
                formattedNumber = String.format(Red+"%3d"+Reset, numbers[i]);
            }
            else {
                formattedNumber = String.format(Cyan+"%3d"+Reset, numbers[i]);
            }
            System.out.print(formattedNumber + " ");
            count++;
        }
        System.out.println("|");
        separate();
    }


    public String getColours(int number){
        return colours.get(number);
    }
    public void separate(){
        System.out.println("\t\t\t\t--------------");
    }
}

