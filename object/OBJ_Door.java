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
public class OBJ_Door extends StaticObject{
        
    public OBJ_Door(GamePanel gp) {
        super(gp, "Door", true, 1);
        BufferedImage image = getuTool().setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Object/door.png", gp.tileSize, gp.tileSize);
        setImage(image);
        getSolidArea().x = 0;
        getSolidArea().y = 16;
        getSolidArea().width = 48;
        getSolidArea().height = 32;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);    
    } 
}
