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
public class OBJ_Heart extends StaticObject{
    
    public OBJ_Heart(GamePanel gp) {
        
        super(gp, "Heart", false, 1);
     
        BufferedImage image = getuTool().setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Object/heart_full.png", gp.tileSize, gp.tileSize);
        setImage(image);
        image = getuTool().setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Object/heart_half.png", gp.tileSize, gp.tileSize);
        setImage2(image);
        image= getuTool().setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Object/heart_blank.png", gp.tileSize, gp.tileSize);
        setImage3(image);
    }
}
