package util.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {

    public Properties properties_reader(String FilePath){
        Properties prop = new Properties();

        try {
            FileReader fileReader =new FileReader(FilePath);
            prop.load(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return prop;
    }

}
