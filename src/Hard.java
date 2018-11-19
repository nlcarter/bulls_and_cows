import java.util.*;

public class Hard extends Level {

    Set<String> codeSet;

    @Override
    public void playGame(String compCode, String playerCode) {

        codeSet = new HashSet<>();
        while (codeSet.size() < 5040){
            codeSet.add(comp.getCode(""));
        }
        List<String> compGuessList = new ArrayList<>(codeSet);
        Collections.shuffle(compGuessList);

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

            int random = (int) (Math.random() * (compGuessList.size()));
            String compGuess = compGuessList.get(random);
            for (int i = 0; i < compGuess.length(); i++){
                if (playerCode.charAt(i) == compGuess.charAt(i)) {
                    int finalI = i;
                    compGuessList.removeIf(n -> (n.charAt(finalI) != playerCode.charAt(finalI)));
                } else {
                    for (int j = 0; j < compGuess.length(); j++){
                        if (playerCode.charAt(i) == compGuess.charAt(j)){
                            System.out.println("PC i = " + playerCode.charAt(i));
                            System.out.println("CC j = " + compGuess.charAt(j));
                            int finalI = i;
                            int finalJ = j;
                            compGuessList.removeIf(n -> (n.charAt(finalJ) == playerCode.charAt(finalI)));
                        }
                    }
                }
            }

            System.out.println("The computer guessed " + compGuess);
            System.out.println("List size remaining = " + compGuessList.size());
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
