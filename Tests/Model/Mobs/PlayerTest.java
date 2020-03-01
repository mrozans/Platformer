package Model.Mobs;

import View.Maps.Map;
import View.graphics.Screen;
import View.graphics.Sprite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private MockSprite sp;

    private class MockSprite extends Sprite
    {

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

    @Before
    public void setUp()
    {
        MockMap map = new MockMap();
        player = new Player(map);
        sp = new MockSprite();
    }

    @Test
    public void CheckUpdate()
    {
        player.map.tiles[1][1][2] = true;
        player.update(sp, player);
        assertFalse(player.map.tiles[1][1][2]);
        player.direction = true;
        player.update(sp, player);
        assertEquals(player.hitboxleft, 0);
        assertEquals(player.hitboxright, 9);
        player.direction = false;
        player.update(sp, player);
        assertEquals(player.hitboxleft, 9);
        assertEquals(player.hitboxright, 0);
        assertEquals(player.HP, 3);
        player.pos.x = 0;
        player.pos.y = 0;
        player.map.tiles[10][0][4] = true;
        player.update(sp, player);
        assertEquals(player.HP, 2);
    }
}