package mr.curk.webJettyResteasy;

import mr.curk.piface.Command;
import mr.curk.piface.PiFaceLogic;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class HttpServer implements Runnable {
    private Server server;
    private PiFaceLogic pi;
    private boolean httpOnly = true;

    public HttpServer(int port) {

        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        ServletHolder h = new ServletHolder(new HttpServletDispatcher());
        h.setInitParameter("javax.ws.rs.Application", "mr.curk.webJettyResteasy.RestEasyServices");

        context.addServlet(h, "/*");
        server.setHandler(context);
   }

    public HttpServer(int port, PiFaceLogic pi) {
        httpOnly = false;
        this.pi = pi;
        new HttpServer(port);
    }

    @Override
    public void run() {
        startJetty();
        stopJetty();
        if (!httpOnly) {
            pi.doCommand(Command.QUIT);
        }
    }

    private void stopJetty() {
        try {
            server.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startJetty() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}