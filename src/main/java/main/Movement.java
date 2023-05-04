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

    public boolean movingUp, movingDown, movingLeft, movingRight;

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()) {

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            movingLeft = true;
        }

        if (code == KeyEvent.VK_RIGHT) {
            movingRight = true;
        }

        if (code == KeyEvent.VK_DOWN) {
            movingDown = true;
        }

        if (code == KeyEvent.VK_UP) {
            movingUp = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            movingLeft = false;
          
        }

        if (code == KeyEvent.VK_RIGHT) {
            movingRight = false;
        }

        if (code == KeyEvent.VK_DOWN) {
            movingDown = false;
        }

        if (code == KeyEvent.VK_UP) {
            movingUp = false;
        }

    }

}
