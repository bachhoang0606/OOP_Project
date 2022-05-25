/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import gameSetting.GamePanel;
import object.OriginObject;

/**
 *
 * @author HOANG XUAN BACH
 */
public class Entity extends OriginObject{
    
    // IMAGE
    private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    private BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
 
    // STATE
    private String direction;
    private int spriteNum = 1;
    int dialogueIndex = 0;
    private boolean collisionOn = false;
    private int spriteCounter = 0;
    private boolean invincible = false;
    private boolean attacking = false;
    private boolean dying = false;
    private boolean hpBarOn = false;
    
    // RECTANGLE
    private Rectangle attackArea = new Rectangle(0, 0, 0, 0);
    
    // COUNTER
    private int invincibleCounter = 0;
    private int actionLockCounter = 0;
    private int dyingCounter = 0;
    private int hpBarCounter = 0;
    
    // CHARATER STATUS
    private int maxLife;
    private int life;
    private String dialogues[] = new String[20];

    public BufferedImage getUp1() {
        return up1;
    }

    public void setUp1(BufferedImage up1) {
        this.up1 = up1;
    }

    public BufferedImage getUp2() {
        return up2;
    }

    public void setUp2(BufferedImage up2) {
        this.up2 = up2;
    }

    public BufferedImage getDown1() {
        return down1;
    }

    public void setDown1(BufferedImage down1) {
        this.down1 = down1;
    }

    public BufferedImage getDown2() {
        return down2;
    }

    public void setDown2(BufferedImage down2) {
        this.down2 = down2;
    }

    public BufferedImage getLeft1() {
        return left1;
    }

    public void setLeft1(BufferedImage left1) {
        this.left1 = left1;
    }

    public BufferedImage getLeft2() {
        return left2;
    }

    public void setLeft2(BufferedImage left2) {
        this.left2 = left2;
    }

    public BufferedImage getRight1() {
        return right1;
    }

    public void setRight1(BufferedImage right1) {
        this.right1 = right1;
    }

    public BufferedImage getRight2() {
        return right2;
    }

    public void setRight2(BufferedImage right2) {
        this.right2 = right2;
    }

    public BufferedImage getAttackUp1() {
        return attackUp1;
    }

    public void setAttackUp1(BufferedImage attackUp1) {
        this.attackUp1 = attackUp1;
    }

    public BufferedImage getAttackUp2() {
        return attackUp2;
    }

    public void setAttackUp2(BufferedImage attackUp2) {
        this.attackUp2 = attackUp2;
    }

    public BufferedImage getAttackDown1() {
        return attackDown1;
    }

    public void setAttackDown1(BufferedImage attackDown1) {
        this.attackDown1 = attackDown1;
    }

    public BufferedImage getAttackDown2() {
        return attackDown2;
    }

    public void setAttackDown2(BufferedImage attackDown2) {
        this.attackDown2 = attackDown2;
    }

    public BufferedImage getAttackLeft1() {
        return attackLeft1;
    }

    public void setAttackLeft1(BufferedImage attackLeft1) {
        this.attackLeft1 = attackLeft1;
    }

    public BufferedImage getAttackLeft2() {
        return attackLeft2;
    }

    public void setAttackLeft2(BufferedImage attackLeft2) {
        this.attackLeft2 = attackLeft2;
    }

    public BufferedImage getAttackRight1() {
        return attackRight1;
    }

    public void setAttackRight1(BufferedImage attackRight1) {
        this.attackRight1 = attackRight1;
    }

    public BufferedImage getAttackRight2() {
        return attackRight2;
    }

