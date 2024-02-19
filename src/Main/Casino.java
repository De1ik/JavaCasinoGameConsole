package Main;

import java.util.Scanner;

public class Casino {
    private boolean isCasino;
    private int MenuSelect;
    private final Scanner scanner;
    protected Player player;
    public RouletteManager rouletteManager;
    Games games;

    public Casino(Player player){
        isCasino = true;
        this.player = player;
        scanner = new Scanner(System.in);
        rouletteManager = new RouletteManager(this.player);
        setMenuSelect(-2);
    }


    public int getMenuSelect() {
        return MenuSelect;
    }

    public void setMenuSelect(int menuSelect) {
        MenuSelect = menuSelect;
    }

    public boolean getIsGame() {
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
        System.out.println("0 <- back");
        MenuSelection(11, 11, 0);
    }

    public void MenuSelection(int min, int max, int back) {
        MenuSelect = scanner.nextInt();
        while ((MenuSelect < min || MenuSelect > max) &&  (MenuSelect != back)){
            System.out.println("Enter the valid code of action!");
            MenuSelect = scanner.nextInt();
        }
    }

}
