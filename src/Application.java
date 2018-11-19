import java.util.*;

public class Application {

    private static final int EASY = 1;
    private static final int MEDIUM = 2;
    private static final int HARD = 3;

    private static final int YES = 1;
    private static final int NO = 2;

    private int level;
    private int replay;
    private int turns;

    /* The start() method acts as the main method, and calls the various other classes depending on what level is selected */

    public void start(){

        Computer comp = new Computer();
        Player player = new Player();
        Level easy = new Easy();
        Level medium = new Medium();
        Level hard = new Hard();

        //Game set up
        System.out.println("--- Welcome to Bulls and Cows! ---");
        int gameOption = gameSetUp();

        if (gameOption == 1){
            String computerCode = comp.getCode("");
//            System.out.println("C: " + computerCode);
            System.out.println("--------------");
            String playerCode = player.getCode("Please enter a unique four digit secret code: ");
            System.out.println("--- Your secret code is: " + playerCode + " ---");
            level = levelSelection();
            turns = getTurns();
            if (level == 1){
                System.out.println("--------------");
                easy.playGame(computerCode, playerCode, turns);
                replay = replayGame();
                if (replay == 1){
                    start();
                }
            } else if (level == 2){
                medium.playGame(computerCode, playerCode, turns);
                replay = replayGame();
                if (replay == 1){
                    start();
                }
            } else if (level == 3){
                hard.playGame(computerCode, playerCode, turns);
                replay = replayGame();
                if (replay == 1){
                    start();
                } else {
                    System.exit(0);
                }
            }
        } else if (gameOption == 2){
            gameInstructions();
            start();
        } else if (gameOption == 3){
            System.exit(0);
        }
    }

    /* gameSetUp() returns an integer, which is used to determine if the game should start, go to the gameInstructions()
    * method or exits the program*/

    private int gameSetUp(){
        System.out.println(" Enter 1 to start game or, \n Enter 2 to get instructions on how to play or, \n Enter 3 to exit the game \n--------------");
        String response = Keyboard.readInput();
        int choice = 0;

        try {
            choice = Integer.parseInt(response);
            if (choice >= 1 && choice <= 3) {
                return choice;
            } else {
                System.out.println("Please enter a valid option: ");
                return gameSetUp();
            }
        } catch (NumberFormatException e){
            System.out.println("Please enter a valid option: ");
            return gameSetUp();
        }
    }

    /* levelSelection() returns an integer, which is used to determine which level of game should be played */

    private int levelSelection (){

        System.out.println("Please select the level you would like to play: \n 1. Easy \n 2. Medium \n 3. Hard \n--------------");

        String choice = Keyboard.readInput();
        level = 0;

        try {
            level = Integer.parseInt(choice);
            if (level >= 1 && level <= 3){
                return level;
            } else {
                System.out.println("Please enter a valid option: ");
                return levelSelection();
            }
        }catch (NumberFormatException e){
            if (choice.equalsIgnoreCase("easy")) {
                return EASY;
            } else if (choice.equalsIgnoreCase("medium")){
                return MEDIUM;
            } else if (choice.equalsIgnoreCase("hard")){
                return HARD;
            } else {
                System.out.println("Please enter a valid option: ");
                return levelSelection();
            }
        }
    }

    /* getTurns() returns an integer, which is used to determine how many rounds of the game should be played */

    private int getTurns () {
        System.out.print("How many rounds would you like to play (choose between 5 and 15): ");
       turns = Integer.parseInt(Keyboard.readInput());
        if (turns  < 5 || turns > 15) {
            System.out.print("You can not choose less than 5 or more than 15 rounds - ");
            return getTurns();
        }
        return turns;
    }

    /* gameInstructions() prints out a list of instructions if the method is called */

    private void gameInstructions (){
        System.out.println("The aim of Bulls and Cows is to get four bulls:");
        System.out.println("\t - Choose which level to play (easy, medium or hard) and how many rounds you want the game to be (from 5 to 15).");
        System.out.println("\t - Enter in a four digit secret code - all four digits must be unique.");
        System.out.println("\t - Now try to guess the computer's random four digit code.");
        System.out.println("\t - If you guess a number that is in the code and in the correct position, you will get one bull.");
        System.out.println("\t - If you guess a number that is in the code but it is not in the correct position, you will get one cow.");
        System.out.println("\t - Each round, the computer will also try and guess your secret code. If you get to four bulls first, you win the game.");
        System.out.println("\t - If at the end of the rounds, neither you nor the computer has four bulls, the game will end in a tie.");
        System.out.println("Enter any key to return to the start menu: ");
        Keyboard.readInput();

    }

    /* replayGame() returns an integer, which is used to determine if the game should be replayed, or if the program
     * should exit */

    private int replayGame (){

        System.out.println("Would you like to play again: \n 1. Yes \n 2. No");

        String choice = Keyboard.readInput();
        replay = 0;

        try {
            replay = Integer.parseInt(choice);
            if (replay == 1 || replay == 2){
                return replay;
            } else {
                System.out.println("Please enter a valid option: ");
                return replayGame();
            }
        }catch (NumberFormatException e){
            if (choice.equalsIgnoreCase("yes")) {
                return YES;
            } else if (choice.equalsIgnoreCase("no")){
                return NO;
            } else {
                System.out.println("Please enter a valid option: ");
                return replayGame();
            }
        }

    }

    public static void main(String []args){
        Application a = new Application();
        a.start();
    }

}
