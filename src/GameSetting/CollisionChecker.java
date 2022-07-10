/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameSetting;

import java.util.List;

import Graphics.DrawSinhVat;
import Graphics.DrawVatThe;


/**
 *
 * @author HOANG XUAN BACH
 */
public class CollisionChecker {
    
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    
    public void checkTile(DrawVatThe DoObj){
        
        int entityLeftWorldX = DoObj.getVatThe().getWorldX() + DoObj.getVatThe().getSolidArea().x;
        int entityRightWorldX = DoObj.getVatThe().getWorldX() + DoObj.getVatThe().getSolidArea().x + DoObj.getVatThe().getSolidArea().width;
        int entityTopWorldY = DoObj.getVatThe().getWorldY() + DoObj.getVatThe().getSolidArea().y;
        int entityBottomWorldY = DoObj.getVatThe().getWorldY() + DoObj.getVatThe().getSolidArea().y + DoObj.getVatThe().getSolidArea().height;
    
        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;
        
        int tileNum1, tileNum2;
        
        switch(DoObj.getVatThe().getDirection()) {
            case "up":
                entityTopRow = (entityTopWorldY - DoObj.getVatThe().getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.dtile[tileNum1].getVatThe().isCollision() == true || gp.tileM.dtile[tileNum2].getVatThe().isCollision() == true){
                	DoObj.setCollisionOn(true);
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + DoObj.getVatThe().getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.dtile[tileNum1].getVatThe().isCollision() == true || gp.tileM.dtile[tileNum2].getVatThe().isCollision() == true){
                	DoObj.setCollisionOn(true);
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - DoObj.getVatThe().getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.dtile[tileNum1].getVatThe().isCollision() == true || gp.tileM.dtile[tileNum2].getVatThe().isCollision() == true){
                	DoObj.setCollisionOn(true);
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + DoObj.getVatThe().getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.dtile[tileNum1].getVatThe().isCollision() == true || gp.tileM.dtile[tileNum2].getVatThe().isCollision() == true){
                	DoObj.setCollisionOn(true);
                }
                break;
        }
    }
    
    public int checkObject(DrawVatThe DoObj, boolean player){
        
        int index = 999;
        
        for(int i = 0; i < gp.dobj.length; i++){
            
            if(gp.dobj[i] != null){
                
                // Get entity's solid area position
            	DoObj.getVatThe().getSolidArea().x = DoObj.getVatThe().getWorldX() + DoObj.getVatThe().getSolidArea().x;
            	DoObj.getVatThe().getSolidArea().y = DoObj.getVatThe().getWorldY() + DoObj.getVatThe().getSolidArea().y;
                
                // Get the object's solid area position
                gp.dobj[i].getVatThe().getSolidArea().x = gp.dobj[i].getVatThe().getWorldX() + gp.dobj[i].getVatThe().getSolidArea().x;
                gp.dobj[i].getVatThe().getSolidArea().y = gp.dobj[i].getVatThe().getWorldY() + gp.dobj[i].getVatThe().getSolidArea().y;
                
                switch(DoObj.getVatThe().getDirection()) {
                case "up":  DoObj.getVatThe().getSolidArea().y -= DoObj.getVatThe().getSpeed(); break;
                case "down": DoObj.getVatThe().getSolidArea().y += DoObj.getVatThe().getSpeed(); break;
                case "left": DoObj.getVatThe().getSolidArea().x -= DoObj.getVatThe().getSpeed(); break;
                case "right": DoObj.getVatThe().getSolidArea().x += DoObj.getVatThe().getSpeed(); break;
                }
                
                if(DoObj.getVatThe().getSolidArea().intersects(gp.dobj[i].getVatThe().getSolidArea())){
                    if(gp.dobj[i].getVatThe().isCollision() == true){
                    	DoObj.setCollisionOn(true);
                    }
                    if(player == true){
                        index = i;
                    }
                }
                    
                
                DoObj.getVatThe().getSolidArea().x = DoObj.getVatThe().getSolidAreaDefaultX();
                DoObj.getVatThe().getSolidArea().y = DoObj.getVatThe().getSolidAreaDefaultY();
                gp.dobj[i].getVatThe().getSolidArea().x = gp.dobj[i].getVatThe().getSolidAreaDefaultX();
                gp.dobj[i].getVatThe().getSolidArea().y = gp.dobj[i].getVatThe().getSolidAreaDefaultY();
            }
        }
        return index;
    }
    
