package mr.curk.webUndertow;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.util.HttpString;


public class MyUndertowHandler1 implements HttpHandler {
    private final HttpString header;
    private final String value;
    private final HttpHandler next;

    public MyUndertowHandler1() {
        this.header = Headers.CONTENT_TYPE;
        this.value = "text/html";
        this.next = null;
    }

    public MyUndertowHandler1(final HttpHandler next) {
        this.header = Headers.CONTENT_TYPE;
        this.value = "text/html";
        this.next = next;
    }

    public MyUndertowHandler1(final HttpHandler next, final String header, final String value) {
        this.header = new HttpString(header);
        this.value = value;
        this.next = next;
    }


    @Override
    public void handleRequest(final HttpServerExchange exchange) throws Exception {

        exchange.getResponseHeaders().put(header, value);
        exchange.getResponseSender().send("Hello World My Friend111111111111111111");
    }


}
