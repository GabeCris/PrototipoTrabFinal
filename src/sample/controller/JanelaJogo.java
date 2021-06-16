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
    public Rectangle rtgJog1;

    @FXML
    public Rectangle rtgJog2;

    @FXML
    private Text invalida;

    @FXML
    public Label plc1;

    @FXML
    public Label plc2;

    @FXML
    private Text txtNome;

    public static Pane[][] panes;
    public Jogo jogo;

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
                panes[i][j].getStyleClass().add("branco");
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
                        //panes[i][j].getStyleClass().add("clicado");
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
        mudaNome();


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

    private void mudaNome(){
        Jogador jogador = jogo.jogadorDaVez();
        rtgJog1.setFill(jogador1.getCor());
        rtgJog2.setFill(jogador2.getCor());
        System.out.println("JOGADOR DA VEZ "+jogador.getNome());
        txtNome.setText(jogador.getNome());
    }

    @FXML
    public void janelaVencedor(){
        Main.mudaCena(Main.JANELAVENCEDOR, (aClass)-> new JanelaVencedor(jogo));
        System.out.println("TESTANDO");
    }

    public void placar(){
        plc1.setText(String.valueOf(jogo.p1));
        //System.out.println("PLACAR DEPOIS DO GAME P1 "+jogo.p1);
        //System.out.println("PLACAR DEPOIS DO GAME "+plc1);
        plc2.setText(String.valueOf(jogo.p2));
        janelaVencedor();

       // System.out.println("PLACAR DEPOIS DO GAME P2 "+jogo.p2);
        //System.out.println("PLACAR DEPOIS DO GAME "+plc2);
    }





}
