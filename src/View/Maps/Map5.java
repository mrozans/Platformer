package View.Maps;

import Model.Mobs.*;
import Model.math.Vec;
import View.graphics.Screen;

public class Map5 extends Map
{
    public Map5()
    {
        Enemy2 mob = new Enemy2(new Vec(230, 104), this);
        Enemy4 mob2 = new Enemy4(new Vec(80, 39), this);
        Enemy4 mob3 = new Enemy4(new Vec(210, 39), this);
        mobs = new Mob[]  {mob, mob2, mob3};
    }

    public void render(Screen s)
    {
        upperbase.render(s, this, 0, 2);
        upperbase.render(s, this, 1, 2);
        upperbase.render(s, this, 2, 2);
        for(int i = 6; i < 10; i++)
        {
            upperbase.render(s, this, i, 2);
        }
        super.render(s);
    }
}
