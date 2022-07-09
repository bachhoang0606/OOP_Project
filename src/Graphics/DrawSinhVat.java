package Graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GameSetting.GamePanel;
import Object.SinhVat;

public abstract class DrawSinhVat extends DrawVatThe{
	
	private SinhVat sinhVat;
	
	// IMAGE
    private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    private BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
    
    // RECTANGLE
    private Rectangle attackArea;
    
    // COUNTER
    private int invincibleCounter;
    private int actionLockCounter;
    private int dyingCounter;
    private int hpBarCounter;
    
    // thoi gian hoi mp
    private int thoiGianHoiPhuc;
    
    // STATE
    private String direction;
    private int spriteNum;
    private int spriteCounter;
    private boolean invincible;
    private boolean dying;
    private boolean hpBarOn;

    public DrawSinhVat(GamePanel gp, SinhVat sinhVat) {
    	super(gp, sinhVat);
        this.sinhVat = sinhVat;
        
        setDirection("down");
        setSolidArea(new Rectangle(0, 0 , gp.tileSize, gp.tileSize));
        
        attackArea = new Rectangle(0, 0, 0, 0);
        
        
        getSolidArea().x = 8;
        getSolidArea().y = 16;
        getSolidArea().height = gp.tileSize - 16;
        getSolidArea().width = gp.tileSize - 16;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        
        invincibleCounter = 0;
        spriteNum = 1;
        spriteCounter = 0;
        actionLockCounter = 0;
        dyingCounter = 0;
        hpBarCounter = 0;
        
        invincible = false;
        dying = false;
        hpBarOn = false;
    }

    
    
    public int getThoiGianHoiPhuc() {
		return thoiGianHoiPhuc;
	}

	public void setThoiGianHoiPhuc(int thoiGianHoiPhuc) {
		this.thoiGianHoiPhuc = thoiGianHoiPhuc;
	}

	public SinhVat getSinhVat() {
		return sinhVat;
	}

	public void setSinhVat(SinhVat sinhVat) {
		this.sinhVat = sinhVat;
	}

	public BufferedImage getUp1() {
		return up1;
	}

	public void setUp1(BufferedImage up1) {
		this.up1 = up1;
	}

	public BufferedImage getUp2() {
		return up2;
	}

	public void setUp2(BufferedImage up2) {
		this.up2 = up2;
	}

	public BufferedImage getDown1() {
		return down1;
	}

	public void setDown1(BufferedImage down1) {
		this.down1 = down1;
	}

	public BufferedImage getDown2() {
		return down2;
	}

	public void setDown2(BufferedImage down2) {
		this.down2 = down2;
	}

	public BufferedImage getLeft1() {
		return left1;
	}
	
	public void setLeft1(BufferedImage left1) {
		this.left1 = left1;
	}

	public BufferedImage getLeft2() {
		return left2;
	}

	public void setLeft2(BufferedImage left2) {
		this.left2 = left2;
	}

	public BufferedImage getRight1() {
		return right1;
	}

	public void setRight1(BufferedImage right1) {
		this.right1 = right1;
	}

	public BufferedImage getRight2() {
		return right2;
	}

	public void setRight2(BufferedImage right2) {
		this.right2 = right2;
	}

	public BufferedImage getAttackUp1() {
		return attackUp1;
	}

	public void setAttackUp1(BufferedImage attackUp1) {
		this.attackUp1 = attackUp1;
	}

	public BufferedImage getAttackUp2() {
		return attackUp2;
	}

	public void setAttackUp2(BufferedImage attackUp2) {
		this.attackUp2 = attackUp2;
	}

	public BufferedImage getAttackDown1() {
		return attackDown1;
	}

	public void setAttackDown1(BufferedImage attackDown1) {
		this.attackDown1 = attackDown1;
	}

	public BufferedImage getAttackDown2() {
		return attackDown2;
	}

	public void setAttackDown2(BufferedImage attackDown2) {
		this.attackDown2 = attackDown2;
	}

	public BufferedImage getAttackLeft1() {
		return attackLeft1;
	}
	
	public void setAttackLeft1(BufferedImage attackLeft1) {
		this.attackLeft1 = attackLeft1;
	}

