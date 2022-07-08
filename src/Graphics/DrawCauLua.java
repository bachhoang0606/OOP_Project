package Graphics;

import java.awt.image.BufferedImage;

import GameSetting.GamePanel;
import Object.CauLua;

public class DrawCauLua extends DrawVatThe{
	
	private CauLua caulua;

	// toa do xuat hien cau lua
    private int startAttackX;
    private int startAttackY;
	
    // anh hieu ung chay khu vuc
    private BufferedImage anhChay; 

	public DrawCauLua(GamePanel gp) {
		
		// TODO Auto-generated constructor stub
		super(gp, new CauLua());
		this.setAnh();
	}
	
	public DrawCauLua(GamePanel gp, CauLua caulua) {
		
		// TODO Auto-generated constructor stub
		super(gp, caulua);
		this.caulua = caulua;
		this.setAnh();
	}
	
	
	public BufferedImage getAnhChay() {
		return anhChay;
	}

	public void setAnhChay(BufferedImage anhChay) {
		this.anhChay = anhChay;
	}

	public CauLua getCaulua() {
		return caulua;
	}

	public void setCaulua(CauLua caulua) {
		this.caulua = caulua;
	}

	public int getStartAttackX() {
        return startAttackX;
    }

    public void setStartAttackX(int startAttackX) {
        this.startAttackX = startAttackX;
    }

    public int getStartAttackY() {
        return startAttackY;
    }

    public void setStartAttackY(int startAttackY) {
        this.startAttackY = startAttackY;
    }
    
    
    public void update(){
    	
        if(isCollisionOn() == false){
            switch(getDirection()){
            case "up": this.setWorldY(this.getWorldY()-caulua.getSpeed()); break;
            case "down": this.setWorldY(this.getWorldY()+caulua.getSpeed()); break;
            case "left": this.setWorldX(this.getWorldX()-caulua.getSpeed()); break;
            case "right": this.setWorldX(this.getWorldX()+caulua.getSpeed()); break;
            }
        }else setDisappearing(true);
    }
    
    public void setAnh() {
    	anhChay = uTool.setup("data/Rong/chay.png", gp.tileSize, gp.tileSize);
    }
}
