package Casino;

import Casino.Casino;
import Games.Slots.SlotManager;
import Player.Player;

public class CasinoManager extends Casino {

    public CasinoManager(Player player) {
        super(player);
    }

    public void managmentStart(){
        switch (getMenuSelect()){
            case -2:
                startMessage();
                break;
            case -1:
                setCasino(false);
                break;
            case 0:
                Menu();
                break;
            case 1:
                selectGames();
                break;
            case 2:
                player.showBalance();
                Menu();
                break;
            case 11:
                rouletteManager.setIsGame(1);
                while(rouletteManager.getIsGame() == 1){
                    rouletteManager.managmentStake();
                }
                Menu();
                break;
            case 12:
                slotManager.setIsGame(2);
                while(slotManager.getIsGame() == 2){
                    slotManager.mangerSlot();
                }
                Menu();
            default:
                Menu();

        }
    }
}
