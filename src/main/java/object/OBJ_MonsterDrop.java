package object;

import javax.imageio.ImageIO;
import java.io.IOException;

import entity.Entity;
import main.GamePanel;

public class OBJ_MonsterDrop extends Entity {

    public OBJ_MonsterDrop(GamePanel gp) {
        super(gp);
        name = "Drop";
       /* try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/EnemyDrop.png"));
            image = ImageIO.read(getClass().getResourceAsStream("/objects/EnemyDrop2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}