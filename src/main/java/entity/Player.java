/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.Movement;
import object.OBJ_Health;


/**
 * @author LazTheGreat
 */
public class Player extends Entity {


    Movement direction;



    public Player( GamePanel gp, Movement direction) {
        super(gp);

        this.direction=direction;

        solidArea = new Rectangle(8,16,32,32);



        setDefaultValues();
        getProperSprite();
        gp.setupGame();

    }

    public void setDefaultValues() {
        x = 100;
        y = 100 ;
        speed = 4;
        ship = 1;

        maxHealth = 6;
        health = maxHealth;

    }



    //MANAGES PLAYER ANIMATION
    public void getProperSprite() {

        try {
            //Each couple is the same ship with two different frames for the ships flame.
            shot1x1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/Ship11.png"));
            shot1x2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/Ship12.png"));

            shot2x1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/Ship21.png"));
            shot2x2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/Ship22.png"));

            shot3x1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/Ship31.png"));
            shot3x2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/Ship32.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (direction.Up) {

            y -= speed;
        }

        if (direction.Down) {

            y += speed;
        }
        if (direction.Left) {

            x -= speed;

        }

        if (direction.Right) {

            x += speed;

        }

        collisionOn = false;
        gp.collide.checkSpace(this);

        int objIndex = gp.collide.checkObject(this, true);
        pickUpObject(objIndex);

        int minionIndex = gp.collide.checkEntity(this, gp.Minions);

       /* if(collisionOn == false) {
            if (direction.Up) {

                y -= speed;
            }

            if (direction.Down) {

                y += speed;
            }
            if (direction.Left) {

                x -= speed;

            }

            if (direction.Right) {

                x += speed;

            }

        }*/

       //int objIndex = gp.collide.checkObject(this, true);

        //Sprite counter is updated at rate of 60/s.
        spriteCounter++;
        if (spriteCounter > 5) {
            if (spriteNumber == 0) {
                spriteNumber = 1;
            } else if (spriteNumber == 1) {
                spriteNumber = 0;
            }
            spriteCounter = 0;
        }
    }

    public void pickUpObject (int i){

        if(i != 999) {
           String objectName = gp.obj[i].name;

           switch (objectName) {
               case "Drop":

           }

        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        //Flickers between two sprites for first ship
        if(ship==1) {
            if (spriteNumber == 0) {
                image = shot1x1;
            }
            if (spriteNumber == 1) {
                image = shot1x2;
            }
        }

        //Flickers between two sprites for second ship
        if(ship==2) {
            if (spriteNumber == 0) {
                image = shot2x1;
            }
            if (spriteNumber == 1) {
                image = shot2x2;
            }
        }

        //Flickers between two sprites for third ship
        if(ship==3) {
            if (spriteNumber == 0) {
                image = shot3x1;
            }
            if (spriteNumber == 1) {
                image = shot3x2;
            }
        }

        g2.drawImage(image, x, y, gp.unitSize * 2, gp.unitSize * 2, null);
    }
}


