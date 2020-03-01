package Model.Tiles;

import View.graphics.Sprite;
import View.graphics.Spritescheet;

public class Platform extends Tile
{
    public Platform()
    {
        WIDTH = 48;
        HEIGHT = 16;
        OFFSET = 9;
        sp = new Sprite(128, 216, WIDTH, HEIGHT, Spritescheet.def1);
    }
}
