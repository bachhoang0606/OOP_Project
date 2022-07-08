package Graphics;

import java.util.Random;

import GameSetting.GamePanel;
import GameSetting.UtilityTool;
import Object.GreenSlime;

public class DrawSlime extends DrawSinhVat{
	
	private GreenSlime slime;

	public GreenSlime getSlime() {
		return slime;
	}

	public void setSlime(GreenSlime slime) {
		this.slime = slime;
	}

	public DrawSlime(GamePanel gp, GreenSlime slime) {

        super(gp, slime, 8, 1);
        this.slime = slime;
        getSolidArea().x = 3;
        getSolidArea().y = 18;
        getSolidArea().width = 42;
        getSolidArea().height = 30;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        
        getEntityImage();
    }
	
	public void getEntityImage(){
        
        UtilityTool uTool = new UtilityTool();
        
        setUp1(uTool.setup("data/Monster/greenslime_down_1.png", gp.tileSize, gp.tileSize));
        setUp2(uTool.setup("data/Monster/greenslime_down_2.png", gp.tileSize, gp.tileSize));
        setDown1(uTool.setup("data/Monster/greenslime_down_1.png", gp.tileSize, gp.tileSize));
        setDown2(uTool.setup("data/Monster/greenslime_down_2.png", gp.tileSize, gp.tileSize));
        setLeft1(uTool.setup("data/Monster/greenslime_down_1.png", gp.tileSize, gp.tileSize));
        setLeft2(uTool.setup("data/Monster/greenslime_down_2.png", gp.tileSize, gp.tileSize));
        setRight1(uTool.setup("data/Monster/greenslime_down_1.png", gp.tileSize, gp.tileSize));
        setRight2(uTool.setup("data/Monster/greenslime_down_2.png", gp.tileSize, gp.tileSize));
        
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
