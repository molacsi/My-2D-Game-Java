/*
 * These lines of code contain images for the main character (getPlayerImage). 
 * Through the use of a spriteCounter, the images(spriteNum) change in sequence to produce an animation.
 * Additionally, this code sets default/starting player position and speed.
 * The players position and direction are changed via the update method.
 * The displayed character sprite is changed through the use of nested if blocks.
 */

package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.keyHandler;

public class Player extends Entity{

	GamePanel gp;
	keyHandler keyH;
	public final int screenX, screenY;
	int hasKey = 0;
	
	
	public Player(GamePanel gp, keyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4; 
		direction = "r_idle";
	}
	
	// Below are the image files for the walking animation
	public void getPlayerImage() {
		
		try {
			
			up0 = ImageIO.read(getClass().getResourceAsStream("/Player/U_Run/U_Run0.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/Player/U_Run/U_Run1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/Player/U_Run/U_Run2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/Player/U_Run/U_Run3.png"));
			
			down0 = ImageIO.read(getClass().getResourceAsStream("/Player/D_Run/D_Run0.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/Player/D_Run/D_Run1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/Player/D_Run/D_Run2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/Player/D_Run/D_Run3.png"));
			
			left0 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Run/L_Run0.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Run/L_Run1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Run/L_Run2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Run/L_Run3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Run/L_Run4.png"));
			left5 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Run/L_Run5.png"));
			left6 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Run/L_Run6.png"));
			left7 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Run/L_Run7.png"));
			
			right0 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Run/R_Run0.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Run/R_Run1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Run/R_Run2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Run/R_Run3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Run/R_Run4.png"));
			right5 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Run/R_Run5.png"));
			right6 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Run/R_Run6.png"));
			right7 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Run/R_Run7.png"));
			
			r_idle0 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Idle/r_idle0.png"));
			r_idle1 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Idle/r_idle1.png"));
			r_idle2 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Idle/r_idle2.png"));
			r_idle3 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Idle/r_idle3.png"));
			r_idle4 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Idle/r_idle4.png"));
			r_idle5 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Idle/r_idle5.png"));
			r_idle6 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Idle/r_idle6.png"));
			r_idle7 = ImageIO.read(getClass().getResourceAsStream("/Player/R_Idle/r_idle7.png"));
			
			l_idle0 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Idle/l_idle0.png"));
			l_idle1 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Idle/l_idle1.png"));
			l_idle2 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Idle/l_idle2.png"));
			l_idle3 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Idle/l_idle3.png"));
			l_idle4 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Idle/l_idle4.png"));
			l_idle5 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Idle/l_idle5.png"));
			l_idle6 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Idle/l_idle6.png"));
			l_idle7 = ImageIO.read(getClass().getResourceAsStream("/Player/L_Idle/l_idle7.png"));
			
			u_idle0 = ImageIO.read(getClass().getResourceAsStream("/Player/U_Idle/U_idle0.png"));
			d_idle0 = ImageIO.read(getClass().getResourceAsStream("/Player/D_Idle/D_Idle0.png"));
			
		}catch(IOException e) {
		
		e.printStackTrace();
		
		}
	}
	public void update() {
		
			if (keyH.upPressed == true) {
				direction = "up";
			
			}
			if(keyH.downPressed == true) {
				direction = "down";
				
			}
			if(keyH.leftPressed == true) {
				direction = "left";
				
			}
			if(keyH.rightPressed == true) {
				direction = "right";
				
			}
			if(keyH.rightPressed == true && keyH.leftPressed == true) {
				direction = "r_idle";
			}
			if(keyH.upPressed == true && keyH.downPressed == true) {
				direction = "u_idle";
			}
			if(keyH.upPressed == true && keyH.rightPressed == true) {
				direction = "ur_diagonal";
			}
			if(keyH.downPressed == true && keyH.rightPressed == true) {
				direction = "dr_diagonal";
			}
			if(keyH.upPressed == true && keyH.leftPressed == true) {
				direction = "ul_diagonal";
			}
			if(keyH.downPressed == true && keyH.leftPressed == true) {
				direction = "dl_diagonal";
			}
			if(keyH.keyPressed == false && keyH.upPressed == false && keyH.downPressed == false && keyH.leftPressed == false && keyH.rightPressed == false && keyH.wLastPressed == false) {
				direction = "u_idle";
			}
			if(keyH.keyPressed == false && keyH.downPressed == false && keyH.upPressed == false && keyH.leftPressed == false && keyH.rightPressed == false && keyH.sLastPressed == false) {
				direction = "d_idle";
			}
			if(keyH.keyPressed == false && keyH.leftPressed == false && keyH.downPressed == false && keyH.upPressed == false && keyH.rightPressed == false && keyH.aLastPressed == false) {
				direction = "l_idle";
			}
			if(keyH.keyPressed == false && keyH.rightPressed == false && keyH.downPressed == false && keyH.leftPressed == false && keyH.upPressed == false && keyH.dLastPressed == false) {
				direction = "r_idle";
			}
			
			// Check Tile Collision
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			// Check Object Collision
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			// if Collision = false, player can move
			if (collisionOn == false) {
				
				switch(direction) {
				case "up": worldY -= speed; break;
				case "down": worldY += speed; break;
				case "left": worldX -= speed; break;
				case "right": worldX += speed; break;
				case "ur_diagonal": worldY -= speed; worldX += speed; break;
				case "ul_diagonal": worldY -= speed; worldX -= speed; break;
				case "dr_diagonal": worldY += speed; worldX += speed; break;
				case "dl_diagonal": worldY += speed; worldX -= speed; break;
				}
			}
			
			spriteCounter++; 
			if (spriteCounter > 8) {
				if (spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 3;		
					}
				else if(spriteNum == 3) {
					spriteNum = 4;
				}
				else if(spriteNum == 4) {
					spriteNum = 5;
				}
				else if(spriteNum == 5) {
					spriteNum = 6;
				}
				else if(spriteNum == 6) {
						spriteNum = 7;
						
				}
				else if(spriteNum == 7) {
					spriteNum = 8;
				}
				else if(spriteNum == 8) {
					spriteNum = 1;
				}
				spriteCounter = 1;
				}
	}
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			switch(objectName){
			case "Key":
				gp.playSe(1); //use this to add sound effects, change the number to change which is used based on sound class array
				hasKey++;
				gp.obj[i] = null;
				break;
//			case "Door":
//				if(hasKey > 0) {
//					gp.obj[i] = null; // this makes object disappear, not ideal for this item // find solution to replaces it with image of open door 
//					hasKey--;
//				}
//				break;
//			case "Boots":
//				speed += 1; // this makes player faster when they have the item
//				gp.obj[i] = null;
//				break;
			}
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up": 
			if(spriteNum == 1) {
				image = up0;
			}
			if(spriteNum == 2) {
				image = up1;
			}
			if(spriteNum == 3) {
				image = up2;
			}
			if(spriteNum == 4) {
				image = up3;
			}
			if(spriteNum == 5) {
				image = up0;
			}
			if(spriteNum == 6) {
				image = up1;
			}
			if(spriteNum == 7) {
				image = up2;
			}
			if(spriteNum == 8) {
				image = up3;
			}
			break;
			
