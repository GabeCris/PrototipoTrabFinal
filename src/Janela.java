import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Random;

public class Janela extends Jogo{

    @FXML
    private GridPane root;

    @FXML
    public Rectangle rtg;

    @FXML
    private Text invalida;

    public static Pane[][] panes;

    private Random rnd;

    public Janela() {
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
                        Janela.panes[i][j].getStyleClass().add("clicado");
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
        //verificaVencedor();
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
}
