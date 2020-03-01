package Model.GS;

import Model.GS.GameStates.Game;
import Model.GS.GameStates.Gameover;
import Model.GS.GameStates.Menu;
import View.graphics.Screen;

public class GameStateManager
{
    public static final int GAME_STATE_MENU = 0;
    public static final int GAME_STATE_GAME = 1;
    public static final int GAME_STATE_GAMEOVER = 2;
    public static final int GAME_STATE_EXIT = 3;

    static GameState gs;

    public static boolean exit = false;

    public GameStateManager()
    {
        change(GAME_STATE_MENU, false);
    }

    public static void change(int ID, boolean version)
    {
        if(ID == GAME_STATE_MENU) gs = new Menu();
        if(ID == GAME_STATE_GAME) gs = new Game();
        if(ID == GAME_STATE_GAMEOVER) gs = new Gameover(version);
        if(ID == GAME_STATE_EXIT) exit = true;
    }

    public void update()
    {
        gs.update();
    }

    public void render(Screen s)
    {
        gs.render(s);
    }
}
