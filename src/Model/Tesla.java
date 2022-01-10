package Model;

public class Tesla extends Car {
    public Tesla(String id){
        this.id = ("Model.Tesla" + id);
        Car.length = super.getLength() * 2f;
    }
}
