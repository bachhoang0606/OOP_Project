package Graphics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GameSetting.GamePanel;
import GameSetting.KeyHandler;
import GameSetting.UtilityTool;
import InterFace.DrawSpeak;
import Object.Player;

public class DrawPlayer extends DrawSinhVat implements DrawSpeak{
	
	private Player player;
	
	// RECTANGLE
    private Rectangle attackArea;
	
    private int dialogueIndex;
	
    private DrawKunai[] drawKunai;
	private final int screenX;
    private final int screenY;
	private int standCounter;
    private int kunaiAttackCounter;

    private KeyHandler keyH;
    
	public DrawPlayer(GamePanel gp, Player player) {
        
        super(gp, player);
        
        this.player = player;
        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;
        
        this.player.getSolidArea().x = 8;
        this.player.getSolidArea().y = 16;
        this.player.getSolidArea().width = getGp().tileSize - 16;
        this.player.getSolidArea().height = getGp().tileSize - 16;
        this.player.setSolidAreaDefaultX(this.player.getSolidArea().x);
        this.player.setSolidAreaDefaultY(this.player.getSolidArea().y);
        
        this.attackArea = new Rectangle(0, 0, 0, 0);
        this.attackArea.width = 36;
        this.attackArea.height = 36;
        
        setDefaultValues();
        getEntityImage();
        getPlayerAttackImage();
        
        this.dialogueIndex = 0;
        this.drawKunai = new DrawKunai[40];
        this.standCounter = 0;
        this.kunaiAttackCounter = 0;
        
    }
	
	public void setDefaultValues(){

		this.getVatThe().setWorldX(this.getGp().tileSize*23);
		this.getVatThe().setWorldY(this.getGp().tileSize*21);
       
		player.setLife(player.getMaxLife());
    }

	
	
	public Rectangle getAttackArea() {
		return attackArea;
	}

	public void setAttackArea(Rectangle attackArea) {
		this.attackArea = attackArea;
	}

	public KeyHandler getKeyH() {
		return keyH;
	}

	public void setKeyH(KeyHandler keyH) {
		this.keyH = keyH;
	}

	public int getDialogueIndex() {
		return dialogueIndex;
	}

	public void setDialogueIndex(int dialogueIndex) {
		this.dialogueIndex = dialogueIndex;
	}

	public DrawKunai[] getDrawKunai() {
		return drawKunai;
	}

