package com.example.linearalgebracomputer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class writeclass extends AppCompatActivity {
    static String dirPath = Environment.getExternalStorageDirectory() + "/";
    static String filename = "file.txt";
    static FileOutputStream fos = null;

    File dir = new File(dirPath);
    public void init() {
        File file = new File(dir, filename);
        try {
            fos = new FileOutputStream(file);
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
   static void Output(String s) {
       try{
           for(int i = 0; i < s.length(); i++)  fos.write((int)s.charAt(i));
       }
       catch (IOException e)
       {

       }
       int len = 0;

   }
    static void Output(float[][] A) {
        try{
            String s;
            for(int i = 0; i < A.length; i++){
                for(int j=0; j<A[0].length; j++){
                    s = Float.toString(A[i][j]);
                    for(int k = 0; k < s.length(); k++) fos.write((int)s.charAt(k));
                    fos.write((int)'\t');
                }
                fos.write((int)'\n');
            }
        }
        catch (IOException e)
        {

        }
        int len = 0;

    }
}
