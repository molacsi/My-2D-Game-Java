package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	
	public int worldX,worldY,speed;

	public BufferedImage up0, up1, up2, up3,up4;
	public BufferedImage down0, down1, down2, down3;
	public BufferedImage left0, left1, left2, left3,left4,left5,left6,left7;
	public BufferedImage right0, right1, right2, right3,right4,right5,right6,right7;
	public BufferedImage u_idle0;
	public BufferedImage d_idle0;
	public BufferedImage l_idle0, l_idle1, l_idle2, l_idle3,l_idle4,l_idle5,l_idle6,l_idle7;
	public BufferedImage r_idle0, r_idle1, r_idle2, r_idle3,r_idle4,r_idle5,r_idle6,r_idle7;
	
	
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
}
