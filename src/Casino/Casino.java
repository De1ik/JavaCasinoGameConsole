package Casino;

import Games.Roulette.RouletteManager;
import Games.Slots.SlotManager;
import Player.Player;

import java.util.Scanner;

public class Casino {
    private boolean isCasino;
    private int MenuSelect;
    private final Scanner scanner;
    protected Player player;
    public RouletteManager rouletteManager;
    public SlotManager slotManager;

    public Casino(Player player){
        isCasino = true;
        this.player = player;
        scanner = new Scanner(System.in);
        rouletteManager = new RouletteManager(this.player);
        slotManager = new SlotManager(this.player);
        setMenuSelect(-2);
    }


    public int getMenuSelect() {
        return MenuSelect;
    }

    public void setMenuSelect(int menuSelect) {
        MenuSelect = menuSelect;
    }

    public boolean getIsCasino() {
        return isCasino;
    }

    public void setCasino(boolean casino) {
        isCasino = casino;
    }

    public void startMessage(){
        System.out.println("You are Welcome in Delik's Casino");
        System.out.println("You can interact with casino, by typing the specific number:");
        Menu();
    }

    public void Menu(){
        System.out.println(" 1 <- list of the available games");
        System.out.println(" 2 <- balance");
        System.out.println("-1 <- exit casino");
        MenuSelection(-1, 2, -999);
    }

    public void selectGames(){
        System.out.println("11 <- Roulete");
        System.out.println("12 <- Slots");
        System.out.println("0 <- back");
        MenuSelection(11, 12, 0);
    }

    public void MenuSelection(int min, int max, int back) {
        MenuSelect = scanner.nextInt();
        while ((MenuSelect < min || MenuSelect > max) &&  (MenuSelect != back)){
            System.out.println("Enter the valid code of action!");
            MenuSelect = scanner.nextInt();
        }
    }

}
