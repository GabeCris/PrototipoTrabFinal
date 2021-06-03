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
    public Rectangle rtg11;

    @FXML
    public Rectangle rtg22;

    @FXML
    private Text invalida;

    @FXML
    public static Label plc1;

    @FXML
    public static Label plc2;

    public static Pane[][] panes;

    private Random rnd;

    /*public JanelaJogo(int p1, int p2) {
        super(p1,p2);
        rnd = new Random();
        panes = new Pane[N_COLS][N_LIN];
    }*/

    public JanelaJogo() {
        rnd = new Random();
        panes = new Pane[N_COLS][N_LIN];

    }

    public void initialize() {
        inicializaGridPane();
        colocarPeca();

        if(vez % 2 == 0){
            quadradinho();
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
        System.out.println("ENTROU PRIMEIRO");
        if(vez %2 ==0) {
            switch (JanelaPreJogo.opcaoP1) {
                case 1:
                    rtg.setFill(Color.RED);
                    rtg11.setFill(Color.RED);
                    break;
                case 2:
                    rtg.setFill(Color.BLUE);
                    rtg11.setFill(Color.BLUE);
                    break;
                case 3:
                    rtg.setFill(Color.GREEN);
                    rtg11.setFill(Color.GREEN);
                    break;
                case 4:
                    rtg.setFill(Color.YELLOW);
                    rtg11.setFill(Color.YELLOW);
                    break;
                case 5:
                    rtg.setFill(Color.PURPLE);
                    rtg11.setFill(Color.PURPLE);
                    break;
                case 6:
                    rtg.setFill(Color.GRAY);
                    rtg11.setFill(Color.GRAY);

                    break;
                case 7:
                    rtg.setFill(Color.ORANGE);
                    rtg11.setFill(Color.ORANGE);
                    break;
            }
        }

        else if(vez %2 !=0){
            switch (JanelaPreJogo.opcaoP2) {
                case 1:
                    rtg.setFill(Color.RED);
                    rtg22.setFill(Color.RED);
                    break;
                case 2:
                    rtg.setFill(Color.BLUE);
                    rtg22.setFill(Color.BLUE);
                    break;
                case 3:
                    rtg.setFill(Color.GREEN);
                    rtg22.setFill(Color.GREEN);
                    break;
                case 4:
                    rtg.setFill(Color.YELLOW);
                    rtg22.setFill(Color.YELLOW);
                    break;
                case 5:
                    rtg.setFill(Color.PURPLE);
                    rtg22.setFill(Color.PURPLE);
                    break;
                case 6:
                    rtg.setFill(Color.GRAY);
                    rtg22.setFill(Color.GRAY);
                    break;
                case 7:
                    rtg.setFill(Color.ORANGE);
                    rtg22.setFill(Color.ORANGE);
                    break;
            }
        }

    }

    @FXML
    public static void janelaVencedor(){
        Main.mudaCena("vencedor");
        System.out.println("TESTANDO");
    }




}
