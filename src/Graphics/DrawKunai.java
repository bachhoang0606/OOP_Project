package Graphics;

import GameSetting.GamePanel;
import Object.Kunai;

public class DrawKunai extends DrawVatThe{
	
	private Kunai kunai;
	
	private int distance;
	
	// toa do xuat hien kunai
    private int startAttackX;
    private int startAttackY;
	
	public DrawKunai(GamePanel gp) {
		super(gp, new Kunai());
		// TODO Auto-generated constructor stub
		this.distance = gp.tileSize*5;
	}
	
	public DrawKunai(GamePanel gp, Kunai kunai) {
		super(gp, kunai);
		// TODO Auto-generated constructor stub
		this.kunai = kunai;
		this.distance = gp.tileSize*5;
	}
	
    public Kunai getKunai() {
		return kunai;
	}

	public void setKunai(Kunai kunai) {
		this.kunai = kunai;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
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
        
        int distanceX = Math.abs(startAttackX - this.getWorldX());
        int distanceY = Math.abs(startAttackY - this.getWorldY());
        if(Math.max(distanceX, distanceY) < distance){
            
            setCollisionOn(false);
            
            // kiem tra va cham voi map
            getGp().cChecker.checkTile(this);
            
            // kiem tra va cham voi nhan vat
            getGp().cChecker.checkEntity(this, getGp().drawN);
            
            // gay dame cho sinh vat cham vao
            DrawSinhVat indexMonster =  getGp().cChecker.checkEntity(this, getGp().drawM);
            inflictDamage(indexMonster);
                        
            // kiem tra va cham voi doi tuong
            getGp().cChecker.checkObject(this, false);

            
            if(isCollisionOn() == false){
                switch(getDirection()){
                case "up": this.setWorldY(this.getWorldY()-kunai.getSpeed()); break;
                case "down": this.setWorldY(this.getWorldY()+kunai.getSpeed()); break;
                case "left": this.setWorldX(this.getWorldX()-kunai.getSpeed()); break;
                case "right": this.setWorldX(this.getWorldX()+kunai.getSpeed()); break;
                }
            }else setDisappearing(true);
        }
        else {
            setDisappearing(true);
        }
    }
    
    // gay dame cho doi tuong cham vao no
    public void inflictDamage(DrawSinhVat sinhVatNhanDamge){
        
        if(sinhVatNhanDamge != null){
            if(sinhVatNhanDamge.isInvincible() == false){
            
                getGp().playSE(6);
                
                // sat thuong dich nhan khi cham kunai
                int satThuong = this.getKunai().getDamge() - sinhVatNhanDamge.getSinhVat().getDefense();
                if (satThuong > 0) {
                	sinhVatNhanDamge.getSinhVat().setLife(sinhVatNhanDamge.getSinhVat().getLife() - satThuong);
                }else sinhVatNhanDamge.getSinhVat().setLife(sinhVatNhanDamge.getSinhVat().getLife() - 1);
                
                sinhVatNhanDamge.getSinhVat().damageReaction();
                sinhVatNhanDamge.setInvincible(true);

                if(sinhVatNhanDamge.getSinhVat().getLife() <= 0){
                	sinhVatNhanDamge.setDying(true);
                }
            }
        }
    }
}

