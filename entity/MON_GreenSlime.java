/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Random;
import gameSetting.GamePanel;
import gameSetting.UtilityTool;

/**
 *
 * @author HOANG XUAN BACH
 */
public class MON_GreenSlime extends Entity{
    
    public MON_GreenSlime(GamePanel gp) {

        super(gp, "Green Slime", 8, 1, 2);
        getSolidArea().x = 3;
        getSolidArea().y = 18;
        getSolidArea().width = 42;
        getSolidArea().height = 30;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        
        getEntityImage();
    }
    
    @Override
    public void getEntityImage(){
        
        UtilityTool uTool = new UtilityTool();
        
        setUp1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Monster/greenslime_down_1.png", getGp().tileSize, getGp().tileSize));
        setUp2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Monster/greenslime_down_2.png", getGp().tileSize, getGp().tileSize));
        setDown1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Monster/greenslime_down_1.png", getGp().tileSize, getGp().tileSize));
        setDown2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Monster/greenslime_down_2.png", getGp().tileSize, getGp().tileSize));
        setLeft1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Monster/greenslime_down_1.png", getGp().tileSize, getGp().tileSize));
        setLeft2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Monster/greenslime_down_2.png", getGp().tileSize, getGp().tileSize));
        setRight1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Monster/greenslime_down_1.png", getGp().tileSize, getGp().tileSize));
        setRight2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Monster/greenslime_down_2.png", getGp().tileSize, getGp().tileSize));
        
    }
    
    @Override
    public void setAction(){
        
        setActionLockCounter(getActionLockCounter()+1);
        
        if(getActionLockCounter() == 120){
            
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25){ setDirection("up"); }
            else if(i > 25 && i <= 50){ setDirection("down"); }
            else if(i > 50 && i <= 75){ setDirection("left"); }
            else if(i > 75 && i <= 100){ setDirection("right"); }
            
            setActionLockCounter(0);
        }
    }
    
    @Override
    public void damageReaction(){
        
        setActionLockCounter(0);
        setDirection(getGp().player.getDirection());
    }
}
