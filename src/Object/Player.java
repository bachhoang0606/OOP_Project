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
import Graphics.DrawVatThe;
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
        super("Player", 1000, 1000, 50, 100, 4, 0, 40);
        
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
                int startAttackX = Dplayer.getVatThe().getWorldX() + this.getSolidArea().x;
                int startAttackY = Dplayer.getVatThe().getWorldY() + this.getSolidArea().y;

                this.playerKunai[hasKunai-1] = new Kunai();
                Dplayer.getDrawKunai()[hasKunai-1] = new DrawKunai(Dplayer.gp, this.playerKunai[hasKunai-1]);
//                Dplayer.getDrawKunai()[hasKunai-1].setImage(Dplayer.uTool.setup("data/Object/"+this.playerKunai[hasKunai-1].getName()+".png", 
//                																	Dplayer.getGp().tileSize, 
//                																	Dplayer.getGp().tileSize));
                switch(Dplayer.getPlayer().getDirection()){
                    case "up": 
                    	Dplayer.getDrawKunai()[hasKunai-1].setImage(Dplayer.uTool.setup("data/Object/kunai_up.png", 
								Dplayer.getGp().tileSize, 
								Dplayer.getGp().tileSize));
                    	startAttackY -= this.playerKunai[hasKunai-1].getSolidArea().height; break;
                    case "down": 
                    	Dplayer.getDrawKunai()[hasKunai-1].setImage(Dplayer.uTool.setup("data/Object/kunai_down.png", 
								Dplayer.getGp().tileSize, 
								Dplayer.getGp().tileSize));
                    	startAttackY += this.getSolidArea().height; break;
                    case "left": 
                    	Dplayer.getDrawKunai()[hasKunai-1].setImage(Dplayer.uTool.setup("data/Object/kunai_left.png", 
								Dplayer.getGp().tileSize, 
								Dplayer.getGp().tileSize));
                    	startAttackX -= this.playerKunai[hasKunai-1].getSolidArea().height; break;
                    case "right": 
                    	Dplayer.getDrawKunai()[hasKunai-1].setImage(Dplayer.uTool.setup("data/Object/kunai_right.png", 
								Dplayer.getGp().tileSize, 
								Dplayer.getGp().tileSize));
                    	startAttackX += this.getSolidArea().height; break;
                }

                this.playerKunai[hasKunai-1].setDirection(Dplayer.getPlayer().getDirection());
                this.playerKunai[hasKunai-1].setWorldX(startAttackX);
                this.playerKunai[hasKunai-1].setWorldY(startAttackY);
                Dplayer.getDrawKunai()[hasKunai-1].setStartAttackX(startAttackX);
                Dplayer.getDrawKunai()[hasKunai-1].setStartAttackY(startAttackY);
                this.playerKunai[hasKunai-1].setSpeed(this.getSpeed()+3);
                this.playerKunai[hasKunai-1].setDamge(this.getDamge()/2);
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
            int currentWorldX = Dplayer.getVatThe().getWorldX();
            int currentWorldY = Dplayer.getVatThe().getWorldY();
            int solidAreaWith = this.getSolidArea().width;
            int solidAreaHeight = this.getSolidArea().height;
            
            // Adjust player/s worldX/Y for the attackArea
            switch(Dplayer.getPlayer().getDirection()){
                case "up": Dplayer.getVatThe().setWorldY(Dplayer.getVatThe().getWorldY() - Dplayer.getAttackArea().height); break;
                case "down": Dplayer.getVatThe().setWorldY(Dplayer.getVatThe().getWorldY() + this.getSolidArea().height); break;
                case "left": Dplayer.getVatThe().setWorldX(Dplayer.getVatThe().getWorldX() - Dplayer.getAttackArea().width); break;
                case "right": Dplayer.getVatThe().setWorldX(Dplayer.getVatThe().getWorldX() + this.getSolidArea().width); break;
            }
            
            this.getSolidArea().width = Dplayer.getAttackArea().width;
            this.getSolidArea().height = Dplayer.getAttackArea().height;
            
            // Check monster collision with the updated worldX, worldY and solidArea           
            DrawSinhVat monterIndex = Dplayer.gp.cChecker.checkEntity(Dplayer, Dplayer.gp.drawM);
            this.damageMonster(monterIndex, Dplayer);
            
            
            // After checking collision, restore the original data
            Dplayer.getVatThe().setWorldX(currentWorldX);
            Dplayer.getVatThe().setWorldY(currentWorldY);
            this.getSolidArea().width = solidAreaWith;
            this.getSolidArea().height = solidAreaHeight;
            
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
                	Dplayer.gp.gameState = Dplayer.gp.winState;
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
            
            if(Dplayer.getPlayer().isInvincible() == false){
            	// am thanh trung dich
            	Dplayer.gp.playSE(6);
            	
            	// tru mau khi cham monster neu giap nhieu hon thi tru 1
            	if(monster.getSinhVat().getDamge() - this.getDefense() > 0) {
            		this.setLife(this.getLife()-(monster.getSinhVat().getDamge() - this.getDefense()));
            	}else this.setLife(this.getLife()-1);
                Dplayer.getPlayer().setInvincible(true);
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
            
            if(sinhVatNhanDamge.getSinhVat().isInvincible() == false){
                
            	Dplayer.gp.playSE(5);
            	sinhVatNhanDamge.getSinhVat().setLife(
            			sinhVatNhanDamge.getSinhVat().getLife()
            			-(this.getDamge() - sinhVatNhanDamge.getSinhVat().getDefense())
            			);
            	sinhVatNhanDamge.getSinhVat().setInvincible(true);
            	sinhVatNhanDamge.getSinhVat().damageReaction(sinhVatNhanDamge, Dplayer);

                if(sinhVatNhanDamge.getSinhVat().getLife() <= 0){
                	sinhVatNhanDamge.getSinhVat().setDying(true);
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
	
	public void upLevel(DrawPlayer dPlayer) {
		dPlayer.gp.playSE(2);
		setMaxLife(getMaxLife()+50);
		setLife(getMaxLife());
		
		setMaxMp(getMaxMp()+50);
		setMp(getMaxMp());
		
		setExp(getExp()-getMaxExp());
		setMaxExp(getMaxExp()+100);

		if (getDefense()+3 < getMaxDefense()) {
			setDefense(getDefense()+3);
		}

		setSpeed(getSpeed()+1);
		
		setDamge(getDamge()+10);

	}

	@Override
	public void damageReaction(DrawSinhVat DSinhVat, DrawVatThe vatGayDamge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAction(DrawSinhVat dSinhVat) {
		// TODO Auto-generated method stub
		
	}

}
