package Model.Tiles;

import View.graphics.Sprite;
import View.graphics.Spritescheet;

public class UpperBase extends Tile
{
    public UpperBase()
    {
        WIDTH = 30;
        HEIGHT = 10;
        OFFSET = 9;
        sp = new Sprite(59, 216, WIDTH, HEIGHT, Spritescheet.def1);
    }
}
