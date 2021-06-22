package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.controller.JanelaCadastro;
import sample.controller.JanelaLogin;
import sample.controller.JanelaMain;
import sample.model.FabricaConexoes;
import sample.model.daos.JDBCPessoaDao;
import sample.model.daos.PessoaDao;


public class Main extends Application {


    public static void main(String[] args) {

        launch(args);
    }

    public static final String MENU = "/fxml/janelinhaMain.fxml";
    public static final String JANELAJOGO = "/fxml/janelinhaJogo.fxml";
    public static final String JANELAOPCOES = "/fxml/janelinhaOpcoes.fxml";
    public static final String JANELAVENCEDOR = "/fxml/janelinhaVencedor.fxml";
    public static final String JANELALOGIN = "/fxml/janelinhaLogin.fxml";
    public static final String JANELACADASTRO = "/fxml/janelinhaCadastro.fxml";
    public static final String JANELATUTORIAL = "/fxml/janelinhaTutorial.fxml";

    private static StackPane base;

    private FabricaConexoes fabricaConexoes;
    private PessoaDao pessoaDao;

    private void alocaDaos(){
        fabricaConexoes = new FabricaConexoes();
        pessoaDao = new JDBCPessoaDao(fabricaConexoes);
    }

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

        alocaDaos();
        base = new StackPane();


        stage.setScene(new Scene(base, Region.USE_PREF_SIZE, Region.USE_PREF_SIZE));
        stage.setTitle("CONNECT");

        //mudaCena(MENU, (aClass)->new JanelaMain());
        mudaCena(JANELALOGIN, (aClass)-> new JanelaLogin(pessoaDao));
        //mudaCena(JANELACADASTRO, (aClass)-> new JanelaCadastro());

        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }


}
