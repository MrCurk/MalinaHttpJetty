package mr.curk.webUndertow;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.util.HttpString;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MyUndertowHandler implements HttpHandler {
    private final HttpString header;
    private final String value;
    private final HttpHandler next;
    private String htmlPage;

    public MyUndertowHandler() {
        this.header = Headers.CONTENT_TYPE;
        this.value = "text/html";
        this.next = null;
    }

    public MyUndertowHandler(final HttpHandler next) {
        this.header = Headers.CONTENT_TYPE;
        this.value = "text/html";
        this.next = next;
    }

    public MyUndertowHandler(final HttpHandler next, final String header, final String value) {
        this.header = new HttpString(header);
        this.value = value;
        this.next = next;
    }


    @Override
    public void handleRequest(final HttpServerExchange exchange) throws Exception {

        exchange.getResponseHeaders().put(header, value);

        setHtmlPage(exchange.getRequestMethod(), exchange.getRequestPath().toString(), true, 5);
        exchange.getResponseSender().send(htmlPage);
    }

    private String setHtmlPage(HttpString requestMetode, String title, boolean avtoRefresh, int seconds) {
        if (avtoRefresh) {
            htmlPage = "<head><title>" + title + "</title><meta http-equiv=\"refresh\" content=\"" + seconds + "\"></head>";
        } else {
            htmlPage = "<head><title>" + title + "</title></head>";
        }

        htmlPage = "<html>" + htmlPage + "<body><h1>RaspberryPi</h1><br><h2>" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) + "</h2><p><a href=\"http://localhost:8888/ccc\">Refresh 1 seconds</a></p><p>" + requestMetode + "</p></body><html>";

        return htmlPage;
    }


}
