/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.Player;
/**
 *
 * @author LazTheGreat
 */
public class GamePanel extends JPanel implements Runnable{
    
    final int originalUnitSize = 12;
    final int scale = 3;
    
    public final int unitSize = scale * originalUnitSize;
    final int maxScreenCol = 35;
    final int maxScreenRow = 25;
    final int screenWidth = unitSize * maxScreenCol;
    final int screenHeight = unitSize * maxScreenRow;
    
    //FPS
     
    int FPS = 60;
    
    Thread gameThread;
    Movement move = new Movement();
    Player player = new Player(this,move);
    
    
    public GamePanel () {
        Color SpaceBlue = new Color(0,0,51);
        this.setPreferredSize(new Dimension( screenWidth, screenHeight));
        this.setBackground(SpaceBlue);
        this.setDoubleBuffered(true);
        this.addKeyListener(move);
        this.setFocusable(true);
        
        
        
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    
    public void update() { 
        
       player.update();
    
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        player.draw(g2);
        
        g2.dispose();
    }
    
   

    @Override
    public void run() {
         
           double drawInterval = 1000000000/FPS;
           double nextDrawTime = System.nanoTime() + drawInterval;
           
       while (gameThread != null) {
          
           //receives feedback to tell whether anything has changed
          update();
          //changes game visuals based on changes player interaction
          repaint();
          
         try{
             double remainingTime = nextDrawTime - System.nanoTime();
             remainingTime = remainingTime/1000000;
             if(remainingTime < 0) {
                 remainingTime = 0;
             }
          
          Thread.sleep((long) remainingTime);
          nextDrawTime += drawInterval;
          
         } catch (InterruptedException e) {
             e.printStackTrace();
         } 
       }
    }
    
}
