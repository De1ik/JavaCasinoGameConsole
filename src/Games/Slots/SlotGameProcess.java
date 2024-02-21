package Games.Slots;

public class SlotGameProcess extends Slots {
    private int playSlot;

    public SlotGameProcess(Player.Player player) {
        super(player);
    }


    public int getPlaySlot() {
        return playSlot;
    }

    public void setPlaySlot(int playSlot) {
        this.playSlot = playSlot;
    }

    public void showSlotMessage() {
        getPlayer().showCurrentStake();
        System.out.println("3 <- Show balance");
        System.out.println("2 <- Change the Stake");
        System.out.println("1 <- Play Slot");
        System.out.println("-1 <- Back to Main List");
        MenuSlotsSelection(-1, 3);
    }

    public void runSlot() {
        //change the balance of the player
        doStake();
        setCurrentGeneration();
        showSlot();
        if (checkWin()) {
            double total = getPlayer().getMultiplier() * getPlayer().getCurrentStake();
            getPlayer().setBalance(getPlayer().getBalance() + total);
            winnerMessage();
        }
        resetCurrentGeneration();
    }

    public boolean checkWin() {
        switch (getCurrentGeneration()) {
            case "111":
                getPlayer().setMultiplier(3);
                return true;
            case "222":
                getPlayer().setMultiplier(5);
                return true;
            case "333":
                getPlayer().setMultiplier(10);
                return true;
            default:
                return false;
        }
    }

    public void MenuSlotsSelection(int min, int max) {
        setPlaySlot(getScanner().nextInt());
        while ((playSlot < min || playSlot > max)) {
            System.out.println("Enter the valid code of action!");
            setPlaySlot(getScanner().nextInt());
        }
    }

}
