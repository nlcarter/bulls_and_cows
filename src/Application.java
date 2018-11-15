public class Application {



    public void start(){

//        Computer comp = new Computer();
//        String code = comp.getCode();
//        System.out.println(code);

        Player player = new Player();
        String code = player.getCode();
        System.out.println(code);


    }


    public static void main(String []args){
        Application a = new Application();
        a.start();
    }

}
