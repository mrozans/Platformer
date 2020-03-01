import Model.GS.GameStateManager;
import View.graphics.Screen;
import Controller.Contorller;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable
{
    private static final String TITLE = "Gra";
    public static final int WIDTH = 1024, HEIGHT = 576;
    private double timer = System.currentTimeMillis();
    private int FPS = 0;
    private int UPS = 0;
    private static final int framerate = 60;
    private double delta;
    private long timebefore = System.nanoTime();

    private boolean RUNNING = false;
    private JFrame frame;

    private Screen screen;

    private Contorller contorller = new Contorller();

    private GameStateManager gsm = new GameStateManager();

    private Main()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(contorller);
        frame = new JFrame();
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this, new BorderLayout().CENTER);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        int i = 17;
        screen = new Screen(16 * i, 9 * i);
    }

    private void start()
    {
        if(RUNNING) return;
        RUNNING = true;

        new Thread(this, "Game" + TITLE).start();
    }

    private void stop()
    {
        if(!RUNNING) return;
        RUNNING = false;
        frame.dispose();
        System.exit(0);
    }

    public void run()
    {
        while(RUNNING && !GameStateManager.exit)
        {
            long timenow = System.nanoTime();
            double frametime = 1000000000 / framerate;
            delta += (timenow - timebefore) / frametime;
            timebefore = timenow;
            while(delta >= 1)
            {
                update();
                delta--;
                UPS++;
            }

            render();
            FPS++;


            if(System.currentTimeMillis() - timer >= 1000)
            {
                timer = System.currentTimeMillis();
                frame.setTitle(TITLE + "FPS: " + FPS + " UPS: " + UPS);
                FPS = 0;
                UPS = 0;
            }
        }
        stop();
    }

    private void update()
    {
        contorller.update();
        gsm.update();
    }

    private void render()
    {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null)
        {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT );

        screen.clear(0xFFFF00);

        gsm.render(screen);

        g.drawImage(screen.getImage(), 0, 0, WIDTH, HEIGHT, null);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args)
    {
        new Main().start();
    }
}