package Main;

import java.awt.*;

public class RouletteManager extends RouletteGameProcess{
    public RouletteManager(Player player) {
        super(player);
    }

    public void managmentStake(){
        switch (getTypeStake()){
            case -1:
                setIsGame(false);
                setTypeStake(0);
                break;
            case 0:
                menuStake();
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
                if (getTypeStake() != 6) managmentStake();
                else StakeAndResult();
                break;
        }
    }

    public void StakeAndResult(){
        doStake();
        if (getPlayer().getCurrentStake() == -1) {
            setTypeStake(0);
            managmentStake();
        }
        else if (!getIsGame()){
            setTypeStake(-1);
            managmentStake();
        }
        else gameResult();
    }
}
