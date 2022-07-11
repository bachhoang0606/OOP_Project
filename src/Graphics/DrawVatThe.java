package Graphics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GameSetting.GamePanel;
import GameSetting.UtilityTool;
import Object.VatThe;

public class DrawVatThe {
	
	public GamePanel gp;
	public UtilityTool uTool;
	
	private VatThe vatThe;

	// Image
    private BufferedImage image, image2, image3, image4;

    // COUNTER
    private int disappearCounter;

    private boolean collisionOn;
    private boolean drawSolidArea;

    public DrawVatThe(GamePanel gp, VatThe vatThe) {
    	
		this.gp = gp;
		this.vatThe = vatThe;
		
		this.collisionOn = false;
		this.drawSolidArea = false;
		
		
		this.disappearCounter = 0;
		
		this.uTool = new UtilityTool();
		
		
		this.vatThe.setSolidArea(new Rectangle(0, 0, gp.tileSize, gp.tileSize));

	}

	public GamePanel getGp() {
		return gp;
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
            
        this.getVatThe().setExist(false);
        }
    }
	
    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }
    
    public void draw(Graphics2D g2){

        BufferedImage image = getImage();
        
        int screenX =  this.vatThe.getWorldX() - gp.drawP.getVatThe().getWorldX()  + gp.drawP.getScreenX();
        int screenY =  this.vatThe.getWorldY() - gp.drawP.getVatThe().getWorldY()  + gp.drawP.getScreenY();

        if(this.vatThe.getWorldX() + gp.tileSize> gp.drawP.getVatThe().getWorldX() - gp.drawP.getScreenX() &&
        		this.vatThe.getWorldX() - gp.tileSize< gp.drawP.getVatThe().getWorldX() + gp.drawP.getScreenX() &&
        		this.vatThe.getWorldY() + gp.tileSize> gp.drawP.getVatThe().getWorldY() - gp.drawP.getScreenY() &&
        		this.vatThe.getWorldY() - gp.tileSize< gp.drawP.getVatThe().getWorldY() + gp.drawP.getScreenY()){
            
            
            if(this.getVatThe().isDisappearing() == true){
                
                disappearAnimation(g2);
            }
            // co ve hop ly hon
            g2.drawImage(image, screenX, screenY, null);
            //g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            changeAlpha(g2, 1f);
            
            if(gp.keyH.drawSolidArea == true){

                g2.setColor(Color.red);
                g2.drawRect(
                		screenX + this.getVatThe().getSolidArea().x, 
                		screenY + this.getVatThe().getSolidArea().y, 
                		this.getVatThe().getSolidArea().width, 
                		this.getVatThe().getSolidArea().height
                		);
            }
        }
    }
}
