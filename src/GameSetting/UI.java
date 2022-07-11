package GameSetting;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class UI {
    GamePanel gp;
    Font arial_40, arial_80B;
    Graphics2D g2;
    BufferedImage heart_full, heart_haft, heart_blank;    
    public boolean messageOn = false;
    public String message = "";
    int messageCount;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    Color colorTitleBackGround;
    Color colorStateBackGround;
    Color colorBountStateBackGround;
    public int commandNum = 0;
    public int titleScreenState = 0; // 0: the first screen, 1: the next screen
    
    
   
    public UI(GamePanel gp) {
        this.gp = gp;
        
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        colorTitleBackGround = new Color(70, 120, 80);
        colorStateBackGround = new Color(255, 0, 0, 200);
        colorBountStateBackGround = new Color(255, 0, 0);

    }
    
    public void showMessage(String text){
        
        message = text;
        messageOn = true;
    }
    
    public void draw(Graphics2D g2){
        
        this.g2 = g2;
        
        g2.setFont(arial_80B);
        g2.setColor(Color.white);
        
        // TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        // PLAY STATE
        if(gp.gameState == gp.playeState){
            
            if(gp.drawP.getPlayer().isKunaiAttacking() == true){
                drawTimeKunaiAttack();
            }
        }
        
        // PAUSTATE
        if(gp.gameState == gp.pauseState){
            
            drawPauseScreen();
            if(gp.drawP.getPlayer().isKunaiAttacking() == true){
                drawTimeKunaiAttack();
            }
        }
        
        // DIALOGSTATE
        if(gp.gameState == gp.dialogueState){
            
            drawDialogueScreen();
        }
        
        if(gp.gameState == gp.winState) {
        	winScreen();
        	 
        }
        
        if(gp.gameState == gp.lostState) {
        	lostScreen();
        }
    }

    
    public void drawTimeKunaiAttack(){
        
        int x = gp.drawP.getScreenX();
        int y = gp.drawP.getScreenY();
        g2.setColor(Color.black);
        g2.drawRect(x, y-gp.tileSize/2, gp.tileSize, 2);
        g2.setColor(Color.white);
        g2.drawRect(x, y-gp.tileSize/2, gp.tileSize*gp.drawP.getKunaiAttackCounter()/120, 2);
    }

    public void drawTitleScreen(){
        
        if(titleScreenState == 0){
            
            g2.setColor(colorTitleBackGround);
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            // TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 75F));
            String text = "Blue Boy Adventure";
            int x = getXforCenteredText(text);
            int y = gp.tileSize*3;

            // SHADOW
            g2.setColor(Color.black);
            g2.drawString(text, x+5, y+5);

            // MAIN COLOR 
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            // BLIE BOY IMAGE
            x = gp.screenWidth/2 - gp.tileSize;
            y += gp.tileSize*2;
            g2.drawImage(gp.drawP.getDown1(), x, y, gp.tileSize*2, gp.tileSize*2 ,null);

            // MENU
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 30F));

            text = "NEW GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize*3;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "LOAD GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">",  x-gp.tileSize, y);
            }

            text = "QUIT GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-gp.tileSize, y);
            }
        }
        else if(titleScreenState == 1){
            
        	
            // CLASS SELECTION SCREEN
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Select you class!";
            int x = getXforCenteredText(text);
            int y = gp.tileSize*3;
            g2.drawString(text, x, y);
            
            text = "Fighter";
            x = getXforCenteredText(text);
            y += gp.tileSize*3;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
            text = "Thief";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
            text = "Sorcerer";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
            text = "Back";
            x = getXforCenteredText(text);
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            if(commandNum == 3){
                g2.drawString(">", x-gp.tileSize, y);
            }

        }
        
    }
    
    public void drawPauseScreen(){
        
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);
    }
    
    public void winScreen(){
        
        String text = "Win Game";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        Color old = g2.getColor();
        g2.setColor(new Color(204, 51, 0));
        g2.drawString(text, x, y);
        g2.setColor(old);
    }
    
    public void lostScreen(){
        
        String text = "Lost Game";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        Color old = g2.getColor();
        g2.setColor(new Color(204, 51, 0));
        g2.drawString(text, x, y);
        g2.setColor(old);
    }
    
    private void drawDialogueScreen() {
        
        // WINDOW
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width  = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;
        drawSubWindow(x, y, width, height);
        
        g2.setFont(arial_40);
        x += gp.tileSize;
        y += gp.tileSize;
        
        for(String line : currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y += 40;
        }
    }
    
    public void drawSubWindow(int x, int y, int width, int height){
        
        Color c = new Color(0,0,0,200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        
        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }
    
    public int getXforCenteredText(String text){
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

    
}
