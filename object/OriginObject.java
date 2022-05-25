/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import gameSetting.GamePanel;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author HOANG XUAN BACH
 */
public abstract class OriginObject {
    
    private GamePanel gp;
    
    // Image
    private BufferedImage image, image2, image3, image4;
    
    // STATE
    private boolean collision = false;
    private boolean collisionOn = false;
    private boolean drawSolidArea = false;
    private boolean exist = true;
    private boolean disappearing = false;
    
    // STATUS
    private String name;
    private String direction = null;
    private int speed = 0;
    private int worldX, worldY;
    private int type; // 0:Player, 1:StaticObject, 2:Monster, 3:NPC
    
    // Rectangle
    private Rectangle solidArea;
    private int solidAreaDefaultX, solidAreaDefaultY;

    // COUNTER
    private int disappearCounter = 0;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    
    
    public boolean isCollisionOn() {
        return collisionOn;
    }

    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    
    
    public boolean isDisappearing() {
        return disappearing;
    }

    public void setDisappearing(boolean disappearing) {
        this.disappearing = disappearing;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
    
    
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage2() {
        return image2;
    }

    public void setImage2(BufferedImage image2) {
        this.image2 = image2;
    }

    public BufferedImage getImage3() {
        return image3;
    }

    public void setImage3(BufferedImage image3) {
        this.image3 = image3;
    }

    public BufferedImage getImage4() {
        return image4;
    }

    public void setImage4(BufferedImage image4) {
        this.image4 = image4;
    }

    public boolean getCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean getDrawSolidArea() {
        return drawSolidArea;
    }

    public void setDrawSolidArea(boolean drawSolidArea) {
        this.drawSolidArea = drawSolidArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public int getSolidAreaDefaultX() {
        return solidAreaDefaultX;
    }

    public void setSolidAreaDefaultX(int solidAreaDefaultX) {
        this.solidAreaDefaultX = solidAreaDefaultX;
    }

    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }

    public void setSolidAreaDefaultY(int solidAreaDefaultY) {
        this.solidAreaDefaultY = solidAreaDefaultY;
    }

    public GamePanel getGp() {
        return gp;
    }

    public void setGp(GamePanel gp) {
        this.gp = gp;
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void draw(Graphics2D g2){}
    
    public void disappearAnimation(Graphics2D g2) {
    
        disappearCounter++;
        
        int i = 5; 
        
        if(disappearCounter <= i){ changeAlpha(g2, 0f); }
        if(disappearCounter > i   && disappearCounter <= i*2){ changeAlpha(g2, 1f); }
        if(disappearCounter > i*2 && disappearCounter <= i*3){ changeAlpha(g2, 0.8f); }
        if(disappearCounter > i*3 && disappearCounter <= i*4){ changeAlpha(g2, 0.6f); }
        if(disappearCounter > i*4 && disappearCounter <= i*5){ changeAlpha(g2, 0.4f); }
        if(disappearCounter > i*5 && disappearCounter <= i*6){ changeAlpha(g2, 0.2f); }
        if(disappearCounter > i*6){
            
            exist = false;
        }
    }
    
    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }

}
