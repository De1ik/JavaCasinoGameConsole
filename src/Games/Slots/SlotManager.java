package Games.Slots;

import Player.Player;

public class SlotManager extends SlotGameProcess {
    public SlotManager(Player player) {
        super(player);
    }

    public void managerGame() {
        switch (getPlaySlot()) {
            case -1:
                setIsGame(-1);
                setPlaySlot(-2);
                break;
            case 1:
                runCurrentGame();
                menuGame();
                break;
            case 2:
                setCurrentStakeConstant();
                menuGame();
                break;
            case 3:
                getPlayer().showBalance();
                menuGame();
                break;
            default:
                showField();
                menuGame();
        }
    }

}
