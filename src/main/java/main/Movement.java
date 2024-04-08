/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author LazTheGreat
 */
public class Movement implements KeyListener {

    GamePanel gp;
    public boolean Up, Down, Left, Right;

    public Movement(GamePanel gp) {
        this.gp=gp;

    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()) {

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //Title state specific key handling
        if(gp.gameState== gp.titleState){
            if(code==KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 1;
                }
            }
            if(code==KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 1) {
                    gp.ui.commandNum = 0;
                }
            }
            if(gp.ui.commandNum==0){
                if(code==KeyEvent.VK_ENTER){
                    gp.gameState= gp.playState;
                }
            }
            if(gp.ui.commandNum==1){
                if(code==KeyEvent.VK_ENTER){
                    System.exit(0);
                }
            }
        }

        if (code == KeyEvent.VK_LEFT) {
            Left = true;
        }

        if (code == KeyEvent.VK_RIGHT) {
            Right = true;
        }

        if (code == KeyEvent.VK_DOWN) {
            Down = true;
        }

        if (code == KeyEvent.VK_UP) {
            Up = true;
        }
        if (code == KeyEvent.VK_P) {
            if(gp.gameState==gp.playState) {
                gp.gameState = gp.pauseState;
            } else if(gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            Left = false;
          
        }

        if (code == KeyEvent.VK_RIGHT) {
            Right = false;
        }

        if (code == KeyEvent.VK_DOWN) {
            Down = false;
        }

        if (code == KeyEvent.VK_UP) {
            Up = false;
        }

    }

}
