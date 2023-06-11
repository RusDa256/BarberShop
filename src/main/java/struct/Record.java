package struct;

public class Record {
    private int id;
    private int dayOfCalendar;
    private String name;
    private int duration;
    private int startTime;
    private int idOfClient;

    public Record(int id, int dayOfCalendar, String name, int duration, int startTime, int idOfClient) {
        this.id = id;
        this.dayOfCalendar = dayOfCalendar;
        this.name = name;
        this.duration = duration;
        this.startTime = startTime;
        this.idOfClient = idOfClient;
    }

    public int getId() {
        return id;
    }
    public int getDayOfCalendar() {return dayOfCalendar;}
    public String getName() {return name;}
    public int getDuration() { return duration; }
    public int getStartTime() {
        return startTime;
    }
    public int getIdOfClient() { return idOfClient; }
}
