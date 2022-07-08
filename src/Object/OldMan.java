package Object;

import Graphics.DrawSinhVat;
import Graphics.DrawVatThe;
import InterFace.NoiChuyen;

public class OldMan extends SinhVat implements NoiChuyen{

	private String dialogues[] = new String[20];
	
	public OldMan() {
		// SinhVat(String name, int maxLife, int maxMp, int maxDefense, int maxExp, int speed, int type)
    	// maxlife = maxMP = 100
    	// maxDefecse = 50
    	// maxExp = 100
    	// speed = 1
    	// type = 0
		// damfe = 0
        super("Oldman", 100, 100, 50, 100, 1, 0, 0);
        this.setCollision(false);
	    setDialogue();
	}
	
	public String[] getDialogues() {
		return dialogues;
	}
	
	public void setDialogues(String[] dialogues) {
		this.dialogues = dialogues;
	}
    
  
	public void setDialogue() {
		
		dialogues[0] = "Hello, Bach.";
		dialogues[1] = "I used to a happy.";
		dialogues[2] ="But now monster every\nwhere.";
		dialogues[3] = "I am so scare.";
    }
	
	public String speak(int dialogueIndex){
     
        return dialogues[dialogueIndex];
    }

	@Override
	public void damageReaction(DrawSinhVat DSinhVat, DrawVatThe vatGayDamge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAction(DrawSinhVat dSinhVat) {
		// TODO Auto-generated method stub
		
	}

	
}
