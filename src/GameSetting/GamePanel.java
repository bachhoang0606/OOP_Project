
package GameSetting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import Graphics.DrawSinhVat;
import Graphics.DrawVatThe;
import Graphics.DrawBossDragon;
import Graphics.DrawOldMan;
import Graphics.DrawPlayer;

import java.util.ArrayList;
import java.util.Collections;

import Object.Key;
import Object.Player;
import Object.TileManager;

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
    public UtilityTool uTool = new UtilityTool();

    // Draw
    public DrawPlayer drawP = new DrawPlayer(this, new Player(keyH));
    public DrawSinhVat[] drawM = new DrawSinhVat[20];
    public DrawOldMan[] drawN = new DrawOldMan[10];
    public DrawVatThe[] dobj = new DrawVatThe[10];
    ArrayList<DrawVatThe> list = new ArrayList<DrawVatThe>();
    
    // GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playeState = 1;
    public final int pauseState = 2;
    public final int winState = 3;
    public final int lostState = 4;
    public final int dialogueState = 5;
    
      
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
        	drawP.update();
            
        	if(drawP.getPlayer().getLife() <= 0) {
        		this.gameState = lostState;
        		this.stopMusic();
        		this.playSE(4);
        	}
        	
            // NPC
            for(int i = 0;i < drawN.length; i++){
                if(drawN[i] != null){
                	drawN[i].update();
                }
            }
            
            
            // Draw kunai of player
            for(int i = 0;i < drawP.getPlayer().getHasKunai()+1 ; i++){
                if(drawP.getPlayer().getPlayerKunai()[i] != null){
                    if(drawP.getDrawKunai()[i].getVatThe().isExist() == true ||
                    		drawP.getDrawKunai()[i].getVatThe().isDisappearing() == false){
                    	
                    	drawP.getDrawKunai()[i].update();
                    }    
                    if(drawP.getDrawKunai()[i].getVatThe().isExist() == false){
                    	drawP.getPlayer().getPlayerKunai()[i] = null;
                    	drawP.getDrawKunai()[i] = null;
                    }
                }
            }
            
            // MONSTER
            for(int i = 0;i < drawM.length; i++){
                if(drawM[i] != null){
                    if(drawM[i].getVatThe().isExist()== true && drawM[i].getSinhVat().isDying() == false){
                    	drawM[i].update();
                    }
                    if(drawM[i].getVatThe().isExist() == false){
                    	// quai chet cong exp cho nhan vat

                    	drawP.getPlayer().setExp(drawP.getPlayer().getExp() + drawM[i].getSinhVat().getExp());
                    	
                    	
                    	// boss roi ra chia khoa de mo cong
                    	if(drawM[i] instanceof DrawBossDragon) {
                    		for (int j = 0; j < dobj.length; j++) {
                    			if (dobj[j] == null) {
                    				dobj[j] = new DrawVatThe(this, new Key());
                    		        dobj[j].setImage(uTool.setup("data/Object/"+dobj[j].getVatThe().getName()+".png", tileSize, tileSize));
                    		        dobj[j].getVatThe().setWorldX(drawM[i].getVatThe().getWorldX());
                    		        dobj[j].getVatThe().setWorldY(drawM[i].getVatThe().getWorldY());
                    				break;
                    			}
                    		}
                    	}
                    	
                    	drawM[i] = null;
                    }
                }
            }
        }
        if(gameState == pauseState){
            // notthing
        }
        if (gameState == winState) {
        	// nothing
        }
        if (gameState == lostState) {
        	// nothing
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
            list.add(drawP);
            for(int i=0; i < drawN.length; i++){
                if(drawN[i] != null){
                	list.add(drawN[i]);
                }
            }
            
            // Add thuc the tinh trong game
            for(int i=0; i < dobj.length; i++){
                if(dobj[i] != null){
                	list.add(dobj[i]);
                }
            }
            
            // them monter trong game
            for(int i=0; i < drawM.length; i++){
                if(drawM[i] != null){
                	list.add(drawM[i]);
                }
            }
            
            // them nhan vat vao trong list ve
            for(int i=0; i < drawP.getPlayer().getPlayerKunai().length; i++){
                if(drawP.getDrawKunai()[i] != null){
                	list.add(drawP.getDrawKunai()[i]);
                }
            }
            
            // SORT 
            Collections.sort(list, new EntityComparator());
            
            // DRAW ENTITY
            for(int i = 0;i < list.size();i++){
            	if(list.get(i) != null) {
            		list.get(i).draw(g2);
            	}
            	
            }
            
            // EMPTY ENTITY LIST
            list.clear();
            
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