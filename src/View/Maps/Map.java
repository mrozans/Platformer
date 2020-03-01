package View.Maps;

import Model.Mobs.Mob;
import Model.Mobs.Player;
import Model.Tiles.Base;
import Model.Tiles.Pilar;
import Model.Tiles.Platform;
import Model.Tiles.UpperBase;
import Model.math.Vec;
import View.graphics.Screen;


public class Map
{
    public final int WIDTH = 272, HEIGHT = 153;
    public boolean[][][] tiles = new boolean[WIDTH][HEIGHT][5]; //0-COLLISION, 1-PLAYER, 2-PLAYERBULLET, 3-ENEMY, 4-ENEMYBULLET
    private static final Base base = new Base();
    static final Platform platform = new Platform();
    static final UpperBase upperbase = new UpperBase();
    static final Pilar pilar = new Pilar();
    public static final Vec gravity = new Vec(0.0f, 0.5f);
    public Mob[] mobs;

    public void update(Player player)
    {
        for(int i = 0; i < this.WIDTH; i++)
        {
            for(int j = 0; j < this.HEIGHT; j++)
            {
                this.tiles[i][j][3] = false;
            }
        }

        for(int i = 0; i < this.WIDTH; i++)
        {
            for(int j = 0; j < this.HEIGHT; j++)
            {
                this.tiles[i][j][4] = false;
            }
        }

        if(mobs != null)
        {
            for(int i = 0; i < mobs.length; i++)
            {
                if(mobs[i] != null) if(Mobup(mobs[i], player)) mobs[i] = null;
            }
        }
    }

    boolean Mobup(Mob mob, Player player)
    {
        mob.update(mob.modelnow, player);
        if(mob.HP <= 0) mob.dead = true;
        return mob.dead && mob.remove();
    }

    public void render(Screen s)
    {
        if(mobs != null)
        {
            for(int i = 0; i < mobs.length; i++)
            {
                if(mobs[i] != null) mobs[i].render(s, mobs[i].modelnow);
            }
        }

        for(int i = 0; i < 6; i++)
        {
            if(this instanceof Map7 && i == 3) continue;
            base.render(s, this, i, 8);
        }
    }

    public boolean victory()
    {
        return false;
    }
}
