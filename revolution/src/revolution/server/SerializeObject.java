package revolution.server;

import java.io.IOException;

public class SerializeObject {

	public static void Convert(Object object, String fileName) {
		fileName = fileName + ".ser";
                
		//serialize to file
		try {
			ConversionUtil.serialize(object, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}


}
