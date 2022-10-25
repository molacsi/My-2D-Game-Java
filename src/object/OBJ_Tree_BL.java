package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Tree_BL extends SuperObject{
	
	public OBJ_Tree_BL() {
		
		name = "Tree_BL";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Tree/Tree2.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		// change to change size of interaction/collision area
		solidArea.setBounds(0, 0, 36, 20);
		
		collision = true;
	}

}