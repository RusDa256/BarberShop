package client.types_of_client;

import base.ConsoleColors;
import base.ConsoleStrings;
import server.InterfaceBarberShop;
import java.util.ArrayList;
import java.util.Scanner;

public class Consumer {
    static Scanner scanner = new Scanner(System.in);
    static int id;
    static ArrayList<Integer> idOfMyRec = new ArrayList<>();
    static InterfaceBarberShop proxy;
    static int dayOfCalendar;

    public Consumer(InterfaceBarberShop proxy) {
        this.proxy = proxy;

        id = proxy.getId();
        System.out.println(ConsoleStrings.CONNECT_SUCCESS + id + "\n");
        playClient();
    }

    static void playClient() {
        System.out.println("\n");
        System.out.println(ConsoleStrings.CLIENT_BIG);
        while(true) {
            System.out.println(ConsoleStrings.CHOOSE_MOVE);
            System.out.println(ConsoleStrings.MAKE_RECORD);
            System.out.println(ConsoleStrings.DELETE_RECORD);
            System.out.println(ConsoleStrings.GET_ALL_SERVICE);
            System.out.println(ConsoleStrings.GET_TIME_MASTER);

            int in = scanner.nextInt();
            switch (in) {
                case 1:
                    getCalendar();
                    System.out.println(ConsoleStrings.CHOOSE_CALENDAR_DAY);
                    dayOfCalendar = scanner.nextInt();

                    System.out.println(ConsoleStrings.INPUT_TIME);
                    int timeOfRec = scanner.nextInt();

                    System.out.println(ConsoleStrings.CHOOSE_ID_SERVICE);
                    int idOfService = scanner.nextInt();

                    String answer = proxy.checkTimeAndDuration(dayOfCalendar, timeOfRec, idOfService);
                    if(answer.equals(ConsoleStrings.OK)) {
                        int idOfRec = proxy.makeRec(dayOfCalendar, timeOfRec, idOfService, id);
                        idOfMyRec.add(idOfRec);
                        System.out.println(ConsoleStrings.MAKE_RECORD_SUCCESS + idOfRec);
                    } else {
                        System.out.println(ConsoleColors.RED + answer + ConsoleColors.RESET);
                    }
                    break;
                case 2:
                    String[] myRec = proxy.getRecordsById(idOfMyRec);
                    for (int i = 0; i < idOfMyRec.size(); i++){
                        System.out.println(myRec[i]);
                    }
                    System.out.println(ConsoleStrings.CHOOSE_ID_RECORD);
                    int idOfRec = scanner.nextInt();
                    if(proxy.deleteRec(idOfRec)) {
                        System.out.println(ConsoleStrings.DELETE_RECORD_SUCCESS);
                        idOfMyRec.remove(idOfRec);
                    } else {
                        System.out.println(ConsoleStrings.RECORD_IS_NOT_DELETE);
                    }
                    break;
                case 3:
                    String allServices[] = proxy.getAllService();
                    for (int i = 0; i < allServices.length; i++) {
                        System.out.println(ConsoleStrings.SEPARATOR_RED);
                        System.out.println(allServices[i]);
                    }
                    System.out.println(ConsoleStrings.SEPARATOR_RED);
                    break;
                case 4:
                    getCalendar();
                    System.out.println(ConsoleStrings.CHOOSE_CALENDAR_DAY);
                    dayOfCalendar = scanner.nextInt();

                    String[] time = proxy.getTimeOfMaster(dayOfCalendar);
                    for(int i = 0; i < time.length; i++) {
                        System.out.println(time[i]);
                    }
                    break;
            }
        }
    }

    private static void getCalendar() {
        System.out.println(ConsoleStrings.SEPARATOR_YELLOW);
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 8; j++) {
                if(i * 7 + j < 10){
                    System.out.print(" " + (i * 7 + j) + " ");
                }else {
                    System.out.print((i * 7 + j) + " ");
                }
            }
            System.out.println();
        }
        System.out.println(ConsoleStrings.SEPARATOR_YELLOW);
    }
}
