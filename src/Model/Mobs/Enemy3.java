package Model.Mobs;

import View.Maps.Map;
import Model.math.Vec;
import View.graphics.Sprite;
import View.graphics.Spritescheet;

public class Enemy3 extends Mob
{
    private static Sprite mobmodel = new Sprite(119, 97, 16, 16, Spritescheet.def1);
    private static Sprite mobmodel2 = new Sprite(141, 97, 16, 16, Spritescheet.def1);

    public Enemy3(Vec pos, boolean model, Map map)
    {
        direction = !model;
        time = System.currentTimeMillis();
        this.pos = pos;
        vel = new Vec(0.0f, 0.0f);
        HP = 3;
        if(model) modelnow = mobmodel;
        else  modelnow = mobmodel2;
        offset = 3;
        this.map = map;
    }
}
