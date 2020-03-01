package Model.Mobs;

import View.Maps.Map;
import Model.math.Vec;
import View.graphics.Screen;
import View.graphics.Sprite;
import View.graphics.Spritescheet;
import Controller.Contorller;

import java.awt.event.KeyEvent;

public class Player extends Mob
{
    public static Sprite modelnow;
    public static Sprite playermodel = new Sprite(143, 47, 26, 33, Spritescheet.def1);
    public static Sprite playermodel2 = new Sprite(8, 47, 26, 33, Spritescheet.def1);
    public static Sprite playermodelup = new Sprite(111, 167, 19, 36, Spritescheet.def1);
    public static Sprite playermodelup2 = new Sprite(89, 167, 19, 36, Spritescheet.def1);
    public static Sprite playermodeldown = new Sprite(111, 135, 26, 25, Spritescheet.def1);
    public static Sprite playermodeldown2 = new Sprite(83, 135, 26, 25, Spritescheet.def1);
    private static Sprite dmgtaken = new Sprite(3, 16, 8, 6, Spritescheet.def1);
    private long lasttime;
    private boolean rest;
    public final float speed = 1.5f;
    public int hitboxright, hitboxleft;
    private Contorller controller = new Contorller();

    public Player()
    {

    }
    public Player(Map m)
    {
        modelnow = playermodel;
        this.pos = new Vec(30, 100);
        vel = new Vec(0.0f, 0.0f);
        HP = 3;
        map = m;
        direction = true;   //ture-prawo, false-lewo
        time = System.currentTimeMillis();
        rest = false;
    }

    public void update(Sprite mod, Player player)
    {
        for(int i = 0; i < map.WIDTH; i++)
        {
            for(int j = 0; j < map.HEIGHT; j++)
            {
                map.tiles[i][j][2] = false;
            }
        }

        for(int i = 0; i < 4; i++)
        {
            if(bullets[i] != null) bullets[i].update(map, directions[i], down);
            if (bullets[i] != null && bullets[i].remove(map)) bullets[i] = null;
        }

        int hitbox = 9;
        if(direction)
        {
            hitboxright = hitbox;
            hitboxleft = 0;
        }
        else
        {
            hitboxright = 0;
            hitboxleft = hitbox;
        }

        control();

        for(int i = (int)pos.x + hitboxleft; i < (int)pos.x + modelnow.width - hitboxright; i++)
        {
            if(System.currentTimeMillis() - lasttime < 3000)
            {
                rest = true;
                break;
            }
            rest = false;
            boolean hit = false;
            for(int j = (int)pos.y; j < (int)pos.y + modelnow.height; j++)
            {
                if(i < 0 || i > map.WIDTH - 1 || j < 0 || j > map.HEIGHT - 1) continue;
                if(map.tiles[i][j][3] || map.tiles[i][j][4])
                {
                    HP--;
                    lasttime = System.currentTimeMillis();
                    hit = true;
                    break;
                }
            }
            if(hit) break;
        }

        this.gravity();
        this.move(modelnow, hitbox);

        for(int i = 0; i < map.WIDTH; i++)
        {
            for(int j = 0; j < map.HEIGHT; j++)
            {
                map.tiles[i][j][1] = i >= (int) pos.x + hitboxleft && i < (int) pos.x + modelnow.width - hitboxright && j >= (int) pos.y && j < (int) pos.y + modelnow.height;
            }
        }
    }

    private void control()
    {
        if(Contorller.getKey(KeyEvent.VK_A)) controller.goleft(this);
        else if(Contorller.getKey(KeyEvent.VK_D)) controller.goright(this);
        else if(Contorller.getKey(KeyEvent.VK_W)) controller.lookup(this);
        else if(Contorller.getKey(KeyEvent.VK_S)) controller.down(this);
        if(Contorller.getKeyOnce(KeyEvent.VK_SPACE)) controller.jump(this);
        if(Contorller.getKeyOnce(KeyEvent.VK_K)) controller.fire(this);
    }

    public Bullet shoot()
    {
        Bullet b;
        if(modelnow == playermodelup || modelnow == playermodelup2)
        {
            b = new Bullet(new Vec(0, 0), true, true);
            b.pos.x = pos.x + modelnow.width/2 - b.bulletsp.width/2;
            b.pos.y = pos.y - b.bulletsp.height;
        }
        else
        {
            b = new Bullet(new Vec(0, 0), true, false);
            if(direction) b.pos.x = pos.x + modelnow.width;
            else b.pos.x = pos.x - b.bulletsp.width;
            b.pos.y = pos.y + 7;
        }
        return b;
    }

    public void render(Screen s)
    {
        s.renderSprite((int)pos.x, (int)pos.y, modelnow);
        for(int i = 0; i < 4; i++)
        {
            if(bullets[i] != null) bullets[i].render(s);
        }
        if(rest) s.renderSprite(49, 0, dmgtaken);
    }

}