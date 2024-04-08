package object;

import entity.Entity;
import main.GamePanel;

;


public class OBJ_Health extends Entity {

    public OBJ_Health(GamePanel gp) {
        super(gp);

            name = "Life";

            image = setup("/objects/Full_Life");
            image2 = setup("/objects/Half_Life");
            image3 = setup("/objects/Zero_Life");

    }
}
