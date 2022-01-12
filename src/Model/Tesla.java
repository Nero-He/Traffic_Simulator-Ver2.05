package Model;

public class Tesla extends Vehicle {
    public Tesla(String id, Road currentRoad){
        super(currentRoad);
        this.id = ("Model.Tesla" + id);
        setLength(super.getLength() * 2);
        breadth = length /2;
        position = -length;
    }
}
