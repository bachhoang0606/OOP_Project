/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import gameSetting.GamePanel;
import gameSetting.KeyHandler;
import gameSetting.UtilityTool;
import object.OBJ_Kunai;

/**
 *
 * @author HOANG XUAN BACH
 */
public class Player extends Entity{
    
    private KeyHandler keyH;
    
    private int hasKunai = 10;
    private int hasKey = 0;
    
    private final int screenX;
    private final int screenY;
    private int standCounter = 0;
    private int kunaiAttackCounter = 0;
    
    private boolean kunaiAttacking = false;
    
    private OBJ_Kunai[] playerKunai = new OBJ_Kunai[hasKunai];

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

    public OBJ_Kunai[] getPlayerKunai() {
        return playerKunai;
    }

    public void setPlayerKunai(OBJ_Kunai[] playerKunai) {
        this.playerKunai = playerKunai;
    }

    public int getHasKunai() {
        return hasKunai;
    }

    public void setHasKunai(int hasKunai) {
        this.hasKunai = hasKunai;
    }
    
    public Player(GamePanel gp, KeyHandler keyH) {
        
        super(gp, "Player", 6, 4, 0);
        
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;
        
        getSolidArea().x = 8;
        getSolidArea().y = 16;
        getSolidArea().width = getGp().tileSize - 16;
        getSolidArea().height = getGp().tileSize - 16;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        
        getAttackArea().width = 36;
        getAttackArea().height = 36;
        
        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
    }
       
    public void setDefaultValues(){

        setWorldX(getGp().tileSize*23);
        setWorldY(getGp().tileSize*21);
       
        setLife(getMaxLife());
    }
    
    
    public void getPlayerImage(){
       
        UtilityTool uTool = new UtilityTool();
        
        setUp1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/boy_up_1.png", getGp().tileSize, getGp().tileSize));
        setUp2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/boy_up_2.png", getGp().tileSize, getGp().tileSize));
        setDown1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/boy_down_1.png", getGp().tileSize, getGp().tileSize));
        setDown2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/boy_down_2.png", getGp().tileSize, getGp().tileSize));
        setLeft1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/boy_left_1.png", getGp().tileSize, getGp().tileSize));
        setLeft2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/boy_left_2.png", getGp().tileSize, getGp().tileSize));
        setRight1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/boy_right_1.png", getGp().tileSize, getGp().tileSize));
        setRight2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/boy_right_2.png", getGp().tileSize, getGp().tileSize));
    }
    
    public void getPlayerAttackImage(){
        
        UtilityTool uTool = new UtilityTool();
        
        setAttackUp1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/Attacking sprites/boy_attack_up_1.png", getGp().tileSize, getGp().tileSize*2));
        setAttackUp2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/Attacking sprites/boy_attack_up_2.png", getGp().tileSize, getGp().tileSize*2));
        setAttackDown1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/Attacking sprites/boy_attack_down_1.png", getGp().tileSize, getGp().tileSize*2));
        setAttackDown2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/Attacking sprites/boy_attack_down_2.png", getGp().tileSize, getGp().tileSize*2));
        setAttackLeft1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/Attacking sprites/boy_attack_left_1.png", getGp().tileSize*2, getGp().tileSize));
        setAttackLeft2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/Attacking sprites/boy_attack_left_2.png", getGp().tileSize*2, getGp().tileSize));
        setAttackRight1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/Attacking sprites/boy_attack_right_1.png", getGp().tileSize*2, getGp().tileSize));
        setAttackRight2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Player/Attacking sprites/boy_attack_right_2.png", getGp().tileSize*2, getGp().tileSize));
        
    }
    
