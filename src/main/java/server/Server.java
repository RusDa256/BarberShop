package server;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Server {
    public static final int port = 8080;
    public static final String url = "http://localhost:%d/Barber";


    public static void main(String[] args) {
        BarberShop server = new BarberShop();
        Endpoint.publish(String.format(url,port),server);
    }
}
