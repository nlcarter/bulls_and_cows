import java.util.*;

public class Hard extends Level {

    @Override
    public void playGame(String compCode, String playerCode, int userTurns) {

        Set<String> codeSet = new HashSet<>();
        while (codeSet.size() < 5040){
            codeSet.add(comp.getCode(""));
        }
        List<String> compGuessList = new ArrayList<>(codeSet);
        Collections.shuffle(compGuessList);

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

            int random = (int) (Math.random() * (compGuessList.size()));
            String compGuess = compGuessList.get(random);
            for (int i = 0; i < compGuess.length(); i++){
                if (playerCode.charAt(i) == compGuess.charAt(i)) {
                    int finalI = i;
                    compGuessList.removeIf(n -> (n.charAt(finalI) != playerCode.charAt(finalI)));
                } else {
                    for (int j = 0; j < compGuess.length(); j++){
                        if (playerCode.charAt(i) == compGuess.charAt(j)){
                            int finalI = i;
                            int finalJ = j;
                            compGuessList.removeIf(n -> (n.charAt(finalJ) == playerCode.charAt(finalI)));
                        }
                    }
                }
            }

            if (compGuessList.contains(compGuess)){
                compGuessList.remove(compGuess);
            }

            System.out.println("List size remaining = " + compGuessList.size());
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
