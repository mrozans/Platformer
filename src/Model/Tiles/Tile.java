package Model.Tiles;

import View.Maps.Map;
import View.graphics.Screen;
import View.graphics.Sprite;

public class Tile
{
    public int WIDTH;
    public int HEIGHT;
    int OFFSET;
    Sprite sp;

    public void render(Screen s, Map m, int x, int y)
    {
        s.renderSprite(x * WIDTH, y * HEIGHT + OFFSET, sp);
        for(int i = y * sp.height + OFFSET; i < y * sp.height + 9 + sp.height; i++)
        {
            for(int j = x * sp.width; j < x * sp.width + sp.width; j++)
            {
                if(j < 0 || j > m.WIDTH - 1|| i < 0 || i > m.HEIGHT - 1) continue;
                m.tiles[j][i][0] = true;
            }
        }
    }
}
