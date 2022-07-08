
package Object;

import Graphics.DrawSlime;

public class GreenSlime extends SinhVat{
    
    public GreenSlime() {

        super("Green Slime", 8, 1, 2);
    }

    public void damageReaction(DrawSlime dMon){
        
    	dMon.setActionLockCounter(0);
    	dMon.setDirection(dMon.gp.drawP.getDirection());
    }
}
