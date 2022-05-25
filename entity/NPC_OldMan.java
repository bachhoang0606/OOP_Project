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
public class NPC_OldMan extends Entity{

    public NPC_OldMan(GamePanel gp) {
        
        super(gp, "Oldman", 0, 1, 3);
        
        getEntityImage();
        setDialogue();
    }
    
    @Override
    public void getEntityImage(){
        
        UtilityTool uTool = new UtilityTool();
        
        setUp1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/NPC/oldman_up_1.png", getGp().tileSize, getGp().tileSize));
        setUp2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/NPC/oldman_up_2.png", getGp().tileSize, getGp().tileSize));
        setDown1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/NPC/oldman_down_1.png", getGp().tileSize, getGp().tileSize));
        setDown2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/NPC/oldman_down_2.png", getGp().tileSize, getGp().tileSize));
        setLeft1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/NPC/oldman_left_1.png", getGp().tileSize, getGp().tileSize));
        setLeft2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/NPC/oldman_left_2.png", getGp().tileSize, getGp().tileSize));
        setRight1(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/NPC/oldman_right_1.png", getGp().tileSize, getGp().tileSize));
        setRight2(uTool.setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/NPC/oldman_right_2.png", getGp().tileSize, getGp().tileSize));
    }
    
    public void setDialogue(){
        
        getDialogues()[0] = "Hello, Bach.";
        getDialogues()[1] = "I used to a happy.";
        getDialogues()[2] ="But now monster every\nwhere.";
        getDialogues()[3] = "I am so scare.";
        
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
    public void speak(){
        
        super.speak();
    }
}
