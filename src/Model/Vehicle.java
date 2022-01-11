package Model;

import java.awt.*;
import java.util.Random;


public abstract class Vehicle {

    private static final int STOPPED = 0;
    private static final int START_POSITION = 0;
    int length; //to set how long is the car will be
    int breadth; // same as above
    String id; //to don't confusion the name tag
    private int Speed; // how fast is the car will be
    private Road currentRoad; //current position on which part of road
    int position; //position on the current road
    private Color color;
    private Random random = new Random();


    public Vehicle(Road currentRoad){
        id = "000";
        length = 4;
        breadth = 2;
        Speed = 0;
        this.currentRoad = currentRoad;
        currentRoad.getVehiclesOnRoad().add(this);
        color = randomColor();
    }

    public Vehicle(){
        id = "000";
        length = 0;
        breadth = 0;
        Speed = 0;
        position = 0;
    }

    public void move(){
        Random random = new Random();
        int nextPosition = position + length + Speed;
        // the vehicle position when it runs front way
        for (Vehicle nextVehicle : currentRoad.getVechlesOnRoad()){
            if (nextVehicle.position > position && nextVehicle.position <= nextPosition + 4){
                Speed = STOPPED;
                break;
            }else {
                Speed = currentRoad.getSpeedLimit();
            }
        }
        // if the light is red, the car can't move
        if (Speed == STOPPED){
        }else {
            if (!currentRoad.getLightsOnRoad().isEmpty() && nextPosition + 1 >= currentRoad.getLightsOnRoad().get(0) && this.currentRoad.getLightsOnRoad().get(0).getState().equals("Red")){
                Speed = STOPPED;
            }else {
                Speed = currentRoad.getSpeedLimit();
                if (currentRoad.getLength() <= nextPosition && !currentRoad.getConnectedRoads().isEmpty()){
                    currentRoad.getVehiclesOnRoad().remove(this);
                    int nextRoadIndex = random.nextInt(2);
                    currentRoad = currentRoad.getConnectedRoads().get(nextRoadIndex);
                    currentRoad.getVehiclesOnRoad().add(this);
                    position = START_POSITION;
                }else if (currentRoad.getLength() >= nextPosition){
                    position = (position + Speed);
                }else {
                    Speed = STOPPED;
                }
            }
        }
    }

    public void paint(Graphics g, int scale){
        int ValueX = 0;
        int ValueY = 1;
        if (currentRoad.getDirection() == Road.Direction.HORIZONTAL){
            int width = getLength() * scale;
            int height = getBreadth() * scale;
            int[] startLocation = getCurrentRoad().getStartLocation();
            int x = (getPosition() + startLocation[ValueX]) * scale;
            int y = (startLocation[ValueY] * scale) + scale;
            g.setColor(color);
            g.fillRect(x, y, width, height);
        } else if (currentRoad.getDirection() == Road.Direction.VERTICAL){
            int[] startLocation = getCurrentRoad().getStartLocation();
            int width = getLength() * scale;
            int height = getBreadth() * scale;
            int x = (startLocation[ValueX] * scale) + ((currentRoad.getWidth() * scale) - (width + scale));
            int y = (getPosition() + startLocation[ValueY]) * scale;
            g.setColor(color);
            g.fillRect(x, y, width,height);
        }
    }

    private Color randomColor(){
        int red = random.nextInt(245 + 1) + 10;
        int green = random.nextInt(245 + 1) +10;
        int blue = random.nextInt(245 + 1) + 10;
        return new Color(red, blue, green);
    }

    public void printStatues(){
        System.out.printf("%s going:%dm/s on %s at position:%s%n", this.getId(), this.getSpeed(), this.getCurrentRoad().
                getId(), this.getPosition());
    }

    public int getLength() {
        return length;
    }

    void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPosition() {
        return position;
    }

    public Road getCurrentRoad() {
        return currentRoad;
    }

    public String getId() {
        return id;
    }
}
