import org.eclipse.jetty.server.Server;

public class SimpleServer {
    Server server;

    public SimpleServer(int port, PiFaceLogic p) {

        try {
            server = new Server(port);
            server.setHandler(new MyHandler(p));
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
