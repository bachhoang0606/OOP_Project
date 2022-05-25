/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameSetting;

import entity.Entity;
import object.OriginObject;


/**
 *
 * @author HOANG XUAN BACH
 */
public class CollisionChecker {
    
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    
    public void checkTile(OriginObject oOBJ){
        
        int entityLeftWorldX = oOBJ.getWorldX() + oOBJ.getSolidArea().x;
        int entityRightWorldX = oOBJ.getWorldX() + oOBJ.getSolidArea().x + oOBJ.getSolidArea().width;
        int entityTopWorldY = oOBJ.getWorldY() + oOBJ.getSolidArea().y;
        int entityBottomWorldY = oOBJ.getWorldY() + oOBJ.getSolidArea().y + oOBJ.getSolidArea().height;
    
        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;
        
        int tileNum1, tileNum2;
        
        switch(oOBJ.getDirection()) {
            case "up":
                entityTopRow = (entityTopWorldY - oOBJ.getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].getCollision() == true || gp.tileM.tile[tileNum2].getCollision() == true){
                    oOBJ.setCollisionOn(true);
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + oOBJ.getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].getCollision() == true || gp.tileM.tile[tileNum2].getCollision() == true){
                    oOBJ.setCollisionOn(true);
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - oOBJ.getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].getCollision() == true || gp.tileM.tile[tileNum2].getCollision() == true){
                    oOBJ.setCollisionOn(true);
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + oOBJ.getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].getCollision() == true || gp.tileM.tile[tileNum2].getCollision() == true){
                    oOBJ.setCollisionOn(true);
                }
                break;
        }
    }
    
    public int checkObject(OriginObject oOBJ, boolean player){
        
        int index = 999;
        
        for(int i = 0; i < gp.obj.length; i++){
            
            if(gp.obj[i] != null){
                
                // Get entity's solid area position
                oOBJ.getSolidArea().x = oOBJ.getWorldX() + oOBJ.getSolidArea().x;
                oOBJ.getSolidArea().y = oOBJ.getWorldY() + oOBJ.getSolidArea().y;
                
                // Get the object's solid area position
                gp.obj[i].getSolidArea().x = gp.obj[i].getWorldX() + gp.obj[i].getSolidArea().x;
                gp.obj[i].getSolidArea().y = gp.obj[i].getWorldY() + gp.obj[i].getSolidArea().y;
                
                switch(oOBJ.getDirection()) {
                case "up":  oOBJ.getSolidArea().y -= oOBJ.getSpeed(); break;
                case "down": oOBJ.getSolidArea().y += oOBJ.getSpeed(); break;
                case "left": oOBJ.getSolidArea().x -= oOBJ.getSpeed(); break;
                case "right": oOBJ.getSolidArea().x += oOBJ.getSpeed(); break;
                }
                
                if(oOBJ.getSolidArea().intersects(gp.obj[i].getSolidArea())){
                    if(gp.obj[i].getCollision() == true){
                        oOBJ.setCollisionOn(true);
                    }
                    if(player == true){
                        index = i;
                    }
                }
                    
                
                oOBJ.getSolidArea().x = oOBJ.getSolidAreaDefaultX();
                oOBJ.getSolidArea().y = oOBJ.getSolidAreaDefaultY();
                gp.obj[i].getSolidArea().x = gp.obj[i].getSolidAreaDefaultX();
                gp.obj[i].getSolidArea().y = gp.obj[i].getSolidAreaDefaultY();
            }
        }
        return index;
    }
    
    // NPC OR MONSTER
    public int checkEntity(OriginObject oOBJ, Entity[] target){
        
        int index = 999;
        
        for(int i = 0; i < target.length; i++){
            
            if(target[i] != null){
                
                // Get entity's solid area position
                oOBJ.getSolidArea().x = oOBJ.getWorldX() + oOBJ.getSolidArea().x;
                oOBJ.getSolidArea().y = oOBJ.getWorldY() + oOBJ.getSolidArea().y;
                
                // Get the object's solid area position
                target[i].getSolidArea().x = target[i].getWorldX() + target[i].getSolidArea().x;
                target[i].getSolidArea().y = target[i].getWorldY() + target[i].getSolidArea().y;
                
                switch(oOBJ.getDirection()) {
                case "up": oOBJ.getSolidArea().y -= oOBJ.getSpeed(); break;
                case "down": oOBJ.getSolidArea().y += oOBJ.getSpeed(); break;
                case "left": oOBJ.getSolidArea().x -= oOBJ.getSpeed(); break;
                case "right": oOBJ.getSolidArea().x += oOBJ.getSpeed(); break;
                }
                
                if(oOBJ.getSolidArea().intersects(target[i].getSolidArea())){
                    if(target[i] != oOBJ){
                        oOBJ.setCollisionOn(true);
                        index = i;
                    }
                }

                oOBJ.getSolidArea().x = oOBJ.getSolidAreaDefaultX();
                oOBJ.getSolidArea().y = oOBJ.getSolidAreaDefaultY();
                target[i].getSolidArea().x = target[i].getSolidAreaDefaultX();
                target[i].getSolidArea().y = target[i].getSolidAreaDefaultY();
            }
        }
        return index;
    } 
    
    public boolean checkPlayer(OriginObject oOBJ){
        
        boolean contactPlayer = false;
        // Get entity's solid area position
        oOBJ.getSolidArea().x = oOBJ.getWorldX() + oOBJ.getSolidArea().x;
        oOBJ.getSolidArea().y = oOBJ.getWorldY() + oOBJ.getSolidArea().y;

        // Get the object's solid area position
        gp.player.getSolidArea().x = gp.player.getWorldX() + gp.player.getSolidArea().x;
        gp.player.getSolidArea().y = gp.player.getWorldY() + gp.player.getSolidArea().y;

        switch(oOBJ.getDirection()) {
        case "up": oOBJ.getSolidArea().y -= oOBJ.getSpeed(); break;
        case "down": oOBJ.getSolidArea().y += oOBJ.getSpeed(); break;
        case "left": oOBJ.getSolidArea().x -= oOBJ.getSpeed(); break;
        case "right": oOBJ.getSolidArea().x += oOBJ.getSpeed(); break;
        }
        
        if(oOBJ.getSolidArea().intersects(gp.player.getSolidArea())){
            oOBJ.setCollisionOn(true);
            contactPlayer = true;
        }   
        oOBJ.getSolidArea().x = oOBJ.getSolidAreaDefaultX();
        oOBJ.getSolidArea().y = oOBJ.getSolidAreaDefaultY();
        gp.player.getSolidArea().x = gp.player.getSolidAreaDefaultX();
        gp.player.getSolidArea().y = gp.player.getSolidAreaDefaultY();
        
        return contactPlayer;
    }
}
