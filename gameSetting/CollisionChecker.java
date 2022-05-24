/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameSetting;

import entity.Entity;


/**
 *
 * @author HOANG XUAN BACH
 */
public class CollisionChecker {
    
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    
    public void checkTile(Entity entity){
        
        int entityLeftWorldX = entity.getWorldX() + entity.getSolidArea().x;
        int entityRightWorldX = entity.getWorldX() + entity.getSolidArea().x + entity.getSolidArea().width;
        int entityTopWorldY = entity.getWorldY() + entity.getSolidArea().y;
        int entityBottomWorldY = entity.getWorldY() + entity.getSolidArea().y + entity.getSolidArea().height;
    
        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;
        
        int tileNum1, tileNum2;
        
        switch(entity.getDirection()) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].getCollision() == true || gp.tileM.tile[tileNum2].getCollision() == true){
                    entity.setCollisionOn(true);
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].getCollision() == true || gp.tileM.tile[tileNum2].getCollision() == true){
                    entity.setCollisionOn(true);
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].getCollision() == true || gp.tileM.tile[tileNum2].getCollision() == true){
                    entity.setCollisionOn(true);
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].getCollision() == true || gp.tileM.tile[tileNum2].getCollision() == true){
                    entity.setCollisionOn(true);
                }
                break;
        }
    }
    
    public int checkObject(Entity entity, boolean player){
        
        int index = 999;
        
        for(int i = 0; i < gp.obj.length; i++){
            
            if(gp.obj[i] != null){
                
                // Get entity's solid area position
                entity.getSolidArea().x = entity.getWorldX() + entity.getSolidArea().x;
                entity.getSolidArea().y = entity.getWorldY() + entity.getSolidArea().y;
                
                // Get the object's solid area position
                gp.obj[i].getSolidArea().x = gp.obj[i].getWorldX() + gp.obj[i].getSolidArea().x;
                gp.obj[i].getSolidArea().y = gp.obj[i].getWorldY() + gp.obj[i].getSolidArea().y;
                
                switch(entity.getDirection()) {
                case "up":  entity.getSolidArea().y -= entity.getSpeed(); break;
                case "down": entity.getSolidArea().y += entity.getSpeed(); break;
                case "left": entity.getSolidArea().x -= entity.getSpeed(); break;
                case "right": entity.getSolidArea().x += entity.getSpeed(); break;
                }
                
                if(entity.getSolidArea().intersects(gp.obj[i].getSolidArea())){
                    if(gp.obj[i].getCollision() == true){
                        entity.setCollisionOn(true);
                    }
                    if(player == true){
                        index = i;
                    }
                }
                    
                
                entity.getSolidArea().x = entity.getSolidAreaDefaultX();
                entity.getSolidArea().y = entity.getSolidAreaDefaultY();
                gp.obj[i].getSolidArea().x = gp.obj[i].getSolidAreaDefaultX();
                gp.obj[i].getSolidArea().y = gp.obj[i].getSolidAreaDefaultY();
            }
        }
        return index;
    }
    
    // NPC OR MONSTER
    public int checkEntity(Entity entity, Entity[] target){
        
        int index = 999;
        
        for(int i = 0; i < target.length; i++){
            
            if(target[i] != null){
                
                // Get entity's solid area position
                entity.getSolidArea().x = entity.getWorldX() + entity.getSolidArea().x;
                entity.getSolidArea().y = entity.getWorldY() + entity.getSolidArea().y;
                
                // Get the object's solid area position
                target[i].getSolidArea().x = target[i].getWorldX() + target[i].getSolidArea().x;
                target[i].getSolidArea().y = target[i].getWorldY() + target[i].getSolidArea().y;
                
                switch(entity.getDirection()) {
                case "up": entity.getSolidArea().y -= entity.getSpeed(); break;
                case "down": entity.getSolidArea().y += entity.getSpeed(); break;
                case "left": entity.getSolidArea().x -= entity.getSpeed(); break;
                case "right": entity.getSolidArea().x += entity.getSpeed(); break;
                }
                
                if(entity.getSolidArea().intersects(target[i].getSolidArea())){
                    if(target[i] != entity){
                        entity.setCollisionOn(true);
                        index = i;
                    }
                }

                entity.getSolidArea().x = entity.getSolidAreaDefaultX();
                entity.getSolidArea().y = entity.getSolidAreaDefaultY();
                target[i].getSolidArea().x = target[i].getSolidAreaDefaultX();
                target[i].getSolidArea().y = target[i].getSolidAreaDefaultY();
            }
        }
        return index;
    } 
    
    public boolean checkPlayer(Entity entity){
        
        boolean contactPlayer = false;
        // Get entity's solid area position
        entity.getSolidArea().x = entity.getWorldX() + entity.getSolidArea().x;
        entity.getSolidArea().y = entity.getWorldY() + entity.getSolidArea().y;

        // Get the object's solid area position
        gp.player.getSolidArea().x = gp.player.getWorldX() + gp.player.getSolidArea().x;
        gp.player.getSolidArea().y = gp.player.getWorldY() + gp.player.getSolidArea().y;

        switch(entity.getDirection()) {
        case "up": entity.getSolidArea().y -= entity.getSpeed(); break;
        case "down": entity.getSolidArea().y += entity.getSpeed(); break;
        case "left": entity.getSolidArea().x -= entity.getSpeed(); break;
        case "right": entity.getSolidArea().x += entity.getSpeed(); break;
        }
        
        if(entity.getSolidArea().intersects(gp.player.getSolidArea())){
            entity.setCollisionOn(true);
            contactPlayer = true;
        }   
        entity.getSolidArea().x = entity.getSolidAreaDefaultX();
        entity.getSolidArea().y = entity.getSolidAreaDefaultY();
        gp.player.getSolidArea().x = gp.player.getSolidAreaDefaultX();
        gp.player.getSolidArea().y = gp.player.getSolidAreaDefaultY();
        
        return contactPlayer;
    }
}
