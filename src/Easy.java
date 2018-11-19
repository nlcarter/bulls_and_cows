import java.util.Arrays;

public class Easy extends Level {

    @Override
    public void playGame(String compCode, String playerCode, int userTurns) {

        turns = 1;

        while (turns <= userTurns) {

            String userGuess = player.getCode("Round " + turns + " of " + userTurns + " - Try to guess the computer's four digit code: ");
            bullCount = getBulls(compCode, userGuess);
            cowCount = getCowCount(compCode, userGuess);
            System.out.println("- You guessed " + userGuess + ", which scored " + bullCount + " Bulls and " + cowCount+ " Cows.");
            if (bullCount == 4){
                System.out.println("Four Bulls! You guessed the computer's secret code (" + compCode + ") and win the game.");
                break;
            }
            String compGuess = comp.getCode("");
            bullCount = getBulls(compGuess, playerCode);
            cowCount = getCowCount(compGuess, playerCode);
            System.out.println("- The computer guessed " + compGuess + ", which scored " + bullCount + " Bulls and " + cowCount+ " Cows.");
            if (bullCount == 4){
                System.out.println("Four Bulls! The computer guessed your secret code (" + playerCode + ") and win the game.");
                break;
            }
            turns++;
            System.out.println("--------------");
            if (turns == userTurns + 1) {
                System.out.println("It's a tie! Neither you nor the computer were able to guess the number of bulls and cows - the computer's secret code was: " + compCode);
                System.out.println("-----------------------------------");
            }
        }

    }
}
