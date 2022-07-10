package Graphics;


import GameSetting.GamePanel;
import GameSetting.UtilityTool;
import Object.BossDragon;

public class DrawBossDragon extends DrawDragon{

	
	private BossDragon bossDragon;

	private int thoiGianTrieuHoi;
	
	public DrawBossDragon(GamePanel gp, BossDragon bossDragon) {
		super(gp, bossDragon);
		// TODO Auto-generated constructor stub
		this.bossDragon = bossDragon;
		this.getEntityImage();
		
		this.thoiGianTrieuHoi = 0;
		
		this.getBossDragon().getSolidArea().x = (int) (this.getBossDragon().getSolidArea().x*1.5);
		this.getBossDragon().getSolidArea().y = (int) (this.getBossDragon().getSolidArea().y*1.5);
		this.getBossDragon().getSolidArea().width = (int) (this.getGp().tileSize*1.5 - 2*this.getBossDragon().getSolidArea().x);
		this.getBossDragon().getSolidArea().height = (int) (this.getGp().tileSize*1.5 - this.getBossDragon().getSolidArea().y);
		this.getBossDragon().setSolidAreaDefaultX(this.getBossDragon().getSolidArea().x);
        this.getBossDragon().setSolidAreaDefaultY(this.getBossDragon().getSolidArea().y);

	}
	
	
	
	public int getThoiGianTrieuHoi() {
		return thoiGianTrieuHoi;
	}

	public void setThoiGianTrieuHoi(int thoiGianTrieuHoi) {
		this.thoiGianTrieuHoi = thoiGianTrieuHoi;
	}

	public BossDragon getBossDragon() {
		return bossDragon;
	}

	public void setBossDragon(BossDragon bossDragon) {
		this.bossDragon = bossDragon;
	}
	
	@Override
	public void getEntityImage() {
		// TODO Auto-generated method stub
		
		
		UtilityTool uTool = new UtilityTool();
        
		int sizeWidth = (int) (gp.tileSize*1.5);
		int sizeHeight = (int) (gp.tileSize*1.5);
		
        setUp1(uTool.setup("data/Boss_Dragon/boss_up_1_preview_rev_1.png", sizeWidth, sizeHeight));
        setUp2(uTool.setup("data/Boss_Dragon/boss_up_2_preview_rev_1.png", sizeWidth, sizeHeight));
        setDown1(uTool.setup("data/Boss_Dragon/boss_down_1_preview_rev_1.png", sizeWidth, sizeHeight));
        setDown2(uTool.setup("data/Boss_Dragon/boss_down_2_preview_rev_1.png", sizeWidth, sizeHeight));
        setLeft1(uTool.setup("data/Boss_Dragon/boss_left_1_preview_rev_1.png", sizeWidth, sizeHeight));
        setLeft2(uTool.setup("data/Boss_Dragon/boss_left_2_preview_rev_1.png", sizeWidth, sizeHeight));
        setRight1(uTool.setup("data/Boss_Dragon/boss_right_1_preview_rev_1.png", sizeWidth, sizeHeight));
        setRight2(uTool.setup("data/Boss_Dragon/boss_right_2_preview_rev_1.png", sizeWidth, sizeHeight));
	}
	
	public void update() {
		
		super.update();
		
		this.bossDragon.trieuHoi(this);

	}
}
