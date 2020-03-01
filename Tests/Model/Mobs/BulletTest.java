package Model.Mobs;

import Model.math.Vec;
import View.Maps.Map;
import View.graphics.Screen;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BulletTest {

    private Bullet b, b2, b3;
    private MockMap map;

    @Before
    public void setUp()
    {
        MockVec vec = new MockVec();
        MockVec vec2 = new MockVec();
        MockVec vec3 = new MockVec();
        map = new MockMap();
        vec.x = 2;
        b = new Bullet(vec, true, false);
        b2 = new Bullet(vec2, false, false);
        b3 = new Bullet(vec3, true, true);
    }

    private class MockMap extends Map
    {
        @Override
        public void update(Player player)
        {

        }

        @Override
        public void render(Screen s)
        {

        }

        @Override
        public boolean victory()
        {
            return false;
        }
    }

    private class MockVec extends Vec
    {

    }

    @Test
    public void correctElements()
    {
        assertTrue(b.player);
        assertFalse(b.up);
        assertEquals(2, b.pos.x, 0);
        assertEquals(0, b.pos.y, 0);
    }

    @Test
    public void CheckUpdate()
    {
        b.update(map, true, false);
        b2.update(map, true, true);
        b3.update(map, false, false);
        assertEquals(5, b.pos.x, 0);
        assertEquals(0, b2.pos.x, 0);
        assertEquals(0, b3.pos.x, 0);
        assertEquals(0, b.pos.y, 0);
        assertEquals(1, b2.pos.y, 0);
        assertEquals(-3, b3.pos.y, 0);
    }

    @Test
    public void CheckRemove()
    {
        assertFalse(b.remove(map));
        b3.update(map, false, false);
        assertTrue(b3.remove(map));
        b2.pos.x = map.WIDTH;
        assertTrue(b2.remove(map));
    }
}