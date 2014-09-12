import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        int port = 8888;
        PiFaceLogic pi;
        SimpleServer myHttpServer;
        KeybordInput commands;

        try {

            pi = new PiFaceLogic();

            myHttpServer = new SimpleServer(port,pi);

            commands = new KeybordInput(pi);

            new Thread(pi).start();
            new Thread(commands).start();
            new Thread(myHttpServer).start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
