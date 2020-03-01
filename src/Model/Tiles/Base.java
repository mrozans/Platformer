package Model.Tiles;

import View.graphics.Sprite;
import View.graphics.Spritescheet;

public class Base extends Tile
{
    public Base()
    {
        WIDTH = 48;
        HEIGHT = 16;
        OFFSET = 9;
        sp = new Sprite(131, 195, WIDTH, HEIGHT, Spritescheet.def1);

    }
}
