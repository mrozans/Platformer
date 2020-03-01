package View.Maps;

import Model.Mobs.Bullet;
import Model.Mobs.Enemy1;
import Model.Mobs.Enemy3;
import Model.Mobs.Player;
import View.graphics.Screen;
import View.graphics.Sprite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Map9Test {

    private MockPlayer player;
    private class MockPlayer extends Player
    {

        @Override
        public void update(Sprite mod, Player player)
        {

        }

        @Override
        public Bullet shoot()
        {
            return null;
        }

        @Override
        public void render(Screen s)
        {

        }
    }

    private Map9 map;
    @Before
    public void setUp()
    {
        map = new Map9();
        player = new MockPlayer();
    }

    @Test
    public void CheckEnemies()
    {
        assertTrue(map.mobs[0] instanceof Enemy1);
        assertTrue(map.mobs[1] instanceof Enemy1);
        assertFalse(map.mobs[0] instanceof Enemy3);
    }


    @Test
    public void CheckVictory()
    {
        map.mobs[0].HP = 0;
        map.mobs[1].HP = 0;
        map.update(player);
        assertTrue(map.victory());
    }
}