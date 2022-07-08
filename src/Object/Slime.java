
package Object;

import java.util.Random;

import Graphics.DrawSinhVat;
import Graphics.DrawVatThe;

public class Slime extends SinhVat{
    
    public Slime() {
    	
        // Exp nguoi choi nhan duoc khi tieu diet slime 
    	// SinhVat(String name, int maxLife, int maxMp, int maxDefense, int maxExp, int speed, int type)
    	// maxlife = maxMP = 100
    	// maxDefecse = 50
    	// maxExp = 40
    	// speed = 2
    	// type = 2
		// damge = 10
        super("Green Slime", 100, 100, 50, 40, 2, 2, 10);
        setExp(getMaxExp());
    }

	@Override
	public void damageReaction(DrawSinhVat DSinhVat, DrawVatThe vatGayDamge) {
		// TODO Auto-generated method stub
		DSinhVat.setActionLockCounter(0);
		DSinhVat.setDirection(vatGayDamge.getDirection());
	}

	@Override
	public void setAction(DrawSinhVat dSinhVat){
        
		dSinhVat.setActionLockCounter(dSinhVat.getActionLockCounter()+1);
        
        if(dSinhVat.getActionLockCounter() == 120){
            
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25){ dSinhVat.setDirection("up"); }
            else if(i > 25 && i <= 50){ dSinhVat.setDirection("down"); }
            else if(i > 50 && i <= 75){ dSinhVat.setDirection("left"); }
            else if(i > 75 && i <= 100){ dSinhVat.setDirection("right"); }
            
            dSinhVat.setActionLockCounter(0);
        }
    }
}
