/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;





import GameSetting.KeyHandler;
import Graphics.DrawKunai;
import Graphics.DrawOldMan;
import Graphics.DrawPlayer;
import Graphics.DrawSinhVat;
import InterFace.NoiChuyen;

/**
 *
 * @author HOANG XUAN BACH
 */
public class Player extends SinhVat implements NoiChuyen{
    
	private Kunai[] playerKunai;
    
    
    private int hasKunai;
    private int hasKey;
        
    private boolean kunaiAttacking;
    private boolean attacking;

    private String[] dialogues;

    public Player(KeyHandler keyH) {
    	// SinhVat(String name, int maxLife, int maxMp, int maxDefense, int maxExp, int speed, int type)
    	// maxlife = maxMP = 100
    	// maxDefecse = 50
    	// maxExp = 100
    	// speed = 4
    	// type = 0
    	// damge = 40
        super("Player", 100, 100, 50, 100, 4, 0, 40);
        
        playerKunai = new Kunai[40];
        hasKunai = 10;
        hasKey = 0;
        kunaiAttacking = false;
        attacking = false;
        dialogues = new String[20];
        
        setDefense(5);
        setDialogue();
	}
    
    public Kunai[] getPlayerKunai() {
		return playerKunai;
	}

	public void setPlayerKunai(Kunai[] playerKunai) {
		this.playerKunai = playerKunai;
	}