	public void setDrawKunai(DrawKunai[] drawKunai) {
		this.drawKunai = drawKunai;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getStandCounter() {
		return standCounter;
	}

	public void setStandCounter(int standCounter) {
		this.standCounter = standCounter;
	}

	public int getKunaiAttackCounter() {
		return kunaiAttackCounter;
	}

	public void setKunaiAttackCounter(int kunaiAttackCounter) {
		this.kunaiAttackCounter = kunaiAttackCounter;
	}
	
	public int getScreenX() {
		return screenX;
	}

	public int getScreenY() {
		return screenY;
	}

	public void getEntityImage(){
	       
        UtilityTool uTool = new UtilityTool();
        
        setUp1(uTool.setup("data/Player/boy_up_1.png", gp.tileSize, gp.tileSize));
        setUp2(uTool.setup("data/Player/boy_up_2.png", gp.tileSize, gp.tileSize));
        setDown1(uTool.setup("data/Player/boy_down_1.png", gp.tileSize, gp.tileSize));
        setDown2(uTool.setup("data/Player/boy_down_2.png", gp.tileSize, gp.tileSize));
        setLeft1(uTool.setup("data/Player/boy_left_1.png", gp.tileSize, gp.tileSize));
        setLeft2(uTool.setup("data/Player/boy_left_2.png", gp.tileSize, gp.tileSize));
        setRight1(uTool.setup("data/Player/boy_right_1.png", gp.tileSize, gp.tileSize));
        setRight2(uTool.setup("data/Player/boy_right_2.png", gp.tileSize, gp.tileSize));
    }
    
    public void getPlayerAttackImage(){
        
        UtilityTool uTool = new UtilityTool();
        
        setAttackUp1(uTool.setup("data/Player/Attacking sprites/boy_attack_up_1.png", gp.tileSize, gp.tileSize*2));
        setAttackUp2(uTool.setup("data/Player/Attacking sprites/boy_attack_up_2.png", gp.tileSize, gp.tileSize*2));
        setAttackDown1(uTool.setup("data/Player/Attacking sprites/boy_attack_down_1.png", gp.tileSize, gp.tileSize*2));
        setAttackDown2(uTool.setup("data/Player/Attacking sprites/boy_attack_down_2.png", gp.tileSize, gp.tileSize*2));
        setAttackLeft1(uTool.setup("data/Player/Attacking sprites/boy_attack_left_1.png", gp.tileSize*2, gp.tileSize));
        setAttackLeft2(uTool.setup("data/Player/Attacking sprites/boy_attack_left_2.png", gp.tileSize*2, gp.tileSize));
        setAttackRight1(uTool.setup("data/Player/Attacking sprites/boy_attack_right_1.png", gp.tileSize*2, gp.tileSize));
        setAttackRight2(uTool.setup("data/Player/Attacking sprites/boy_attack_right_2.png", gp.tileSize*2, gp.tileSize));
        
    }
    public void update(){
    	
        // KUNAI ATTACK
        if(getGp().keyH.kPressed == true){
            player.setKunaiAttacking(true);
        }

        if(player.isKunaiAttacking() == true){
        	player.kunaiAttack(this);
        }
        if(player.isAttacking() == true){
        	player.attacking(this);
        }
        else if(getGp().keyH.upPressed == true || getGp().keyH.downPressed == true ||
        		getGp().keyH.leftPressed == true || getGp().keyH.rightPressed == true || 
        				getGp().keyH.enterPressed == true){

            if(getGp().keyH.upPressed == true){ this.getPlayer().setDirection("up");
            }else if(getGp().keyH.downPressed == true){ this.getPlayer().setDirection("down");
            }else if(getGp().keyH.leftPressed == true){ this.getPlayer().setDirection("left");
            }else if(getGp().keyH.rightPressed == true){ this.getPlayer().setDirection("right"); }

            //moving = true;

            // CHECK TILE COLLISION
            setCollisionOn(false);
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            player.pickUpObject(objIndex, this);

            // CHECK NPC COLLISION
            DrawSinhVat npcIndex = gp.cChecker.checkEntity(this, gp.drawN);
            player.interactNPC((DrawOldMan) npcIndex, this);

            // CHECK MONSTER COLLISION
            DrawSinhVat monsterIndex = gp.cChecker.checkEntity(this, gp.drawM);
            player.contactMonster(monsterIndex, this);
            
            
            // kiem tra va cham voi quai trieu hoi
            
            
            // CHECK EVENT
            gp.eHandler.checkEvent();

            if(isCollisionOn() == false && getGp().keyH.enterPressed == false){
                switch(this.getPlayer().getDirection()){
                    case "up": this.getVatThe().setWorldY(this.getVatThe().getWorldY()-player.getSpeed()); break;
                    case "down": this.getVatThe().setWorldY(this.getVatThe().getWorldY()+player.getSpeed()); break;
                    case "left": this.getVatThe().setWorldX(this.getVatThe().getWorldX()-player.getSpeed()); break;
                    case "right": this.getVatThe().setWorldX(this.getVatThe().getWorldX()+player.getSpeed()); break; 
                }
            }
                        
            setSpriteCounter(getSpriteCounter()+1);
                if(getSpriteCounter() > 12){
                    if(getSpriteNum() == 1){
                        setSpriteNum(2);
                    }
                    else if(getSpriteNum() ==2){
                        setSpriteNum(1);
                    }
                    setSpriteCounter(0);
                }
        }
        else {
        	setStandCounter(getStandCounter()+1);

            if(getStandCounter() == 20){
                setSpriteNum(1);
                setStandCounter(0);

            }
        }
        
        // This need to be outside of key if statement!
        if(this.getPlayer().isInvincible() == true){
            setInvincibleCounter(getInvincibleCounter()+1);
            if(getInvincibleCounter() > 60){
                this.getPlayer().setInvincible(false);
                setInvincibleCounter(0);
            }
        }   
        
        // thoi gian hoi phuc mot lan la 1 giay
        if (this.getThoiGianHoiPhuc() >= 60) {
        	this.player.recuperateMP();
        	this.setThoiGianHoiPhuc(0);
        }else this.setThoiGianHoiPhuc(this.getThoiGianHoiPhuc()+1);
        
        // nhan vat du exp nang cap
        if (this.player.getExp() >= this.player.getMaxExp()) {
        	this.player.upLevel(this);
        }
    }
    public void draw(Graphics2D g2){
        
        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;
        
        int attackWorldX = screenX;
        int attackWorldY = screenY;
        
        switch (this.getPlayer().getDirection()) {
        case "up":
            if(player.isAttacking() == false){
                if(getSpriteNum() == 1){ image = getUp1(); }
                if(getSpriteNum() == 2){ image = getUp2(); }
            }
            if(player.isAttacking() == true){
                tempScreenY -= gp.tileSize;
                if(getSpriteNum() == 1){ image = getAttackUp1(); }
                if(getSpriteNum() == 2){ image = getAttackUp2(); }
            }
            attackWorldY = attackWorldY - this.attackArea.height -4;
            break;
        case "down":
            if(player.isAttacking() == false){
                if(getSpriteNum() == 1){ image = getDown1(); }
                if(getSpriteNum() == 2){ image = getDown2(); } 
            }
            if(player.isAttacking() == true){
                if(getSpriteNum() == 1){ image = getAttackDown1(); }
                if(getSpriteNum() == 2){ image = getAttackDown2(); }
            }
            attackWorldY += this.player.getSolidArea().height;
            break;
        case "left":
            if(player.isAttacking() == false){
                if(getSpriteNum() == 1){ image = getLeft1(); }
                if(getSpriteNum() == 2){ image = getLeft2(); }
            }
            if(player.isAttacking() == true){
                tempScreenX -= gp.tileSize;
                if(getSpriteNum() == 1){ image = getAttackLeft1(); }
                if(getSpriteNum() == 2){ image = getAttackLeft2(); }
            }
            attackWorldX = attackWorldX - this.attackArea.width - 4;
            break;
        case "right":
            if(player.isAttacking() == false){
                if(getSpriteNum() == 1){ image = getRight1(); }
                if(getSpriteNum() == 2){ image = getRight2(); }
            }
            if(player.isAttacking() == true){
                if(getSpriteNum() == 1){ image = getAttackRight1(); }
                if(getSpriteNum() == 2){ image = getAttackRight2(); }
            }
            attackWorldX += this.player.getSolidArea().width;
            break;
        }
        
        getGp().ui.drawSubWindow(gp.tileSize/2 - 20, gp.tileSize/2 - 20,  gp.tileSize*5, gp.tileSize*4);
        drawPlayerLife(g2);
        drawMpBar(g2);
        drawExpBar(g2);
        drawPlayerKunai(g2);
        drawPlayerKey(g2);
        
        if(this.getPlayer().isInvincible() == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }
        
        g2.drawImage(image, tempScreenX, tempScreenY, null);
        
        // Reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
        if(gp.keyH.drawSolidArea == true){
//            g2.drawRect(screenX, screenY, gp.tileSize, gp.tileSize);
            g2.setColor(Color.red);
            g2.drawRect(screenX + this.player.getSolidArea().x, 
            		screenY + this.player.getSolidArea().y, 
            		this.player.getSolidArea().width, 
            		this.player.getSolidArea().height
            		);
            g2.drawRect(attackWorldX + this.player.getSolidArea().x, 
            		attackWorldY + this.player.getSolidArea().y, 
            		this.attackArea.width+4, 
            		this.attackArea.height+4);
        }
    }
    
//    public void DrawSpeakSV(){
//        
//    	if(player.speak(dialogueIndex) == null) {
//    		this.dialogueIndex = 0;
//    	}
//    	
//    	gp.ui.currentDialogue = player.speak(dialogueIndex);
//        dialogueIndex++;
//
//        switch(this.getPlayer().getDirection()){
//	        case "up": this.setDirection("down"); break;
//	        case "down": this.setDirection("up"); break;
//	        case "left": this.setDirection("right"); break;
//	        case "right": this.setDirection("left"); break;
//        }
//    }
    
    public void drawPlayerLife(Graphics2D g2){
        
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        
        int width = 3*gp.tileSize;
        int height = 20;
        
        Color old = g2.getColor();
        
        double oneScale = (double) width/this.getPlayer().getMaxLife();
        double hpBarValue = oneScale*this.getPlayer().getLife();
        
        g2.setColor(new Color(35, 35, 35));
        g2.drawRect(x, y, width+2, height);
        g2.setColor(new Color(255, 0, 30));
        g2.fillRect(x+1, y+1, (int) hpBarValue, height-2);
        g2.setColor(old);

    }
    
    public void drawMpBar(Graphics2D g2){
        
        int x = gp.tileSize/2;
        int y = gp.tileSize;
        
        int width = (int)2.5*gp.tileSize;
        int height = 15;
        
        Color old = g2.getColor();
        
        double oneScale = (double) width/this.getPlayer().getMaxMp();
        double mpBarValue = oneScale*this.getPlayer().getMp();
        g2.setColor(new Color(35, 35, 35));
        g2.drawRect(x, y, width+2, height);
        g2.setColor(new Color(0, 0, 255));
        g2.fillRect(x+1, y+1, (int) mpBarValue, height-2);
        g2.setColor(old);

    }
    
    public void drawExpBar(Graphics2D g2){
        
        int x = gp.tileSize*15;
        int y = gp.tileSize*3;
        
        int width = 20;
        int height = (int) gp.tileSize*7;
        
        Color old = g2.getColor();
        
        double oneScale = (double) height/this.getPlayer().getMaxExp();
        double barValue = oneScale*this.getPlayer().getExp();
        g2.setColor(new Color(35, 35, 35));
        g2.drawRect(x, y, width, height);
        g2.setColor(new Color(255, 0, 255));
        g2.fillRect(x+1, (int) (y+1 + height -(barValue-2)), (int) width-2, (int)barValue-2);
        
        g2.setColor(old);

    }

    public void drawPlayerKunai(Graphics2D g2){
        
        int x = gp.tileSize/2;
        int y = gp.tileSize*2;

        g2.drawImage(gp.dobj[6].getImage(), x+gp.tileSize/4+10, y+gp.tileSize/4+15, null);
        g2.setFont(g2.getFont().deriveFont(30f));
        g2.drawString(" X "+gp.drawP.getPlayer().getHasKunai(), x+gp.tileSize, y+gp.tileSize);
    }    
    public void drawPlayerKey(Graphics2D g2){
        
        int x = gp.tileSize/2;
        int y = gp.tileSize*1;
//        if(gp.dobj[7] == null)
        g2.drawImage(gp.dobj[7].getImage(), x+gp.tileSize/4+10, y+gp.tileSize/4+15, null);
        g2.setFont(g2.getFont().deriveFont(30f));
        g2.drawString(" X "+gp.drawP.getPlayer().getHasKey(), x+gp.tileSize, y+gp.tileSize);
    }

	@Override
	public void DrawSpeakSV() {
		// TODO Auto-generated method stub
		
	}
	
}
