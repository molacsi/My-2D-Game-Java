package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	
	public Tile [] tile;
	
	public int[][] mapTileNum;
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[500];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadmap("/maps/world.txt"); // change this to change map
	}
	
	public void getTileImage() {
		
		try {
			
			//Tiles 0 - 11 are grass and flower tiles
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass0.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass1.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass2.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass3.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass4.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass5.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass6.png"));
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass7.png"));
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass8.png"));
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass9.png"));
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass10.png"));
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass11.png"));
			
			//Tiles 12 - 16 are Grass and stone path tiles
			
			// all sides
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass12.png"));
			
			// 2 right
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass13.png"));
			
			// 2 left
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass14.png"));
			
			// 2 bottom
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass15.png"));
			
			// 2 top
			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Exterior Ground/Grass16.png"));
			
			
			
			
			// Tiles 65 is water tile
			tile[65] = new Tile();
			tile[65].image = ImageIO.read(getClass().getResourceAsStream("/Water/Water0.png"));
			tile[65].collision = true; // add this to include collision
			
			
			
			
			
			
			
			
			
		} catch(IOException e) {
		e.printStackTrace();

		}
	}
	public void loadmap(String filePath) {
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while (col < gp.maxWorldCol &&  row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col  < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
					
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			
		}
		
	}

	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
		
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
			   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
			   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
				
			}
			
		worldCol++;
		
		if(worldCol == gp.maxWorldCol) {
			worldCol = 0;
			worldRow++;
			}
		}
	}	
}