    // NPC OR MONSTER
    public DrawSinhVat checkEntity(DrawVatThe DoObj, DrawSinhVat[] target){
        
    	DrawSinhVat index = null;
        
        for(int i = 0; i < target.length; i++){
            
            if(target[i] != null){
                
                // Get entity's solid area position
            	DoObj.getVatThe().getSolidArea().x = DoObj.getVatThe().getWorldX() + DoObj.getVatThe().getSolidArea().x;
            	DoObj.getVatThe().getSolidArea().y = DoObj.getVatThe().getWorldY() + DoObj.getVatThe().getSolidArea().y;
                
                // Get the object's solid area position
                target[i].getVatThe().getSolidArea().x = target[i].getVatThe().getWorldX() + target[i].getVatThe().getSolidArea().x;
                target[i].getVatThe().getSolidArea().y = target[i].getVatThe().getWorldY() + target[i].getVatThe().getSolidArea().y;
                
                switch(DoObj.getVatThe().getDirection()) {
                case "up": DoObj.getVatThe().getSolidArea().y -= DoObj.getVatThe().getSpeed(); break;
                case "down": DoObj.getVatThe().getSolidArea().y += DoObj.getVatThe().getSpeed(); break;
                case "left": DoObj.getVatThe().getSolidArea().x -= DoObj.getVatThe().getSpeed(); break;
                case "right": DoObj.getVatThe().getSolidArea().x += DoObj.getVatThe().getSpeed(); break;
                }
                
                if(DoObj.getVatThe().getSolidArea().intersects(target[i].getVatThe().getSolidArea())){
                    if(target[i].getSinhVat() != DoObj.getVatThe()){
                    	
                    	if(target[i].getSinhVat().isCollision() == true){
                    		DoObj.setCollisionOn(true);
                    	}
                        index = target[i];
                    }
                }

                DoObj.getVatThe().getSolidArea().x = DoObj.getVatThe().getSolidAreaDefaultX();
                DoObj.getVatThe().getSolidArea().y = DoObj.getVatThe().getSolidAreaDefaultY();
                target[i].getVatThe().getSolidArea().x = target[i].getVatThe().getSolidAreaDefaultX();
                target[i].getVatThe().getSolidArea().y = target[i].getVatThe().getSolidAreaDefaultY();
            }
        }
        return index;
    } 
    
    
 // NPC OR MONSTER with list
    public DrawSinhVat checkEntity(DrawVatThe DoObj, List<DrawSinhVat> list){
        
    	DrawSinhVat index = null;
        
        for(DrawSinhVat sinhVat : list){
            
            if(sinhVat != null){
                
                // Get entity's solid area position
            	DoObj.getVatThe().getSolidArea().x = DoObj.getVatThe().getWorldX() + DoObj.getVatThe().getSolidArea().x;
            	DoObj.getVatThe().getSolidArea().y = DoObj.getVatThe().getWorldY() + DoObj.getVatThe().getSolidArea().y;
                
                // Get the object's solid area position
            	sinhVat.getVatThe().getSolidArea().x = sinhVat.getVatThe().getWorldX() + sinhVat.getVatThe().getSolidArea().x;
            	sinhVat.getVatThe().getSolidArea().y = sinhVat.getVatThe().getWorldY() + sinhVat.getVatThe().getSolidArea().y;
                
                switch(DoObj.getVatThe().getDirection()) {
                case "up": DoObj.getVatThe().getSolidArea().y -= DoObj.getVatThe().getSpeed(); break;
                case "down": DoObj.getVatThe().getSolidArea().y += DoObj.getVatThe().getSpeed(); break;
                case "left": DoObj.getVatThe().getSolidArea().x -= DoObj.getVatThe().getSpeed(); break;
                case "right": DoObj.getVatThe().getSolidArea().x += DoObj.getVatThe().getSpeed(); break;
                }
                
                if(DoObj.getVatThe().getSolidArea().intersects(sinhVat.getVatThe().getSolidArea())){
                    if(sinhVat.getSinhVat() != DoObj.getVatThe()){
                    	
                    	if(sinhVat.getSinhVat().isCollision() == true){
                    		DoObj.setCollisionOn(true);
                    	}
                        index = sinhVat;
                    }
                }

                DoObj.getVatThe().getSolidArea().x = DoObj.getVatThe().getSolidAreaDefaultX();
                DoObj.getVatThe().getSolidArea().y = DoObj.getVatThe().getSolidAreaDefaultY();
                sinhVat.getVatThe().getSolidArea().x = sinhVat.getVatThe().getSolidAreaDefaultX();
                sinhVat.getVatThe().getSolidArea().y = sinhVat.getVatThe().getSolidAreaDefaultY();
            }
        }
        return index;
    } 
    
    // kiem tra xem nguoi choi co va cham voi doi tuong khong
    public boolean checkPlayer(DrawVatThe doOBJ){
        
        boolean contactPlayer = false;
        // Get entity's solid area position
        doOBJ.getVatThe().getSolidArea().x = doOBJ.getVatThe().getWorldX() + doOBJ.getVatThe().getSolidArea().x;
        doOBJ.getVatThe().getSolidArea().y = doOBJ.getVatThe().getWorldY() + doOBJ.getVatThe().getSolidArea().y;

        // Get the object's solid area position
        gp.drawP.getVatThe().getSolidArea().x = gp.drawP.getVatThe().getWorldX() + gp.drawP.getVatThe().getSolidArea().x;
        gp.drawP.getVatThe().getSolidArea().y = gp.drawP.getVatThe().getWorldY() + gp.drawP.getVatThe().getSolidArea().y;

        switch(doOBJ.getVatThe().getDirection()) {
        case "up": doOBJ.getVatThe().getSolidArea().y -= doOBJ.getVatThe().getSpeed(); break;
        case "down": doOBJ.getVatThe().getSolidArea().y += doOBJ.getVatThe().getSpeed(); break;
        case "left": doOBJ.getVatThe().getSolidArea().x -= doOBJ.getVatThe().getSpeed(); break;
        case "right": doOBJ.getVatThe().getSolidArea().x += doOBJ.getVatThe().getSpeed(); break;
        }
        
        if(doOBJ.getVatThe().getSolidArea().intersects(gp.drawP.getVatThe().getSolidArea())){
        	doOBJ.setCollisionOn(true);
            contactPlayer = true;
        }   
        doOBJ.getVatThe().getSolidArea().x = doOBJ.getVatThe().getSolidAreaDefaultX();
        doOBJ.getVatThe().getSolidArea().y = doOBJ.getVatThe().getSolidAreaDefaultY();
        gp.drawP.getVatThe().getSolidArea().x = gp.drawP.getVatThe().getSolidAreaDefaultX();
        gp.drawP.getVatThe().getSolidArea().y = gp.drawP.getVatThe().getSolidAreaDefaultY();
        
        return contactPlayer;
    }
    
}
