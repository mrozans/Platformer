package View.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spritescheet
{
    public static final Spritescheet def1 = new Spritescheet("/space_merc.png");
    public static final Spritescheet def2 = new Spritescheet("/bg.png");
    public int WIDTH, HEIGHT;
    int[] pixels;

    public Spritescheet(String path)
    {
        try
        {
            BufferedImage image = ImageIO.read(Spritescheet.class.getResource(path));
            WIDTH = image.getWidth();
            HEIGHT = image.getHeight();
            pixels = new int[WIDTH * HEIGHT];
            image.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0 ,WIDTH);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
