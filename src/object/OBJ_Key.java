package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject{
	
	public OBJ_Key() {
		
		name = "Key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Prop/Key.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		solidArea.setBounds(0, 0, 10,10);
		collision = true;
	}

}
