package revolution.server;

import java.io.IOException;

public class DeserializeObject {

    public static Object Convert(String fileName){
        fileName = fileName + ".ser";
        Object object = null;
        try {
                object = (User) ConversionUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
        }
        
        return object;
    }

}
