package mr.curk.webJettyResteasy;

import mr.curk.piface.PiFaceLogic;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


public class RestEasyServices extends Application {
    private static Set services = new HashSet();


    public RestEasyServices() {
        // initialize restful services
        services.add(new Page());
    }

    public RestEasyServices(PiFaceLogic pi) {
        // initialize restful services
        services.add(new Page(pi));
    }

    @Override
    public Set getSingletons() {
        return services;
    }

    public static Set getServices() {
        return services;
    }
}