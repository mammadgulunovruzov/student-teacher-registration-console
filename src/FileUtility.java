import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtility {
    public static void writeObjectToFile(Object obj, String fileName) {
        try{

            FileOutputStream fileOutputStream =  new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream =  new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(obj);
        }catch (Exception  e){
            throw new RuntimeException(e);
        }

    }

    public static Object readObjectFromFile(String fileName) {
        try{

            FileInputStream fileInputStream =  new FileInputStream(fileName);
            ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);

            return objectInputStream.readObject();
        }catch (Exception  e){
            throw new RuntimeException(e);
        }
    }
}
