/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import gameSetting.GamePanel;

/**
 *
 * @author HOANG XUAN BACH
 */
public class OBJ_Key extends StaticObject{

    
    public OBJ_Key(GamePanel gp) {
        super(gp, "Key", false, 1);
        setImage(getuTool().setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Object/key.png", gp.tileSize, gp.tileSize));
    }
    
    
}
