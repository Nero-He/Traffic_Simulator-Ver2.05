public class Motorbike extends Car{
    public Motorbike(String id){
        this.id = ("Motorbike" + id);
        length = super.getLength() * 1.5f;
    }
}
