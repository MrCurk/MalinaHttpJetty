import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyHandler extends AbstractHandler{
    PiFaceLogic p;

    public MyHandler(PiFaceLogic p) {
        this.p = p;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<h1> Hello my friend</h1>");
        response.getWriter().println("<h2>");
        response.getWriter().print(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        response.getWriter().println("</h2>");

        response.getWriter().println(p.getStatusInputOutput(0));
        response.getWriter().println(p.getStatusInputOutput(1));
        response.getWriter().println(p.getStatusInputOutput(2));
        response.getWriter().println(p.getStatusInputOutput(3));
        response.getWriter().println(p.getStatusInputOutput(4));
        response.getWriter().println(p.getStatusInputOutput(5));
        response.getWriter().println(p.getStatusInputOutput(6));
        response.getWriter().println(p.getStatusInputOutput(7));
    }
}
