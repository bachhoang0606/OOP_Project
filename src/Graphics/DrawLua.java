package Graphics;

import GameSetting.GamePanel;
import Object.Lua;

public class DrawLua extends DrawVatThe{

	private Lua lua;
	
	public DrawLua(GamePanel gp, Lua lua) {
		
		super(gp, lua);
		this.setAnh();
		this.lua = lua;
	}
	
	public Lua getLua() {
		return lua;
	}

	public void setLua(Lua lua) {
		this.lua = lua;
	}
	
	public void setAnh() {
    	setImage(uTool.setup("data/Rong/chay_preview_rev_1.png", gp.tileSize*2, gp.tileSize*2)); 
    }
	
	
}
