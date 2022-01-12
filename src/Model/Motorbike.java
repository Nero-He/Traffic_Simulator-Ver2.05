package Model;

public class Motorbike extends Vehicle {

    public Motorbike(String id, Road, Road currentRoad){
        super(currentRoad);
        this.id = ("Model.Motorbike" + id);
        setLength(super.getLength() / 1);
        breadth = super.getBreadth() / 1;
        position = -length;
    }
}
