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
    private int life;
    private int mp;
    private int defense;
    private int exp;
    private int damge;
    // kha nang hoi phuc
    private int healingAbility;
    
    // Max parameter
    private int maxLife;
    private int maxMp;
    private int maxDefense;
    private int maxExp;
    
    
    public SinhVat(String name, int maxLife, int maxMp, int maxDefense, int maxExp, int speed, int type, int damge) {
    	super(name, true, speed, type);
    	this.setMaxParameter(maxLife, maxMp, maxDefense, maxExp);
    	this.life = maxLife;
    	this.mp = maxMp;
    	this.damge = damge;

    	this.defense = 0;
    	this.exp = 0;
    	this.healingAbility = 5;
    }

    public void setMaxParameter(int maxLife, int maxMp, int maxDefense, int maxExp) {
    	this.maxLife = maxLife;
    	this.maxMp = maxMp;
    	this.maxDefense = maxDefense;
    	this.maxExp = maxExp;
    }

    
    
    public int getHealingAbility() {
		return healingAbility;
	}

	public void setHealingAbility(int healingAbility) {
		this.healingAbility = healingAbility;
	}

	public int getDamge() {
		return damge;
	}

	public void setDamge(int damge) {
		this.damge = damge;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public int getMaxDefense() {
		return maxDefense;
	}

	public void setMaxDefense(int maxDefense) {
		this.maxDefense = maxDefense;
	}

	public int getMaxExp() {
		return maxExp;
	}

	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
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

    
    // co che hoi phuc the luc trong game
    public void recuperateMP() {
    	
    	if (this.mp + this.healingAbility <= this.maxMp) {
    		this.mp = this.mp + this.healingAbility;
    	}else {
    		this.mp = this.maxMp;
    	}
    	
    }
    
    public void damageReaction(){}

}
