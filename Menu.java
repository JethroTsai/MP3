import javafx.application.*; // Application
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.*; // Stage
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.*; // Button
import javafx.scene.shape.*;	//Scene
import javafx.scene.layout.*; //FlowPane
import javafx.geometry.*; // Pos - alignment
import javafx.scene.image.*; // Image, ImageView


import java.io.*; // fileinputstream
import javafx.scene.input.*; // mouseevent
import javafx.event.*;
import javafx.animation.*;

public class Menu extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
           Parent root= FXMLLoader.load(getClass().getResource("menu.fxml"));
           Scene menu= new Scene (root,600,600);
           primaryStage.setTitle("That's Life");
           primaryStage.setScene(menu);
           primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}

