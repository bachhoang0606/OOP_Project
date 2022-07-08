package Graphics;

import java.awt.image.BufferedImage;

import GameSetting.GamePanel;
import Object.VatThe;

public class DrawObject extends DrawTinhVat{
	
	public DrawObject(GamePanel gp, VatThe tinhVat){
		super(gp, tinhVat);
	    BufferedImage image = uTool.setup("data/Object/"+tinhVat.getName()+".png", gp.tileSize, gp.tileSize);
	    setImage(image);
	}
}
