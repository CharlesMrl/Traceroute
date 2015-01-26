/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.GraphView;

/**
 *
 * @author charlesmariller
 */
public class MyController {
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
        String myString = "";
        
        
        try {
            while((i = myStream.read()) != -1)
            {
                myString += (char)i;
            }
            System.out.println(myString);
            String[] test = null;
            Pattern p = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
            Matcher m = p.matcher(myString);
            List myTest = new LinkedList();
            
            while (m.find())
            {
                myTest.add(m.group());
                System.out.print ("Trouvé < " + m.group());
                System.out.println (" > de " + m.start() + " à " + m.end());
            }
            System.out.println(myTest);
            /*test = myString.split("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
            
            for(String elem : test)
            {
                System.out.println(elem);
            }*/
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GraphView graph = new GraphView();
        graph.testGraph();
        

    }
}
