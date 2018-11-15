public class Application {


    public void start(){

        Computer comp = new Computer();
        Player player = new Player();
        Level easy = new Easy();


        //Game set up
        System.out.println("Welcome to Bulls and Cows!");
        int gameOption = gameSetUp();


        if (gameOption == 1){
            //Gets the random computer code that is used for the game
            String computerCode = comp.getCode("");
            System.out.println("C: " + computerCode);
            //Gets the user's secret four digit code (that the computer will try guess)
            String playerCode = player.getCode("Please enter a unique four digit code: ");
            System.out.println("P: " + playerCode);
            easy.playGame(computerCode, playerCode);
        } else if (gameOption == 2){
            int startMenu = gameInstructions();
            if (startMenu == 1){
                start();
            }
        } else if (gameOption == 3){
            System.exit(0);
        }
    }

    private int gameSetUp(){
        System.out.println(" Enter 1 to start game or, \n Enter 2 to get instructions on how to play or, \n Enter 3 to exit the game");
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

    private int gameInstructions (){
        System.out.println("The aim of Bulls and Cows is to get four bulls:");
        System.out.println("\t - Choose which level to play (easy, medium or hard) and how many rounds you want the game to be (from 5 to 15).");
        System.out.println("\t - Enter in a four digit secret code - all four digits must be unique.");
        System.out.println("\t - Now try to guess the computer's random four digit code");
        System.out.println("\t - If you guess a number that is in the code and in the correct position, you will get one bull.");
        System.out.println("\t - If you guess a number that is in the code but it is not in the correct position, you will get one cow.");
        System.out.println("\t - Each round, the computer will also try and guess your secret code. If you get to four bulls first, you win the game");
        System.out.println("\t - If at the end of the rounds, neither you nor the computer has four bulls, the game will end in a tie");
        System.out.println("Enter any key to return to the start menu: ");
        Keyboard.readInput();
        return 1;
    }


    public static void main(String []args){
        Application a = new Application();
        a.start();
    }

}
