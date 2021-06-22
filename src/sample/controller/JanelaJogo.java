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
import sample.model.daos.PessoaDao;

import static sample.model.Jogo.COL;
import static sample.model.Jogo.LIN;


public class JanelaJogo{

    @FXML
    private GridPane root;

    @FXML
    public Rectangle rtg;

    @FXML
    private Text invalida;


    private String [][] matrixes = new String[COL][LIN];
    public static Pane[][] panes;
    public static Jogo jogo;

    private Jogador jogador1;
    public Jogador jogador2;
    private Color cor;

    private PessoaDao pessoaDao;

    public JanelaJogo(Jogo jogo) {
        panes = new Pane[COL][LIN];
        this.jogador1 = new Jogador();
        this.jogador2 = new Jogador();
        this.jogo = jogo;

    }

    public JanelaJogo(PessoaDao pessoaDao){
        this.pessoaDao = pessoaDao;
    }

    public void initialize() {
        quadradinho();
        inicializaGuia();
        inicializaGridPane();
        colocarPeca();
        System.out.println("Sera");

    }

    private void inicializaGuia(){
        int aux = 0;
        String other = "A";

        for (int i = 0; i< LIN; i++) {
            for (int j = 0; j < COL; j++) {
                aux++;
                matrixes[j][i] = String.valueOf(other + aux);
                if (j == 6) {
                    aux = 0;
                }
            }
            switch (i) {
                case 0:
                    other = "B";
                    break;
                case 1:
                    other = "C";
                    break;
                case 2:
                    other = "D";
                    break;
                case 3:
                    other = "E";
                    break;
                case 4:
                    other = "F";
                    break;
                case 5:
                    other = "G";
                    break;
            }
        }

    }


    private void inicializaGridPane() {

        for (int i = 0; i < COL; i++) {
            for(int j = 0; j< LIN; j++){
                panes[i][j] = new Pane();
                panes[i][j].setPrefSize(100,100);
                panes[i][j].setOnMouseClicked((evt)->clicou(evt));
                root.add(panes[i][j], i,j);

                Label lb = new Label();
                lb.setText(matrixes[i][j]);
                lb.getStyleClass().add("ab");
                panes[i][j].getChildren().add(lb);

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


        for (i = 0; i< COL; i++) {
            for (j = 0; j < LIN; j++){
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
        for (int i = 0; i< COL; i++){
            for (int j = 0; j< LIN; j++){
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
    private void menu(){
        Main.mudaCena(Main.MENU, (aClass)-> new JanelaMain(pessoaDao));
    }

    @FXML
    public static void janelaVencedor(){
        Main.mudaCena(Main.JANELAVENCEDOR, (aClass)-> new JanelaVencedor(jogo));
        System.out.println("TESTANDO");
    }
}
