/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.awt.Rectangle;

/**
 *
 * @author HOANG XUAN BACH
 */
public abstract class VatThe {
    
    // STATUS
    private String name;
    private int speed;
    private int type; // 0:Player, 1:StaticObject, 2:Monster, 3:NPC
    private boolean collision;

    // Rectangle
    private Rectangle solidArea;
    private int solidAreaDefaultX, solidAreaDefaultY;
    
    // toa do tren map
    private int worldX, worldY;
    
    // STATE
    
    //hướng nhân vật
    private String direction;
    private boolean exist;
    
    
    // dang bien mat
    private boolean disappearing;
    
	public VatThe(String name, boolean collision, int speed, int type) {
		this.name = name;
		this.speed = speed;
		this.type = type;
		this.collision = collision;
		
		this.direction = null;
		
		this.exist = true;
		this.disappearing = false;
		
	}
	
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public boolean isExist() {
		return exist;
	}

	public Rectangle getSolidArea() {
		return solidArea;
	}

	public void setSolidArea(Rectangle solidArea) {
		this.solidArea = solidArea;
	}

	public int getSolidAreaDefaultX() {
		return solidAreaDefaultX;
	}

	public void setSolidAreaDefaultX(int solidAreaDefaultX) {
		this.solidAreaDefaultX = solidAreaDefaultX;
	}

	public int getSolidAreaDefaultY() {
		return solidAreaDefaultY;
	}

	public void setSolidAreaDefaultY(int solidAreaDefaultY) {
		this.solidAreaDefaultY = solidAreaDefaultY;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public boolean isDisappearing() {
		return disappearing;
	}

	public void setDisappearing(boolean disappearing) {
		this.disappearing = disappearing;
	}

	public int getWorldX() {
		return worldX;
	}

	public void setWorldX(int worldX) {
		this.worldX = worldX;
	}

	public int getWorldY() {
		return worldY;
	}

	public void setWorldY(int worldY) {
		this.worldY = worldY;
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
