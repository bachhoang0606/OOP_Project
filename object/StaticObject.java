/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import gameSetting.GamePanel;
import gameSetting.UtilityTool;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author HOANG XUAN BACH
 */
public abstract class StaticObject extends OriginObject{
    
    private UtilityTool uTool;

    public UtilityTool getuTool() {
        return uTool;
    }

    public void setuTool(UtilityTool uTool) {
        this.uTool = uTool;
    }

    public StaticObject(GamePanel gp, String name, int worldX, int worldY, boolean colision, int type) {
        setGp(gp);
        setCollision(colision);
        setName(name);
        setWorldX(worldX);
        setWorldX(worldY);
        setType(type);
        setSolidArea(new Rectangle(0, 0, gp.tileSize, gp.tileSize));
        
        this.uTool = new UtilityTool();
    }
    
    public StaticObject(GamePanel gp, String name,boolean colision,int type) {
        setGp(gp);
        setCollision(colision);
        setName(name);
        setType(type);
        setSolidArea(new Rectangle(0, 0, gp.tileSize, gp.tileSize));
        
        this.uTool = new UtilityTool();
    }
    
    @Override
    public void draw(Graphics2D g2){

        BufferedImage image = getImage();
        
        int screenX =  getWorldX() - getGp().player.getWorldX()  + getGp().player.getScreenX();
        int screenY =  getWorldY() - getGp().player.getWorldY()  + getGp().player.getScreenY();

        if(getWorldX() + getGp().tileSize> getGp().player.getWorldX() - getGp().player.getScreenX() &&
           getWorldX() - getGp().tileSize< getGp().player.getWorldX() + getGp().player.getScreenX() &&
           getWorldY() + getGp().tileSize> getGp().player.getWorldY() - getGp().player.getScreenY() &&
           getWorldY() - getGp().tileSize< getGp().player.getWorldY() + getGp().player.getScreenY()){
            
            
            if(isDisappearing() == true){
                
                disappearAnimation(g2);
            }
            
            g2.drawImage(image, screenX, screenY, getGp().tileSize, getGp().tileSize, null);
            changeAlpha(g2, 1f);
            
            if(getGp().keyH.drawSolidArea == true){
                g2.setColor(Color.red);
                g2.drawRect(screenX + getSolidArea().x, screenY + getSolidArea().y, getSolidArea().width, getSolidArea().height);
            }
        }
    }
}
