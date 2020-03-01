package Model.GS.GameStates;

import Model.Mobs.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    @Before
    public void setUp()
    {
        game = new Game();
    }

    @Test
    public void CheckUpdate()
    {
        game.player.pos.x = game.player.map.WIDTH - Player.playermodel.width/2 + 5;
        game.update();
        assertEquals(game.player.pos.x, -10, 0);
        game.player.pos.x = -20;
        game.update();
        assertEquals(game.player.pos.x, 252, 0);
        game.player.pos.y = 200;
        game.player.vel.y = 0;
        game.update();
        assertEquals(game.player.pos.y, -10 + game.player.vel.y, 0);
    }
}