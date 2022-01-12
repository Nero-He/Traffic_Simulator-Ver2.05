package Test;

import Model.Tesla;
import Model.Road;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeslaTest {
    Module.Road road = new Model.Road("0", 1, 5, new int[]{0, 0}, Road.Direction.VERTICAL);
    Module.Tesla tesla = new Model.Tesla("0", road);
    @Test
    void testMove(){
        Tesla.move();
        assertEquals(-3, Tesla.getPosition());
    }
    @Test
    void getLength() {
        assertEquals(4, Tesla.getLength());
    }

    @Test
    void getBreadth() {
        assertEquals(2.0, Tesla.getBreadth());
    }

    @Test
    void getSpeed() {
        assertEquals(0, Tesla.getSpeed());
    }

    @Test
    void getPosition() {
        assertEquals(-4, Tesla.getPosition());
    }

    @Test
    void getRoad() {
        assertEquals(road, Tesla.getCurrentRoad());
    }

    @Test
    void getId() {
        assertEquals("car_0", Tesla.getId());
    }
}




