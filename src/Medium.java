import java.util.*;

public class Medium extends Level {

    Set<String> codeSet;

    @Override
    public void playGame(String compCode, String playerCode, int userTurns) {

        //Create a set of codes that contain the 5040 unique four-digit codes. The computer will then select a code
        //from this list each time, ensuring it will not pick the same code multiple times

        codeSet = new HashSet<>();
        while (codeSet.size() < 5040){
            codeSet.add(comp.getCode(""));
        }
        List<String> compGuessList = new ArrayList<>(codeSet);
        Collections.shuffle(compGuessList);

        turns = 1;
        int count = 0;

        while (turns <= userTurns) {

            String userGuess = player.getCode("Round " + turns + " of " + userTurns + " - Try to guess the computer's four digit code: ");
            System.out.println("You guessed " + userGuess);
            bullCount = getBulls(compCode, userGuess);
            cowCount = getCowCount(compCode, userGuess);
            System.out.println("Player Bulls: " + bullCount);
            System.out.println("Player Cows: " + cowCount);
            if (bullCount == 4){
                System.out.println("Four Bulls! You win");
                break;
            }
            String compGuess = compGuessList.get(count);
            count++;
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
