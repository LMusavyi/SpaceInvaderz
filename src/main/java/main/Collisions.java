package main;
import entity.Entity;
public class Collisions {
    GamePanel gp;
    public Collisions (GamePanel gp) {
        this.gp = gp;

    }

    public void checkSpace(Entity entity){
        int entityLeftX = entity.solidArea.x + entity.x;
        int entityRightX= entity.solidArea.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.y + entity.solidArea.y;
        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;


    }
    public int checkObject(Entity entity, boolean player) {

        int index = 999;

        for(int i = 0; i < gp.obj.length; i++){

            if(gp.obj[i]!=null) {

               entity.solidArea.x = entity.x + entity.solidArea.x;
               entity.solidArea.y = entity.y + entity.solidArea.y;

               gp.obj[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
               gp.obj[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;

                switch(entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collisionOn == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collisionOn == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collisionOn == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collisionOn == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                }
            }
        }

        return index;


    }

}
