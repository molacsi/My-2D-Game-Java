package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Tree_TR extends SuperObject{
	
	public OBJ_Tree_TR() {
		
		name = "Tree_TR";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Tree/Tree1.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		// change to change size of interaction/collision area
		solidArea.setBounds(0, 0, 32, 40);
	
		collision = true;
	}

}