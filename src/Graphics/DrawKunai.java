package Graphics;

import GameSetting.GamePanel;
import Object.Kunai;

public class DrawKunai extends DrawObject{
	
	private Kunai kunai;
	private int distance;
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
            
            getGp().cChecker.checkTile(this);
            getGp().cChecker.checkEntity(this, getGp().drawN);
            
            int indexMonster =  getGp().cChecker.checkEntity(this, getGp().drawM);
            inflictDamage(indexMonster);
                        
            getGp().cChecker.checkObject(this, false);
            
            System.out.println(isCollisionOn());
            
            if(isCollisionOn() == false){
            	System.out.println("update kunai");  // false
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
    
    public void inflictDamage(int i){
        
        if(i != 999){
            if(getGp().drawM[i].isInvincible() == false){
            
                getGp().playSE(6);
                getGp().drawM[i].getSinhVat().setLife(getGp().drawM[i].getSinhVat().getLife()-1);
                getGp().drawM[i].getSinhVat().damageReaction();
                getGp().drawM[i].setInvincible(true);

                if(getGp().drawM[i].getSinhVat().getLife() <= 0){

                    getGp().drawM[i].setDying(true);
                }
            }
        }
    }
}

