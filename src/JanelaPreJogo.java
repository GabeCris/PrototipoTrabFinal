import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class JanelaPreJogo extends Jogo{

    @FXML
    public RadioButton redP1;

    @FXML
    public RadioButton blueP1;

    @FXML
    public RadioButton greenP1;

    @FXML
    public RadioButton yellowP1;

    @FXML
    public RadioButton purpleP1;

    @FXML
    public RadioButton grayP1;

    @FXML
    public RadioButton orangeP1;

    @FXML
    public RadioButton redP2;

    @FXML
    public RadioButton blueP2;

    @FXML
    public RadioButton greenP2;

    @FXML
    public RadioButton yellowP2;

    @FXML
    public RadioButton purpleP2;

    @FXML
    public RadioButton grayP2;

    @FXML
    public RadioButton orangeP2;

    @FXML
    public ToggleGroup pecaP1;

    @FXML
    public TextField nomeP1;

    @FXML
    public TextField nomeP2;

    @FXML
    public Button jogar;

    @FXML
    public Button mainmenu;


    public void clicou(MouseEvent event){
        mainmenu.getStyleClass().add("fundoBotao");

        jogar.getStyleClass().add("fundoBotao");
    }

    @FXML
    protected void menu(ActionEvent e){
        jogar.setOnMouseClicked((evt)->clicou(evt));


        Main.mudaCena("menu");
    }

    @FXML
    public void jogo(ActionEvent e){

        pecaPlayer1();
        pecaPlayer2();

        Main.mudaCena("jogo");
    }

    public static int opcaoP1;
    public static int opcaoP2;

    public void pecaPlayer1(){
        if(redP1.isSelected()){
            opcaoP1 = 1;
        }

        if(greenP1.isSelected()){
            opcaoP1 = 2;
        }

        if(yellowP1.isSelected()){
            opcaoP1 = 3;
        }


        if(purpleP1.isSelected()){
            opcaoP1 = 4;
        }

        if(grayP1.isSelected()){
            opcaoP1 = 5;
        }

    }

    public void pecaPlayer2(){

        if(redP2.isSelected()){
            opcaoP2 = 1;
        }

        if(greenP2.isSelected()){
            opcaoP2 = 2;
        }

        if(yellowP2.isSelected()){
            opcaoP2 = 3;
        }


        if(purpleP2.isSelected()){
            opcaoP2 = 4;
        }

        if(grayP2.isSelected()){
            opcaoP2 = 5;
        }
    }
}
