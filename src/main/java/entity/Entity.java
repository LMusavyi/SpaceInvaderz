/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import main.UtilityTool;
import main.GamePanel;
import main.Movement;

import javax.imageio.ImageIO;

/**
 *
 * @author LazTheGreat
 */
public class Entity {

   public GamePanel gp;
   public String direction;
    public int x,y;
    public int speed;
    public int ship;
    public BufferedImage shot1x1, shot1x2, shot2x1, shot2x2, shot3x1, shot3x2;
 public BufferedImage image, image2, image3, up1,up2,left1,left2,down1,down2,right1,right2;
    public int spriteCounter = 0;
    public int spriteNumber = 0;



    //Sets area of avatar that collision acts on
    public Rectangle solidArea = new Rectangle( 1, 2, 46, 46);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;



    public String name;
    public int maxHealth;
    public int health;


    public Entity(GamePanel gp) {
        this.gp = gp;

    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

    }

    public BufferedImage setup(String imagePath) {

     UtilityTool uTool = new UtilityTool();
     BufferedImage image = null;

     try {
      image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
     }catch(IOException e) {
      e.printStackTrace();
     }
     return image;
    }




}
