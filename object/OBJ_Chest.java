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
public class OBJ_Chest extends StaticObject{
        
    public OBJ_Chest(GamePanel gp) {
        super(gp, "Chest", false, 1);
        BufferedImage down1 = getuTool().setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Object/chest.png", gp.tileSize, gp.tileSize);
        setImage(down1);
    }
}
