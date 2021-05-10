import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Janela extends Jogo{

    @FXML
    private GridPane root;

    @FXML
    public Rectangle rtg;

    public static Pane[][] panes;

    private Random rnd;

    public Janela() {
        rnd = new Random();
        panes = new Pane[N_LIN][N_COL];
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
        for (int i = 0; i < Jogo.N_LIN; i++) {
            for(int j = 0; j< Jogo.N_COL; j++){
                panes[i][j] = new Pane();
                System.out.println("COLOCANDO");
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
        boolean flag = true;

        Pane source = (Pane) event.getSource();

        for (i = 0; i< N_LIN; i++) {
            for (j = 0; j < N_COL; j++) {
                if (panes[i][j].equals(source)) {
                    jogadorDaVez(i,j);
                }
                else{
                    flag = false;
                }
            }
        }

        if(flag == false){
            System.out.println("Posição invalida");
        }

        colocarPeca();
        quadradinho();

        System.out.println("Clicou..."+i+"."+j);
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
