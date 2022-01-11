package Model;

import java.awt.*;
import java.util.ArrayList;  // To set a list for include the cars

public class Road {

    public enum Direction{  // to build two direction module into One package
        HORIZONTAL,VERTICAL
    }

    private Direction direction;
    private String id;
    private int SpeedLimit; //get this and compare with the car speed
    private int length; // how long is the road
    private int[] startLocation; //where is the car's start
    private  int[] endLocation; // where is the car's goal
    private ArrayList<Car> carsOnRoad = new ArrayList<>(); // put the car into the road's list so that we can know which car is on the which road
    private ArrayList<TrafficLight> lightsOnRoad = new ArrayList<>();
    private ArrayList<Road> connectedRoads = new ArrayList<>();

    public Road(String id, int speedLimit, int length, int[] startLocation, Direction direction){
        this.id = "road_" + id;
        this.SpeedLimit = speedLimit;
        this.length = length;
        width = 9;
        this.startLocation = startLocation;
        this.direction = direction;
        setEndLocation();
    }


    public void draw(Graphics g, int scale){
        if (direction == Direction.HORIZONTAL){
            int[] starLocation = this.startLocation;
            int x = starLocation[0] * scale;
            int y = starLocation[1] * scale;
            int width = length * scale;
            int height = this.width * scale;
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, width, height);
            // lines
            g.setColor(Color.white);
            g.fillRect(x, y + (height /2) - scale / 6, width, scale /6);
            g.fillRect(x, y + (height / 2) + scale, width, scale /6);
        } else if (direction == Direction.VERTICAL){
            int[] starLocation = this.startLocation;
            int x = starLocation[0] * scale;
            int y = starLocation[1] * scale;
            int width = this.width * scale;
            int height = length * scale;
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, width, height);
            // Lines
            g.setColor(Color.white);
            g.fillRect(x + (width / 2) - scale / 6, y, scale / 6, height);
            g.fillRect(x + (width / 2) + scale / 6, y, scale / 6, height);
        }
    }


    String getId() {return id;}

    public int getSpeedLimit() { return SpeedLimit;}

    public int getLength() { return length;}

    int getWidth() { return width; }

    private void setEndLocation(){
        if (direction == Direction.HORIZONTAL){
            this.endLocation = new int[]{this.length + this.startLocation[0], this.startLocation[1]};
        } else if (direction == Direction.VERTICAL){
            this.endLocation = new int[]{this.startLocation[1], this.length + this.startLocation[0]};
        }
    }

    public int[] getStartLocation() {return startLocation;}

    public  int[] getEndLocation(){ return endLocation; }

    public ArrayList<TrafficLight> getLightsOnRoad() {return lightsOnRoad;}

    public ArrayList<Road> getConnectedRoads() {return connectedRoads;}

    Direction getDirection() {return direction;}


}
