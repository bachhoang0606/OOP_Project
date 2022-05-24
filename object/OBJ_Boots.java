/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import gameSetting.GamePanel;
import java.awt.image.BufferedImage;

/**
 *
 * @author HOANG XUAN BACH
 */
public class OBJ_Boots extends StaticObject{
        
    public OBJ_Boots(GamePanel gp) {
        super(gp, "Boots", false, 1);
        BufferedImage image = getuTool().setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Object/boots.png", gp.tileSize, gp.tileSize);
        setImage(image);
    }
}
