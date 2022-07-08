/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author HOANG XUAN BACH
 */
public class SinhVat extends VatThe{
    
    
    // CHARATER STATUS
    private int maxLife;
    private int life;

    public SinhVat(String name, int maxLife, int speed, int type) {
    	super(name, true, speed, type);
        this.maxLife = maxLife;
        this.life = this.maxLife;
    }
    
    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    
    
       
    public void damageReaction(){}
    
    
    
}
