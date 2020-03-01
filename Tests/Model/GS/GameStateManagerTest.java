package Model.GS;

import Model.GS.GameStates.Gameover;
import Model.GS.GameStates.Menu;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameStateManagerTest {

    @Before
    public void setUp()
    {
    }

    @Test
    public void CheckChange()
    {
        GameStateManager.change(0, false);
        assertTrue(GameStateManager.gs instanceof Menu);
        GameStateManager.change(2, true);
        assertTrue(GameStateManager.gs instanceof Gameover);
    }
}