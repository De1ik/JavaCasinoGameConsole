package Main;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        CasinoManager casinoManager = new CasinoManager(player);
        while (casinoManager.getIsGame()){
            casinoManager.managmentStart();
        }
    }
}
