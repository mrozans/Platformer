package View.Maps;

import Model.Mobs.Enemy4;
import Model.Mobs.Mob;
import Model.math.Vec;
import View.graphics.Screen;

public class Map6 extends Map
{
    public Map6()
    {
        Enemy4 mob = new Enemy4(new Vec(10, 19), this);
        Enemy4 mob2 = new Enemy4(new Vec(70, 19), this);
        Enemy4 mob3 = new Enemy4(new Vec(160, 19), this);
        Enemy4 mob4 = new Enemy4(new Vec(240, 19), this);
        mobs = new Mob[]  {mob, mob2, mob3, mob4};
    }

    public void render(Screen s)
    {
        pilar.render(s, this, 15, 1);
        upperbase.render(s, this, 0, 0);
        upperbase.render(s, this, 2, 0);
        upperbase.render(s, this, 3, 0);
        upperbase.render(s, this, 5, 0);
        upperbase.render(s, this, 6, 0);
        upperbase.render(s, this, 8, 0);
        platform.render(s, this, 1, 7);
        platform.render(s, this, 3, 7);
        platform.render(s, this, 4, 6);
        upperbase.render(s, this, 7, 6);
        upperbase.render(s, this, 8, 6);
        upperbase.render(s, this, 9, 6);
        super.render(s);
    }
}
