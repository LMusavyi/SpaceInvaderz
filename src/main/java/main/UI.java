package main;

import entity.Entity;
import object.OBJ_Health;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    BufferedImage full_Life, half_Life, zero_Life;
    public boolean messageON = false;
    public String message = "";
    public int commandNum = 0;


    public UI(GamePanel gp) {

        this.gp = gp;

        Entity Life = new OBJ_Health(gp);
        full_Life = Life.image;
        half_Life = Life.image2;
        zero_Life = Life.image3;

    }
//FIGURE OUT LATER IF YOU WANT!!!!!!!!!!!!!!!!!!!!!!
   /* public void showMessage(String text) {

        message = text;
        messageON = true;
    }

    */
    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        if(gp.gameState == gp.playState) {
            drawPlayerLife();
        }
        if(gp.gameState == gp.pauseState) {

            drawPauseScreen();
            drawPlayerLife();
        }
        if(gp.gameState == gp.titleState) {
            drawTitleScreen();
        }


    }

    public void drawPlayerLife () {

        int x = gp.unitSize/2;
        int y = gp.unitSize/2;
        int i = 0;

        //Max life
        while(i < gp.player.maxHealth/2) {
            g2.drawImage(zero_Life, x, y, null);
            i++;
            x += gp.unitSize;
        }

        x = gp.unitSize/2;
        y = gp.unitSize/2;
        i=0;

        //Current life
        while(i < gp.player.health){
            g2.drawImage(half_Life, x,y,null);
            i++;
            if(i < gp.player.health) {
                g2.drawImage(full_Life, x, y, null );
                g2.drawString("x"+"gp.player.health", x, y);

            }
            i++;
            x += gp.unitSize;
        }

    }

    public void drawPauseScreen() {

        String text = "GAME PAUSED";
        int x = getXforCenteredText(text);

        int y = gp.screenHeight/2;
        g2.drawString(text, x, y);
    }

    public void drawTitleScreen() {
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96));
        String text = "Space Invaders";
        int x = getXforCenteredText(text);
        int y = gp.unitSize*3;

        g2.setColor(Color.GRAY);
        g2.drawString(text, x+5, y+5);
        g2.setColor(Color.white);
        g2.drawString(text, x,y);

        x = (gp.screenWidth/2)+50;
        y += gp.unitSize *2;
        g2.drawImage(gp.player.shot1x1,x,y, gp.unitSize*13, gp.unitSize*13, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48));

        text = "NEW GAME";
         x = getXforCenteredText(text);
         y += gp.unitSize*4;
         g2.drawString(text, x, y);
         if(commandNum==0) {
             g2.drawString(">",x-gp.unitSize,y);
         }

        text = "EXIT";
        x = getXforCenteredText(text);
        y += gp.unitSize*5;
        g2.drawString(text, x, y);
        if(commandNum==1) {
            g2.drawString(">",x-gp.unitSize,y);
        }


    }

    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
