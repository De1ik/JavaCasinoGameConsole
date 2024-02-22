package Games.Roulette;

import Player.Player;

public class RouletteManager extends RouletteGameProcess {
    public RouletteManager(Player player) {
        super(player);
    }

    public void managerGame(){
        switch (getTypeStake()){
            case -1:
                setIsGame(-1);
                setTypeStake(0);
                break;
            case 1:
                getPlayer().setMultiplier(2);
                setEvenOdd(1);
                StakeAndResult();
                break;
            case 2:
                getPlayer().setMultiplier(2);
                setEvenOdd(2);
                StakeAndResult();
                break;
            case 3:
                getPlayer().setMultiplier(2);
                setRedBlackGreen(1);
                StakeAndResult();
                break;
            case 4:
                getPlayer().setMultiplier(2);
                setRedBlackGreen(2);
                StakeAndResult();
                break;
            case 5:
                getPlayer().setMultiplier(36);
                setRedBlackGreen(3);
                StakeAndResult();
                break;
            case 6:
                getPlayer().setMultiplier(36);
                exactNumber();
                if (getTypeStake() != 6) managerGame();
                else StakeAndResult();
                break;
            case 7:
                getPlayer().showBalance();
                menuGame();
                break;
            case 8:
                setCurrentStakeConstant();
                menuGame();
                break;
            default:
                menuGame();
        }
    }

    public void StakeAndResult(){
        if (doStake()){
            if (getPlayer().getCurrentStake() == -1) {
                setTypeStake(0);
                managerGame();
            }
            else if (getIsGame() != 1){
                setTypeStake(-1);
                managerGame();
            }
            else runCurrentGame();
        }
        else menuGame();
    }
}
