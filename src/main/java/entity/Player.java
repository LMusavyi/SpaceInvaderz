/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.Movement;

/**
 *
 * @author LazTheGreat
 */
public class Player extends Entity {

    GamePanel gp;
    Movement move; 
    int ship;

    public Player(GamePanel gp, Movement move) {
        this.gp = gp;
        this.move = move;

        setDefaultValues();
        getProperSprite();

    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        //direction = null;
     
    }

    public void getProperSprite() {
  
        try {

          shot1 = ImageIO.read(new File()("/player/boy_down_1.png"));
          //shot2 = ImageIO.read(getClass().getResourceAsStream("./../src/res/player/Ship2.png"));
          //shot3 = ImageIO.read(getClass().getResourceAsStream("./../src/res/player/Ship3.png"));
         
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (move.movingUp == true) {
           
            y -= speed;
        }

        if (move.movingDown == true) {
          
            y += speed;
        }
        if (move.movingLeft == true) {
           
            x -= speed;
        }

        if (move.movingRight == true) {
        
            x += speed;
        }

    }

    public void draw(Graphics2D g2) {

        //  g2.setColor(Color.WHITE);
        //  g2.fillRect(x, y, gp.unitSize, gp.unitSize);
        BufferedImage image = null;

        if (spriteCounter == 1) {
            image = shot1;
        }
      /*  if (ship == 2) {
            image = shot2;
        }
        if (ship == 3) {
            image = shot3;

        }
*/
        g2.drawImage(image, x, y, gp.unitSize, gp.unitSize, null);

    }

}
