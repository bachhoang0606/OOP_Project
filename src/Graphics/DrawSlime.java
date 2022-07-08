package Graphics;


import GameSetting.GamePanel;
import GameSetting.UtilityTool;
import Object.Slime;

public class DrawSlime extends DrawSinhVat{
	
	private Slime slime;

	public DrawSlime(GamePanel gp, Slime slime) {

        super(gp, slime);
        this.slime = slime;
        getSolidArea().x = 3;
        getSolidArea().y = 18;
        getSolidArea().width = 42;
        getSolidArea().height = 30;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        
        getEntityImage();
    }
	
	public Slime getSlime() {
		return slime;
	}

	public void setSlime(Slime slime) {
		this.slime = slime;
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
}
