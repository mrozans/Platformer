package Model.Mobs;

import View.Maps.Map;
import Model.math.Vec;
import View.graphics.Sprite;
import View.graphics.Spritescheet;

public class Enemy2 extends Mob
{
    private static Sprite mobmodel = new Sprite(12, 96, 26, 33, Spritescheet.def1);
    private static Sprite mobmodel2 = new Sprite(43, 96, 26, 33, Spritescheet.def1);

    public Enemy2(Vec pos, Map map)
    {
        time = System.currentTimeMillis();
        this.pos = pos;
        vel = new Vec(0.0f, 0.0f);
        HP = 2;
        modelnow = mobmodel;
        offset = 10;
        this.map = map;
    }

    public void update(Sprite mod, Player player)
    {
        float speed = 0.5f;
        if(player != null && pos.x + modelnow.width / 2 > player.pos.x + player.playermodel.width / 2)
        {
            direction = false;
            modelnow = mobmodel;
            boolean left = true;
            for(int i = (int)pos.y; i < (int)pos.y + modelnow.height; i++)
            {
                if((int)pos.x - 1 < 0 || (int)pos.x - 1 > map.WIDTH - 1 || i < 0 || i > map.HEIGHT - 1) continue;
                if(map.tiles[(int)pos.x - 1][i][0])
                {
                    left = false;
                    break;
                }
            }
            if(left) pos.x -= speed;
        }

        else
        {
            direction = true;
            modelnow = mobmodel2;
            boolean right = true;
            for(int i = (int)pos.y; i < (int)pos.y + modelnow.height; i++)
            {
                if((int)pos.x + modelnow.width < 0 || (int)pos.x + modelnow.width > map.WIDTH -1 || i < 0 || i > map.HEIGHT - 1) continue;
                if(map.tiles[(int)pos.x + modelnow.width][i][0])
                {
                    right = false;
                    break;
                }
            }
            if(right) pos.x += speed;
        }
        super.update(modelnow, null);
    }
}
