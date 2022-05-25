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
public class OBJ_Kunai extends StaticObject{
 
    private int distance;
    private int startAttackX;
    private int startAttackY;

    public int getStartAttackX() {
        return startAttackX;
    }

    public void setStartAttackX(int startAttackX) {
        this.startAttackX = startAttackX;
    }

    public int getStartAttackY() {
        return startAttackY;
    }

    public void setStartAttackY(int startAttackY) {
        this.startAttackY = startAttackY;
    }
    
    public OBJ_Kunai(GamePanel gp) {

        super(gp, "Kunai", false, 1);
        setImage(getuTool().setup("C:/Users/HOANG XUAN BACH/Documents/NetBeansProjects/TutorialGameProject/data/Object/kunai.png", gp.tileSize/2, gp.tileSize/2));
        distance = gp.tileSize*5;
    }
    
    public void update(){
        
        int distanceX = Math.abs(startAttackX - getWorldX());
        int distanceY = Math.abs(startAttackY - getWorldY());
        if(Math.max(distanceX, distanceY) < distance){
            
            setCollisionOn(false);
            
            getGp().cChecker.checkTile(this);
            getGp().cChecker.checkEntity(this, getGp().npc);
            
            int indexMonster =  getGp().cChecker.checkEntity(this, getGp().monster);
            inflictDamage(indexMonster);
                        
            getGp().cChecker.checkObject(this, false);
            
            System.out.println(isCollisionOn());
            
            if(isCollisionOn() == false){
                switch(getDirection()){
                case "up": setWorldY(getWorldY()-this.getSpeed()); break;
                case "down": setWorldY(getWorldY()+this.getSpeed()); break;
                case "left": setWorldX(getWorldX()-this.getSpeed()); break;
                case "right": setWorldX(getWorldX()+this.getSpeed()); break;
                }
            }else setDisappearing(true);
        }
        else {
            setDisappearing(true);
        }
    }
    
    public void inflictDamage(int i){
        
        if(i != 999){
            if(getGp().monster[i].isInvincible() == false){
            
                getGp().playSE(6);
                getGp().monster[i].setLife(getGp().monster[i].getLife()-1);
                getGp().monster[i].damageReaction();
                getGp().monster[i].setInvincible(true);

                if(getGp().monster[i].getLife() <= 0){

                    getGp().monster[i].setDying(true);
                }
            }
        }
    }
}
