/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameSetting;

import Graphics.DrawSlime;
import Graphics.DrawVatThe;
import Graphics.DrawBossDragon;
import Graphics.DrawDragon;
import Graphics.DrawOldMan;
import Object.Boots;
import Object.BossDragon;
import Object.Door;
import Object.Dragon;
import Object.Slime;
import Object.Key;
import Object.Kunai;
import Object.OldMan;
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
    	
    	gp.dobj[0] = new DrawVatThe(gp, new Door());
    	gp.dobj[0].setImage(gp.uTool.setup("data/Object/"+gp.dobj[0].getVatThe().getName()+".png", gp.tileSize, gp.tileSize));
        gp.dobj[0].setWorldX(10 * gp.tileSize);
        gp.dobj[0].setWorldY(12 * gp.tileSize);
        
        gp.dobj[1] = new DrawVatThe(gp, new Door());
        gp.dobj[1].setImage(gp.uTool.setup("data/Object/"+gp.dobj[1].getVatThe().getName()+".png", gp.tileSize, gp.tileSize));
        gp.dobj[1].setWorldX(23 * gp.tileSize);
        gp.dobj[1].setWorldY(24 * gp.tileSize);
        
        gp.dobj[2] = new DrawVatThe(gp, new Key());
        gp.dobj[2].setImage(gp.uTool.setup("data/Object/"+gp.dobj[2].getVatThe().getName()+".png", gp.tileSize, gp.tileSize));
        gp.dobj[2].setWorldX(23 * gp.tileSize);
        gp.dobj[2].setWorldY(20 * gp.tileSize);
        
        gp.dobj[3] = new DrawVatThe(gp, new Boots());
        gp.dobj[3].setImage(gp.uTool.setup("data/Object/"+gp.dobj[3].getVatThe().getName()+".png", gp.tileSize, gp.tileSize));
        gp.dobj[3].setWorldX(34 * gp.tileSize);
        gp.dobj[3].setWorldY(41 * gp.tileSize);
        
        gp.dobj[4] = new DrawVatThe(gp, new Key());
        gp.dobj[4].setImage(gp.uTool.setup("data/Object/"+gp.dobj[4].getVatThe().getName()+".png", gp.tileSize, gp.tileSize));
        gp.dobj[4].setWorldX(23 * gp.tileSize);
        gp.dobj[4].setWorldY(22 * gp.tileSize);
        
        gp.dobj[5] = new DrawVatThe(gp, new Kunai());
        gp.dobj[5].setImage(gp.uTool.setup("data/Object/"+gp.dobj[5].getVatThe().getName()+".png", gp.tileSize, gp.tileSize));
        gp.dobj[5].setWorldX(23 * gp.tileSize);
        gp.dobj[5].setWorldY(23 * gp.tileSize);
        
        gp.dobj[6] = new DrawVatThe(gp, new Kunai());
        gp.dobj[6].setImage(gp.uTool.setup("data/Object/"+gp.dobj[6].getVatThe().getName()+".png", gp.tileSize, gp.tileSize));
        gp.dobj[6].setImage(gp.uTool.scaleImage(gp.dobj[6].getImage(), gp.tileSize/2, gp.tileSize/2));
        
        gp.dobj[7] = new DrawVatThe(gp, new Key());
        gp.dobj[7].setImage(gp.uTool.setup("data/Object/"+gp.dobj[7].getVatThe().getName()+".png", gp.tileSize, gp.tileSize));
        gp.dobj[7].setImage(gp.uTool.scaleImage(gp.dobj[7].getImage(), gp.tileSize/2, gp.tileSize/2));
        }
    
    public void setNPC(){
        
    	gp.drawN[0] = new DrawOldMan(gp, new OldMan());
        gp.drawN[0].setWorldX(21 * gp.tileSize);
        gp.drawN[0].setWorldY(21 * gp.tileSize);
        
        gp.drawN[1] = new DrawOldMan(gp, new OldMan());
        gp.drawN[1].setWorldX(22 * gp.tileSize);
        gp.drawN[1].setWorldY(21 * gp.tileSize);
        
        gp.drawN[2] = new DrawOldMan(gp, new OldMan());
        gp.drawN[2].setWorldX(20 * gp.tileSize);
        gp.drawN[2].setWorldY(21 * gp.tileSize);
    }
    
    public void setMonster(){
        
    	gp.drawM[0] = new DrawSlime(gp, new Slime());
        gp.drawM[0].setWorldX(23 * gp.tileSize);
        gp.drawM[0].setWorldY(36 * gp.tileSize);
        
        gp.drawM[1] = new DrawSlime(gp, new Slime());
        gp.drawM[1].setWorldX(23 * gp.tileSize);
        gp.drawM[1].setWorldY(37 * gp.tileSize);
        
        gp.drawM[2] = new DrawSlime(gp, new Slime());
        gp.drawM[2].setWorldX(23 * gp.tileSize);
        gp.drawM[2].setWorldY(35 * gp.tileSize);
        
        gp.drawM[3] = new DrawDragon(gp, new Dragon(40*gp.tileSize, 9*gp.tileSize));
        gp.drawM[3].setWorldX(38 * gp.tileSize);
        gp.drawM[3].setWorldY(8 * gp.tileSize);
        
        gp.drawM[4] = new DrawDragon(gp, new Dragon(40*gp.tileSize, 9*gp.tileSize));
        gp.drawM[4].setWorldX(36 * gp.tileSize);
        gp.drawM[4].setWorldY(8 * gp.tileSize);
        
        gp.drawM[5] = new DrawDragon(gp, new Dragon(40*gp.tileSize, 9*gp.tileSize));
        gp.drawM[5].setWorldX(37 * gp.tileSize);
        gp.drawM[5].setWorldY(8 * gp.tileSize);
        
        gp.drawM[6] = new DrawDragon(gp, new Dragon(40*gp.tileSize, 9*gp.tileSize));
        gp.drawM[6].setWorldX(38 * gp.tileSize);
        gp.drawM[6].setWorldY(9 * gp.tileSize);
        
        gp.drawM[7] = new DrawDragon(gp, new Dragon(40*gp.tileSize, 9*gp.tileSize));
        gp.drawM[7].setWorldX(37 * gp.tileSize);
        gp.drawM[7].setWorldY(9 * gp.tileSize);
        
        gp.drawM[8] = new DrawBossDragon(gp, new BossDragon(40*gp.tileSize, 9*gp.tileSize));
        gp.drawM[8].setWorldX(40 * gp.tileSize);
        gp.drawM[8].setWorldY(9 * gp.tileSize);
        
    }
}
