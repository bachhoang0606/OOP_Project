package Object;

import java.util.Random;

import Graphics.DrawCauLua;
import Graphics.DrawDragon;
import Graphics.DrawSinhVat;
import Graphics.DrawVatThe;

public class Dragon extends SinhVat{
	
	// pham vi tan cong
	private int attackRange;
	private int startAttackX;
	private int startAttackY;
	private CauLua caulua;
	
	// vao trang thai chien dau
	private boolean attack;
	public Dragon() {
		
		// TODO Auto-generated constructor stub
		// SinhVat(String name, int maxLife, int maxMp, int maxDefense, int maxExp, int speed, int type)
    	// maxlife = maxMP = 100
    	// maxDefecse = 50
    	// maxExp = 100
    	// speed = 1
    	// type = 0
		// damfe = 0
		super("Dragon", 100, 100, 50, 40, 2, 2, 10);
		
		setExp(getMaxExp());
		this.attack = false;
		this.attackRange = 240;
	}

	
	public boolean isAttack() {
		return attack;
	}

	public void setAttack(boolean attack) {
		this.attack = attack;
	}

	public int getAttackRange() {
		return attackRange;
	}
	
	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
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



	@Override
	public void damageReaction(DrawSinhVat DSinhVat, DrawVatThe vatGayDamge) {
		// TODO Auto-generated method stub
		DSinhVat.setActionLockCounter(0);
		
		// Chuyen sang trang thai chien dau
		this.attack = true;
	}

	// chieu ban cau lua cua rong
	public void banCauLua(DrawDragon dDragon, int playerX, int playerY) {
		
		// kiem tra xem player co trong pham vi tan cong khong
		double x = Math.pow(dDragon.getWorldX() - playerX, 2);
		double y = Math.pow(dDragon.getWorldY() - playerY, 2);
		double distance = Math.sqrt(x + y);
		
		// neu nguoi choi trong pham vi thi tan cong
		if (distance < attackRange) {
			this.caulua = new CauLua();
			if (this.getMp() - this.caulua.getMp() >=0) {
				this.setMp(this.getMp() - this.caulua.getMp());
		        this.startAttackX = dDragon.getWorldX() + dDragon.getSolidArea().x;
		        this.startAttackY = dDragon.getWorldY() + dDragon.getSolidArea().y;

		        
		        dDragon.setdCauLua(new DrawCauLua(dDragon.getGp(), this.caulua));
		        dDragon.getdCauLua().setImage(dDragon.uTool.setup("data/Object/"+this.caulua.getName()+".png", 
		        		dDragon.getGp().tileSize, 
		        		dDragon.getGp().tileSize
		        	)
		        );

		        switch(dDragon.getDirection()){
		            case "up": this.startAttackY -= dDragon.getSolidArea().height; break;
		            case "down": this.startAttackY += dDragon.getSolidArea().height; break;
		            case "left": this.startAttackX -= dDragon.getSolidArea().height; break;
		            case "right": this.startAttackX += dDragon.getSolidArea().height; break;
		        }

		        dDragon.getdCauLua().setDirection(dDragon.getDirection());
		        dDragon.getdCauLua().setWorldX(startAttackX);
		        dDragon.getdCauLua().setWorldY(startAttackY);
		        dDragon.getdCauLua().setStartAttackX(startAttackX);
		        dDragon.getdCauLua().setStartAttackY(startAttackY);
		        this.caulua.setSpeed(this.getSpeed()+3);
			}
		}
	}
	
	
	// truy duoi nguoi choi
	public void truyDuoi(DrawDragon dDragon, int playerX, int playerY) {

		
		int distanceX = playerX - dDragon.getWorldX();
        int distanceY = playerY - dDragon.getWorldY();
        
        // di chuyen theo khoang cach ngan hon den nguoi choi
        //System.out.println(dDragon.isCollisionOn());
        if( Math.abs(distanceX) > Math.abs(distanceY)){
        	// neu distanceX > 0 thi nguoi choi ben duoi rong
        	if(dDragon.isCollisionOn() == false) {
        		if (distanceX > 0) {
	        		dDragon.setDirection("right");
	        	}else {
	        		dDragon.setDirection("left");
	        	}
        	}else {
	        	if (distanceY > 0) {
	        		dDragon.setDirection("down");
	        	}else {
	        		dDragon.setDirection("up");
	        	}
        	}
        }else {
        	if(dDragon.isCollisionOn() == false) {
        		if (distanceY > 0) {
	        		dDragon.setDirection("down");
	        	}else {
	        		dDragon.setDirection("up");
	        	}
        	}else {
        		if (distanceX > 0) {
	        		dDragon.setDirection("right");
	        	}else {
	        		dDragon.setDirection("left");
	        	}
        	}
        }
	}
	
	
	@Override
	public void setAction(DrawSinhVat dSinhVat){
        
		dSinhVat.setActionLockCounter(dSinhVat.getActionLockCounter()+1);
        
        if(dSinhVat.getActionLockCounter() == 120){
            
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25){ dSinhVat.setDirection("up"); }
            else if(i > 25 && i <= 50){ dSinhVat.setDirection("down"); }
            else if(i > 50 && i <= 75){ dSinhVat.setDirection("left"); }
            else if(i > 75 && i <= 100){ dSinhVat.setDirection("right"); }
            
            dSinhVat.setActionLockCounter(0);
        }
    }
}
