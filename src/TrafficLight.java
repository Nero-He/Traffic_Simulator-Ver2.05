import java.util.Random;
//use the random to control the lights turn red or green/

public class TrafficLight {
    private static final double CHANGE_GREEN = 0.5; // to set the number for the chance to switch the lights
    private static final String GREEN = "green";
    private static final String RED = "red";
    private String id;
    private String state;
    private int position;
    private Road roadAttachedTo;

    public TrafficLight(String id, Road road){
        this.id = "Light_" + id; //set the String id for the light/
        state = RED;
        this.roadAttachedTo = road;
        position = this.roadAttachedTo.getLength(); //set the lights on the end of the road/
        this.roadAttachedTo.getLightsOnRoad().add(this); // add the lights to the road where it belongs/
    }

    //set the chance to switch the lights red or green/
    public void operate(int seed){
        Random random = new Random(seed);
        double chance = random.nextDouble();
        if (chance > CHANGE_GREEN) {
            this.setState(GREEN);
        }else {
            this.setState(RED);
        }

    }


    //set the output for the status/
    public void printLightStatus(){
        System.out.printf("%s is:%s on %s at position:%s%n", this.getId(), this.getState(), this.getRoadAttachedTo().getId(), this.getPosition());
    }


    //set the data/
    public String getState(){return state;}
    public void setState(String state){this.state = state;};

    public Road getRoadAttachedTo(){return roadAttachedTo;}
    public void setRoadAttachedTo(Road roadAttachedTo){this.roadAttachedTo = roadAttachedTo;}

    public int getPosition(){return position;}
    public String getId(){return id;}

    public void setId(String id){this.id = id;}
    public void setPosition(int position){this.position = position;}
}
