import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/janelinha.fxml"));

        Parent root = loader.load();

        stage.setTitle("CONNECT 4");
        stage.setScene(new Scene(root, 550,600));


        stage.show();

    }
}
