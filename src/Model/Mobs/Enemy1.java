package Model.Mobs;

import View.Maps.Map;
import Model.math.Vec;
import View.graphics.Sprite;
import View.graphics.Spritescheet;

public class Enemy1 extends Mob
{
    private static final Sprite mobmodel = new Sprite(95, 47, 26, 33, Spritescheet.def1);
    private static final Sprite mobmodel2 = new Sprite(53, 47, 26, 33, Spritescheet.def1);
    public Enemy1(Vec pos, Map map)
    {
        time = System.currentTimeMillis();
        this.pos = pos;
        vel = new Vec(0.0f, 0.0f);
        HP = 5;
        modelnow = mobmodel;
        this.map = map;
    }

    public void update(Sprite mod, Player player)
    {
        if(player != null && pos.x + modelnow.width / 2 > player.pos.x + player.playermodel.width / 2)
        {
            modelnow = mobmodel2;
            direction = false;
        }
        else
        {
            modelnow = mobmodel;
            direction = true;
        }
        super.update(modelnow, null);
    }
}
