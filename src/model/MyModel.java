/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author charlesmariller
 */
public class MyModel {
    public static void main(String[] args) 
    {
        
        Runtime rt = Runtime.getRuntime();
        Process process = null;
        
        try {
            process = rt.exec("java -jar ./lib/fakeroute.jar google.com");  //execute Memory.java which is in same directory
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
        
        InputStream myStream = process.getInputStream();

        int i;

        try {
            while((i = myStream.read()) != -1)
                System.out.print((char)i);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
