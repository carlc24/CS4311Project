/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 *
 * @author verastu
 */
public class TicTacToeApp extends Application {
    
    private int userControl;
    private List<List<Button>> btnlist;
    @Override
    public void start(Stage primaryStage) {
        userControl = 0;
        Button btn = new Button();
        btn.setText("Change User Control : " + userControl);
        btn.setPrefSize(200,50);
        btn.relocate(100, 300);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(userControl == 0){
                    userControl = 1;
                }
                else if(userControl == 1){
                    userControl = 2;
                }
                else if(userControl == 2){
                    userControl = 1;
                }
                btn.setText("Change User Control : " + userControl);
                //System.out.println("Hello World!");
            }
        });
        
        Rectangle r = new Rectangle();
        r.setX(50);
        r.setY(50);
        r.setWidth(200);
        r.setHeight(100);
        r.setArcWidth(20);
        r.setArcHeight(20);
        
        //Line line = new Line(50, 100, 300, 100);
        
        AnchorPane root = new AnchorPane();
        //root.getChildren().add(line);
        setTicTacToe(root,100,100,300,300,3);
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 800, 720);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void setTicTacToe(AnchorPane root, int start_x, int start_y, int end_x, int end_y, int size){
        int tempX = (end_x - start_x) / (size);
        int tempY = (end_y - start_y) / (size);
        
        /**
        Line lineX0 = new Line(start_x, start_y, end_x, start_y);
        Line lineX1 = new Line(start_x, start_y + tempY, end_x, start_y + tempY);
        Line lineX2 = new Line(start_x, start_y + tempY*2, end_x, start_y + tempY*2);
        Line lineX3 = new Line(start_x, end_y, end_x, end_y);
        
        Line lineY0 = new Line(start_x, start_y, start_x, end_y);
        Line lineY1 = new Line(start_x + tempX, start_y, start_x + tempX, end_y);
        Line lineY2 = new Line(start_x + tempX*2, start_y, start_x + tempX*2, end_y);
        Line lineY3 = new Line(end_x, start_y, end_x, end_y);
        root.getChildren().add(lineX0);
        root.getChildren().add(lineX1);
        root.getChildren().add(lineX2);
        root.getChildren().add(lineX3);
        
        root.getChildren().add(lineY0);
        root.getChildren().add(lineY1);
        root.getChildren().add(lineY2);
        root.getChildren().add(lineY3);
        */
        btnlist = new ArrayList<>();
        for(int i = 0; i<size ; i++){
            btnlist.add(new ArrayList<>());
            for(int j = 0; j<size; j++){
                Button newbtn = new Button();
                newbtn.setPrefSize(tempX, tempY);
                newbtn.relocate(start_x+tempX*i, start_y+tempY*j);
                btnlist.get(i).add(new Button());
                root.getChildren().add(newbtn);
                newbtn.setOnAction((ActionEvent event) -> {
                    if(userControl == 1){
                        if(newbtn.getText().equals("")){
                            newbtn.setText("O");
                        }
                    }
                    else if(userControl == 2){
                        if(newbtn.getText().equals("")){
                            newbtn.setText("X");
                        }
                    }
                });
            }
        }
        //root.getChildren().add(lineX1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
