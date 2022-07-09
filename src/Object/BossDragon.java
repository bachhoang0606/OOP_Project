package Object;


import Graphics.DrawBossDragon;
import Graphics.DrawDragon;

public class BossDragon extends Dragon{
	
	public BossDragon(int toaDoToX, int toaDoToY) {
		super(toaDoToX, toaDoToY);
		// TODO Auto-generated constructor stub
		
		this.setMaxParameter(
				(int) (this.getMaxLife()*1.5), 
				(int) (this.getMaxMp()*1.5), 
				(int) (this.getMaxDefense()*1.5), 
				(int) (this.getMaxExp()*1.5)
				);
		
		
		this.setName("Boss Dragon");
		this.setLife(200);
		this.setMaxLife(200);
		//this.setLife(this.getMaxLife());
		this.setMp(this.getMp());
		this.setDefense((int) (this.getDefense()*1.5));
		this.setExp(this.getMaxExp());
	}

	public void trieuHoi(DrawBossDragon dBossDragon) {
		
		// sau 3 giay trieu hoi 1 con rong
		if(dBossDragon.getThoiGianTrieuHoi() >= 10*60) {
			if (dBossDragon.getBossDragon().isAttack() == true) {
				dBossDragon.setThoiGianTrieuHoi(0);

				//list.add(newDragon);
				for (int i = 0; i < 20; i++) {
					if (dBossDragon.getGp().drawM[i] == null) {
						Dragon newDragon = new Dragon(40*dBossDragon.getGp().tileSize, 9*dBossDragon.getGp().tileSize);
						DrawDragon newDrawDragon = new DrawDragon(dBossDragon.getGp(), newDragon);
						newDrawDragon.setWorldX(dBossDragon.getWorldX());
						newDrawDragon.setWorldY(dBossDragon.getWorldY());
						newDragon.setAttack(true);
						dBossDragon.getGp().drawM[i] = newDrawDragon;
						break;
					}
				}
			}
		}else dBossDragon.setThoiGianTrieuHoi(dBossDragon.getThoiGianTrieuHoi()+1);
		
	}
}
