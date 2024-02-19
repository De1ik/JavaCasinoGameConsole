package Main;

public class RouletteGameProcess extends Roulette{
    static String colourNumber;
    private int typeStake;
    private int EvenOdd;
    private int RedBlackGreen;
    private int exactNumberStake;
    //    private int multiplier;
    private int resultNumber;
    private int resultRedBlackGreen;
    private int resultEvenOdd;

    public RouletteGameProcess(Player player) {
        super(player);
        setTypeStake(0);
    }


    public int getTypeStake() {
        return typeStake;
    }

    public void setTypeStake(int typeStake) {
        this.typeStake = typeStake;
    }

    public int getEvenOdd() {
        return EvenOdd;
    }

    public void setEvenOdd(int evenOdd) {
        EvenOdd = evenOdd;
    }

    public int getRedBlackGreen() {
        return RedBlackGreen;
    }

    public void setRedBlackGreen(int redBlackGreen) {
        RedBlackGreen = redBlackGreen;
    }

    public void menuStake(){
        show_field();
        System.out.println("You can make different stakes: ");
        System.out.println("1 <- Even number (2x)");
        System.out.println("2 <- Odd number (2x)");
        System.out.println("3 <- Red cell (2x)");
        System.out.println("4 <- Black cell (2x)");
        System.out.println("5 <- Green cell (36x)");
        System.out.println("6 <- Exact number (36x)");
        System.out.println("-1 <- Back to Main List");
        MenuGameSelection(0, 6);
    }

    public void MenuGameSelection(int min, int max) {
        typeStake = getScanner().nextInt();
        while ((typeStake < min || typeStake > max) && typeStake != -1){
            System.out.println("Enter the valid code of action!");
            typeStake = getScanner().nextInt();
        }
    }

    public void exactNumber(){
        System.out.println("Select the cell: ");
        System.out.println("-1 <- Go back");
        exactNumberStake = getScanner().nextInt();
        while (exactNumberStake < -1 || exactNumberStake > 36){
            System.out.println("Invalid number of cell");
            exactNumberStake = getScanner().nextInt();
        }
        if (exactNumberStake == -1){
            typeStake = 0;
        }
    }

    public void generateResult(){
        resultNumber = (int) (Math.random() * 37);
        //set resultEvenOdd
        if (resultNumber % 2 == 0) resultEvenOdd = 1;
        else resultEvenOdd = 2;

        //set resultRedBlackGreen
        if (getColours(resultNumber).equals("Red")) {
            resultRedBlackGreen = 1;
            colourNumber = Red;
        }
        else if (getColours(resultNumber).equals("Black")) {
            resultRedBlackGreen = 2;
            colourNumber = Cyan;
        }
        else {
            resultRedBlackGreen = 3;
            colourNumber = Green;
        }
    }

    public void gameResult(){
        generateResult();
        resultMessage();
        if (RedBlackGreen == resultRedBlackGreen || EvenOdd == resultEvenOdd || exactNumberStake == resultNumber){
            increaseBalance();
            winnerMessage();
        }
        else {
            loseMessage();
        }
        EvenOdd = -1;
        RedBlackGreen = -1;
        exactNumberStake = -1;

        gameAgain();
    }

    public void resultMessage(){
        show_field();
        System.out.println("The current number is: " + colourNumber + " " + resultNumber);
    }

    public void gameAgain(){
        System.out.println("0 <- Play Again");
        System.out.println("-1 <- Main Menu");
        MenuGameSelection(-1, 0);
    }
}
