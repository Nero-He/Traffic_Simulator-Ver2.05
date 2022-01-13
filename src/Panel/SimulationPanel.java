package Panel;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;

public class SimulationPanel extends JPanel {
    // build up the enum of the vehicle moving steps
    public enum State{
        STOPPED, MOVING, ARRIVE
    }

    private State state = State.STOPPED;
    private int scale;
    private ArrayList<Road> roads;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<TrafficLight> lights;
    //build up the list of the modules

    private Timer timer; //build up the clock
    private Boolean stop = true;
    private Random random = new Random(); //build up the random for control the traffic lights
    private static int cycle = 0; //loop

    private int vehiclesToSpot = 3;
    private int vehiclesSpot = 0;
    private int vehiclesSpawned = 0;
    private int vehiclesRemoved = 0;
    private int numberOfLoops = 25;
    private int updateRate = 110;
    // build up the car's moving rules and the Spawn

    public void loadMap(ArrayList<Road> roads, ArrayList<TrafficLight> lights){
        this.roads = roads;
        this.lights = lights;
    }

    public void setVehiclesSpawned(int spawns){
        this.vehiclesToSpot = spawns - 1;
        createVehicle();
    }

    public void setVehiclesSpotRate(int rate){this.numberOfLoops = rate;}

    private void createVehicle(){
        //random vehicles on the road
        int randomVehicle = random.nextInt(4);
        switch (randomVehicle){
            case 0:
                vehicles.add(new Car(Integer.toString(cycle), roads.get(0)));
                break;
            case 1:
                vehicles.add(new Bus(Integer.toString(cycle), roads.get(0)));
                break;
            case 2:
                vehicles.add(new Motorbike(Integer.toString(cycle), roads.get(0)));
                break;
            case 4:
                vehicles.add(new Tesla(Integer.toString(cycle), roads.get(0)));
                break;
        }
    }

    public void setScale(int scale){this.scale = scale;}

    //build up the simulator
    public void simulate(){
        setLayout(new BorderLayout());
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2,1));
        infoPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        JLabel vehicleLabel = new JLabel("Vehicles:");
        infoPanel.add(vehicleLabel);

        JLabel averageSpeedLabel = new JLabel("Average Speed: ");
        infoPanel.add(averageSpeedLabel);

        JLabel stateLabel = new JLabel("State: " +state);
        infoPanel.add(stateLabel);

        add(infoPanel, BorderLayout.SOUTH);

        if (timer != null){
            timer.stop();
        }
        timer = new Timer(updateRate / 60, e ->{
            cycle++;
            if (vehicles.size() == 0) {
                state = State.ARRIVE;
            }else if (stop){
                state = State.STOPPED;
            }else{
                state = State.MOVING;
            }
            stateLabel.setText("State" + state);
            vehicleLabel.setText("Vehicles: " + getTotalVehicles());
            averageSpeedLabel.setText("Average Speed: " +getAverageSpeed());
            if (vehicles.size() == 0 || stop){
                timer.stop();
            }
            if (cycle % 30 == 0){
                for (TrafficLight light: lights){
                    light.operate(random.nextInt());
                    light.printLightStatus();
                }
            }
            for (Iterator<Vehicle> iterator = vehicles.iterator(); iterator.hasNext();){
                Vehicle vehicle = iterator.next();
                vehicle.move();
                vehicle.printStatues();
                if (vehicle.getPosition() + vehicle.getLength() + vehicle.getSpeed() >= vehicle.getCurrentRoad().getLength() && vehicle.getCurrentRoad().getConnectedRoads().isEmpty() && (vehicle.getSpeed() == 0)){
                    vehicle.getCurrentRoad().getVehiclesOnRoad().remove(vehicle);
                    iterator.remove();
                    vehiclesRemoved++;
                }
            }

            if (cycle % numberOfLoops == 0 && vehiclesSpawned < vehiclesToSpot){
                createVehicle();
                vehiclesSpawned++;
        }
            repaint();
    });
            timer.start();
    }

        public String paintPart(Graphics g){
        super.paintComponent(g);

        for (Road road : roads){
            road.draw(g, scale);
        }
        if (!vehicles.isEmpty()){
            for (Vehicle vehicle : vehicles){ vehicle.draw(g, scale);}

        for (TrafficLight light : lights);{ light.draw(g, scale);}
        }

        private String getAverageSpeed(){
            int totalSpeed = 0;
            for (Vehicle vehicle: vehicles){totalSpeed = totalSpeed + vehicle.getSpeed();}

            if (!vehicles.isEmpty()){int average = totalSpeed / vehicles.size();
            return average * 3.6 +  "km/h";
            } else {return "0";}
            }
    public void setUpdataRate(int updateRate) {this.updateRate = updateRate;}

        public void setStopSim(Boolean stop){ this.stop = stop;}





        }




}
