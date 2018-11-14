public class Application {



    public void start(){

        System.out.println("Guess a number: ");

        String guess = Keyboard.readInput();

        System.out.println(guess);

    }


    public static void main(String []args){
        Application a = new Application();
        a.start();
    }

}
