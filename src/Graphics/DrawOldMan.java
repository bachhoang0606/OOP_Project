package Graphics;


import GameSetting.GamePanel;
import GameSetting.UtilityTool;
import InterFace.DrawSpeak;
import Object.OldMan;

public class DrawOldMan extends DrawSinhVat implements DrawSpeak{
	
	public OldMan oldMan;
	
    private int dialogueIndex = 0;
	
	public DrawOldMan(GamePanel gp, OldMan man) {
        
        super(gp, man);
        
        this.oldMan = man;
        this.setDirection("right");
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
    
    
    public void DrawSpeakSV(){
        
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
        
        if(getActionLockCounter() == 60){
        	switch (this.getDirection()) {
			case "left": { setDirection("right"); break;}
			case "right": { setDirection("left"); break;}
	
			default: { setDirection("right"); break;}
			}
        	
            setActionLockCounter(0);
        }
    }
    
    public void update() {
    	super.update();
    	this.setAction();
    }
}
