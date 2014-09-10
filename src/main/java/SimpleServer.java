import org.eclipse.jetty.server.Server;

public class SimpleServer {
    Server server;

    public SimpleServer(int port) {

        try {
            server = new Server(port);
            server.setHandler(new MyHandler());
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
