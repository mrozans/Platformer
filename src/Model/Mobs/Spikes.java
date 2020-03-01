package Model.Mobs;

import View.Maps.Map;
import Model.math.Vec;
import View.graphics.Sprite;
import View.graphics.Spritescheet;

public class Spikes extends Mob
{
    public Spikes(Vec pos, Map map)
    {
        modelnow = new Sprite(85, 94, 13, 6, Spritescheet.def1);
        this.pos = pos;
        HP = 1;
        this.map = map;
    }

    public void update(Sprite mod, Player player)
    {
        Set(modelnow, map);
    }
}
