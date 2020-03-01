package View.graphics;

public class Sprite
{
    public int x, y, width, height;
    public Spritescheet s;

    public Sprite()
    {

    }

    public Sprite(int x, int y, int w, int h, Spritescheet s)
    {
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        this.s = s;
    }
}
