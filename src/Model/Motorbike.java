package Model;

public class Motorbike extends Car {
    public Motorbike(String id){
        this.id = ("Model.Motorbike" + id);
        Car.length = super.getLength() * 1.5f;
    }
}
