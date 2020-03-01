package Model.Tiles;

import Model.Mobs.Player;
import View.Maps.Map;
import View.graphics.Screen;
import View.graphics.Sprite;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class BaseTest {

    private Base base;
    private MockScreen s;
    private MockMap map;

    @Before
    public void setUp()
    {
        base = new Base();
        s = new MockScreen();
        map = new MockMap();
    }

    private class MockScreen extends Screen
    {


        @Override
        public void clear(int color)
        {

        }

        @Override
        public BufferedImage getImage()
        {
            return null;
        }

        @Override
        public void renderSprite(int x, int y, Sprite sp)
        {

        }
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

    @Test
    public void correctElements()
    {
        assertEquals(48, base.WIDTH);
        assertEquals(16, base.HEIGHT);
        assertEquals(9, base.OFFSET);
    }
    @Test
    public void CheckRender()
    {
        base.render(s, map, 0, 0);
        int i = 0;
        for(int j = 0; j < 48; j++)
        {
            for(int k = 9; k < 16 + 9; k++)
            {
                if(map.tiles[j][k][0]) i++;
            }
        }
        assertEquals(i, 48 * 16);
    }
}