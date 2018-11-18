public class Easy extends Level {

    @Override
    public void playGame(String compCode, String playerCode) {

        turns = 1;

        while (turns < 8) {

            String userGuess = player.getCode("Round " + turns + " of 7 - Try to guess the computer's four digit code: ");
            System.out.println("You guessed " + userGuess);
            bullCount = getBulls(compCode, userGuess);
            cowCount = getCowCount(compCode, userGuess);
            System.out.println("Player Bulls: " + bullCount);
            System.out.println("Player Cows: " + cowCount);
            if (bullCount == 4){
                System.out.println("Four Bulls! You win");
                break;
            }
            String compGuess = comp.getCode("");
            System.out.println("The computer guessed " + compGuess);
            bullCount = getBulls(compGuess, playerCode);
            cowCount = getCowCount(compGuess, playerCode);
            System.out.println("Computer Bulls: " + bullCount);
            System.out.println("Computer Cows: " + cowCount);
            if (bullCount == 4){
                System.out.println("Four Bulls! The computer wins");
                break;
            }
            turns++;
        }

    }
}
