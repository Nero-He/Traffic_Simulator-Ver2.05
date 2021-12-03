import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    Road road = new Road("0", 1, 5, new int[]{0, 0}); //  Road(String id, int speedLimit, int length, int[] startLocation)
    Car car = new Car("0", road); //  Car(String id, Road currentRoad){

    @Test
    void testMove() {
        car.move();
        assertEquals(2, car.getPosition());
        // Process finished with exit code 0
    }

    @Test
    void getLength() {
        assertEquals(1, car.getLength());
    }

    @Test
    void getBreath() {
        assertEquals(0.5, car.getBreath());
    }

    @Test
    void getSpeed() {
        assertEquals(0, car.getSpeed());
    }

    @Test
    void getPosition() {
        assertEquals(1, car.getPosition());
    }

    @Test
    void getRoad() {
        assertEquals(road, car.getCurrentRoad());
    }

    @Test
    void getId() {
        assertEquals("car_0", car.getId());
    }
}