		case "down":
		if(spriteNum == 1) {
				image = down0;
		}
			if(spriteNum == 2) {
				image = down1;
			}
			if(spriteNum == 3) {
				image = down2;				
			}
			if(spriteNum == 4) {
				image = down3;
			}
			if(spriteNum == 5) {
				image = down0;
			}
			if(spriteNum == 6) {
				image = down1;
			}
			if(spriteNum == 7) {
				image = down2;
			}
			if(spriteNum == 8) {
				image = down3;
			}
			break;
			
		case "left":
			if(spriteNum == 1) {
				image = left0;				
			}
			if(spriteNum == 2) {
				image = left1;
			}
			if(spriteNum == 3) {
				image = left2;				
			}
			if(spriteNum == 4) {
				image = left3;
			}
			if(spriteNum == 5) {
				image = left4;				
			}
			if(spriteNum == 6) {
				image = left5;
			}
			if(spriteNum == 7) {
				image = left6;				
			}
			if(spriteNum == 8) {
				image = left7;
			}
			break;
			
		case "ul_diagonal":
			if(spriteNum == 1) {
				image = left0;				
			}
			if(spriteNum == 2) {
				image = left1;
			}
			if(spriteNum == 3) {
				image = left2;				
			}
			if(spriteNum == 4) {
				image = left3;
			}
			if(spriteNum == 5) {
				image = left4;				
			}
			if(spriteNum == 6) {
				image = left5;
			}
			if(spriteNum == 7) {
				image = left6;				
			}
			if(spriteNum == 8) {
				image = left7;
			}
			break;
			
