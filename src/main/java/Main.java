import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        PiFaceLogic p;
        int port = 8888;

        try {

            p = new PiFaceLogic();
            new Thread(p).start();
            new KeybordInput(p);
            new SimpleServer(port, p);

        } catch (IOException e) {
            System.out.println("Error on PiFaceLogic");
            e.printStackTrace();
        }


    }
}
