package View.Maps;

import Model.Mobs.Enemy1;
import Model.Mobs.Mob;
import Model.math.Vec;
import View.graphics.Screen;

public class Map9 extends Map
{
    public Map9()
    {
        Enemy1 mob = new Enemy1(new Vec(230, 100), this);
        Enemy1 mob2 = new Enemy1(new Vec(20, 100), this);
        mobs = new Mob[]  {mob, mob2};
    }

    public void render(Screen s)
    {
        super.render(s);
        pilar.render(s, this, 0 , 0);
        pilar.render(s, this, 0 , 1);
        pilar.render(s, this, 16 , 0);
        pilar.render(s, this, 16 , 1);
    }

    public boolean victory()
    {
        return mobs[0] == null && mobs[1] == null;
    }
}
