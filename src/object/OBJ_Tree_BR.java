package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Tree_BR extends SuperObject{
	
	public OBJ_Tree_BR() {
		
		name = "Tree_BR";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Tree/Tree3.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		// change the change size of interaction/collision area
		solidArea.setBounds(0, 0, 32, 20);
	
		collision = true;
	}

}