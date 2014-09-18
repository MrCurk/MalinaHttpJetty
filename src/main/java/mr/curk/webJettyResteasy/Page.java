package mr.curk.webJettyResteasy;

import mr.curk.piface.PiFaceLogic;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Path("/")
public class Page {
    private String headTitle = "RaspberryPi Control Center";
    private String head;
    private String body;
    private PiFaceLogic pi;

    public Page() {
    }

    public Page(PiFaceLogic pi) {
        this.pi = pi;
    }


    @GET
    @Produces("text/html")
    public Response index() throws URISyntaxException {
        //index.html page from file
        //File f = new File(System.getProperty("user.dir")+"/index.html");
        //String mt = new MimetypesFileTypeMap().getContentType(f);
        //return Response.ok(f, mt).build();
        head = getHead(headTitle, false, null);
        body = getBody();
        return Response.status(200).entity(head + body+"Front Page").build();
    }


    @GET
    @Path("/hello")
    public Response helloGet() {
        return Response.status(200).entity("HTTP GET method called Hello").build();
    }

    @GET
    @Path("/status")
    public Response autoRefresh(@QueryParam("refreshTime") String refreshTime,@QueryParam("inputPin") String inputPin) {
        head = getHead(headTitle, true, refreshTime);
        body = getBody();
        return Response.status(200).entity(head + body + inputPin).build();
    }

    @POST
    @Path("/hello")
    public Response helloPost() {
        System.out.println("aaaaa");
        return Response.status(200).entity("HTTP POST method called").build();
    }


    private String getHead(String title, boolean avtoRefresh, String seconds) {
        if (avtoRefresh) {
            return "<head><title>" + title + "</title><meta http-equiv=\"refresh\" content=\"" + seconds + "\"></head>";
        } else {
            return "<head><title>" + title + "</title></head>";
        }

    }

    private String getBody() {
        return "<body><h1>RaspberryPi</h1><br><h2>" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) + "</h2></body>";
    }
}
