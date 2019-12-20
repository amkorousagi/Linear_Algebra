package com.example.linearalgebracomputer;

import android.content.Context;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class readclass extends AppCompatActivity {
    static String dirPath = Environment.getExternalStorageDirectory() + "/";
    static String filename = "file.txt";
    static FileInputStream fos = null;

    File dir = new File(dirPath);
    public void init() {
        File file = new File(dir, filename);
        try {
            fos = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            fos.close();
        } catch(FileNotFoundException e1){
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    static String Input() {
        String s="";
        byte[] buffer = new byte[1024 * 1024];
        try{
            int readData = -1;
            while((readData = fos.read())!= -1){
                s += (char)readData;
            }
        }
        catch (IOException e)
        {

        }

        return s;
    }
}
