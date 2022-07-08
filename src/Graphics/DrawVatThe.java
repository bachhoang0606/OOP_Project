package Graphics;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GameSetting.GamePanel;
import GameSetting.UtilityTool;
import Object.VatThe;

public class DrawVatThe {
	
	public GamePanel gp;
	UtilityTool uTool;
	private VatThe vatThe;
	// toa do tren map
    private int worldX, worldY;

	// Image
    private BufferedImage image, image2, image3, image4;
    
    // Rectangle
    private Rectangle solidArea;
    private int solidAreaDefaultX, solidAreaDefaultY;

    // COUNTER
    private int disappearCounter;
    
    // STATE
    private String direction;
    
    private boolean collisionOn;
    private boolean drawSolidArea;
    private boolean exist;
    private boolean disappearing;

    public DrawVatThe(GamePanel gp, VatThe oObject) {
		this.gp = gp;
		this.vatThe = oObject;
		this.direction = null;
		this.collisionOn = false;
		this.drawSolidArea = false;
		this.exist = true;
		this.disappearing = false;
		
		this.disappearCounter = 0;
	}

	public int getWorldX() {
		return worldX;
	}

	public void setWorldX(int worldX) {
		this.worldX = worldX;
	}

	public int getWorldY() {
		return worldY;
	}

	public void setWorldY(int worldY) {
		this.worldY = worldY;
	}

	public GamePanel getGp() {
		return gp;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setGp(GamePanel gp) {
		this.gp = gp;
	}

	public UtilityTool getuTool() {
		return uTool;
	}

	public void setuTool(UtilityTool uTool) {
		this.uTool = uTool;
	}

	
	public VatThe getVatThe() {
		return vatThe;
	}

	public void setVatThe(VatThe vatThe) {
		this.vatThe = vatThe;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage getImage2() {
		return image2;
	}

	public void setImage2(BufferedImage image2) {
		this.image2 = image2;
	}

	public BufferedImage getImage3() {
		return image3;
	}

	public void setImage3(BufferedImage image3) {
		this.image3 = image3;
	}

	public BufferedImage getImage4() {
		return image4;
	}

	public void setImage4(BufferedImage image4) {
		this.image4 = image4;
	}

	public Rectangle getSolidArea() {
		return solidArea;
	}

	public void setSolidArea(Rectangle solidArea) {
		this.solidArea = solidArea;
	}

	public int getSolidAreaDefaultX() {
		return solidAreaDefaultX;
	}

	public void setSolidAreaDefaultX(int solidAreaDefaultX) {
		this.solidAreaDefaultX = solidAreaDefaultX;
	}

	public int getSolidAreaDefaultY() {
		return solidAreaDefaultY;
	}

	public void setSolidAreaDefaultY(int solidAreaDefaultY) {
		this.solidAreaDefaultY = solidAreaDefaultY;
	}

	public int getDisappearCounter() {
		return disappearCounter;
	}

	public void setDisappearCounter(int disappearCounter) {
		this.disappearCounter = disappearCounter;
	}

	public boolean isCollisionOn() {
		return collisionOn;
	}

	public void setCollisionOn(boolean collisionOn) {
		this.collisionOn = collisionOn;
	}

	public boolean isDrawSolidArea() {
		return drawSolidArea;
	}

	public void setDrawSolidArea(boolean drawSolidArea) {
		this.drawSolidArea = drawSolidArea;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public boolean isDisappearing() {
		return disappearing;
	}

	public void setDisappearing(boolean disappearing) {
		this.disappearing = disappearing;
	}

	public void disappearAnimation(Graphics2D g2) {
        
        disappearCounter++;
        
        int i = 5; 
        
        if(disappearCounter <= i){ changeAlpha(g2, 0f); }
        if(disappearCounter > i   && disappearCounter <= i*2){ changeAlpha(g2, 1f); }
        if(disappearCounter > i*2 && disappearCounter <= i*3){ changeAlpha(g2, 0.8f); }
        if(disappearCounter > i*3 && disappearCounter <= i*4){ changeAlpha(g2, 0.6f); }
        if(disappearCounter > i*4 && disappearCounter <= i*5){ changeAlpha(g2, 0.4f); }
        if(disappearCounter > i*5 && disappearCounter <= i*6){ changeAlpha(g2, 0.2f); }
        if(disappearCounter > i*6){
            
            exist = false;
        }
    }
    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }
    public void draw(Graphics2D g2) {};
}
