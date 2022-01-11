package Test;

import Model.Road;
import Model.TrafficLight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrafficLightTest{
    Road road = new Road("0", 1, 5, new int[]{0,0},Road.Direction.VERTICAL);
    TrafficLight Light = new TrafficLight("0", road);

    @Test
    void testOperate(){
        Light.operate(3515);
        assertEquals("Green", Light.getState());
    }
}