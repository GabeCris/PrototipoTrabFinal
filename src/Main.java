import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public static final String MENU = "/fxml/janelinhaMain.fxml";
    public static final String JANELAJOGO = "/fxml/janelinhaJogo.fxml";
    public static final String JANELAPREJOGO = "/fxml/janelinhaPreJogo.fxml";
    public static final String JANELAVENCEDOR = "/fxml/janelinhaVencedor.fxml";


    private static StackPane base;

    public static void mudaCena(String fxml, Callback controllerFactory) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(fxml));
            loader.setControllerFactory(controllerFactory);

            Parent novoRoot = loader.load();

            //ja existe alguma coisa sendo mostrada, entao remover
            if (base.getChildren().stream().count() > 0) {
                base.getChildren().remove(0);
            }
            base.getChildren().add(novoRoot);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void start(Stage stage) throws Exception {

        base = new StackPane();


        stage.setScene(new Scene(base, Region.USE_PREF_SIZE, Region.USE_PREF_SIZE));
        stage.setTitle("Simulador de Subway...");

        mudaCena(MENU, (aClass)->new JanelaMain());

        //stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }


}
