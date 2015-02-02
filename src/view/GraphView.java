/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author charlesmariller
 */
public class GraphView {
   
    int current_x, current_y;
    
    
    
    public org.graphstream.graph.Graph  initGraph(){
          org.graphstream.graph.Graph graph = new SingleGraph("Tutorial 1");
          InetAddress thisIp = null;
        try {
            thisIp = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(GraphView.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          org.graphstream.graph.Node n = graph.addNode(thisIp.getHostAddress());
        n.addAttribute("ui.label",thisIp.getHostAddress());
          return graph;
    }
    
    public void addNodeTree(String son,org.graphstream.graph.Graph graph){
        org.graphstream.graph.Node n =graph.addNode(son);
          n.addAttribute("ui.label",son);
            //graph.addEdge(son + mother , mother, son);
            
        
    }
    
      public void addRelation(String mother, String son,org.graphstream.graph.Graph graph){
        //org.graphstream.graph.Node n =graph.addNode(son);
          //n.addAttribute("ui.label",son);
            graph.addEdge(son + mother , mother, son, true);
            
        
    }
      
      
    public void affichGraph(org.graphstream.graph.Graph graph){
         graph.addAttribute("ui.stylesheet", "graph { padding: 40px;  } node { text-alignment: at-right; text-background-mode: plain; text-background-color: #EB2; text-color: #222; text-size: 20px;}");
        graph.display();
    }
}
