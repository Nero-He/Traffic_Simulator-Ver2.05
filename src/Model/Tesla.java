package Model;

public class Tesla extends Vehicle {
    public Tesla(String id, Road currentRoad){
        super(currentRoad);
        this.id = ("Model.Tesla" + id);
        setLength(super.getLength() * 3);
        breadth = length /2;
        position = -length;
    }
}
