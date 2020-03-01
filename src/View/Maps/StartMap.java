package View.Maps;

import View.graphics.Screen;

public class StartMap extends Map
{

    public StartMap()
    {
    }

    public void render(Screen s)
    {
        pilar.render(s, this, 0, 1);
        super.render(s);
    }
}
