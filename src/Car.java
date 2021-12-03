public class Car {
    private static final int stopped = 0; //Basic speed of car is 0/
    private static final int Next_Road_Index = 0;
    private static final int Star_Position = 1; //the car's position also include in 1/
    String id;
    static float length;// how many space the car will be occupied/
    private static float breath; // the width of car could be decimal ,so it should be float type/
    private int speed; // the car's speed should be regular /
    private int position; // position on what the road is/
    private Road currentRoad; // current Road object/

    public Car(String id, Road currentRoad){
        this.id = "car_" + id;
        this.currentRoad = currentRoad;
        length = 2f; // the car length set in 2m /
        breath = length * 1.5f;
        speed = 0;
        position = 1;
        this.currentRoad.getCarsOnRoad().add(this); // to get the basic data and set into 'this' to fill up the data/

    }

    public Car(){
        id = "000";
        length = 2f;
        breath = length * 1.5f;
        speed = 1;
        position = 1;
    }

    //set the movement for the basic car/
    public void move(){
        this.speed = this.currentRoad.getSpeedLimit(); //get the speed limit for the road and compare with the speed /
        if (!this.currentRoad.getLightOnRoad().isEmpty() && this.position == this.currentRoad.getLightsOnRoad().get(0).getPosition() && this.currentRoad.getLightsOnRoad().get(0).getState().equals("Red")){
            this.currentRoad.getCarsOnRoad().remove(this);
            this.currentRoad = this.currentRoad.getConnectedRoads().get(Next_Road_Index)
        }
    }

}


