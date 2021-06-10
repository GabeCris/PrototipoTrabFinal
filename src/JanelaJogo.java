import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Random;

public class JanelaJogo{

    @FXML
    private GridPane root;

    @FXML
    public Rectangle rtg;

    @FXML
    public Rectangle rtg11;

    @FXML
    public Rectangle rtg22;

    @FXML
    private Text invalida;

    @FXML
    public Label plc1;

    @FXML
    public Label plc2;

    public static Pane[][] panes;

    private Random rnd;

    private Jogo jogo;


    public JanelaJogo(Jogo jogo) {
        rnd = new Random();
        panes = new Pane[Jogo.N_COLS][Jogo.N_LIN];
        this.jogo = jogo;

    }

    public void initialize() {
        inicializaGridPane();
        colocarPeca();

    }

    private void inicializaGridPane() {
        for (int i = 0; i < Jogo.N_COLS; i++) {
            for(int j = 0; j< Jogo.N_LIN; j++){
                panes[i][j] = new Pane();
                panes[i][j].setPrefSize(100,100);
                panes[i][j].setOnMouseClicked((evt)->clicou(evt));
                root.add(panes[i][j], i,j);
                panes[i][j].getStyleClass().add("redondo");
            }
        }
    }

    private void clicou(MouseEvent event){
        int i = 0;
        int j=0;

        Pane source = (Pane) event.getSource();


        for (i = 0; i< Jogo.N_COLS; i++) {
            for (j = 0; j < Jogo.N_LIN; j++) {
                if (panes[i][j].equals(source) && jogo.estaVazia(i,j)) {
                    if(jogo.registraJogada(i,j)) {
                        JanelaJogo.panes[i][j].getStyleClass().add("clicado");
                        invalida.setText("...");

                    }

                    else{
                        invalida.setText("JOGADA INVALIDA");
                    }
                    System.out.println("Clicou..."+i+"."+j);
                }
            }
        }


        colocarPeca();

        quadradinho();


    }

    public void colocarPeca(){
        for (int i = 0; i< Jogo.N_COLS; i++){
            for (int j = 0; j< Jogo.N_LIN; j++){
                Color cor = jogo.getCor(i,j);
                panes[i][j].setBackground(new Background(new BackgroundFill(cor,new CornerRadii(50.0),null)));
            }
        }
    }


    public void quadradinho(){
        System.out.println("ENTROU PRIMEIRO");

        Jogador jogador = jogo.jogadorDaVez();

        rtg.setFill(jogador.getCor());
        //rtg11.setFill(jogador.getCor());
        //rtg22.setFill(jogador.getCor());

    }

    @FXML
    public static void janelaVencedor(){
        //Main.mudaCena("vencedor");
        System.out.println("TESTANDO");
    }




}
