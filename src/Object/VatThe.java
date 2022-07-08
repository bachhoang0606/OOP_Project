/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author HOANG XUAN BACH
 */
public class VatThe {
    
    // STATUS
    private String name;
    private int speed;
    private int type; // 0:Player, 1:StaticObject, 2:Monster, 3:NPC
    private boolean collision;

	public VatThe(String name, boolean collision, int speed, int type) {
		this.name = name;
		this.speed = speed;
		this.type = type;
		this.collision = collision;
	}

	public boolean isCollision() {
		return collision;
	}

	public void setCollision(boolean collision) {
		this.collision = collision;
	}

	public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
   
}
