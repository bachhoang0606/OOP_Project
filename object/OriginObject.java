/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import gameSetting.GamePanel;
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
    private boolean drawSolidArea = false;
    
    // STATUS
    private String name;
    private int worldX, worldY;
    private int type; // 0:Player, 1:StaticObject, 2:Monster, 3:NPC
    
    // Rectangle
    private Rectangle solidArea;
    private int solidAreaDefaultX, solidAreaDefaultY;

    
    
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
    
}
