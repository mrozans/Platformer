package Model.Mobs;

import View.Maps.Map;
import Model.math.Vec;
import View.graphics.Screen;
import View.graphics.Sprite;

public class Mob
{
    public Vec pos;
    public Vec vel;
    long time;
    public boolean direction;
    public int HP;
    public boolean dead;
    int offset;
    boolean down;
    public Sprite modelnow;
    public Bullet[] bullets;
    public boolean[] directions;
    public Map map;

    public Mob()
    {
        this.pos = new Vec(0, 0);
        vel = new Vec(0.0f, 0.0f);
        time = 0;
        HP = 1;
        dead = false;
        offset = 7;
        down = false;
        bullets = new Bullet[4];
        directions = new boolean[4];
    }

    public void update(Sprite modelnow, Player player)
    {
        for(int i = 0; i < 4; i++)
        {
            if(bullets[i] != null) bullets[i].update(map, directions[i], down);
            if(bullets[i] != null && bullets[i].remove(map)) bullets[i] = null;
        }

        if(dead) return;
        if(time == 0) time = System.currentTimeMillis();
        if (System.currentTimeMillis() - time > 1350)
        {
            time = 0;
            int i = 0;
            while (i < 4) {
                if (bullets[i] == null)
                {
                    bullets[i] = this.shoot(modelnow, offset);
                    directions[i] = direction;
                    break;
                }
                i++;
            }
        }

        for(int i = (int)pos.x; i < (int)pos.x + modelnow.width; i++)
        {
            boolean hit = false;
            for(int j = (int)pos.y; j < (int)pos.y + modelnow.height; j++)
            {
                if(i < 0 || i > map.WIDTH - 1|| j < 0 || j > map.HEIGHT - 1) continue;
                if(map.tiles[i][j][2])
                {
                    HP--;
                    hit = true;
                    break;
                }
            }
            if(hit) break;
        }

        if(!down) this.gravity();

        move(modelnow, 0);

        Set(modelnow, map);
    }

    void Set(Sprite modelnow, Map map)
    {
        for(int i = (int)pos.x; i < (int)pos.x + modelnow.width; i++)
        {
            for(int j = (int)pos.y; j < (int)pos.y + modelnow.height; j++)
            {
                if(j < 0 || j > map.HEIGHT - 1|| i < 0 || i > map.WIDTH - 1) continue;
                map.tiles[i][j][3] = true;
            }
        }
    }

    private Bullet shoot(Sprite modelnow, int offset)
    {
        Bullet b = new Bullet(new Vec(0, 0), false, false);
        if(down)
        {
            b.pos.x = pos.x + modelnow.width/2 - b.bulletsp.width/2;
            b.pos.y = pos.y + modelnow.height;
        }

        else
        {
            if(direction) b.pos.x = pos.x + modelnow.width;
            else b.pos.x = pos.x - b.bulletsp.width;
            b.pos.y = pos.y + offset;
        }
        return b;
    }

    void gravity()
    {
        vel.y += Map.gravity.y;
        if (vel.y > 12) vel.y = 12;
        else if (vel.y < -12) vel.y = -12;
    }

    void move(Sprite modelnow, int hitbox)
    {
        if(vel.y > 0)
        {
            for(int i = (int)pos.x + hitbox; i < (int)pos.x + modelnow.width - hitbox; i++)
            {
                if((int)pos.y + modelnow.height + (int)vel.y < 0 || (int)pos.y + modelnow.height + (int)vel.y > map.HEIGHT - 1 || i < 0 || i > map.WIDTH - 1) continue;
                if(map.tiles[i][(int)pos.y + modelnow.height + (int)vel.y][0])
                {
                    vel.y = 0;
                    break;
                }
            }
        }

        if(vel.y <= 0)
        {
            for(int i = (int)pos.x + hitbox; i < (int)pos.x + modelnow.width - hitbox; i++)
            {
                if((int)pos.y - 1 < 0 || (int)pos.y - 1 > map.HEIGHT - 1 || i < 0 || i > map.WIDTH - 1) continue;
                if(map.tiles[i][(int)pos.y - 1][0])
                {
                    vel.y = 0;
                    break;
                }
            }
        }

        pos.y += vel.y;
    }

    public boolean remove()
    {
        int j = 0;
        for(int i = 0; i < 4; i++)
        {
            if(bullets[i] == null) j++;
        }
        return j == 4;
    }

    public void render(Screen s, Sprite modelnow)
    {
        if(!dead) s.renderSprite((int)pos.x, (int)pos.y, modelnow);
        for(int i = 0; i < 4; i++)
        {
            if(bullets[i] != null) bullets[i].render(s);
        }
    }
}
