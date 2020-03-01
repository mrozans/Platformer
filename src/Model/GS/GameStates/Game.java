package Model.GS.GameStates;

import View.Maps.*;
import Model.Mobs.Player;
import Model.GS.GameState;
import Model.GS.GameStateManager;
import View.graphics.Screen;
import View.graphics.Sprite;
import View.graphics.Spritescheet;
import Controller.Contorller;

import java.awt.event.KeyEvent;

public class Game extends GameState
{
    public Player player;
    int active;
    private static final Sprite header = new Sprite(0, 0, 48, 8, Spritescheet.def1);
    private static final Sprite hpbar = new Sprite(0, 16, 3, 8, Spritescheet.def1);
    private Map[] maps;
    private Contorller contorller;

    public Game()
    {
        StartMap map0 = new StartMap();
        Map1 map1 = new Map1();
        Map2 map2 = new Map2();
        Map3 map3 = new Map3();
        Map4 map4 = new Map4();
        Map5 map5 = new Map5();
        Map6 map6 = new Map6();
        Map7 map7 = new Map7();
        Map8 map8 = new Map8();
        Map9 map9 = new Map9();
        player = new Player(map0);
        active = 0;
        maps = new Map[]  {map0, map1, map2, map3, map4, map5, map6, map7, map8, map9};
        contorller = new Contorller();
    }

    public void update()
    {
        if(active == 9 && maps[active].victory()) GameStateManager.change(GameStateManager.GAME_STATE_GAMEOVER, true);
        if(Contorller.getKeyOnce(KeyEvent.VK_ESCAPE))
        {
            contorller.end();
        }

        if(player.pos.x + Player.playermodel.width/2 >= player.map.WIDTH)
        {
            clean();
            active++;
            player.pos.x = -10;
            if(player.vel.y == 0) player.pos.y--;
        }

        else if(player.pos.x + Player.playermodel.width/2 <= 0)
        {
            clean();
            active--;
            player.pos.x = 252;
            if(player.vel.y == 0) player.pos.y--;
        }

        else if(player.pos.y + Player.playermodel.height/2 >= player.map.HEIGHT)
        {
             clean();
            active += 2;
            player.pos.y = -10;
        }
        else
        {
            maps[active].update(player);
        }
        if(active < 0) active = 0;
        if(active >= maps.length) active = maps.length - 1;
        player.map = maps[active];
        player.update(Player.modelnow, null);
        if(player != null && player.HP <= 0) player = null;
        if(player == null) GameStateManager.change(GameStateManager.GAME_STATE_GAMEOVER, false);
    }

    private void clean()
    {
        if(maps[active].mobs != null)
        {
            for(int i = 0; i < maps[active].mobs.length; i++)
            {
                for(int j = 0; j < 4; j++)
                {
                    if(maps[active].mobs[i] != null) maps[active].mobs[i].bullets[j] = null;
                }
            }
        }

        for(int j = 0; j < 4; j++)
        {
            if(player.bullets[j] != null) player.bullets[j] = null;
        }
    }

    public void render(Screen s)
    {
        s.clear(0x0000ff);
        maps[active].render(s);
        if(player != null) player.render(s);
        s.renderSprite(0, 0, header);
        for(int i = 1; i <= player.HP; i++)
        {
            s.renderSprite(20 + i * (hpbar.width + 1), 0, hpbar);
        }
    }
}
