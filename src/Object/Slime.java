
package Object;

import Graphics.DrawSlime;

public class Slime extends SinhVat{
    
    public Slime() {
    	// SinhVat(String name, int maxLife, int maxMp, int maxDefense, int maxExp, int speed, int type)
    	// maxlife = maxMP = 100
    	// maxDefecse = 50
    	// maxExp = 40
    	// speed = 2
    	// type = 2
		// damge = 10
        super("Green Slime", 100, 100, 50, 40, 2, 2, 10);
        // Exp nguoi choi nhan duoc khi tieu diet slime 
        setExp(getMaxExp());
    }

    public void damageReaction(DrawSlime dMon){
        
    	dMon.setActionLockCounter(0);
    	dMon.setDirection(dMon.gp.drawP.getDirection());
    }
}
