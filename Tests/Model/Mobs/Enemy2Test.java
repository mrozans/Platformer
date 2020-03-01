package Model.Mobs;

import Model.math.Vec;
import View.Maps.Map;
import View.graphics.Screen;
import View.graphics.Sprite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Enemy2Test {

    private Enemy2 mob;
    private MockSprite sp;
    private MockPlayer player;

    private class MockVec extends Vec
    {

    }

    private class MockSprite extends Sprite
    {

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
        MockVec vec = new MockVec();
        MockMap map = new MockMap();
        mob = new Enemy2(vec, map);
        player = new MockPlayer();
        sp = new MockSprite();
    }

    @Test
    public void CheckUpdate()
    {
        mob.pos.x = 50;
        player.pos.x = 0;
        mob.update(sp, player);
        assertTrue(mob.pos.x < 50);
        assertFalse(mob.direction);
        mob.pos.x = 50;
        player.pos.x = 100;
        mob.update(sp, player);
        assertTrue(mob.pos.x > 50);
        assertTrue(mob.direction);
    }
}