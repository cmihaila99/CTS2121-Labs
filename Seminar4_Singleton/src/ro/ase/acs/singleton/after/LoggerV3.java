package ro.ase.acs.singleton.after;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

public class LoggerV3 {
    public static LoggerV3 instance = null;
    
    static {
        instance = new LoggerV3();
    }
    
    private LoggerV3() {
    }

    public synchronized void log(String message){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("log.txt",true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(String.valueOf(new Date()));
            bufferedWriter.write(" ");
            bufferedWriter.write(message);
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
