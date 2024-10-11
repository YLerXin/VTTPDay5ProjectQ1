package exceptions;

import java.io.*;

public class OpenFile{

    public void OpenFile(String fileName){
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);

        byte[] buff = new byte[1024];

        int readBytes = 0;
        int sendBytes = 0;
        for ((readBytes = bis.read(buff)) > 0){
            sendBytes += readBytes;
            dos.write(buff,0,readBytes)

        }

    }


}