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
import java.util.Random;
import javafx.scene.Group;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
 
/**
 *
 * @author charlesmariller
 */
public class InterfaceFX{

    GraphView graph;
    org.graphstream.graph.Graph myGraph;
    public static int os =0;
    
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

        final Menu OSMenu = new Menu("Operating System");
        final Menu helpMenu = new Menu("Help");
        
      
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioMenuItem linuxItem = new RadioMenuItem("Linux");
        linuxItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Linux");
                os = 1;
            }
        });
        linuxItem.setToggleGroup(toggleGroup);
        RadioMenuItem windowsItem = new RadioMenuItem("Windows");
        windowsItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Windows");
                os = 2;
            }
        });
        windowsItem.setToggleGroup(toggleGroup);
          RadioMenuItem fakerouteItem = new RadioMenuItem("Fakeroute");
        fakerouteItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("FakeRoute");
                os = 0;
            }
        });
        fakerouteItem.setToggleGroup(toggleGroup);
        fakerouteItem.setSelected(true);
        MenuBar menuBar = new MenuBar();
        OSMenu.getItems().add(fakerouteItem);
        OSMenu.getItems().add(linuxItem);
        OSMenu.getItems().add(windowsItem);
        menuBar.getMenus().addAll(OSMenu, helpMenu);
        
        //grid.add(menuBar,0,0);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        
        Button btn = new Button("Trace");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        
        Button rdm = new Button("Trace Random");
        hbBtn.getChildren().add(rdm);
        grid.add(hbBtn, 1, 4);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent e) {
            String name = IPTextField.getText();
            TraceRoute route = new TraceRoute(name, graph, myGraph);
            System.out.println(name);
            
            
        
        }
        
        });
        rdm.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent e) {
            int i = 0;
            int nb;
            String ipAdd = "";
            Random rdm = new Random();
            
            for (i = 0;i<4;i++)
            {
                nb = rdm.nextInt(255);
                ipAdd+=nb;
                if(i!=3)
                    ipAdd+=".";
            }
            TraceRoute route = new TraceRoute(ipAdd, graph, myGraph);
            System.out.println(ipAdd);
            
            
        
        }
        });
        
        VBox vbox = new VBox(2);
        //vbox.setAlignment(Pos.BOTTOM_RIGHT);
        vbox.getChildren().add(menuBar);
        vbox.getChildren().add(grid);
        vbox.autosize();
        
        Group root = new Group();
       
        Scene scene = new Scene(root, 300, 275);
        root.getChildren().add(vbox);
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
  
    
    
    
}
