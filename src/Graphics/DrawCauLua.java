package Graphics;

import java.awt.Graphics2D;

import GameSetting.GamePanel;
import Object.CauLua;

public class DrawCauLua extends DrawVatThe{
	
	private CauLua caulua;
	private DrawLua dLua;

	// toa do xuat hien cau lua
    private int startAttackX;
    private int startAttackY;
    private int targetX;
    private int targetY;
    
    // thoi gian hieu ung chay duy tri
    private int chayCounter;
        
	public DrawCauLua(GamePanel gp) {
		
		// TODO Auto-generated constructor stub
		super(gp, new CauLua());
		this.chayCounter = 0;
	}
	
	public DrawCauLua(GamePanel gp, CauLua caulua) {
		
		// TODO Auto-generated constructor stub
		super(gp, caulua);
		this.caulua = caulua;
		this.chayCounter = 0;
	}

	public DrawLua getdLua() {
		return dLua;
	}

	public void setdLua(DrawLua dLua) {
		this.dLua = dLua;
	}
	
	public int getChayCounter() {
		return chayCounter;
	}

	public void setChayCounter(int chayCounter) {
		this.chayCounter = chayCounter;
	}

	public int getTargetX() {
		return targetX;
	}

	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}

	public int getTargetY() {
		return targetY;
	}

	public void setTargetY(int targetY) {
		this.targetY = targetY;
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

    public void draw(Graphics2D g2) {
    	
    	super.draw(g2);
    	if (this.dLua != null) {
    		this.dLua.draw(g2);
    	}
    }
    
    public void update(){

    	// neu cau bay qua khoang cach thi tu no
    	int distanceX = Math.abs(this.getStartAttackX() - this.getVatThe().getWorldX());
        int distanceY = Math.abs(this.getStartAttackY() - this.getVatThe().getWorldY());
    	
        if (this.dLua != null) {
        	
        	if (this.getGp().cChecker.checkPlayer(dLua) == true ) {
    			
        		this.dLua.getLua().thieuDot(this.dLua);
        	}
        	
        	if (this.chayCounter >= 240) {
        		this.getVatThe().setExist(false);
        		this.chayCounter = 0;
        	}else {
        		
        		this.chayCounter++;
        	}
        	
        }else {
        	if (// co hai cach set 1 la lay toa do nhan vat truc tiep hoac lay target cua nhan vat
        			// 1 cai tu nhien hon nhung xau??
        			// 1 cai khong tu nhien nhung hien thi tot hon??
        			(this.getVatThe().getWorldX() - this.getGp().drawP.getVatThe().getWorldX() < 0) && this.getVatThe().getDirection().equals("left")||
        			(this.getVatThe().getWorldX() - this.getGp().drawP.getVatThe().getWorldX() > 0) && this.getVatThe().getDirection().equals("right")||
        			(this.getVatThe().getWorldY() - this.getGp().drawP.getVatThe().getWorldY() < 0) && this.getVatThe().getDirection().equals("up")||
        			(this.getVatThe().getWorldY() - this.getGp().drawP.getVatThe().getWorldY() > 0) && this.getVatThe().getDirection().equals("down")||
        			Math.max(distanceX, distanceY) >= this.caulua.getDistanceExists()
        			) {
        				this.caulua.gayChayKhuVuc(this);
        		
        	}else {
                switch(this.getVatThe().getDirection()){
	                case "up": this.getVatThe().setWorldY(this.getVatThe().getWorldY()-caulua.getSpeed()); break;
	                case "down": this.getVatThe().setWorldY(this.getVatThe().getWorldY()+caulua.getSpeed()); break;
	                case "left": this.getVatThe().setWorldX(this.getVatThe().getWorldX()-caulua.getSpeed()); break;
	                case "right": this.getVatThe().setWorldX(this.getVatThe().getWorldX()+caulua.getSpeed()); break;
                }
        	}
        }
    }
    
}
