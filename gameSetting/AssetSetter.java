/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameSetting;

import entity.NPC_OldMan;
import entity.MON_GreenSlime;
import object.OBJ_Boots;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Kunai;
/**
 *
 * @author HOANG XUAN BACH
 */
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    
    public void setObject(){

        gp.obj[0] = new OBJ_Door(gp);
        gp.obj[0].setWorldX(23 * gp.tileSize);
        gp.obj[0].setWorldY(19 * gp.tileSize);

        gp.obj[1] = new OBJ_Door(gp);
        gp.obj[1].setWorldX(23 * gp.tileSize);
        gp.obj[1].setWorldY(24 * gp.tileSize);
        
        gp.obj[2] = new OBJ_Key(gp);
        gp.obj[2].setWorldX(23 * gp.tileSize);
        gp.obj[2].setWorldY(20 * gp.tileSize);
        
        gp.obj[3] = new OBJ_Boots(gp);
        gp.obj[3].setWorldX(23 * gp.tileSize);
        gp.obj[3].setWorldY(21 * gp.tileSize);
        
        gp.obj[4] = new OBJ_Key(gp);
        gp.obj[4].setWorldX(23 * gp.tileSize);
        gp.obj[4].setWorldY(22 * gp.tileSize);
        
        gp.obj[5] = new OBJ_Kunai(gp);
        gp.obj[5].setWorldX(23 * gp.tileSize);
        gp.obj[5].setWorldY(23 * gp.tileSize);
        
        gp.obj[6] = new OBJ_Kunai(gp);
        gp.obj[7] = new OBJ_Key(gp);
        gp.obj[7].setImage(gp.uTool.scaleImage(gp.obj[7].getImage(), gp.tileSize/2, gp.tileSize/2));
        }
    
    public void setNPC(){
        
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].setWorldX(21 * gp.tileSize);
        gp.npc[0].setWorldY(21 * gp.tileSize);
        
        gp.npc[1] = new NPC_OldMan(gp);
        gp.npc[1].setWorldX(22 * gp.tileSize);
        gp.npc[1].setWorldY(21 * gp.tileSize);
        
        gp.npc[2] = new NPC_OldMan(gp);
        gp.npc[2].setWorldX(20 * gp.tileSize);
        gp.npc[2].setWorldY(21 * gp.tileSize);
    }
    
    public void setMonster(){
        
        gp.monster[0] = new MON_GreenSlime(gp);
        gp.monster[0].setWorldX(23 * gp.tileSize);
        gp.monster[0].setWorldY(36 * gp.tileSize);
        
        gp.monster[1] = new MON_GreenSlime(gp);
        gp.monster[1].setWorldX(23 * gp.tileSize);
        gp.monster[1].setWorldY(37 * gp.tileSize);
        
        gp.monster[2] = new MON_GreenSlime(gp);
        gp.monster[2].setWorldX(23 * gp.tileSize);
        gp.monster[2].setWorldY(35 * gp.tileSize);
    }
}
