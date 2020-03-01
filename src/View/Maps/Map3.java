package View.Maps;

import Model.Mobs.Enemy3;
import Model.Mobs.Enemy4;
import Model.Mobs.Mob;
import Model.math.Vec;
import View.graphics.Screen;

public class Map3 extends Map
{
    public Map3()
    {
        Enemy3 mob = new Enemy3(new Vec(50, 40), false, this);
        Enemy4 mob2 = new Enemy4(new Vec(50, 69), this);
        mobs = new Mob[]  {mob, mob2};
    }

    public void render(Screen s)
    {
        super.render(s);
        upperbase.render(s, this, 1, 5);
        upperbase.render(s, this, 2, 5);

        for(int i = 5; i < 10; i++)
        {
            upperbase.render(s, this, i, 5);
        }

        platform.render(s, this, 2, 6);
        pilar.render(s, this, 13, 1);
    }
}
