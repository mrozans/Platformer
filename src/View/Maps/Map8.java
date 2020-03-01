package View.Maps;

import Model.Mobs.Enemy1;
import Model.Mobs.Enemy2;
import Model.Mobs.Mob;
import Model.math.Vec;
import View.graphics.Screen;

public class Map8 extends Map
{
    public Map8()
    {
        Enemy2 mob = new Enemy2(new Vec(150, 36), this);
        Enemy1 mob2 = new Enemy1(new Vec(20, 104), this);
        mobs = new Mob[]  {mob, mob2};
    }

    public void render(Screen s)
    {
        pilar.render(s, this, 16, 0);
        pilar.render(s, this, 16, 1);

        for(int i = 0; i < 6; i++)
        {
            upperbase.render(s, this, i, 6);
        }

        super.render(s);
    }
}
