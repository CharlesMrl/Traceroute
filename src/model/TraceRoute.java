/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.GraphView;

/**
 *
 * @author charlesmariller
 */
public class TraceRoute {
    
    public TraceRoute(String IPName, GraphView graph, org.graphstream.graph.Graph myGraph)
    {
        Runtime rt = Runtime.getRuntime();
        Process process = null;
        
        try {
                process = rt.exec("java -jar ./lib/fakeroute.jar "+ IPName);  //execute Memory.java which is in same directory
            } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
        
        InputStream myStream = process.getInputStream();
       
        
        int i,j,k;
        String myString = "";
        int pos_x = 0, pos_y = 0;

        
        try {
            while((i = myStream.read()) != -1)
            {
                myString += (char)i;
            }
            
            System.out.println(myString);
            String lines[] = myString.split("\\r?\\n");
            Pattern p = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
            Matcher m ;
             //System.out.println(p.matcher(lines[1]));
             
            //List myTest = new LinkedList();
            
            
        
           
            List<String> son = new LinkedList();
            List<String> mother = new LinkedList();
            InetAddress thisIp = null;
             try {
                 thisIp = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Logger.getLogger(GraphView.class.getName()).log(Level.SEVERE, null, ex);
            }

            mother.add( thisIp.getHostAddress());
            
            //System.out.println(m.get(0).group());
            for (i = 1; i< lines.length; i++)
            {
           
                m = p.matcher(lines[i]);

                while (m.find())
                {
                    //myTest.add(m.group());
                    //System.out.println(m.find());
                    son.add(m.group());
                    System.out.print ("Trouvé < " + m.group());
                    System.out.println (" > de " + m.start() + " à " + m.end());
                }


                for (k=0; k<son.size();k++)
                    {
                        graph.addNodeTree(son.get(k), myGraph);
                    }
                
                for (j=0; j<mother.size();j++)
                {
                    System.out.println ("mother : " + mother.get(j));
                    
                    for (k=0; k<son.size();k++)
                    {
                        System.out.println ("son : " + son.get(k));                    
                       //graph.addNodeTree(mother.get(j),son.get(k), g);
                        graph.addRelation(mother.get(j),son.get(k), myGraph);

                    }
                }
                
                mother.clear();
                mother.addAll(son);
                son.clear();
                pos_x ++;
            }
            
            
            //System.out.println(myTest);
            /*test = myString.split("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
            
            for(String elem : test)
            {
                System.out.println(elem);
            }*/
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
