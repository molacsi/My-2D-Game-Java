package object;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject{
	
	public OBJ_Chest() {
		
		name = "Chest";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Prop/T_Chest.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		// change to change size of interaction/collision area
		solidArea.setBounds(0, 0, 48, 48);
		collision = true;
	}
	
}
