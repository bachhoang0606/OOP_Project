package Graphics;

import java.awt.Graphics2D;

import GameSetting.GamePanel;
import GameSetting.UtilityTool;
import Object.Dragon;

public class DrawDragon extends DrawSinhVat{

	private Dragon dragon;
	private DrawCauLua dCauLua;
	// anh chieu thuc
	
	// thoi gian doi huong khi truy duoi
	private int truyDuoiCounter;
	private int banCauLuaCounter;
	
	public DrawDragon(GamePanel gp, Dragon dragon) {
		super(gp, dragon);
		// TODO Auto-generated constructor stub
		this.dragon = dragon;
		this.getEntityImage();
		this.truyDuoiCounter = 0;
		this.banCauLuaCounter = 0;
	}

	
	
	public int getTruyDuoiCounter() {
		return truyDuoiCounter;
	}

	public void setTruyDuoiCounter(int truyDuoiCounter) {
		this.truyDuoiCounter = truyDuoiCounter;
	}

	public int getBanCauLuaCounter() {
		return banCauLuaCounter;
	}

	public void setBanCauLuaCounter(int banCauLuaCounter) {
		this.banCauLuaCounter = banCauLuaCounter;
	}

	public DrawCauLua getdCauLua() {
		return dCauLua;
	}

	public void setdCauLua(DrawCauLua dCauLua) {
		this.dCauLua = dCauLua;
	}
	
	public Dragon getDragon() {
		return dragon;
	}

	public void setDragon(Dragon dragon) {
		this.dragon = dragon;
	}

	@Override
	public void getEntityImage() {
		// TODO Auto-generated method stub
		
		
		UtilityTool uTool = new UtilityTool();
        
        setUp1(uTool.setup("data/Rong/rong_up1_preview_rev_1.png", gp.tileSize, gp.tileSize));
        setUp2(uTool.setup("data/Rong/rong_up2_preview_rev_1.png", gp.tileSize, gp.tileSize));
        setDown1(uTool.setup("data/Rong/rong_down1_preview_rev_1.png", gp.tileSize, gp.tileSize));
        setDown2(uTool.setup("data/Rong/rong_down2_preview_rev_1.png", gp.tileSize, gp.tileSize));
        setLeft1(uTool.setup("data/Rong/rong_left1_preview_rev_1.png", gp.tileSize, gp.tileSize));
        setLeft2(uTool.setup("data/Rong/rong_left2_preview_rev_1.png", gp.tileSize, gp.tileSize));
        setRight1(uTool.setup("data/Rong/rong_right1_preview_rev_1.png", gp.tileSize, gp.tileSize));
        setRight2(uTool.setup("data/Rong/rong_right2_preview_rev_1.png", gp.tileSize, gp.tileSize));
	}

	public void update() {
		super.update();
		
		
		// cap nhat qua cau lua sau khi duoc tao
		if (this.dCauLua != null) {
			this.dCauLua.update();
		}

		// kiem tra su quay ve cua rong
		this.dragon.veTo(this);
		
		if (dragon.isAttack() == false) {
			dragon.setAction(this);
		}else {
			if (this.truyDuoiCounter >= 15) {
				dragon.truyDuoi(this, this.gp.drawP.getVatThe().getWorldX(), this.gp.drawP.getVatThe().getWorldY());
				this.truyDuoiCounter = 0;
			}else this.truyDuoiCounter++;
			
			if (this.banCauLuaCounter >= 120 && this.dCauLua == null) {
				dragon.banCauLua(this, this.gp.drawP.getVatThe().getWorldX(), this.gp.drawP.getVatThe().getWorldY());
				this.banCauLuaCounter = 0;
			}else this.banCauLuaCounter++;
			
		}
		
		if (dCauLua!= null && dCauLua.getVatThe().isExist() == false) {
			dCauLua.getdLua().setLua(null);
			dCauLua.setdLua(null);
			dCauLua.setCaulua(null);
			dCauLua = null;
			
		}
		
		this.dragon.phatHienDich(this);
	}
	
	public void draw(Graphics2D g2) {
		
		super.draw(g2);
	
		if (this.dCauLua != null) {
			this.dCauLua.draw(g2);
		}
	}
}