    public void update(){

        // KUNAI ATTACK
        if(keyH.kPressed == true){
            System.out.println("Kuai Attacking = true");
            kunaiAttacking = true;
        }

        if(kunaiAttacking == true){
            kunaiAttack();
        }
        if(isAttacking() == true){
            attacking();
        }
        else if(keyH.upPressed == true || keyH.downPressed == true ||
            keyH.leftPressed == true || keyH.rightPressed == true || 
            keyH.enterPressed == true){

            if(keyH.upPressed == true){ setDirection("up");
            }else if(keyH.downPressed == true){ setDirection("down");
            }else if(keyH.leftPressed == true){ setDirection("left");
            }else if(keyH.rightPressed == true){ setDirection("right"); }

            //moving = true;

            // CHECK TILE COLLISION
            setCollisionOn(false);
            getGp().cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = getGp().cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // CHECK NPC COLLISION
            int npcIndex = getGp().cChecker.checkEntity(this, getGp().npc);
            interactNPC(npcIndex);

            // CHECK MONSTER COLLISION
            int monsterIndex = getGp().cChecker.checkEntity(this, getGp().monster);
            contactMonster(monsterIndex);

            // CHECK EVENT
            getGp().eHandler.checkEvent();

            
            if(isCollisionOn() == false && keyH.enterPressed == false){
                switch(getDirection()){
                    case "up": setWorldY(getWorldY()-getSpeed()); break;
                    case "down": setWorldY(getWorldY()+getSpeed()); break;
                    case "left": setWorldX(getWorldX()-getSpeed()); break;
                    case "right": setWorldX(getWorldX()+getSpeed()); break; 
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
            standCounter++;

            if(standCounter == 20){
                setSpriteNum(1);
                standCounter = 0;

            }
        }
        
        // This need to be outside of key if statement!
        if(isInvincible() == true){
            setInvincibleCounter(getInvincibleCounter()+1);
            if(getInvincibleCounter() > 60){
                setInvincible(false);
                setInvincibleCounter(0);
            }
        }   
    }
        
    private void kunaiAttack() {
        
        if(kunaiAttackCounter == 0){

            if(hasKunai > 0){
            
                System.out.println("Kunai created!");
                int startAttackX = this.getWorldX() + this.getSolidArea().x;
                int startAttackY = this.getWorldY() + this.getSolidArea().y;

                playerKunai[hasKunai-1] = new OBJ_Kunai(getGp());

                switch(getDirection()){
                    case "up": startAttackY -= playerKunai[hasKunai-1].getSolidArea().height; break;
                    case "down": startAttackY += getSolidArea().height; break;
                    case "left": startAttackX -= playerKunai[hasKunai-1].getSolidArea().height; break;
                    case "right": startAttackX += getSolidArea().height; break;
                }

                playerKunai[hasKunai-1].setDirection(getDirection());
                playerKunai[hasKunai-1].setWorldX(startAttackX);
                playerKunai[hasKunai-1].setWorldY(startAttackY);
                playerKunai[hasKunai-1].setStartAttackX(startAttackX);
                playerKunai[hasKunai-1].setStartAttackY(startAttackY);
                playerKunai[hasKunai-1].setSpeed(this.getSpeed()+3);
                hasKunai--;
            }
        }
        
        kunaiAttackCounter++;
        if(kunaiAttackCounter > 120){
            kunaiAttackCounter = 0;
            kunaiAttacking = false;
        }
    }
    
    public void attacking(){
        
        setSpriteCounter(getSpriteCounter()+1);
        
        if(getSpriteCounter() <= 5){
            setSpriteNum(1);
        }
        if(getSpriteCounter() > 5 && getSpriteCounter() <= 25){
            setSpriteNum(2);
            
            // Save the current worldX, worldY, solidArea
            int currentWorldX = getWorldX();
            int currentWorldY = getWorldY();
            int solidAreaWith = getSolidArea().width;
            int solidAreaHeight = getSolidArea().height;
            
            // Adjust player/s worldX/Y for the attackArea
            switch(getDirection()){
                case "up": setWorldY(getWorldY() - getAttackArea().height); break;
                case "down": setWorldY(getWorldY() + getSolidArea().height); break;
                case "left": setWorldX(getWorldX() - getAttackArea().width); break;
                case "right": setWorldX(getWorldX() + getSolidArea().width); break;
            }
            
            getSolidArea().width = getAttackArea().width;
            getSolidArea().height = getAttackArea().height;
            
            // Check monster collision with the updated worldX, worldY and solidArea
            int monterIndex = getGp().cChecker.checkEntity(this, getGp().monster);
            damageMonster(monterIndex);
            
            // After checking collision, restore the original data
            setWorldX(currentWorldX);
            setWorldY(currentWorldY);
            getSolidArea().width = solidAreaWith;
            getSolidArea().height = solidAreaHeight;
            
        }
        if(getSpriteCounter() > 25){
            setSpriteNum(1);
            setSpriteCounter(0);
            setAttacking(false);
        }
    }
    
    public void pickUpObject(int i){
        
        if(i != 999){
            
            String objectName = getGp().obj[i].getName();
            
            switch(objectName){
                case "Key":
                    getGp().playSE(1);
                    hasKey++;
                    getGp().obj[i] = null;
                    getGp().ui.showMessage("You got a key!");
                    break;
                case "Door":
                    if(hasKey > 0){
                        getGp().obj[i] = null;
                        hasKey--;
                        getGp().playSE(3);
                        getGp().ui.showMessage("You opened the door!");
                    }
                    else {
                        getGp().ui.showMessage("You need the key!");
                    }
                    break;
                case "Boots":
                    getGp().ui.showMessage("Speed up!");
                    getGp().playSE(2);
                    setSpeed(getSpeed()+2);
                    getGp().obj[i] = null;
                    break;
                case "Chest":
                    getGp().ui.gameFinished = true;
                    getGp().stopMusic();
                    getGp().playSE(4);
                    break;
          }
        }    
    }
    
    private void interactNPC(int i) {
        
        if(getGp().keyH.enterPressed == true){
            if(i != 999){
                getGp().gameState = getGp().dialogueState;
                getGp().npc[i].speak();
            }
            else {
                getGp().playSE(7);
                setAttacking(true);
            }
        }
        
    }
    
    @Override
    public void draw(Graphics2D g2){
        
        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;
        
        int attackWorldX = screenX;
        int attackWorldY = screenY;
        
        switch (getDirection()) {
        case "up":
            if(isAttacking() == false){
                if(getSpriteNum() == 1){ image = getUp1(); }
                if(getSpriteNum() == 2){ image = getUp2(); }
            }
            if(isAttacking() == true){
                tempScreenY -= getGp().tileSize;
                if(getSpriteNum() == 1){ image = getAttackUp1(); }
                if(getSpriteNum() == 2){ image = getAttackUp2(); }
            }
            attackWorldY = attackWorldY - getAttackArea().height -4;
            break;
        case "down":
            if(isAttacking() == false){
                if(getSpriteNum() == 1){ image = getDown1(); }
                if(getSpriteNum() == 2){ image = getDown2(); } 
            }
            if(isAttacking() == true){
                if(getSpriteNum() == 1){ image = getAttackDown1(); }
                if(getSpriteNum() == 2){ image = getAttackDown2(); }
            }
            attackWorldY += getSolidArea().height;
            break;
        case "left":
            if(isAttacking() == false){
                if(getSpriteNum() == 1){ image = getLeft1(); }
                if(getSpriteNum() == 2){ image = getLeft2(); }
            }
            if(isAttacking() == true){
                tempScreenX -= getGp().tileSize;
                if(getSpriteNum() == 1){ image = getAttackLeft1(); }
                if(getSpriteNum() == 2){ image = getAttackLeft2(); }
            }
            attackWorldX = attackWorldX - getAttackArea().width - 4;
            break;
        case "right":
            if(isAttacking() == false){
                if(getSpriteNum() == 1){ image = getRight1(); }
                if(getSpriteNum() == 2){ image = getRight2(); }
            }
            if(isAttacking() == true){
                if(getSpriteNum() == 1){ image = getAttackRight1(); }
                if(getSpriteNum() == 2){ image = getAttackRight2(); }
            }
            attackWorldX += getSolidArea().width;
            break;
        }
        
        if(isInvincible() == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }
        
        g2.drawImage(image, tempScreenX, tempScreenY, null);
        
        // Reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
        if(getGp().keyH.drawSolidArea == true){
//            g2.drawRect(screenX, screenY, gp.tileSize, gp.tileSize);
            g2.setColor(Color.red);
            g2.drawRect(screenX + getSolidArea().x, screenY + getSolidArea().y, getSolidArea().width, getSolidArea().height);
            g2.drawRect(attackWorldX + getSolidArea().x, attackWorldY + getSolidArea().y, getAttackArea().width+4, getAttackArea().height+4);
        }
    }

    public void contactMonster(int i) {
        
        if(i != 999){
            
            if(isInvincible() == false){
                getGp().playSE(6);
                setLife(getLife()-1);
                setInvincible(true);
            }

        }
    }
    
    public void damageMonster(int i){
        
        if( i != 999){
            
            if(getGp().monster[i].isInvincible() == false){
                
                getGp().playSE(5);
                getGp().monster[i].setLife(getGp().monster[i].getLife()-1);
//              System.out.println("Monster ["+i+"] attacked: "+getGp().monster[i].getLife());
                getGp().monster[i].setInvincible(true);
                getGp().monster[i].damageReaction();
                
                if(getGp().monster[i].getLife() <= 0){
                    getGp().monster[i].setDying(true);
                }
            }
        }
    }

}
