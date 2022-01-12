package Model;

import java.awt.*;
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
        if (chance > CHANGE && !getRoadAttachedTo().getVehiclesOnRoad().isEmpty()){
            setState(RED);
        }else {
            setState(GREEN);
        }

    }


    public String getState() {return state;}
    public void setState(String state) {this.state = state;}
    public  Road getRoadAttachedTo() {return roadAttachedTo;}
    public int getPosition() {return position;}
    public String getId() {return id;}
    public void  print(Graphics g, int scale){
        if (roadAttachedTo.getDirection() == Road.Direction.HORIZONTAL){
            switch (state){
                case "Red":
                    g.setColor(Color.RED);
                    break;
                case "Green":
                    g.setColor(Color.GREEN);
            }
            int[] startLocation = getRoadAttachedTo().getStartLocation();
            int x = (getPosition() + startLocation[0]) * scale;
            int y =startLocation[1] * scale;
            int height = (getRoadAttachedTo().getWidth() / 2) * scale;
            g.fillRect(x, y, scale, height);
        }
        if (roadAttachedTo.getDirection() == Road.Direction.VERTICAL){
            switch (state){
                case "Red":
                    g.setColor(Color.RED);
                case "Green":
                    g.setColor(Color.GREEN);
            }
            int[] startLocation = getRoadAttachedTo().getStartLocation();
            int x = (startLocation[0] + (getRoadAttachedTo().getWidth() / 2)) * scale;
            int y = (getPosition() + startLocation[1]) * scale;
            int width = (getRoadAttachedTo().getWidth() / 2) * scale;
            g.fillRect(x, y, width, scale);
        }
    }
}