    public void setAttackRight2(BufferedImage attackRight2) {
        this.attackRight2 = attackRight2;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public int getActionLockCounter() {
        return actionLockCounter;
    }

    public void setActionLockCounter(int actionLockCounter) {
        this.actionLockCounter = actionLockCounter;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public int getDialogueIndex() {
        return dialogueIndex;
    }

    public void setDialogueIndex(int dialogueIndex) {
        this.dialogueIndex = dialogueIndex;
    }

    public boolean isCollisionOn() {
        return collisionOn;
    }

    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }

    public boolean isDying() {
        return dying;
    }

    public void setDying(boolean dying) {
        this.dying = dying;
    }

    public boolean isHpBarOn() {
        return hpBarOn;
    }

    public void setHpBarOn(boolean hpBarOn) {
        this.hpBarOn = hpBarOn;
    }

    public Rectangle getAttackArea() {
        return attackArea;
    }

    public void setAttackArea(Rectangle attackArea) {
        this.attackArea = attackArea;
    }

    public int getInvincibleCounter() {
        return invincibleCounter;
    }

    public void setInvincibleCounter(int invincibleCounter) {
        this.invincibleCounter = invincibleCounter;
    }

    public int getDyingCounter() {
        return dyingCounter;
    }

    public void setDyingCounter(int dyingCounter) {
        this.dyingCounter = dyingCounter;
    }

    public int getHpBarCounter() {
        return hpBarCounter;
    }

    public void setHpBarCounter(int hpBarCounter) {
        this.hpBarCounter = hpBarCounter;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String[] getDialogues() {
        return dialogues;
    }

    public void setDialogues(String[] dialogues) {
        this.dialogues = dialogues;
    }

    
    
    public Entity(GamePanel gp, String name, int maxLife, int speed,int type) {
        setGp(gp);
        this.maxLife = maxLife;
        this.life = this.maxLife;
        setSpeed(speed);
        
        setName(name);
        setType(type);
        
        direction = "down";
        
        setSolidArea(new Rectangle(0, 0 , gp.tileSize, gp.tileSize));
        
        getSolidArea().x = 8;
        getSolidArea().y = 16;
        getSolidArea().height = gp.tileSize - 16;
        getSolidArea().width = gp.tileSize - 16;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
    }
    
    
    
    public void setAction(){}
    public void damageReaction(){}
    
    public void speak(){
        if(dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        getGp().ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        switch(getGp().player.getDirection()){
        case "up": direction = "down"; break;
        case "down": direction = "up"; break;
        case "left": direction = "right"; break;
        case "right": direction = "left"; break;
        }
    }
    
    public void update(){
    
        setAction();
        
        collisionOn = false;
        
        getGp().cChecker.checkTile(this);
        getGp().cChecker.checkEntity(this, getGp().npc);
        getGp().cChecker.checkEntity(this, getGp().monster);

        getGp().cChecker.checkObject(this, false);
        
        boolean contactPlayer = getGp().cChecker.checkPlayer(this);
        
        if(this.getType() == 2 && contactPlayer == true){
            if(getGp().player.isInvincible() == false){
                getGp().playSE(6);
                // we can give damage
                getGp().player.setLife(getGp().player.getLife() - 1);
                getGp().player.setInvincible(true);
            }
        }
        
        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(collisionOn == false){
            switch(direction){
                case "up": setWorldY(getWorldY() - getSpeed()); break;
                case "down": setWorldY(getWorldY() + getSpeed()); break;
                case "left": setWorldX(getWorldX() - getSpeed()); break;
                case "right": setWorldX(getWorldX() + getSpeed()); break; 
            }
        }

        spriteCounter++;
        if(spriteCounter > 12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum ==2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }
    
    public void draw(Graphics2D g2){
        
        BufferedImage image = null;
        int screenX =  getWorldX() - getGp().player.getWorldX()  + getGp().player.getScreenX();
        int screenY =  getWorldY() - getGp().player.getWorldY()  + getGp().player.getScreenY();

        if(getWorldX() + getGp().tileSize> getGp().player.getWorldX() - getGp().player.getScreenX() &&
           getWorldX() - getGp().tileSize< getGp().player.getWorldX() + getGp().player.getScreenX() &&
           getWorldY() + getGp().tileSize> getGp().player.getWorldY() - getGp().player.getScreenY() &&
           getWorldY() - getGp().tileSize< getGp().player.getWorldY() + getGp().player.getScreenY()){
            
            switch (direction) {
            case "up":
                if(spriteNum == 1){ image = up1; }
                if(spriteNum == 2){ image = up2; }
                break;
            case "down":
                if(spriteNum == 1){ image = down1; }
                if(spriteNum == 2){ image = down2; }
                break;
            case "left":
                if(spriteNum == 1){ image = left1; }
                if(spriteNum == 2){ image = left2; }
                break;
            case "right":
                if(spriteNum == 1){ image = right1; }
                if(spriteNum == 2){ image = right2; }
                break;
            }
            
            // Monster Hp bar
            if(getType() == 2 && hpBarOn == true){
                
                double oneScale = (double) getGp().tileSize/maxLife;
                double hpBarValue = oneScale*life;
                
                g2.setColor(new Color(35, 35, 35));
                g2.drawRect(screenX - 1, screenY - 16, getGp().tileSize+2, 12);
                g2.setColor(new Color(255, 0, 30));
                g2.fillRect(screenX, screenY - 15, (int) hpBarValue, 10);
             
                hpBarCounter++;
                if(hpBarCounter > 600){
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }
            
            if(invincible == true){
                hpBarCounter = 0;
                hpBarOn = true;
                changeAlpha(g2, 0.4f);
            }
            
            if(dying == true){
                dyingAnimation(g2);
            }
            
            g2.drawImage(image, screenX, screenY, getGp().tileSize, getGp().tileSize, null);
            changeAlpha(g2, 1f);
            
            // Reset alpha
            
            if(getGp().keyH.drawSolidArea == true){
                g2.setColor(Color.red);
                g2.drawRect(screenX + getSolidArea().x, screenY + getSolidArea().y, getSolidArea().width, getSolidArea().height);
            }
        }
        
    }
    
    public void dyingAnimation(Graphics2D g2){
        
        dyingCounter++;
        
        int i = 5 ; 
        
        if(dyingCounter <= i){ changeAlpha(g2, 0f); }
        if(dyingCounter > i   && dyingCounter <= i*2){ changeAlpha(g2, 1f); }
        if(dyingCounter > i*2 && dyingCounter <= i*3){ changeAlpha(g2, 0f); }
        if(dyingCounter > i*3 && dyingCounter <= i*4){ changeAlpha(g2, 1f); }
        if(dyingCounter > i*4 && dyingCounter <= i*5){ changeAlpha(g2, 0f); }
        if(dyingCounter > i*5 && dyingCounter <= i*6){ changeAlpha(g2, 1f); }
        if(dyingCounter > i*6 && dyingCounter <= i*7){ changeAlpha(g2, 0f); }
        if(dyingCounter > i*7 && dyingCounter <= i*8){ changeAlpha(g2, 1f); }
        if(dyingCounter > i*8){
//            dying = false;
            setExist(false);
        }
    }
    
    public void getEntityImage(){}
    
}
