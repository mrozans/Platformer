package View.graphics;

import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.*;

public class SpritescheetTest
{
    private Spritescheet sp;

    @Before
    public void setUp()
    {
        sp = new Spritescheet("/space_merc.png");
    }

    @Test
    public void correctElements()
    {
        BufferedImage image;
        try
        {
            image = ImageIO.read(Spritescheet.class.getResource("/space_merc.png"));
        }

        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
        assertEquals(sp.WIDTH, image.getWidth());
        assertEquals(sp.HEIGHT, image.getHeight());
        assertEquals(sp.HEIGHT * sp.WIDTH, sp.pixels.length);
    }

}