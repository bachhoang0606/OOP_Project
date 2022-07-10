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

		this.lua = new Lua();
		
		dCauLua.setdLua(new DrawLua(dCauLua.getGp(), this.lua));
		
		// toa do cua ngon lua
		int x = dCauLua.getVatThe().getWorldX() - dCauLua.getGp().tileSize/2;
		int y = dCauLua.getVatThe().getWorldY() - dCauLua.getGp().tileSize/2;
		int doRong = dCauLua.getGp().tileSize*2;    

		
		// khu vuc gay chay
		
		this.getLua().setSolidAreaDefaultX(0);
		this.getLua().setSolidAreaDefaultY(0);
		this.getLua().getSolidArea().x = 0;
		this.getLua().getSolidArea().y = 0;
		this.getLua().getSolidArea().width = doRong;
		this.getLua().getSolidArea().height = doRong;	
		
		this.getLua().setWorldX(x);
		this.getLua().setWorldY(y);
		this.getLua().setDirection(this.getDirection());
	}
}
