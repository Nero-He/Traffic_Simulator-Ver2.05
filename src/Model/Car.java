package Model;

public class Car extends Vehicle{
    public Car(String id, Road currentRoad){
        super(currentRoad);
        this.id = "Car_" +id);
        setLength(super.getLength());
        breadth = length / 2;
        position = -length;
    }
}
