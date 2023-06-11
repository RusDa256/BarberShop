package client.types_of_client;

import base.ConsoleStrings;
import server.InterfaceBarberShop;
import java.util.Scanner;

public class Employee {
    static Scanner scanner = new Scanner(System.in);
    static int id;
    static InterfaceBarberShop proxy;

    public Employee(InterfaceBarberShop proxy) {
        this.proxy = proxy;

        id = proxy.getId();
        System.out.println(ConsoleStrings.CONNECT_SUCCESS + id + "\n");
        playEmployee();
    }

    static void playEmployee() {
        System.out.println("\n");
        System.out.println(ConsoleStrings.EMPLOYEE_BIG);
        while(true) {
            System.out.println(ConsoleStrings.CHOOSE_MOVE);
            System.out.println(ConsoleStrings.ADD_SERVICE);
            System.out.println(ConsoleStrings.DELETE_SERVICE_BY_ID);
            System.out.println(ConsoleStrings.GET_ALL_SERVICE);
            int in = scanner.nextInt();
            switch (in) {
                case 1:
                    scanner.nextLine();
                    System.out.println(ConsoleStrings.INPUT_NAME_SERVICE);
                    String name = scanner.nextLine();
                    System.out.println(ConsoleStrings.INPUT_DURATION_SERVICE);
                    int dur = scanner.nextInt();
                    System.out.println(ConsoleStrings.INPUT_PRICE_SERVICE);
                    int price = scanner.nextInt();
                    System.out.println(ConsoleStrings.GET_ID_NEW_SERVICE + proxy.addNewService(name,dur, price));
                    break;
                case 2:
                    System.out.println(ConsoleStrings.INPUT_ID_SERVICE);
                    int id = scanner.nextInt();
                    if(proxy.deleteServiceById(id)) {
                        System.out.println(ConsoleStrings.DELETE_SERVICE_SUCCESS);
                    } else {
                        System.out.println(ConsoleStrings.ERROR_INDEX_SERVICE);
                    }
                    break;
                case 3:
                    String allServices[] = proxy.getAllService();
                    for (int i = 0; i < allServices.length; i++){
                        System.out.println(ConsoleStrings.SEPARATOR_RED);
                        System.out.println(allServices[i]);
                    }
                    System.out.println(ConsoleStrings.SEPARATOR_RED);
                    break;
            }
        }
    }
}
