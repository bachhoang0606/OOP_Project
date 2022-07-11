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
        this.oldMan.setDirection("right");
        getEntityImage();
    }

	public OldMan getOldMan() {
		return oldMan;
	}

	public void setOldMan(OldMan oldMan) {
		this.oldMan = oldMan;
	}

	public int getDialogueIndex() {
		return dialogueIndex;
	}

	public void setDialogueIndex(int dialogueIndex) {
		this.dialogueIndex = dialogueIndex;
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

        switch(gp.drawP.getPlayer().getDirection()){
	        case "up": this.getOldMan().setDirection("down"); break;
	        case "down": this.getOldMan().setDirection("up"); break;
	        case "left": this.getOldMan().setDirection("right"); break;
	        case "right": this.getOldMan().setDirection("left"); break;
        }
    }
    
    public void setAction(){
        
    	setActionLockCounter(getActionLockCounter()+1);
        
        if(getActionLockCounter() == 60){
        	switch (this.getOldMan().getDirection()) {
			case "left": { this.getOldMan().setDirection("right"); break;}
			case "right": { this.getOldMan().setDirection("left"); break;}
	
			default: { this.getOldMan().setDirection("right"); break;}
			}
        	
            setActionLockCounter(0);
        }
    }
    
    public void update() {
    	super.update();
    	this.setAction();
    }
}
