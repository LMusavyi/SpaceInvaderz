package enemies;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

public class Minions extends Entity {


    public Minions(GamePanel gp) {
        super(gp);

        name = "Minion";
        speed=1;
        maxHealth = 4;
        health = maxHealth;

        solidArea.x=3;
        solidArea.y=18;
        solidArea.width=42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }
    public void getImage () {
        up1 = setup("/enemy/Minion11");
        up2 = setup("/enemy/Minion12");
        down1 = setup("/enemy/Minion11");
        down2 = setup("/enemy/Minion12");
        left1 = setup("/enemy/Minion11");
        left2 = setup("/enemy/Minion12");
        right1 = setup("/enemy/Minion11");
        right2 = setup("/enemy/Minion12");


    }

    public void setAction() {
        actionLockCounter++;

        if(actionLockCounter ==120){
        Random rand = new Random();
        int i = rand.nextInt(100)+1;


            if(i <= 25) {
                direction="up";
            }
            if(i > 25 && i<=50 ) {
                direction="down";
            }
            if(i >50 && i<=75) {
                direction="left";
            }
            if(i > 75 && i <= 100) {
                direction="right";
            }
            actionLockCounter = 0;
            }
        }

    }

