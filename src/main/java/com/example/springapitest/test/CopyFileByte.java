package com.example.springapitest.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileByte {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream =  null;
        FileOutputStream fileOutputStream = null;

        try {
             fileInputStream = new FileInputStream("inStream.txt");
             fileOutputStream = new FileOutputStream("outStream.txt");
            int c;
            while ((c = fileInputStream.read()) != -1) {
                fileOutputStream.write(c);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(fileInputStream != null){
                fileInputStream.close();
            }
            if(fileOutputStream != null){
                fileOutputStream.close();
            }
        }

    }
}
