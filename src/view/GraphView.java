/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author charlesmariller
 */
public class GraphView {
   
    public void testGraph()
    {
        org.graphstream.graph.Graph graph = new SingleGraph("Tutorial 1");

        graph.addNode("A" );



        org.graphstream.graph.Node n = graph.addNode("B");
        n.addAttribute("ui.label","B");
        graph.addNode("C" );
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");



        graph.addAttribute("ui.stylesheet", "graph { padding: 40px;  } node { text-alignment: at-right; text-background-mode: plain; text-background-color: #EB2; text-color: #222; text-size: 20px;}");
        graph.display();
    }
    
  
}
