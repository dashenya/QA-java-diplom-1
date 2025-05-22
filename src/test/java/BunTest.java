import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void bunGetNameTest() {
        Bun bun = new Bun( "Пшеничная", 19.99f);
        assertEquals(bun.getName(), "Пшеничная");
    }

    @Test
    public void bunGetPriceTest() {
        Bun bun = new Bun( "Пшеничная", 19.99f);
        assertEquals(bun.getPrice(), 19.99f, 0);
    }



}
