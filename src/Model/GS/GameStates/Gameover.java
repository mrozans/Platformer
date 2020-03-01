package Model.GS.GameStates;

import Model.GS.GameState;
import View.graphics.Screen;
import View.graphics.Sprite;
import View.graphics.Spritescheet;
import Controller.Contorller;

import java.awt.event.KeyEvent;

public class Gameover extends GameState
{
    private boolean version;
    private static final Sprite GO = new Sprite(188, 90, 106, 34, Spritescheet.def1);
    private static final Sprite VIC = new Sprite(177, 129, 123, 23, Spritescheet.def1);
    private static final Sprite EN1 = new Sprite(180, 70, 55, 13, Spritescheet.def1);
    private static final Sprite EN2 = new Sprite(240, 70, 55, 13, Spritescheet.def1);
    private Contorller contorller = new Contorller();
    public Gameover(boolean version)
    {
        this.version = version;
    }
    public void update()
    {
        if (Contorller.getKeyOnce(KeyEvent.VK_ENTER))
        {
            contorller.end();
        }
    }
    public void render(Screen s)
    {
        s.clear(0x000000);
        if(version)
        {
            s.renderSprite(65, 60, VIC);
            s.renderSprite(100, 100, EN2);
        }
        else
        {
            s.renderSprite(83, 60, GO);
            s.renderSprite(110, 100, EN1);
        }
    }
}
