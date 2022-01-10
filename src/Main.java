import Model.Car;
import Model.Road;
import Model.TrafficLight;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // I guess I should print out something as a main menu
        // Also, as the reference I need to ask the user for some data... So I should ask for the input :)
        Scanner simController = new Scanner(System.in);

        // Should I use the < 2 or < roadSpawns and setting a basic value for roadSpawns?


        System.out.println("Object Creation: \n——————————————————————");
        System.out.println("Roads:");
        ArrayList<Road> roads = new ArrayList<>(); //build a road list
        for (int i = 0; i < 2; i++) {
            //I don't get it what is these three dots used for? why?
            System.out.println("Please input the number of roads: " + i + "...");
            System.out.println("Length: ");
            int lengthInput = simController.nextInt();
            int speedLimitInput = 2; // just set a number for the proto
            roads.add(new Road(Integer.toString(i), speedLimitInput, lengthInput, new int[]{0, 0}));
        }


        System.out.println("\nRoads:");
        for (Road road : roads){
            road.printRoadInfo(); // output the information for roads
        }


        System.out.println("\nCars:");
        ArrayList<Car> cars = new ArrayList<>(); //build a car list
        for (int i = 0; i < 2; i++){
            cars.add(new Car(Integer.toString(i), roads.get(0))); //set the cars that I built, all on the road 0
            cars.get(i).printCarStatus();
        }

        System.out.println("\nTraffic Lights:");
        ArrayList<TrafficLight> lights = new ArrayList<>(); //build a trafficLight list
        for (int i = 0; i < 1; i++) {
            cars.add(new Car(Integer.toString(i),roads.get(0))); //set the lights on the road 0
            cars.get(i).printCarStatus();
        }
        System.out.println();


        // setting the connection between the road 0 and road 1
        System.out.println("Settings:");
        roads.get(1).setStartLocation(new int[]{roads.get(0).getLength() + 1, 0}); //connect the road 1 to the end of road 0
        roads.get(1).printRoadInfo();
        roads.get(0).getConnectedRoads().add(roads.get(1)); //link the road 0 to road 1
        System.out.println();


        // simulation loop
        System.out.println("Simulation: ");
        Random random = new Random();
        int time = 0; //set the original be the 0, so that it can be loop and loop until end
        System.out.print("Set the time in milliseconds: ");
        int timeinmilliseconds = simController.nextInt();
        int carsStoped = 0;
        while(carsStoped < cars.size()){
            for (TrafficLight light: lights){
                light.operate(random.nextInt());
                light.printLightStatus();
            }
            for (Car car : cars){
                car.move();
                car.printCarStatus();
                if (car.getCurrentRoad().getConnectedRoads().isEmpty() && (car.getSpeed() == 0)){
                    carsStoped = carsStoped +1;
                }
            }
            time = time +1;
            System.out.println(time + "Seconds already gone.\n");
            try{
                Thread.sleep(timeinmilliseconds); //set the speed of simulation
            }catch (InterruptedException sim){
                Thread.currentThread().interrupt();
            }
        }

        }

    }

