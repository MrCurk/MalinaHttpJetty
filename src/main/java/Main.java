import mr.curk.piface.KeybordInput;
import mr.curk.piface.PiFaceLogic;
import mr.curk.webJetty.SimpleServer;
import mr.curk.webJettyResteasy.HttpServer;

public class Main {


    public static void main(String[] args) {
        int port = 8888;
        PiFaceLogic pi;
        HttpServer httpServer;
        KeybordInput commands;


        //pi = new PiFaceLogic();



        new Thread(new HttpServer(port)).start();


        //new Thread(new SimpleServer(port,pi)).start();
        //commands = new KeybordInput(pi);
        //new Thread(pi).start();
        //new Thread(commands).start();


    }
}
