package Model;

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
        this.startLocation = startLocation;
        this.endLocation = new int[]{this.length + this.startLocation[0], 0};
        this.direction = direction;
        setEndLocation();
    }


    //get the id part/
    public String getId(){return id;}
    public  void setId(String id) {this.id = id;}

    //get the speed limit part/
    public int getSpeedLimit() {return SpeedLimit;}
    public void setSpeedLimit(int speedLimit){this.SpeedLimit = speedLimit;}

    //get the road length part/
    public int getLength(){return length;}
    public void setLength(int length){this.length = length;}

    //output the Location part/
    public String printStartLocation() {return startLocation[0] + "," + startLocation[1];}
    public void setStartLocation(int[] startLocation){
        this.startLocation = startLocation;
        this.endLocation = new int[]{this.length + this.startLocation[0], 0};
    }
    public String printEndLocation(){return endLocation[0] + "," + endLocation[1];}
    public void printRoadInfo(){
        System.out.printf("%s limit of:%dm/s is %dm long at location:%s to %s%n", this.getId(),this.getSpeedLimit(),this.getLength(),this.printStartLocation(),this.printEndLocation());
    }
    public void setEndLocation(int[] endLocation){this.endLocation = endLocation;}
    public int[] getStartLocation(){return startLocation;}
    public int[] getEndLocation() {return endLocation;}

    //the list of the car on road/
    public  ArrayList<Car> getCarsOnRoad(){return carsOnRoad;}
    public void setCarsOnRoad(ArrayList<Car> carsOnRoad){this.carsOnRoad = carsOnRoad;}

    // the Traffic Lights part/
    public ArrayList<TrafficLight> getLightsOnRoad(){return lightsOnRoad;}
    public void setLightsOnRoad(ArrayList<TrafficLight> lightsOnRoad){this.lightsOnRoad = lightsOnRoad;}

    // the connected road for the a and b roads/
    public ArrayList<Road> getConnectedRoads(){return connectedRoads;}
    public void setConnectedRoads(ArrayList<Road> connectedRoads){this.connectedRoads = connectedRoads;}

}
