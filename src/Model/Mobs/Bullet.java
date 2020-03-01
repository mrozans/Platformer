package Model.Mobs;

import View.Maps.Map;
import Model.math.Vec;
import View.graphics.Screen;
import View.graphics.Sprite;
import View.graphics.Spritescheet;

public class Bullet
{
    Vec pos;
    Sprite bulletsp;
    boolean up;
    boolean player;

    public Bullet()
    {

    }
    Bullet(Vec pos, boolean player, boolean up)
    {
        this.player = player;
        this.pos = pos;
        Sprite bulletsp1 = new Sprite(13, 16, 4, 4, Spritescheet.def1);
        Sprite bulletsp2 = new Sprite(17, 16, 4, 4, Spritescheet.def1);
        if(player) bulletsp = bulletsp1;
        else bulletsp = bulletsp2;
        this.up = up;
    }

    public void update(Map m, boolean direction, boolean down)
    {
        int speed;
        if(player) speed = 3;
        else speed = 1;
        if(down) pos.y += speed;

        else if(up)
        {
            pos.y -= speed;
        }

        else
        {
            if(direction) pos.x += speed;
            else pos.x -= speed;
        }

        for(int i = (int)pos.x; i < (int)pos.x + bulletsp.width; i++)
        {
            for(int j = (int)pos.y; j < (int)pos.y + bulletsp.height; j++)
            {
                if(j < 0 || j > m.HEIGHT - 1|| i < 0 || i > m.WIDTH - 1) continue;
                if(player) m.tiles[i][j][2] = true;
                    else m.tiles[i][j][4] = true;
            }
        }
    }

    boolean remove(Map m)
    {
        for(int i = (int)pos.x; i < (int)pos.x + bulletsp.width; i++)
        {
            for(int j = (int)pos.y; j < (int)pos.y + bulletsp.height; j++)
            {
                if(j < 0 || j > m.HEIGHT - 1|| i < 0 || i > m.WIDTH - 1) return true;
                if(m.tiles[i][j][0]) return true;
                if(player && m.tiles[i][j][3]) return true;
                else if(!player && m.tiles[i][j][1])
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void render(Screen s)
    {
        s.renderSprite((int)pos.x, (int)pos.y, bulletsp);
    }
}
