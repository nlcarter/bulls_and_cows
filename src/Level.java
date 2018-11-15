public abstract class Level {

    int bullCount; //Creating an instance variable to count the number of Bulls for each guess
    int cowCount; //Creating an instance variable to count the number of Cows for each guess
    int turns; //Creating an instance variable to count the number of turns during each game
    String compCode;
    String playerCode;

    public Level(int bullCount, int cowCount, int turns, String compCode, String playerCode){
        this.bullCount = bullCount;
        this.cowCount = cowCount;
        this.turns = turns;
        this.compCode = compCode;
        this.playerCode = playerCode;
    }

    public Level(){

    }

    Code comp = new Computer();
    Code player = new Player();

    public abstract void playGame (String compCode, String playerCode);

    int getBulls(String compCode, String playerCode){
        int countBulls = 0;
        int i = 0;
        while(i < compCode.length() && i < playerCode.length()){
            if(compCode.charAt(i) == playerCode.charAt(i)){
                countBulls++;
            }
            i++;
        }
        return countBulls;
    }

    int getCowCount (String compCode, String playerCode){
        cowCount = 0;
        bullCount = 0;
        for (int i = 0; i < compCode.length(); i++){
            if (compCode.charAt(i) == playerCode.charAt(i)){
                bullCount++;
            } else {
                for (int j = 0; j < playerCode.length(); j++){
                    if (compCode.charAt(i) == playerCode.charAt(j)){
                        cowCount++;
                    }
                }
            }
        }
        return cowCount;
    }

}
