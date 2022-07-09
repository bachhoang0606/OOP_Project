package Object;

import Graphics.DrawLua;

public class Lua extends VatThe{

	private final int damge = 10;
	
	public Lua() {
    	// lat nho set lai speed bang speed dragon
        super("lua", false, 0, 1);
        
    }

	public int getDamge() {
		return damge;
	}

	public void thieuDot(DrawLua dLua) {
		
		// nheu nhan vat bat tu thi bo qua
		if (dLua.getGp().drawP.isInvincible() == false) {
			
			// am thanh trung dich
			dLua.getGp().playSE(6);
			
			// neu giap lon hon damge thi st la 1
			int damgeNhan = this.damge - dLua.getGp().drawP.getPlayer().getDefense();
			if (damgeNhan > 0) {
				dLua.getGp().drawP.getPlayer().setLife(dLua.getGp().drawP.getPlayer().getLife() - damgeNhan);
			}else dLua.getGp().drawP.getPlayer().setLife(dLua.getGp().drawP.getPlayer().getLife() - 1);
			
			dLua.getGp().drawP.setInvincible(true);
		}
	}
}
