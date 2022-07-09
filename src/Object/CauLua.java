package Object;


import Graphics.DrawCauLua;
import Graphics.DrawLua;

public class CauLua extends VatThe{
    	
	private final int mp = 30;
	private int distanceExists;
	private Lua lua;
	
    public CauLua() {
    	// lat nho set lai speed bang speed dragon
        super("caulua", false, 0, 1);
        this.distanceExists = 48*5;
    }

	public int getMp() {
		return mp;
	}

	public int getDistanceExists() {
		return distanceExists;
	}

	public void setDistanceExists(int distanceExists) {
		this.distanceExists = distanceExists;
	}
	
	public Lua getLua() {
		return lua;
	}

	public void setLua(Lua lua) {
		this.lua = lua;
	}

	public void gayChayKhuVuc(DrawCauLua dCauLua) {

		dCauLua.setdLua(new DrawLua(dCauLua.getGp(), new Lua()));
		
		// toa do cua ngon lua
		int x = dCauLua.getWorldX() - dCauLua.getGp().tileSize/2;
		int y = dCauLua.getWorldY() - dCauLua.getGp().tileSize/2;
		int doRong = dCauLua.getGp().tileSize*2;    

		
		// khu vuc gay chay
		dCauLua.getdLua().setWorldX(x);
		dCauLua.getdLua().setWorldY(y);
		dCauLua.getdLua().setSolidAreaDefaultX(0);
		dCauLua.getdLua().setSolidAreaDefaultY(0);
		dCauLua.getdLua().getSolidArea().x = 0;
		dCauLua.getdLua().getSolidArea().y = 0;
		dCauLua.getdLua().getSolidArea().width = doRong;
		dCauLua.getdLua().getSolidArea().height = doRong;	
		dCauLua.getdLua().setDirection(dCauLua.getDirection());
	}
}
