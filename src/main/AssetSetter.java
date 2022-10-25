package main;

import object.OBJ_Bush;
import object.OBJ_Chest;
import object.OBJ_Key;
import object.OBJ_Tree_BL;
import object.OBJ_Tree_BR;
import object.OBJ_Tree_TL;
import object.OBJ_Tree_TR;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_Key(); 
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Chest(); 
		gp.obj[1].worldX = 23 * gp.tileSize;
		gp.obj[1].worldY = 9 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Tree_TL(); 
		gp.obj[2].worldX = 23 * gp.tileSize;
		gp.obj[2].worldY = 14 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Tree_TR(); 
		gp.obj[3].worldX = 24 * gp.tileSize;
		gp.obj[3].worldY = 14 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Tree_BL(); 
		gp.obj[4].worldX = 23 * gp.tileSize;
		gp.obj[4].worldY = 15 * gp.tileSize;

		gp.obj[5] = new OBJ_Tree_BR(); 
		gp.obj[5].worldX = 24 * gp.tileSize;
		gp.obj[5].worldY = 15 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Bush(); 
		gp.obj[6].worldX = 29 * gp.tileSize;
		gp.obj[6].worldY = 15 * gp.tileSize;
		
	}
}
