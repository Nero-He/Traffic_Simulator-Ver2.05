public class Tesla extends Car{
    public Tesla(String id){
        this.id = ("Tesla" + id);
        length = super.getLength() * 2f;
    }
}
