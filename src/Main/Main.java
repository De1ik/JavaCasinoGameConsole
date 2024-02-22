package Main;

import Casino.CasinoManager;
import Games.Slots.SlotGameProcess;
import Games.Slots.SlotManager;
import Games.Slots.Slots;
import Player.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        CasinoManager casinoManager = new CasinoManager(player);
        while (casinoManager.getIsCasino()){
            casinoManager.managerCasino();
        }
    }
}
