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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import entity.Entity;
import entity.Player;

/**
 *
 * @author LazTheGreat
 */
public class GamePanel extends JPanel implements Runnable {

    final int originalUnitSize = 12;
    final int scale = 3;


    public final int unitSize = scale * originalUnitSize;
    public final int maxScreenCol = 35;
    public final int maxScreenRow = 25;
    public int screenWidth = unitSize * maxScreenCol;
    public int screenHeight = unitSize * maxScreenRow;

    int FPS = 60;


    Thread gameThread;
    Movement direction = new Movement(this);
    public Collisions collide = new Collisions(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public UtilityTool uTool = new UtilityTool();
    public Player player = new Player(this, direction);
    public Entity obj[] = new Entity[10];
    public Entity Minions[] = new Entity[30];
    ArrayList<Entity> entityList = new ArrayList<>();


    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;


    public GamePanel() {
        Color SpaceBlue = new Color(0, 0, 51);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(SpaceBlue);
        this.setDoubleBuffered(true);
        this.addKeyListener(direction);
        this.setFocusable(true);


    }

    public void setupGame() {

        aSetter.setMinions();
        gameState = titleState;

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void update() {
        if (gameState == playState) {
            player.update();

            for (int i = 0; i < Minions.length; i++) {
                if (Minions[i] != null) {
                    Minions[i].update();
                }
            }
        }


        if (gameState == pauseState) {


        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        if(gameState==titleState){
            ui.draw(g2);
        } else {

            entityList.add(player);

            for(int i = 0; i <Minions.length; i++){
                if(Minions[i] !=null) {
                    entityList.add(Minions[i]);
                }
            }

            for(int i = 0; i <obj.length; i++){
                if(obj[i] !=null) {
                    entityList.add(obj[i]);
                }
            }

            Collections.sort(entityList, new Comparator<Entity>() {

                @Override
                public int compare(Entity e1, Entity e2) {
                    int result  = Integer.compare(e1.y,e2.y);
                    return result;
                    }
                }
            );

            for(int i = 0 ; i< entityList.size(); i++){
                entityList.get(i).draw(g2);
            }
            entityList.clear();
            }

            ui.draw(g2);

            g2.dispose();

        }
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
