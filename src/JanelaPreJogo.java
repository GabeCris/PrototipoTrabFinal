import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

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
    public ToggleGroup pecaP1;

    @FXML
    public TextField nomeP1;

    @FXML
    public TextField nomeP2;

    @FXML
    public Button jogar;

    @FXML
    public Button mainmenu;

    private Color[] cores = {Color.RED, Color.GRAY, Color.YELLOW, Color.BLUE, Color.PURPLE};

    private Jogador jogador1;
    private Jogador jogador2;

    private Jogo jogo;

    public JanelaPreJogo(){
        this.jogador1 = new Jogador();
        this.jogador2 = new Jogador();
        this.jogo = new Jogo(jogador1, jogador2);

    }

    public void clicou(MouseEvent event){
        mainmenu.getStyleClass().add("fundoBotao");

        jogar.getStyleClass().add("fundoBotao");
    }

    @FXML
    protected void menu(ActionEvent e){
        jogar.setOnMouseClicked((evt)->clicou(evt));


       // Main.mudaCena("menu");
    }



    @FXML
    public void jogo(ActionEvent e){

        pecaPlayer1();
        pecaPlayer2();

        Main.mudaCena(Main.JANELAJOGO, (aClass) -> new JanelaJogo(jogo));
    }

    public static int opcaoP1;
    public static int opcaoP2;

    public void pecaPlayer1(){

        int opcao =0;



        if(redP1.isSelected()){
            opcao = 0;
        }

        if(greenP1.isSelected()){
            opcao = 1;
        }

        if(yellowP1.isSelected()){
            opcao = 2;
        }


        if(purpleP1.isSelected()){
            opcao = 3;
        }

        if(grayP1.isSelected()){
            opcao = 4;
        }

        jogador1.setCor(cores[opcao]);

    }

    public void pecaPlayer2(){

        int opcao =0;

        if(redP2.isSelected()){
            opcao = 0;
        }

        if(greenP2.isSelected()){
            opcao = 1;
        }

        if(yellowP2.isSelected()){
            opcao = 2;
        }


        if(purpleP2.isSelected()){
            opcao = 3;
        }

        if(grayP2.isSelected()){
            opcao = 4;
        }

        jogador2.setCor(cores[opcao]);
    }
}
