package Products;

public class HotDrink extends Product {
    private int temperature;
    private int volume;


    public HotDrink(String name, double cost, int volume, int temperature1) {
        super(name, cost);
        this.volume = volume;
        this.temperature = temperature1;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    public HotDrink(String name, double cost) {
        super(name, cost);
    }

    public HotDrink(String name, double cost, int temperature1) {
        super(name, cost);
        temperature = temperature1;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature1) {
        temperature = temperature1;
    }
    @Override
    public String toString() {
        return "Hot drink {" +
                "name='" + super.getName() + '\'' +
                "temperature='" + this.temperature + '\'' +
                ", price=" + super.getPrice() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HotDrink that)) {
            return false;
        }
        return super.getName().equalsIgnoreCase(that.getName())
                && super.getPrice() == that.getPrice()
                && getVolume() == that.getVolume();
    }
}