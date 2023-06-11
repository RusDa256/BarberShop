package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface InterfaceBarberShop {
    @WebMethod
    int getId();

    @WebMethod
    int addNewService(String name, int dur, int price);

    @WebMethod
    Boolean deleteServiceById(int id);

    @WebMethod
    String[] getAllService();

    @WebMethod
    String[] getTimeOfMaster(int day);

    @WebMethod
    String checkTimeAndDuration(int day, int time, int idOfRec);

    @WebMethod
    int makeRec(int day, int time, int idOfRec, int idOfClient);

    @WebMethod
    boolean deleteRec(int idOfRec);

    @WebMethod
    String[] getRecordsById(ArrayList<Integer> listId);
}
