import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class JanelaPreJogo{

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
    protected void menu(ActionEvent e){

        Main.mudaCena("menu");
    }

    @FXML
    protected void jogo(ActionEvent e){

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

        if(blueP1.isSelected()){
            opcaoP1 = 2;
        }

        if(greenP1.isSelected()){
            opcaoP1 = 3;
        }

        if(yellowP1.isSelected()){
            opcaoP1 = 4;
        }


        if(purpleP1.isSelected()){
            opcaoP1 = 5;
        }

        if(grayP1.isSelected()){
            opcaoP1 = 6;
        }

        if(orangeP1.isSelected()){
            opcaoP1 = 7;
        }
    }

    public void pecaPlayer2(){

        if(redP2.isSelected()){
            opcaoP2 = 1;
        }

        if(blueP2.isSelected()){
            opcaoP2 = 2;
        }
        if(greenP2.isSelected()){
            opcaoP2 = 3;
        }

        if(yellowP2.isSelected()){
            opcaoP2 = 4;
        }


        if(purpleP2.isSelected()){
            opcaoP2 = 5;
        }

        if(grayP2.isSelected()){
            opcaoP2 = 6;
        }

        if(orangeP2.isSelected()){
            opcaoP2 = 7;
        }
    }
}
