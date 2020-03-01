package View.graphics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpriteTest
{
    private Sprite sp;
    @Before
    public void setUp()
    {
        sp = new Sprite(131, 195, 45, 50, Spritescheet.def1);
    }
    @Test
    public void correctElements()
    {
        assertEquals(131, sp.x, 0 );
        assertEquals(195, sp.y, 0 );
        assertEquals(45, sp.width, 0 );
        assertEquals(50, sp.height, 0 );
        assertSame(Spritescheet.def1, sp.s);
    }
}