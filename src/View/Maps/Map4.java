package View.Maps;

import Model.Mobs.Enemy1;
import Model.Mobs.Enemy3;
import Model.Mobs.Mob;
import Model.Mobs.Spikes;
import Model.math.Vec;
import View.graphics.Screen;

public class Map4 extends Map
{

    public Map4()
    {
        Enemy1 mob = new Enemy1(new Vec(210, 25), this);
        Enemy3 mob2 = new Enemy3(new Vec(50, 122), false, this);
        Spikes sp1 = new Spikes(new Vec(167, 131), this);
        Spikes sp2 = new Spikes(new Vec(154, 131), this);
        mobs = new Mob[]  {mob, mob2, sp1, sp2};
    }

    public void render(Screen s)
    {
        for(int i = 0; i < 5; i++)
        {
            upperbase.render(s, this, i, 5);
        }
        upperbase.render(s, this, 7, 5);
        pilar.render(s, this, 1, 1);
        super.render(s);
    }
}
