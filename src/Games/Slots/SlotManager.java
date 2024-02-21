package Games.Slots;

import Games.Games;
import Player.Player;

public class SlotManager extends SlotGameProcess {
    public SlotManager(Player player) {
        super(player);
    }

    public void mangerSlot() {
        switch (getPlaySlot()) {
            case -1:
                setIsGame(-1);
                break;
            case 1:
                runSlot();
                showSlotMessage();
                break;
            case 2:
                setCurrentStakeConstant(false);
                showSlotMessage();
                break;
            case 3:
                getPlayer().showBalance();
                showSlotMessage();
                break;
            default:
                showSlot();
                showSlotMessage();
        }
    }

}
