package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Bush extends SuperObject{
	
	public OBJ_Bush() {
		
		name = "Bush";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Tree/Tree4.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		// change to change size of interaction/collision area
		solidArea.setBounds(0, 0, 48, 24);
		collision = true;
	}

}