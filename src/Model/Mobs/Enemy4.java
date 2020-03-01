package Model.Mobs;

import View.Maps.Map;
import Model.math.Vec;
import View.graphics.Sprite;
import View.graphics.Spritescheet;

public class Enemy4 extends Mob
{
    private static Sprite mobmodel = new Sprite(125, 81, 8, 8, Spritescheet.def1);
    public Enemy4(Vec pos, Map map)
    {
        time = System.currentTimeMillis();
        this.pos = pos;
        vel = new Vec(0.0f, 0.0f);
        HP = 1;
        modelnow = mobmodel;
        down = true;
        this.map = map;
    }

    public void update(Sprite mod, Player player)
    {
        if(player != null && (int)pos.x + modelnow.width / 2 > (int)player.pos.x + Player.playermodel.width / 2)
        {
            if(pos.x - 1 > 0 && pos.y - 1 > 0 && map.tiles[(int)pos.x - 1][(int)pos.y - 1][0]) pos.x--;
        }

        else if(player != null && (int)pos.x + modelnow.width / 2 < (int)player.pos.x + player.playermodel.width / 2)
        {
            if(pos.x + modelnow.width < map.WIDTH && pos.y - 1 > 0 && map.tiles[(int)pos.x + modelnow.width][(int)pos.y - 1][0]) pos.x++;
        }

        super.update(modelnow, null);
    }
}
