import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileEventLogger implements EventLogger{


    private  String fileName;
    private File file;


    public  FileEventLogger(String fileName){
        this.fileName = fileName;
    }

    private   void init() throws IOException{
        this.file = new File(fileName);
        if(!file.canWrite()){
            throw new IOException("Unable to write in file " + fileName);
        }
    }
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, "\r\n" + event.toString() ,true);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
