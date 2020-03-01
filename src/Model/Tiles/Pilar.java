package Model.Tiles;

import View.graphics.Sprite;
import View.graphics.Spritescheet;

public class Pilar extends Tile
{
    public Pilar()
    {
        WIDTH = 16;
        HEIGHT = 64;
        OFFSET = 9;
        sp = new Sprite(37, 135, WIDTH, HEIGHT, Spritescheet.def1);
    }
}
