package View.Maps;

import Model.Mobs.Enemy2;
import Model.Mobs.Mob;
import Model.math.Vec;
import View.graphics.Screen;

public class Map1 extends Map
{
    public Map1()
    {
        Enemy2 mob = new Enemy2(new Vec(230, 104), this);
        mobs = new Mob[]  {mob};
    }
}