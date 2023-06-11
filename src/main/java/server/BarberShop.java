package server;

import base.ConsoleStrings;
import struct.Record;
import struct.SeviceBar;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebService
public class BarberShop implements InterfaceBarberShop{
    static int IdOfService = 0;
    static int CountOfClients = 0;
    static int CountOfRecords = 0;
    static ArrayList<SeviceBar> Services = new ArrayList<>();
    static ArrayList<Record> Records = new ArrayList<>();
    static Map<Integer, Boolean> TimeOfMaster;
    static ArrayList<Map<Integer, Boolean>> Calendar = new ArrayList<>();

    static final int firstHour = 10;
    static final int lastHour = 19;
    static final int sizeCalendar = 28;

    public BarberShop () {
        setDefaultServices();
        setCalendar();
    }

    @Override
    public String[] getTimeOfMaster(int day) {
        String[] answer = new String[Calendar.get(day).size()];
        for(int i = firstHour; i < lastHour;i++){
            boolean isFree = Calendar.get(day).get(i);
            if(isFree) {
                answer[i - firstHour] = i + ":00 " + "[СВОБОДНО]";
            } else {
                answer[i - firstHour] = i + ":00 " + "[ЗАНЯТО]";
            }
        }
        return answer;
    }

    @Override
    public int getId() {
        return CountOfClients++;
    }

    @Override
    public int addNewService(String name, int dur, int price) {
        SeviceBar tmp = new SeviceBar(name, dur, price, IdOfService);
        Services.add(tmp);
        return IdOfService++;
    }

    @Override
    public String[] getAllService() {
        String[] res = new String[Services.size()];
        for(int i = 0; i < Services.size(); i++){
            SeviceBar tmp = Services.get(i);
            res[i] = "id: " + tmp.getId() + ", услуга: " + tmp.getName() +
                    ", длительность: " + tmp.getDuration() + ", цена: " + tmp.getPrice();
        }
        return res;
    }

    @Override
    public Boolean deleteServiceById(int id) {
        try{
            Services.remove(id);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public String checkTimeAndDuration(int day, int time, int idOfRec) {
        int durOfService;
        for(int i = 0; i < Services.size(); i++) {
            if(idOfRec == Services.get(i).getId()) {
                durOfService = Services.get(i).getDuration();
                if(lastHour - time >= durOfService) {
                    for(int j = time; j < time + durOfService; j++) {
                        if(!Calendar.get(day).get(j)){
                            return ConsoleStrings.TIME_IS_BUSY;
                        }
                    }
                    return ConsoleStrings.OK;
                }
                return ConsoleStrings.ERROR_TIME;
            }
        }
        return ConsoleStrings.ERROR_SERVICE;
    }

    @Override
    public int makeRec(int day, int time, int _idOfService, int idOfClient) {
        int duration = 0;
        String name = null;

        for(int i = 0; i < Services.size(); i++) {
            if(_idOfService == Services.get(i).getDuration()) {
                duration = Services.get(i).getDuration();
                name = Services.get(i).getName();
                break;
            }
        }
        for(int i = time; i < time + duration; i++) {
            Calendar.get(day).put(i, false);
        }
        Records.add(new Record(CountOfRecords, day, name, duration, time, idOfClient));
        return CountOfRecords++;
    }

    @Override
    public boolean deleteRec(int idOfRec) {
        for(int i = 0; i < Records.size(); i++) {
            Record curRec = Records.get(i);
            if(idOfRec == curRec.getId()) {
                for(int j = curRec.getStartTime(); j < curRec.getStartTime() + curRec.getDuration(); j++) {
                    Calendar.get(curRec.getDayOfCalendar()).put(j, true);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] getRecordsById(ArrayList<Integer> listId) {
        String[] res = new String[Records.size()];

        for(int i = 0; i < listId.size(); i++){
            for(int j = 0; j < Records.size(); j++){
                Record tmp = Records.get(j);
                if(listId.get(i) == tmp.getId()){
                    res[i] = "id - [" + tmp.getId() + "], услуга - " + tmp.getName() +
                            ", день - " + tmp.getDayOfCalendar() + ", время - " + tmp.getStartTime() + ":00";
                    break;
                }
            }
        }
        return res;
    }

    static void setDefaultServices() {
        Services.add(new SeviceBar("Покраска", 1,400, IdOfService));
        IdOfService++;
        Services.add(new SeviceBar("Укладка", 1,250, IdOfService));
        IdOfService++;
        Services.add(new SeviceBar("Стрижка+Укладка", 2,850, IdOfService));
        IdOfService++;
    }

    static void setTimeOfMaster() {
        TimeOfMaster = new HashMap<>();
        for(int i = firstHour; i < lastHour; i++){
            TimeOfMaster.put(i, true);
        }
    }

    static void setCalendar() {
        for(int i = 0; i < sizeCalendar; i++){
            setTimeOfMaster();
            Calendar.add(TimeOfMaster);
        }
    }
}
