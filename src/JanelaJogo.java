import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Random;

public class JanelaJogo extends Jogo{

    @FXML
    private GridPane root;

    @FXML
    public Rectangle rtg;

    @FXML
    private Text invalida;

    @FXML
    public static Label plc1;

    @FXML
    public static Label plc2;

    public static Pane[][] panes;

    private Random rnd;

    public JanelaJogo() {
        rnd = new Random();
        panes = new Pane[N_COLS][N_LIN];
    }

    public void initialize() {
        inicializaGridPane();
        colocarPeca();

        if(vez %2==0){
            rtg.setFill(Color.RED);
        }

        else{
            rtg.setFill(Color.YELLOW);
        }
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


        for (i = 0; i< N_COLS; i++) {
            for (j = 0; j < N_LIN; j++) {
                if (panes[i][j].equals(source) && matriz[i][j] != 1 && matriz[i][j] != 2) {
                    if(j == N_LIN -1 || matriz[i][j+1] ==  1 || matriz[i][j+1] == 2) {
                        jogadorDaVez(i, j);
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

    public void quadradinho(){
        if(vez %2==0){
            rtg.setFill(Color.RED);
        }

        else{
            rtg.setFill(Color.YELLOW);
        }

    }

    @FXML
    public static void janelaVencedor(){
        Main.mudaCena("vencedor");
        System.out.println("TESTANDO");
    }



    public static void placar(){
        int p1 = 0;
        int p2 = 0;

        if(player == 1){
            p1++;
        }

        if(player == 2){
            p2++;
        }

        System.out.println("JOGADOR 1:"+p1);
        System.out.println("JOGADOR 2:"+p2);

        plc1.setText(String.valueOf(p1));
        plc2.setText(String.valueOf(p2));
    }




}
