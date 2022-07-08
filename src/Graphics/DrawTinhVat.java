package Graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GameSetting.GamePanel;
import GameSetting.UtilityTool;
import Object.VatThe;

public class DrawTinhVat extends DrawVatThe{
	public UtilityTool uTool;
	private VatThe tinhVat;

	public UtilityTool getuTool() {
		return uTool;
	}

	public void setuTool(UtilityTool uTool) {
		this.uTool = uTool;
	}

	public VatThe getTinhVat() {
		return tinhVat;
	}

	public void setTinhVat(VatThe tinhVat) {
		this.tinhVat = tinhVat;
	}

	public DrawTinhVat(GamePanel gp,VatThe tinhVat ,int worldX, int worldY) {
		super(gp, tinhVat);
        this.tinhVat = tinhVat;
        this.setWorldX(worldX);
        this.setWorldX(worldY);
        setSolidArea(new Rectangle(0, 0, gp.tileSize, gp.tileSize));
        this.uTool = new UtilityTool();
    }

	public DrawTinhVat(GamePanel gp, VatThe tinhVat) {
		super(gp, tinhVat);
        this.tinhVat = tinhVat;
        setSolidArea(new Rectangle(0, 0, gp.tileSize, gp.tileSize)); 
        this.uTool = new UtilityTool();
    }
	
	public void draw(Graphics2D g2){

        BufferedImage image = getImage();
        
        int screenX =  this.getWorldX() - gp.drawP.getWorldX()  + gp.drawP.getScreenX();
        int screenY =  this.getWorldY() - gp.drawP.getWorldY()  + gp.drawP.getScreenY();

        if(this.getWorldX() + gp.tileSize> gp.drawP.getWorldX() - gp.drawP.getScreenX() &&
        		this.getWorldX() - gp.tileSize< gp.drawP.getWorldX() + gp.drawP.getScreenX() &&
        		this.getWorldY() + gp.tileSize> gp.drawP.getWorldY() - gp.drawP.getScreenY() &&
        		this.getWorldY() - gp.tileSize< gp.drawP.getWorldY() + gp.drawP.getScreenY()){
            
            
            if(isDisappearing() == true){
                
                disappearAnimation(g2);
            }
            
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            changeAlpha(g2, 1f);
            
            if(gp.keyH.drawSolidArea == true){
                g2.setColor(Color.red);
                g2.drawRect(screenX + getSolidArea().x, screenY + getSolidArea().y, getSolidArea().width, getSolidArea().height);
            }
        }
    }
}
