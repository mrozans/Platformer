package View.graphics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScreenTest {

    private Screen s;
    @Before
    public void setUp()
    {
        s = new Screen(50, 60);
    }

    @Test
    public void correctElements()
    {
        assertEquals(50, s.WIDTH);
        assertEquals(60, s.HEIGHT, 0 );
        assertEquals(s.pixels.length, 50 * 60);
    }

    @Test
    public void Checkclear()
    {
        s.clear(0x0000FF);
        assertEquals(0x0000FF, s.pixels[20]);
    }

    @Test
    public void CheckPixel()
    {
        s.pixel(10, 10, 0x0000FF);
        assertEquals(0x0000FF, s.pixels[10 + 10 * s.WIDTH]);
    }
}