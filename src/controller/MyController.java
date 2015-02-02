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
import javafx.application.Application;
import javafx.stage.Stage;
import view.GraphView;
import model.TraceRoute;
import view.InterfaceFX;

/**
 *
 * @author charlesmariller
 */
public class MyController extends Application{
    
    public static void main(String[] args) 
    {
        
        //InterfaceFX interfaceFX = new InterfaceFX();
        launch(args);
        //graph.testGraph();
        

    }

    @Override
    public void start(Stage stage) throws Exception {
        InterfaceFX inter = new InterfaceFX(stage);
    }
}
