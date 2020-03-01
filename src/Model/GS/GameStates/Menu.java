package Model.GS.GameStates;

import Model.GS.GameState;
import View.graphics.Screen;
import View.graphics.Sprite;
import View.graphics.Spritescheet;
import Controller.Contorller;

import java.awt.event.KeyEvent;

public class Menu extends GameState
{
    static final Sprite pointer = new Sprite(227, 21, 8, 16, Spritescheet.def1);
    static final Sprite newgame = new Sprite(180, 37, 44, 31, Spritescheet.def1);
    private static final Sprite back = new Sprite(0, 0, Spritescheet.def2.WIDTH, Spritescheet.def2.HEIGHT, Spritescheet.def2);
    static final Sprite exit = new Sprite(248, 45, 38, 13, Spritescheet.def1);
    private Contorller contorller = new Contorller();

    public int choice = 0;
    int poiterPositoin = 0;
    public Menu()
    {

    }

    public void update()
    {
        if(Contorller.getKeyOnce(KeyEvent.VK_ENTER))
        {
            contorller.accept(choice);
        }
        if(Contorller.getKeyOnce(KeyEvent.VK_S)) contorller.up(this);
        if(Contorller.getKeyOnce(KeyEvent.VK_W)) contorller.down(this);
        if(choice < 0) choice = 1;
        if(choice > 1) choice = 0;
        if(choice == 0) poiterPositoin = newgame.height / 2 - pointer.height / 2;
        if(choice == 1) poiterPositoin =  35 + exit.height / 2 - pointer.height / 2;
    }

    public void render(Screen s)
    {
        s.clear(0x000000);
        s.renderSprite(0, 0, back);
        s.renderSprite(6, poiterPositoin, pointer);
        s.renderSprite(16, 0, newgame);
        s.renderSprite(16, 35, exit);
    }

}
