package mr.curk.webUndertow;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.util.HttpString;


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

        setHtmlPage(exchange.getRequestMethod());
        exchange.getResponseSender().send(htmlPage);
    }

    private void setHtmlPage(HttpString s) {
        htmlPage = "Hello my friend <br>" + s;
    }



}
