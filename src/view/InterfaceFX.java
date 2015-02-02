/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.MyController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.TraceRoute;
 
/**
 *
 * @author charlesmariller
 */
public class InterfaceFX{

    GraphView graph;
    org.graphstream.graph.Graph myGraph;
    
    public InterfaceFX(Stage primaryStage, GraphView graph, org.graphstream.graph.Graph myGraph) 
    {
        this.graph = graph;
        this.myGraph = myGraph;
        primaryStage.setTitle("JavaFX Welcome");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Traceroute manager");
        scenetitle.setFont(Font.font("Helvetica", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("IP address: ");
        grid.add(userName, 0, 1);

        TextField IPTextField = new TextField();
        grid.add(IPTextField, 1, 1);

        
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        
        Button btn = new Button("Trace");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent e) {
            String name = IPTextField.getText();
            TraceRoute route = new TraceRoute(name, graph, myGraph);
            System.out.println(name);
            
            
        
    }
});
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
  
    
    
    
}
