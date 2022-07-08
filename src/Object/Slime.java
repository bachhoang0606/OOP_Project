
package Object;

import Graphics.DrawSlime;

public class Slime extends SinhVat{
    
    public Slime() {
    	// SinhVat(String name, int maxLife, int maxMp, int maxDefense, int maxExp, int speed, int type)
    	// maxlife = maxMP = 100
    	// maxDefecse = 50
    	// maxExp = 100
    	// speed = 2
    	// type = 2
		// damfe = 10
        super("Green Slime", 100, 100, 50, 100, 2, 2, 10);
    }

    public void damageReaction(DrawSlime dMon){
        
    	dMon.setActionLockCounter(0);
    	dMon.setDirection(dMon.gp.drawP.getDirection());
    }
}
