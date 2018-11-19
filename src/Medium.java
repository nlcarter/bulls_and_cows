import java.util.*;

public class Medium extends Level {

    /* The Medium playGame() method runs through the selected number of rounds, and each round it will pull a code from
     * a set of codes that contain the 5040 unique four-digit codes. The computer will then select a code from this
     * list each time and remove the previous guess, ensuring it will not pick the same code multiple times */

    @Override
    public void playGame(String compCode, String playerCode, int userTurns) {

        Set<String> codeSet = new HashSet<>();
        while (codeSet.size() < 5040){
            codeSet.add(comp.getCode(""));
        }
        List<String> compGuessList = new ArrayList<>(codeSet);
        Collections.shuffle(compGuessList);

        turns = 1;
        int count = 0;

        while (turns <= userTurns) {

            String userGuess = player.getCode("Round " + turns + " of " + userTurns + " - Try to guess the computer's four digit code: ");
            bullCount = getBulls(compCode, userGuess);
            cowCount = getCowCount(compCode, userGuess);
            System.out.println("- You guessed " + userGuess + ", which scored " + bullCount + " Bulls and " + cowCount+ " Cows.");
            if (bullCount == 4){
                System.out.println("Four Bulls! You guessed the computer's secret code (" + compCode + ") and win the game.");
                break;
            }
            String compGuess = compGuessList.get(count);
            count++;
            bullCount = getBulls(compGuess, playerCode);
            cowCount = getCowCount(compGuess, playerCode);
            compGuessList.remove(compGuess);
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
