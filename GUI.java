import javafx.application.*; // Application
import javafx.stage.*; // Stage
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;


public class GUI extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
           Parent root= FXMLLoader.load(getClass().getResource("view/Menu.fxml"));
           Scene menu= new Scene(root,600,600);
           primaryStage.setTitle("That's Life");
           primaryStage.setScene(menu);
           primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

