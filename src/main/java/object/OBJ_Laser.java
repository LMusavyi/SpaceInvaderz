package object;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Laser extends Projectile {
    public OBJ_Laser(GamePanel gp) {
        super(gp);
        this.gp = gp;

        //name = "Laser";
        speed = 5;



    }
}
