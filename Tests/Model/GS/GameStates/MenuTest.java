package Model.GS.GameStates;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    private Menu menu;
    @Before
    public void setUp()
    {
        menu = new Menu();
    }

    @Test
    public void update()
    {
        menu.choice = 3;
        menu.update();
        assertEquals(0, menu.choice);
        assertEquals(menu.poiterPositoin, Menu.newgame.height / 2 - Menu.pointer.height / 2);
        menu.choice = -1;
        menu.update();
        assertEquals(1, menu.choice);
        assertEquals(menu.poiterPositoin, 35 + Menu.exit.height / 2 - Menu.pointer.height / 2);
    }
}