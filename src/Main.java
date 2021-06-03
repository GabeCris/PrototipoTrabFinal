import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    
    private static Scene sceneJogo, sceneMenu, sceneVencedor, scenePreJogo;
    private static Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("fxml/janelinhaMain.fxml"));
        sceneMenu = new Scene(fxmlMain, 550,600);

        Parent fxmlJogo = FXMLLoader.load(getClass().getResource("fxml/janelinhaJogo.fxml"));
        sceneJogo = new Scene(fxmlJogo, 550,600);

        Parent fxmlVencedor = FXMLLoader.load(getClass().getResource("fxml/janelinhaVencedor.fxml"));
        sceneVencedor = new Scene(fxmlVencedor, 550,600);

        Parent fxmlPreJogo = FXMLLoader.load(getClass().getResource("fxml/janelinhaPreJogo.fxml"));
        scenePreJogo = new Scene(fxmlPreJogo, 550,600);

        primaryStage.setScene(sceneMenu);
        primaryStage.show();

    }

    public static void mudaCena(String src){
        JanelaJogo.inicializaMatriz();
        JanelaJogo.colocarPeca();
        switch (src){
            case "menu":
                stage.setScene(sceneMenu);
                break;
            case "vencedor":
                stage.setScene(sceneVencedor);
                break;
            case "jogo":
                stage.setScene(sceneJogo);
                break;
            case "prejogo":
                stage.setScene(scenePreJogo);
                break;
        }
    }
}
