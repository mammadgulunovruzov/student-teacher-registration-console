import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileUtility {
    public static void writeObjectToFile(Object obj, String fileName) throws  Exception{
        FileOutputStream fileOutputStream =  new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream =  new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);

    }
}
