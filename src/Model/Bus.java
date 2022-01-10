package Model;

public class Bus extends Car {

    public Bus(String id， Road currentRoad) {
        super(currentRoad);
        this.id = ("bus_" + id);
        Car.length = super.getLength() * 3;
        setLength(super.getLength() *3);
        position = -length;
    }

}
