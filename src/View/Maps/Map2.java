package View.Maps;

import Model.Mobs.Enemy3;
import Model.Mobs.Mob;
import Model.Mobs.Spikes;
import Model.math.Vec;
import View.graphics.Screen;

public class Map2 extends Map
{

    public Map2()
    {
        Enemy3 mob = new Enemy3(new Vec(230, 122), true, this);
        Spikes sp1 = new Spikes(new Vec(200, 131), this);
        Spikes sp2 = new Spikes(new Vec(150, 131), this);
        Spikes sp3 = new Spikes(new Vec(100, 131), this);
        mobs = new Mob[]  {mob, sp1, sp2, sp3};
    }

    public void render(Screen s)
    {
        super.render(s);
    }
}
