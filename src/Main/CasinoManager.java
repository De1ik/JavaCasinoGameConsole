package Main;

public class CasinoManager extends Casino{

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
                rouletteManager.setIsGame(true);
                while(rouletteManager.getIsGame()){
                    rouletteManager.managmentStake();
                }
                Menu();
                break;
            default:
                Menu();

        }
    }
}
