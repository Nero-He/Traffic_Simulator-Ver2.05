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
}
