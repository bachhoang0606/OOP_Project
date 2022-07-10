package Graphics;

import GameSetting.GamePanel;
import Object.Kunai;

public class DrawKunai extends DrawVatThe{
	
	private Kunai kunai;

	// toa do xuat hien kunai
    private int startAttackX;
    private int startAttackY;
	
	public DrawKunai(GamePanel gp) {
		
		// TODO Auto-generated constructor stub
		super(gp, new Kunai());
	}
	
	public DrawKunai(GamePanel gp, Kunai kunai) {
		
		// TODO Auto-generated constructor stub
		super(gp, kunai);
		this.kunai = kunai;
	}
	
    public Kunai getKunai() {
		return kunai;
	}

	public void setKunai(Kunai kunai) {
		this.kunai = kunai;
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
        
        int distanceX = Math.abs(startAttackX - this.getVatThe().getWorldX());
        int distanceY = Math.abs(startAttackY - this.getVatThe().getWorldY());
        if(Math.max(distanceX, distanceY) < this.kunai.getDistanceExists()){
            
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

            
            if(isCollisionOn() == false && this.getVatThe().isDisappearing() == false){
                switch(this.getVatThe().getDirection()){
                case "up": this.getVatThe().setWorldY(this.getVatThe().getWorldY()-kunai.getSpeed()); break;
                case "down": this.getVatThe().setWorldY(this.getVatThe().getWorldY()+kunai.getSpeed()); break;
                case "left": this.getVatThe().setWorldX(this.getVatThe().getWorldX()-kunai.getSpeed()); break;
                case "right": this.getVatThe().setWorldX(this.getVatThe().getWorldX()+kunai.getSpeed()); break;
                }
            }else this.getVatThe().setDisappearing(true);
        }
        else {
        	this.getVatThe().setDisappearing(true);
        }
    }
    
    // gay dame cho doi tuong cham vao no
    public void inflictDamage(DrawSinhVat sinhVatNhanDamge){
        
        if(sinhVatNhanDamge != null){
        	// cham vao quai bien mat
        	this.getVatThe().setDisappearing(true);
            if(sinhVatNhanDamge.getSinhVat().isInvincible() == false){

                getGp().playSE(6);
                
                // sat thuong dich nhan khi cham kunai
                int satThuong = this.getKunai().getDamge() - sinhVatNhanDamge.getSinhVat().getDefense();
                if (satThuong > 0) {
                	sinhVatNhanDamge.getSinhVat().setLife(sinhVatNhanDamge.getSinhVat().getLife() - satThuong);
                }else sinhVatNhanDamge.getSinhVat().setLife(sinhVatNhanDamge.getSinhVat().getLife() - 1);
                
                sinhVatNhanDamge.getSinhVat().damageReaction(sinhVatNhanDamge, this);
                sinhVatNhanDamge.getSinhVat().setInvincible(true);

                if(sinhVatNhanDamge.getSinhVat().getLife() <= 0){
                	sinhVatNhanDamge.getSinhVat().setDying(true);
                }
            }
        }
    }
}

