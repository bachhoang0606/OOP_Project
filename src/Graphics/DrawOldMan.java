package Graphics;

import java.util.Random;

import GameSetting.GamePanel;
import GameSetting.UtilityTool;
import InterFace.DrawSpeak;
import Object.OldMan;

public class DrawOldMan extends DrawSinhVat implements DrawSpeak{
	
	public OldMan oldMan;
	
    private int dialogueIndex = 0;
	
	public DrawOldMan(GamePanel gp, OldMan man) {
        
        super(gp, man, 0, 1);
        
        this.oldMan = man;
        getEntityImage();
    }
	
	public void getEntityImage(){
        
        UtilityTool uTool = new UtilityTool();
        
        setUp1(uTool.setup("data/NPC/oldman_up_1.png", gp.tileSize, gp.tileSize));
        setUp2(uTool.setup("data/NPC/oldman_up_2.png", gp.tileSize, gp.tileSize));
        setDown1(uTool.setup("data/NPC/oldman_down_1.png", gp.tileSize, gp.tileSize));
        setDown2(uTool.setup("data/NPC/oldman_down_2.png", gp.tileSize, gp.tileSize));
        setLeft1(uTool.setup("data/NPC/oldman_left_1.png", gp.tileSize, gp.tileSize));
        setLeft2(uTool.setup("data/NPC/oldman_left_2.png", gp.tileSize, gp.tileSize));
        setRight1(uTool.setup("data/NPC/oldman_right_1.png", gp.tileSize, gp.tileSize));
        setRight2(uTool.setup("data/NPC/oldman_right_2.png", gp.tileSize, gp.tileSize));
    }
    
    
    public void DrawSpeak(){
        
    	if(oldMan.speak(dialogueIndex) == null) {
    		this.dialogueIndex = 0;
    	}
    	
    	gp.ui.currentDialogue = oldMan.speak(dialogueIndex);
        dialogueIndex++;

        switch(gp.drawP.getDirection()){
	        case "up": this.setDirection("down"); break;
	        case "down": this.setDirection("up"); break;
	        case "left": this.setDirection("right"); break;
	        case "right": this.setDirection("left"); break;
        }
    }
    
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
}