	public BufferedImage getAttackLeft2() {
		return attackLeft2;
	}

	public void setAttackLeft2(BufferedImage attackLeft2) {
		this.attackLeft2 = attackLeft2;
	}

	public BufferedImage getAttackRight1() {
		return attackRight1;
	}

	public void setAttackRight1(BufferedImage attackRight1) {
		this.attackRight1 = attackRight1;
	}

	public BufferedImage getAttackRight2() {
		return attackRight2;
	}

	public void setAttackRight2(BufferedImage attackRight2) {
		this.attackRight2 = attackRight2;
	}

	public Rectangle getAttackArea() {
		return attackArea;
	}

	public void setAttackArea(Rectangle attackArea) {
		this.attackArea = attackArea;
	}

	public int getInvincibleCounter() {
		return invincibleCounter;
	}

	public void setInvincibleCounter(int invincibleCounter) {
		this.invincibleCounter = invincibleCounter;
	}

	public int getActionLockCounter() {
		return actionLockCounter;
	}

	public void setActionLockCounter(int actionLockCounter) {
		this.actionLockCounter = actionLockCounter;
	}

	public int getDyingCounter() {
		return dyingCounter;
	}

	public void setDyingCounter(int dyingCounter) {
		this.dyingCounter = dyingCounter;
	}

	public int getHpBarCounter() {
		return hpBarCounter;
	}

	public void setHpBarCounter(int hpBarCounter) {
		this.hpBarCounter = hpBarCounter;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getSpriteNum() {
		return spriteNum;
	}

	public void setSpriteNum(int spriteNum) {
		this.spriteNum = spriteNum;
	}

	public int getSpriteCounter() {
		return spriteCounter;
	}

	public void setSpriteCounter(int spriteCounter) {
		this.spriteCounter = spriteCounter;
	}

	public boolean isInvincible() {
		return invincible;
	}

	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}

	public boolean isDying() {
		return dying;
	}

	public void setDying(boolean dying) {
		this.dying = dying;
	}

	public boolean isHpBarOn() {
		return hpBarOn;
	}

	public void setHpBarOn(boolean hpBarOn) {
		this.hpBarOn = hpBarOn;
	}
	
    public void update(){
        
    	this.sinhVat.setAction(this);;
        
        setCollisionOn(false);
        
        gp.cChecker.checkTile(this);
        gp.cChecker.checkEntity(this, gp.drawN);
        gp.cChecker.checkEntity(this, gp.drawM);

        gp.cChecker.checkObject(this, false);
        
        // kiem tra xem 
        boolean contactPlayer = gp.cChecker.checkPlayer(this);
 
        // neu cham vao quai khong trong tranng thai bi thuong thi chui sat thuong
        if(this.sinhVat.getType() == 2 && contactPlayer == true){
            if(gp.drawP.isInvincible() == false){
            	gp.playSE(6);
                // we can give damage
            	// sat thuong nhan bang sat thuong quai tru phong th
            	int satThuongNhan = this.sinhVat.getDamge() - gp.drawP.getPlayer().getDefense();
            	
            	// dam bao sat thuong nhan luon lon hon 0
            	if (satThuongNhan > 0) {
            		gp.drawP.getPlayer().setLife(gp.drawP.getPlayer().getLife() - satThuongNhan);
            	}else gp.drawP.getPlayer().setLife(gp.drawP.getPlayer().getLife() - 1);
            	
            	gp.drawP.setInvincible(true);
            }
        }
        
        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(this.isCollisionOn() == false){
            switch(direction){
                case "up": this.setWorldY(this.getWorldY() - this.sinhVat.getSpeed()); break;
                case "down": this.setWorldY(this.getWorldY() + this.sinhVat.getSpeed()); break;
                case "left": this.setWorldX(this.getWorldX() - this.sinhVat.getSpeed()); break;
                case "right": this.setWorldX(this.getWorldX() + this.sinhVat.getSpeed()); break; 
            }
        }

        spriteCounter++;
        if(spriteCounter > 12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum ==2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }
        
        // thoi gian hoi phuc mot lan la 1 giay
        if (this.thoiGianHoiPhuc >= 60) {
//        	if (this.sinhVat instanceof Dragon) {         // debug mp sinh vat
//        		System.out.println(this.sinhVat.getMp());
//        	}
        	this.sinhVat.recuperateMP();
        	this.thoiGianHoiPhuc = 0;
        }else this.thoiGianHoiPhuc++;
    }
    
