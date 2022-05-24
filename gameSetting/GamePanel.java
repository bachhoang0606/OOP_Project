/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameSetting;

import entity.Entity;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import entity.Player;
import java.util.ArrayList;
import java.util.Collections;
import object.OriginObject;
import object.StaticObject;
import object.TileManager;

/**
 *
 * @author HOANG XUAN BACH
 */
public class GamePanel extends JPanel implements Runnable{
    
    // SCREEN SETTING
    public final int tileSize = 48; // 48X48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize* maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize* maxScreenRow; // 576 pixels
    
    //WORLD SETTING 
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize* maxWorldCol;
    public final int worldHeight = tileSize* maxWorldRow;
    
    // FPS
    private int FPS = 60;
    
    // SYSTEM
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    public AssetSetter  aSetter = new AssetSetter(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    Thread gameThread;
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    
    // EINTITY AND OBJECT
    public Player player = new Player(this, keyH);
    public StaticObject obj[] = new StaticObject[10];
    public Entity[] npc = new Entity[10];
    public Entity[] monster = new Entity[20];
    ArrayList<OriginObject> entityList = new ArrayList<>();
    
    // GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playeState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    
    public GamePanel() {
         
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
//        playMusic(0);
        gameState = titleState;
    }
    
    public void startGameThread(){
        
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
          
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null){
//            System.out.println("System is running");
            // 1 UPDATE : update information such as chracter positions
            update();
            // 2 DRAW : draw the screen with the update information
            repaint();
                        
            try {
                
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                
                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void update(){
        
        if(gameState == playeState){
            // PLAYER
            player.update();
            
            // NPC
            for(int i = 0;i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
            
            // MONSTER
            for(int i = 0;i < monster.length; i++){
                if(monster[i] != null){
                    if(monster[i].isAlive() == true && monster[i].isDying() == false){
                        monster[i].update();
                    }
                    if(monster[i].isAlive() == false){
                        monster[i] = null;
                    }
                }
                
            }
        }
        if(gameState == pauseState){
            // notthing
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        //  DEBUG
        long drawStart = 0;
        if(keyH.checkDrawTime == true){
            drawStart = System.nanoTime();
        }

        Graphics2D g2  = (Graphics2D) g;
        
        // TITLE SCREEN
        if(gameState == titleState){
            ui.draw(g2);
        }
        // OTHER
        else {
            // TILE
            tileM.draw(g2);

            // ADD ENTITY TO THE LIST
            entityList.add(player);
            for(int i=0; i < npc.length; i++){
                if(npc[i] != null){
                    entityList.add(npc[i]);
                }
            }
            
            for(int i=0; i < obj.length; i++){
                if(obj[i] != null){
                    entityList.add(obj[i]);
                }
            }
            
            for(int i=0; i < monster.length; i++){
                if(monster[i] != null){
                    entityList.add(monster[i]);
                }
            }
            
            // SORT 
            Collections.sort(entityList, new EntityComparator());
             
            // DRAW ENTITY
            for(int i = 0;i < entityList.size();i++){
                entityList.get(i).draw(g2);
            }
            
            // EMPTY ENTITY LIST
            entityList.clear();
            
            // UI
            ui.draw(g2);
        }
        
        //  DEBUG
        long drawEnd = 0;
        long passed = 0;
        if(keyH.checkDrawTime == true){
            drawEnd = System.nanoTime();
            passed = - drawStart + drawEnd;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: "+passed, 10, 400);
            System.out.println("Draw Time: "+passed);
        }
        
        
        g2.dispose();
    }
    
    public void playMusic(int i){
        
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    
    public void stopMusic(){
        
        sound.stop();
    }
    
    public void playSE(int i){
        
        sound.setFile(i);
        sound.play();
    }
}