package Graphics;

import GameSetting.GamePanel;
import Object.Tile;

public class DrawTile extends DrawTinhVat{
	Tile tile;
	public DrawTile(GamePanel gp, Tile tile) {
        super(gp, tile);
        this.tile = tile; 
    }
}
