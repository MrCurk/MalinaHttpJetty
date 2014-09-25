package mr.curk.webUndertow;


import io.undertow.Undertow;

import static io.undertow.Handlers.path;

public class UndertowServer {


    public static void main(final String[] args) {


        Undertow.Builder builder = Undertow.builder();
        builder.addHttpListener(8888, "localhost");

        builder.setHandler(path().addPrefixPath("/aaa", new MyUndertowHandler()).addPrefixPath("/ccc", new MyUndertowHandler1()));



        Undertow server = builder.build();
        server.start();


    }


}