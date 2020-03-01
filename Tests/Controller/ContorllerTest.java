package Controller;

import Model.Mobs.Bullet;
import Model.Mobs.Player;
import View.Maps.Map;
import View.graphics.Screen;
import View.graphics.Sprite;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ContorllerTest
{
    private MockPlayer player;
    private Contorller contorller;
    private MockMap map;
    private MockBullet b;
    private class MockPlayer extends Player
    {

        @Override
        public void update(Sprite mod, Player player)
        {

        }

        @Override
        public Bullet shoot()
        {
            return b;
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

    @Before
    public void setUp()
    {
        player = new MockPlayer();
        contorller = new Contorller();
        map = new MockMap();
        b = new MockBullet();
    }

    @Test
    public void chceckConut()
    {
        assertEquals(200, Contorller.Count);
        assertEquals(200, Contorller.keys.length);
        assertEquals(200, Contorller.prevkeys.length);
    }

    @Test
    public void checkGetkey()
    {
        Contorller.keys[0] = true;
        assertTrue(Contorller.getKey(0));
        assertFalse(Contorller.getKey(1));
    }

    @Test
    public void checkHetKeyOnce()
    {
        Contorller.prevkeys[0] = true;
        Contorller.keys[0] = true;
        Contorller.keys[1] = true;
        assertFalse(Contorller.getKeyOnce(0));
        assertTrue(Contorller.getKeyOnce(1));
        assertFalse(Contorller.getKeyOnce(2));
    }


    @Test
    public void checkGo()
    {
        float x = player.pos.x;
        contorller.goleft(player);
        assertNotEquals(player.pos.x, x);
        assertEquals(x - player.pos.x, player.speed, 0);
        assertSame(Player.modelnow, Player.playermodel2);
        player.pos.x = 30;
        map.tiles[29][0][0] = true;
        player.map = map;
        contorller.goleft(player);
        assertEquals(30, player.pos.x, 0);
    }

    @Test
    public void checkLookup()
    {
        player.direction = false;
        contorller.lookup(player);
        assertSame(Player.modelnow,  Player.playermodelup2);
        player.direction = true;
        contorller.lookup(player);
        assertSame(Player.modelnow, Player.playermodelup);
        Player.modelnow = Player.playermodel;
        float y = player.pos.y;
        contorller.lookup(player);
        assertEquals(Player.playermodelup.height - Player.playermodel.height,  y - player.pos.y , 0);
    }

    @Test
    public void down()
    {
        player.direction = false;
        contorller.down(player);
        assertSame(Player.modelnow,  Player.playermodeldown2);
        player.direction = true;
        contorller.down(player);
        assertSame(Player.modelnow, Player.playermodeldown);
    }

    @Test
    public void checkJump()
    {
        player.map = map;
        contorller.jump(player);
        assertEquals(player.vel.y,  0 , 0);
        player.pos.x = 0;
        player.pos.y = 0;
        player.map.tiles[10][Player.modelnow.height][0] = true;
        contorller.jump(player);
        assertEquals(player.vel.y,  -7 , 0);
    }

    @Test
    public void checkFire()
    {
        contorller.fire(player);
        assertNotNull(player.bullets[0]);
        assertNull(player.bullets[1]);
    }
}