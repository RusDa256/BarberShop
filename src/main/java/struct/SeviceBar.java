package struct;

public class SeviceBar {
    private int id;
    private String name;
    private int duration;
    private int price;

    public SeviceBar(String name, int duration, int price, int id) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }
    public int getDuration() {
        return duration;
    }
    public String getName() {
        return name;
    }
    public int getId() {return id;}
}
