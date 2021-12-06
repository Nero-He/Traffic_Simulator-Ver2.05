import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeslaTest {
    Road road = new Road("0", 1, 5, new int[]{0, 0});
    Tesla tesla = new Tesla("0");


    @Test
    void getLength() {
        assertEquals(3, tesla.getLength());
    }

    @Test
    void getId() {
        assertEquals("tesla_0", tesla.getId());
    }

    @Test
    void testInheritance() {
        assertEquals(0, tesla.getSpeed());
        assertEquals(1, tesla.getPosition());
    }
}

