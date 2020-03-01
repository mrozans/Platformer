package View.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen
{
    public int WIDTH;
    public int HEIGHT;

    private BufferedImage image;
    int[] pixels;

    public Screen()
    {

    }

    public Screen(int w, int h)
    {
        WIDTH = w;
        HEIGHT = h;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    }

    public void clear(int color)
    {
        for(int i = 0; i < pixels.length; i++)
        {
            pixels[i] = color;
        }
    }

    public BufferedImage getImage()
    {
        return image;
    }

    public void renderSprite(int x, int y, Sprite sp)
    {
        for(int i = 0; i < sp.width; i++)
        {
            for(int j = 0; j < sp.height; j++)
            {
                pixel(x + i, y + j, sp.s.pixels[sp.x + i + (sp.y + j) * sp.s.WIDTH]);
            }
        }
    }

    void pixel(int x, int y, int color)
    {
        if(x < 0 || x >= WIDTH || y < 0 || y >=HEIGHT || color == 0xFFFF00FF) return;
        pixels[x + y * WIDTH] = color;
    }
}