	public boolean isAttacking() {
		return attacking;
	}

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}

    public int getHasKey() {
        return hasKey;
    }

    public void setHasKey(int hasKey) {
        this.hasKey = hasKey;
    }

    public boolean isKunaiAttacking() {
        return kunaiAttacking;
    }

    public void setKunaiAttacking(boolean kunaiAttacking) {
        this.kunaiAttacking = kunaiAttacking;
    }
    
    public int getHasKunai() {
        return hasKunai;
    }

    public void setHasKunai(int hasKunai) {
        this.hasKunai = hasKunai;
    }

	public String[] getDialogues() {
		return dialogues;
	}

	public void setDialogues(String[] dialogues) {
		this.dialogues = dialogues;
	}

	

    public void kunaiAttack(DrawPlayer Dplayer) {
        
        if(Dplayer.getKunaiAttackCounter() == 0){

            if(hasKunai > 0 && this.getMp() >= 10){
            
            	this.setMp(this.getMp() - 10);
                int startAttackX = Dplayer.getWorldX() + Dplayer.getSolidArea().x;
                int startAttackY = Dplayer.getWorldY() + Dplayer.getSolidArea().y;

                this.playerKunai[hasKunai-1] = new Kunai();
                Dplayer.getDrawKunai()[hasKunai-1] = new DrawKunai(Dplayer.gp, this.playerKunai[hasKunai-1]);
                Dplayer.getDrawKunai()[hasKunai-1].setImage(Dplayer.uTool.setup("data/Object/"+this.playerKunai[hasKunai-1].getName()+".png", 
                																	Dplayer.getGp().tileSize, 
                																	Dplayer.getGp().tileSize
                																)
                											);

                switch(Dplayer.getDirection()){
                    case "up": startAttackY -= Dplayer.getDrawKunai()[hasKunai-1].getSolidArea().height; break;
                    case "down": startAttackY += Dplayer.getSolidArea().height; break;
                    case "left": startAttackX -= Dplayer.getDrawKunai()[hasKunai-1].getSolidArea().height; break;
                    case "right": startAttackX += Dplayer.getSolidArea().height; break;
                }

                Dplayer.getDrawKunai()[hasKunai-1].setDirection(Dplayer.getDirection());
                Dplayer.getDrawKunai()[hasKunai-1].setWorldX(startAttackX);
                Dplayer.getDrawKunai()[hasKunai-1].setWorldY(startAttackY);
                Dplayer.getDrawKunai()[hasKunai-1].setStartAttackX(startAttackX);
                Dplayer.getDrawKunai()[hasKunai-1].setStartAttackY(startAttackY);
                this.playerKunai[hasKunai-1].setSpeed(this.getSpeed()+3);
                hasKunai--;
            }
        }
        
        Dplayer.setKunaiAttackCounter(Dplayer.getKunaiAttackCounter() + 1);
        if(Dplayer.getKunaiAttackCounter() > 120){
        	Dplayer.setKunaiAttackCounter(0);
            kunaiAttacking = false;
        }
    }
    
    public void attacking(DrawPlayer Dplayer){
        
    	Dplayer.setSpriteCounter(Dplayer.getSpriteCounter()+1);
        
        if(Dplayer.getSpriteCounter() <= 5){
        	Dplayer.setSpriteNum(1);
        }
        if(Dplayer.getSpriteCounter() > 5 && Dplayer.getSpriteCounter() <= 25){
        	Dplayer.setSpriteNum(2);
            
            // Save the current worldX, worldY, solidArea
            int currentWorldX = Dplayer.getWorldX();
            int currentWorldY = Dplayer.getWorldY();
            int solidAreaWith = Dplayer.getSolidArea().width;
            int solidAreaHeight = Dplayer.getSolidArea().height;
            
            // Adjust player/s worldX/Y for the attackArea
            switch(Dplayer.getDirection()){
                case "up": Dplayer.setWorldY(Dplayer.getWorldY() - Dplayer.getAttackArea().height); break;
                case "down": Dplayer.setWorldY(Dplayer.getWorldY() + Dplayer.getSolidArea().height); break;
                case "left": Dplayer.setWorldX(Dplayer.getWorldX() - Dplayer.getAttackArea().width); break;
                case "right": Dplayer.setWorldX(Dplayer.getWorldX() + Dplayer.getSolidArea().width); break;
            }
            
            Dplayer.getSolidArea().width = Dplayer.getAttackArea().width;
            Dplayer.getSolidArea().height = Dplayer.getAttackArea().height;
            
            // Check monster collision with the updated worldX, worldY and solidArea
            DrawSinhVat monterIndex = Dplayer.gp.cChecker.checkEntity(Dplayer, Dplayer.gp.drawM);
            damageMonster(monterIndex, Dplayer);
            
            // After checking collision, restore the original data
            Dplayer.setWorldX(currentWorldX);
            Dplayer.setWorldY(currentWorldY);
            Dplayer.getSolidArea().width = solidAreaWith;
            Dplayer.getSolidArea().height = solidAreaHeight;
            
        }
        if(Dplayer.getSpriteCounter() > 25){
        	Dplayer.setSpriteNum(1);
        	Dplayer.setSpriteCounter(0);
        	setAttacking(false);
        }
    }
    
    public void pickUpObject(int i, DrawPlayer Dplayer){
        
        if(i != 999){
            
            String objectName = Dplayer.gp.dobj[i].getVatThe().getName();
            
            switch(objectName){
                case "key":
                	Dplayer.gp.playSE(1);
                    hasKey++;
                    Dplayer.gp.dobj[i] = null;
                    Dplayer.gp.ui.showMessage("You got a key!");
                    break;
                case "door":
                    if(hasKey > 0){
                    	Dplayer.gp.dobj[i] = null;
                        hasKey--;
                        Dplayer.gp.playSE(3);
                        Dplayer.gp.ui.showMessage("You opened the door!");
                    }
                    else {
                    	Dplayer.gp.ui.showMessage("You need the key!");
                    }
                    break;
                case "boots":
                	Dplayer.gp.ui.showMessage("Speed up!");
                	Dplayer.gp.playSE(2);
                    setSpeed(getSpeed()+2);
                    Dplayer.gp.dobj[i] = null;
                    break;
                case "chest":
                	Dplayer.gp.ui.gameFinished = true;
                	Dplayer.gp.stopMusic();
                	Dplayer.gp.playSE(4);
                    break;
                case "kunai":
                	Dplayer.gp.dobj[i] = null;
                	if (Dplayer.getPlayer().getHasKunai()+10 > 40)
                	{
                		Dplayer.getPlayer().setHasKunai(40);
                		break;
                	}
                	Dplayer.getPlayer().setHasKunai(Dplayer.getPlayer().getHasKunai()+10);
                	Dplayer.gp.playSE(1);
                	break;
          }
        }    
    }
    
    public void contactMonster(DrawSinhVat monster, DrawPlayer Dplayer) {
        
        if(monster != null && !(monster instanceof DrawOldMan)){
            
            if(Dplayer.isInvincible() == false){
            	// am thanh trung dich
            	Dplayer.gp.playSE(6);
            	
            	// tru mau khi cham monster neu giap nhieu hon thi tru 1
            	if(monster.getSinhVat().getDamge() - this.getDefense() > 0) {
            		this.setLife(this.getLife()-(monster.getSinhVat().getDamge() - this.getDefense()));
            	}else this.setLife(this.getLife()-1);
                Dplayer.setInvincible(true);
            }

        }
    }
    
    public void interactNPC(DrawOldMan npc, DrawPlayer Dplayer) {
        
        if(Dplayer.gp.keyH.enterPressed == true){
            if(npc != null){
            	Dplayer.gp.gameState = Dplayer.gp.dialogueState;
            	npc.DrawSpeakSV();
            }
            else {
            	
            	if(Dplayer.getPlayer().getMp() >= 20)
            	{
            		Dplayer.getPlayer().setMp(Dplayer.getPlayer().getMp() - 20);
            		setAttacking(true);
            		Dplayer.gp.playSE(7);
            	}
                
            }
        }
        
    }

    public void damageMonster(DrawSinhVat sinhVatNhanDamge, DrawPlayer Dplayer){
        
        if( sinhVatNhanDamge != null){
            
            if(sinhVatNhanDamge.isInvincible() == false){
                
            	Dplayer.gp.playSE(5);
            	sinhVatNhanDamge.getSinhVat().setLife(
            			sinhVatNhanDamge.getSinhVat().getLife()
            			-(this.getDamge() - sinhVatNhanDamge.getSinhVat().getDefense())
            			);
            	sinhVatNhanDamge.setInvincible(true);
            	sinhVatNhanDamge.getSinhVat().damageReaction();
                
                if(sinhVatNhanDamge.getSinhVat().getLife() <= 0){
                	sinhVatNhanDamge.setDying(true);
                }
            }
        }
    }

    public void setDialogue() {
		
		dialogues[0] = "ok  ";
		dialogues[1] = "fgdfg";
		dialogues[2] ="adfdsfads";
		dialogues[3] = "asdfdsfsa";
    }
	
	public String speak(int dialogueIndex){
     
        return dialogues[dialogueIndex];
    }
	
	public void upLevel() {
		setMaxLife(getMaxLife()+50);
		setLife(getMaxLife());
		
		setMaxMp(getMaxMp()+50);
		
		setMaxExp(getMaxExp()+100);
		setExp(0);
		
		if (getDefense()+3 < getMaxDefense()) {
			setDefense(getDefense()+3);
		}

		setSpeed(getSpeed()+1);
		
		setDamge(getDamge()+10);

	}
}
