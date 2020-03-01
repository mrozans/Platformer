package Controller;

import Model.GS.GameStateManager;
import Model.GS.GameStates.Menu;
import Model.Mobs.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Contorller implements KeyListener
{
    static final int Count = 200;
    static boolean[] keys = new boolean[Count];
    static boolean[] prevkeys = new boolean[Count];

    public void keyPressed(KeyEvent arg0)
    {
        keys[arg0.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent arg0)
    {
        keys[arg0.getKeyCode()] = false;
    }

    public static boolean getKey(int Key)
    {
        return keys[Key];
    }

    public static boolean getKeyOnce(int Key)
    {
        if(!prevkeys[Key] && keys[Key])
        {
            prevkeys[Key] = true;
            return true;
        }

        return false;
    }

    public void update()
    {
        for(int i = 0; i < Count; i++)
        {
            if(!keys[i]) prevkeys[i] = false;
        }
    }

    public void keyTyped(KeyEvent arg0)
    {

    }

    public void goleft(Player player)
    {
        if(Player.modelnow == Player.playermodeldown || Player.modelnow == Player.playermodeldown2) player.pos.y -= Player.playermodel.height - Player.playermodeldown.height;
        boolean left = true;
        for(int i = (int)player.pos.y; i < (int)player.pos.y + Player.playermodel.height; i++)
        {
            if((int)player.pos.x - 1 + player.hitboxleft < 0 || (int)player.pos.x - 1 + player.hitboxleft > player.map.WIDTH - 1 || i < 0 || i > player.map.HEIGHT - 1) continue;
            if(player.map.tiles[(int)player.pos.x - 1 + player.hitboxleft][i][0])
            {
                left = false;
                break;
            }
        }
        if(left) player.pos.x -= player.speed;
        player.direction = false;
        Player.modelnow = Player.playermodel2;
    }

    public void goright(Player player)
    {
        if(Player.modelnow == Player.playermodeldown || Player.modelnow == Player.playermodeldown2) player.pos.y -= Player.playermodel.height - Player.playermodeldown.height;
        boolean right = true;
        for(int i = (int)player.pos.y; i < (int)player.pos.y + Player.playermodel.height; i++)
        {
            if((int)player.pos.x + Player.playermodel.width - player.hitboxright + 1 < 0 || (int)player.pos.x + Player.playermodel.width - player.hitboxright + 1 > player.map.WIDTH -1 || i < 0 || i > player.map.HEIGHT - 1) continue;
            if(player.map.tiles[(int)player.pos.x + Player.playermodel.width - player.hitboxright + 1][i][0])
            {
                right = false;
                break;
            }
        }
        if(right) player.pos.x += player.speed;
        player.direction = true;
        Player.modelnow = Player.playermodel;
    }

    public void lookup(Player player)
    {
        if(Player.modelnow == Player.playermodeldown || Player.modelnow == Player.playermodeldown2) player.pos.y -= Player.playermodelup.height - Player.playermodeldown.height;
        if(Player.modelnow == Player.playermodel || Player.modelnow == Player.playermodel2) player.pos.y -= Player.playermodelup.height - Player.playermodel.height;
        if(player.direction) Player.modelnow = Player.playermodelup;
        else Player.modelnow = Player.playermodelup2;
    }

    public void down(Player player)
    {
        if(player.direction)
            Player.modelnow = Player.playermodeldown;
        else
            Player.modelnow = Player.playermodeldown2;
    }

    public void jump(Player player)
    {
        for(int i = (int)player.pos.x + player.hitboxleft; i < (int)player.pos.x + Player.modelnow.width - player.hitboxright; i++)
        {
            if(i < 0 || i > player.map.WIDTH - 1 || (int)player.pos.y + Player.modelnow.height < 0 || (int)player.pos.y + Player.modelnow.height > player.map.HEIGHT -1)
                continue;
            if(player.map.tiles[i][(int)player.pos.y + Player.modelnow.height][0])
            {
                player.vel.y = -7;
                break;
            }
        }
    }

    public void fire(Player player)
    {
        int i = 0;
        while (i < 4) {
            if (player.bullets[i] == null)
            {
                player.bullets[i] = player.shoot();
                player.directions[i] = player.direction;
                break;
            }
            i++;
        }
    }

    public void accept(int choice)
    {
        if(choice == 0) GameStateManager.change(GameStateManager.GAME_STATE_GAME, false);
        if(choice == 1) GameStateManager.change(GameStateManager.GAME_STATE_EXIT, false);
    }

    public void up(Menu menu)
    {
        menu.choice++;
    }

    public void down(Menu menu)
    {
        menu.choice--;
    }

    public void end()
    {
        GameStateManager.change(GameStateManager.GAME_STATE_MENU, false);
    }
}
