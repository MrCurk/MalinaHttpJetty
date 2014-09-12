import org.eclipse.jetty.server.Server;

public class SimpleServer implements Runnable{
    private Server server;
    private PiFaceLogic pi;

    public SimpleServer(int port, PiFaceLogic pi) {
        this.pi = pi;
        server = new Server(port);
        server.setHandler(new MyHandler(pi));
    }

    @Override
    public void run() {

        startJetty();

        stopJetty();

        pi.doCommand(Command.QUIT);
    }

    private void startJetty() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopJetty(){
        try {
            server.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
