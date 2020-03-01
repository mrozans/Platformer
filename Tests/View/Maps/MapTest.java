package View.Maps;

import Model.Mobs.Bullet;
import Model.Mobs.Mob;
import Model.Mobs.Player;
import View.graphics.Screen;
import View.graphics.Sprite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {

    private Map map;
    private MockPlayer player;
    private MockMob mob;
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

    public class MockMob extends Mob
    {
        @Override
        public void update(Sprite modelnow, Player player)
        {

        }

        @Override
        public boolean remove()
        {
            return  false;
        }
    }

    @Before
    public void setUp()
    {
        map = new Map();
        player = new MockPlayer();
        mob = new MockMob();
    }

    @Test
    public void Checkupdate()
    {
        boolean s = true;
        for(int i = 0; i < map.WIDTH; i++)
        {
            for(int j = 0; j < map.HEIGHT; j++)
            {
                map.tiles[i][j][3] = true;
                map.tiles[i][j][4] = true;
            }
        }
        map.update(player);
        for(int i = 0; i < map.WIDTH; i++)
        {
            for(int j = 0; j < map.HEIGHT; j++)
            {
                if(map.tiles[i][j][3] || map.tiles[i][j][4])  s = false;
            }
        }
        assertTrue(s);
        map.mobs = new MockMob[2];
        map.mobs[0] = mob;
        assertNull(map.mobs[1]);
        map.mobs[0].HP = 1;
        map.update(player);
        map.mobs[0].HP = 0;
        map.update(player);
        assertNotNull(map.mobs[0]);
    }


    @Test
    public void CheckVictory()
    {
        assertFalse(map.victory());
    }
}