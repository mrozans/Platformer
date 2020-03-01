package Model.Mobs;

import View.Maps.Map;
import View.graphics.Screen;
import View.graphics.Sprite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MobTest {

    private Mob mob;
    private MockMap map;
    private MockPlayer player;
    private MockSprite sp;
    private MockBullet bullet;

    private class MockBullet extends Bullet
    {
        @Override
        public void update(Map m, boolean direction, boolean down)
        {

        }

        @Override
        public void render(Screen s)
        {

        }
    }

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
        mob = new Mob();
        player = new MockPlayer();
        map = new MockMap();
        sp = new MockSprite();
        bullet = new MockBullet();
        mob.map = map;
    }

    @Test
    public void update()
    {
        mob.HP = 1;
        sp.width = 3;
        sp.height = 2;
        mob.Set(sp, map);
        map.tiles[0][0][2] = true;
        mob.update(sp, player);
        assertEquals(0, mob.HP, 0);
    }

    @Test
    public void set()
    {
        sp.width = 3;
        sp.height = 2;
        mob.Set(sp, map);
        int k = 0;
        for(int i = 0; i < map.WIDTH; i++)
        {
            for (int j = 0; j < map.HEIGHT; j++)
            {
                if(map.tiles[i][j][3]) k++;
            }
        }
        assertEquals(2 * 3, k, 0);
    }

    @Test
    public void CheckGravity()
    {
        mob.vel.y = 13;
        mob.gravity();
        assertEquals(mob.vel.y, 12, 0);
        mob.vel.y = -14;
        mob.gravity();
        assertEquals(mob.vel.y, -12, 0);
        mob.vel.y = -7;
        mob.gravity();
        assertEquals(mob.vel.y, -6.5, 0);
    }

    @Test
    public void move()
    {
        float y = mob.pos.y;
        mob.vel.y = 2;
        mob.move(sp, 0);
        assertEquals(y + 2, mob.pos.y, 0);
        y = mob.pos.y;
        mob.vel.y = -3;
        mob.move(sp, 0);
        assertEquals(y - 3, mob.pos.y, 0);
    }

    @Test
    public void remove()
    {
        assertTrue(mob.remove());
        mob.bullets[0] = bullet;
        assertFalse(mob.remove());
    }
}