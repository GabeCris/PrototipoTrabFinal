package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import sample.Main;
import sample.model.Jogador;
import sample.model.Jogo;


public class JanelaJogo{

    @FXML
    private GridPane root;

    @FXML
    public Rectangle rtg;

    @FXML
    private Text invalida;


    public static Pane[][] panes;
    public static Jogo jogo;

    private Jogador jogador1;
    public Jogador jogador2;
    private Color cor;


    public JanelaJogo(Jogo jogo) {
        panes = new Pane[Jogo.N_COLS][Jogo.N_LIN];
        this.jogador1 = new Jogador();
        this.jogador2 = new Jogador();
        this.jogo = jogo;
        //this.jogo = new sample.model.Jogo(jogador1, jogador2);

    }

    public JanelaJogo(){

    }

    public void initialize() {
        inicializaGridPane();
        colocarPeca();
        System.out.println("Sera");

    }

    private void inicializaGridPane() {
        for (int i = 0; i < Jogo.N_COLS; i++) {
            for(int j = 0; j< Jogo.N_LIN; j++){
                panes[i][j] = new Pane();
                panes[i][j].setPrefSize(100,100);
                panes[i][j].setOnMouseClicked((evt)->clicou(evt));
                root.add(panes[i][j], i,j);
               // panes[i][j].getStyleClass().add("branco");
                if(jogo.estaVazia(i,j)){
                    panes[i][j].getStyleClass().add("redondo");
                }


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
                        panes[i][j].getStyleClass().add("clicado");
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
                cor = jogo.getCor(i,j);
                panes[i][j].setBackground(new Background(new BackgroundFill(cor,new CornerRadii(50.0),null)));
            }
        }
    }

    public void quadradinho(){
        System.out.println("ENTROU PRIMEIRO");

        Jogador jogador = jogo.jogadorDaVez();


        rtg.setFill(jogador.getCor());

    }

    @FXML
    public static void janelaVencedor(){
        Main.mudaCena(Main.JANELAVENCEDOR, (aClass)-> new JanelaVencedor(jogo));
        System.out.println("TESTANDO");
    }
}
