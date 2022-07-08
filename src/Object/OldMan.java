package Object;

import InterFace.NoiChuyen;

public class OldMan extends SinhVat implements NoiChuyen{

	private String dialogues[] = new String[20];
	
	public OldMan() {
	    
	    super("Oldman", 0, 1, 3);
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
}
