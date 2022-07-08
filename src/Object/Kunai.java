/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;


/**
 *
 * @author HOANG XUAN BACH
 */
public class Kunai extends VatThe{
 
	private int damge;
    
    public Kunai() {
        super("kunai", false, 0, 1);
        this.damge = 20;
    }

	public int getDamge() {
		return damge;
	}

	public void setDamge(int damge) {
		this.damge = damge;
	}
    

}    
    
