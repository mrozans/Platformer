package View.Maps;

import Model.Mobs.Enemy3;
import Model.Mobs.Mob;
import Model.Mobs.Spikes;
import Model.math.Vec;
import View.graphics.Screen;

public class Map7 extends Map
{
    public Map7()
    {
        Enemy3 mob = new Enemy3(new Vec(240, 45), true, this);
        Enemy3 mob2 = new Enemy3(new Vec(150, 45), true, this);
        Spikes sp1 = new Spikes(new Vec(40, 63), this);
        Spikes sp2 = new Spikes(new Vec(80, 63), this);
        Spikes sp3 = new Spikes(new Vec(120, 63), this);
        Spikes sp4 = new Spikes(new Vec(160, 63), this);
        Spikes sp5 = new Spikes(new Vec(200, 63), this);
        mobs = new Mob[]  {mob, mob2, sp1, sp2, sp3, sp4, sp5};
    }

    public void render(Screen s)
    {
        pilar.render(s, this, 1, 1);

        for(int i = 0; i < 9; i++)
        {
            upperbase.render(s, this, i, 6);
        }

        super.render(s);
    }
}
