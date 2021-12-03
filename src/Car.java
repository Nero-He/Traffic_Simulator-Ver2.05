public class Car {
    private static final int STOPPED = 0; //Basic speed of car is 0/
    private static final int Next_Road_Index = 0;
    private static final int Start_Position = 1; //the car's position also include in 1/
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
        if (!this.currentRoad.getLightsOnRoad().isEmpty() && this.position == this.currentRoad.getLightsOnRoad().get(0).getPosition() && this.currentRoad.getLightsOnRoad().get(0).getState().equals("Red")){
            this.speed = STOPPED;
        } else {
            this.speed = this.currentRoad.getSpeedLimit();
            if (this.currentRoad.getLength() == this.getPosition() && !this.currentRoad.getConnectedRoads().isEmpty()) {
                this.currentRoad.getCarsOnRoad().remove(this);
                this.currentRoad = this.currentRoad.getConnectedRoads().get(Next_Road_Index);
                this.currentRoad.getCarsOnRoad().add(this);
                this.position = Start_Position;
            } else if (this.currentRoad.getLength()>this.getPosition()){
                this.position = (this.position + this.speed);
            } else {
                this.speed = STOPPED;
            }

        }
    }
    //set the output of the car Status/
    public void printCarStatus(){
        System.out.printf("%s going:%dm/s on %s at position:%s%n", this.getId(), this.getSpeed(), this.getCurrentRoad().
                getId(), this.getPosition());
    }

    //get the length for the car/
    public float getLength(){
        return length;
    }
    public void setLength(float length) {Car.length = length;}

    //get the Breath for the car/
    public float getBreath(){return breath;}
    public void setBreath(float breath) {Car.breath = breath;}

    //get the Car speed
    public int getSpeed(){return speed;}
    public void setSpeed(int speed){this.speed = speed;}

    public int getPosition(){return position;}
    public void setPosition(int position){this.position = position;}

    public Road getCurrentRoad(){return currentRoad;}
    public void setCurrentRoad(Road currentRoad){this.currentRoad = currentRoad;}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
}