    public void draw(Graphics2D g2){
        
        BufferedImage image = null;
        int screenX =  this.getWorldX() - gp.drawP.getWorldX()  + gp.drawP.getScreenX();
        int screenY =  this.getWorldY() - gp.drawP.getWorldY()  + gp.drawP.getScreenY();

        if(this.getWorldX() + gp.tileSize> gp.drawP.getWorldX() - gp.drawP.getScreenX() &&
        		this.getWorldX() - gp.tileSize< gp.drawP.getWorldX() + gp.drawP.getScreenX() &&
        		this.getWorldY() + gp.tileSize> gp.drawP.getWorldY() - gp.drawP.getScreenY() &&
        		this.getWorldY() - gp.tileSize< gp.drawP.getWorldY() + gp.drawP.getScreenY()){
            
            switch (direction) {
            case "up":
                if(spriteNum == 1){ image = up1; }
                if(spriteNum == 2){ image = up2; }
                break;
            case "down":
                if(spriteNum == 1){ image = down1; }
                if(spriteNum == 2){ image = down2; }
                break;
            case "left":
                if(spriteNum == 1){ image = left1; }
                if(spriteNum == 2){ image = left2; }
                break;
            case "right":
                if(spriteNum == 1){ image = right1; }
                if(spriteNum == 2){ image = right2; }
                break;
            }
            
            // Monster Hp bar
            if(this.sinhVat.getType() == 2 && hpBarOn == true){
                double oneScale = (double) this.getSolidArea().width/this.sinhVat.getMaxLife();
                double hpBarValue = oneScale*this.sinhVat.getLife();
                
                g2.setColor(new Color(35, 35, 35));
                g2.drawRect(screenX - 1 + this.getSolidArea().x , screenY - 16, this.getSolidArea().width+2, 12);
                g2.setColor(new Color(255, 0, 30));
                g2.fillRect(screenX + this.getSolidArea().x, screenY - 15, (int) hpBarValue, 10);
             
                hpBarCounter++;
                if(hpBarCounter > 600){
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }
            
            if(invincible == true){
                hpBarCounter = 0;
                hpBarOn = true;
                changeAlpha(g2, 0.4f);
            }
            
            if(dying == true){
                dyingAnimation(g2);
            }
            
            //g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize, null);
            g2.drawImage(image, screenX, screenY, null);
            changeAlpha(g2, 1f);
            
            // Reset alpha
            
            if(gp.keyH.drawSolidArea == true){
                g2.setColor(Color.red);
                g2.drawRect(screenX + getSolidArea().x, screenY + getSolidArea().y, getSolidArea().width, getSolidArea().height);
            }
        }
        
    }
    
    public void dyingAnimation(Graphics2D g2){
        
        dyingCounter++;
        
        int i = 5 ; 
        
        if(dyingCounter <= i){ changeAlpha(g2, 0f); }
        if(dyingCounter > i   && dyingCounter <= i*2){ changeAlpha(g2, 1f); }
        if(dyingCounter > i*2 && dyingCounter <= i*3){ changeAlpha(g2, 0f); }
        if(dyingCounter > i*3 && dyingCounter <= i*4){ changeAlpha(g2, 1f); }
        if(dyingCounter > i*4 && dyingCounter <= i*5){ changeAlpha(g2, 0f); }
        if(dyingCounter > i*5 && dyingCounter <= i*6){ changeAlpha(g2, 1f); }
        if(dyingCounter > i*6 && dyingCounter <= i*7){ changeAlpha(g2, 0f); }
        if(dyingCounter > i*7 && dyingCounter <= i*8){ changeAlpha(g2, 1f); }
        if(dyingCounter > i*8){
            setExist(false);
        }
    }

    public abstract void getEntityImage();
    
}
