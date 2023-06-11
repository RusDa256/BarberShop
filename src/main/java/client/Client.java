package client;

import base.ConsoleStrings;
import client.types_of_client.Consumer;
import client.types_of_client.Employee;
import server.InterfaceBarberShop;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Scanner;

public class Client {
    public static final int port = 8080;
    public static final String url = "http://localhost:%d/Barber?wsdl";

    static Scanner scanner = new Scanner(System.in);
    static Employee employee;
    static Consumer consumer;

    public static void main(String[] args) throws Exception {
        Service service = Service.create(new URL(String.format(url, port)), new QName("http://server/","BarberShopService"));
        InterfaceBarberShop proxy = service.getPort(new QName("http://server/", "BarberShopPort"),InterfaceBarberShop.class);

        if(getRole()) {
            employee = new Employee(proxy);
        } else {
            consumer = new Consumer(proxy);
        }
    }

    static boolean getRole() {
        System.out.println(ConsoleStrings.WHO_ARE_YOU);
        System.out.println(ConsoleStrings.SET_EMPLOYEE);
        System.out.println(ConsoleStrings.SET_CLIENT);
        String role = scanner.nextLine();
        if(role.equals(ConsoleStrings.EMPLOYEE)) {
            return false;
        } else if (role.equals(ConsoleStrings.CLIENT)) {
            return true;
        } else {
            return getRole();
        }
    }
}
