package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Tree_TL extends SuperObject{
	
	public OBJ_Tree_TL() {
		
		name = "Tree_TL";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Tree/Tree0.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		// change to change size of interaction/collision area
		solidArea.setBounds(20, 0, 42 , 40);
		
		collision = true;
	}

}