		case "dl_diagonal":
			if(spriteNum == 1) {
				image = left0;				
			}
			if(spriteNum == 2) {
				image = left1;
			}
			if(spriteNum == 3) {
				image = left2;				
			}
			if(spriteNum == 4) {
				image = left3;
			}
			if(spriteNum == 5) {
				image = left4;				
			}
			if(spriteNum == 6) {
				image = left5;
			}
			if(spriteNum == 7) {
				image = left6;				
			}
			if(spriteNum == 8) {
				image = left7;
			}
			break;
			
		case "right":
			if(spriteNum == 1) {
				image = right0;				
			}
			if(spriteNum == 2) {
				image = right1;
			}
			if(spriteNum == 3) {
				image = right2;				
			}
			if(spriteNum == 4) {
				image = right3;
			}
			if(spriteNum == 5) {
				image = right4;				
			}
			if(spriteNum == 6) {
				image = right5;
			}
			if(spriteNum == 7) {
				image = right6;				
			}
			if(spriteNum == 8) {
				image = right7;
			}
			break;
			
		case "ur_diagonal":
			if(spriteNum == 1) {
				image = right0;				
			}
			if(spriteNum == 2) {
				image = right1;
			}
			if(spriteNum == 3) {
				image = right2;				
			}
			if(spriteNum == 4) {
				image = right3;
			}
			if(spriteNum == 5) {
				image = right4;				
			}
			if(spriteNum == 6) {
				image = right5;
			}
			if(spriteNum == 7) {
				image = right6;				
			}
			if(spriteNum == 8) {
				image = right7;
			}
			break;
			
		case "dr_diagonal":
			if(spriteNum == 1) {
				image = right0;				
			}
			if(spriteNum == 2) {
				image = right1;
			}
			if(spriteNum == 3) {
				image = right2;				
			}
			if(spriteNum == 4) {
				image = right3;
			}
			if(spriteNum == 5) {
				image = right4;				
			}
			if(spriteNum == 6) {
				image = right5;
			}
			if(spriteNum == 7) {
				image = right6;				
			}
			if(spriteNum == 8) {
				image = right7;
			}
			break;
			
		case "r_idle":
			if(spriteNum == 1) {
				image = r_idle0;				
			}
			if(spriteNum == 2) {
				image = r_idle1;
			}
			if(spriteNum == 3) {
				image = r_idle2;				
			}
			if(spriteNum == 4) {
				image = r_idle3;
			}
			if(spriteNum == 5) {
				image = r_idle4;				
			}
			if(spriteNum == 6) {
				image = r_idle5;
			}
			if(spriteNum == 7) {
				image = r_idle6;				
			}
			if(spriteNum == 8) {
				image = r_idle7;
			}
			break;
			
		case "l_idle":
			if(spriteNum == 1) {
				image = l_idle0;				
			}
			if(spriteNum == 2) {
				image = l_idle1;
			}
			if(spriteNum == 3) {
				image = l_idle2;				
			}
			if(spriteNum == 4) {
				image = l_idle3;
			}
			if(spriteNum == 5) {
				image = l_idle4;				
			}
			if(spriteNum == 6) {
				image = l_idle5;
			}
			if(spriteNum == 7) {
				image = l_idle6;				
			}
			if(spriteNum == 8) {
				image = l_idle7;
			}
			break;
		case "u_idle":
			if(spriteNum == 1) {
				image = u_idle0;				
			}
			if(spriteNum == 2) {
				image = u_idle0;
			}
			if(spriteNum == 3) {
				image = u_idle0;				
			}
			if(spriteNum == 4) {
				image = u_idle0;
			}
			if(spriteNum == 5) {
				image = u_idle0;				
			}
			if(spriteNum == 6) {
				image = u_idle0;
			}
			if(spriteNum == 7) {
				image = u_idle0;				
			}
			if(spriteNum == 8) {
				image = u_idle0;
			}
			break;
	case "d_idle":
		if(spriteNum == 1) {
			image = d_idle0;			
		}
		if(spriteNum == 2) {
			image = d_idle0;
		}
		if(spriteNum == 3) {
			image = d_idle0;			
		}
		if(spriteNum == 4) {
			image = d_idle0;
		}
		if(spriteNum == 5) {
			image = d_idle0;
			
		}
		if(spriteNum == 6) {
			image = d_idle0;
		}
		if(spriteNum == 7) {
			image = d_idle0;			
		}
		if(spriteNum == 8) {
			image = d_idle0;
		}
		break;
	}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}