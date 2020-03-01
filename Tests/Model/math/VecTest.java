package Model.math;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class VecTest
{
    private Vec vec;
    @Before
    public void setUp()
    {
        vec = new Vec(50, 30.5f);
    }

    @Test
    public void correctElements()
    {
        assertEquals(50, vec.x, 0 );
        assertEquals(30.5, vec.y, 0 );
    }
}