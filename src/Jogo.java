import javafx.scene.control.Alert;

public class Jogo extends Exception{
    public static int N_COLS = 7;
    public static int N_LIN = 6;

    public int[][] matriz;
    public int vez = 0;

    public Jogo(){
        matriz = new int[N_COLS][N_LIN];
        inicializaMatriz();

    }

    public void inicializaMatriz() {
        for (int i = 0; i < N_COLS; i++) {
            for (int j = 0; j < N_LIN; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public void jogadorDaVez(int i, int j){
        if(vez%2==0){
            matriz[i][j] = 1;
        }

        else{
            matriz[i][j] = 2;
        }
        vez++;

    }

    public void colocarPeca(){
        for (int i = 0; i< N_COLS; i++){
            for (int j = 0; j< N_LIN; j++){
                String classe="";
                switch (matriz[i][j]){
                    case 1: classe="vermelho";
                        break;
                    case 0: classe="verde";
                        break;
                    case 2:classe="amarelo";
                        break;
                }
                Janela.panes[i][j].getStyleClass().removeAll("vermelho","verde","amarelo");
                Janela.panes[i][j].getStyleClass().add(classe);

            }
        }
    }


    public int vencedor = 0;
    /*public void verificaVencedor(){
        for (int i = 0; i < N_COLS; i++) {
            for (int j = 0; j < N_LIN; j++) {
                if (DIREITA matriz[i][j] == 1 && matriz[i][j + 1] == 1 && matriz[i][j + 2] == 1 && matriz[i][j + 3] == 1
                        ESQUERDA || matriz[i][j] == 1 && matriz[i - 1][j] == 1 && matriz[i - 2][j] == 1 && matriz[i - 3][j] == 1
                        DIAGONAL DIREITA || matriz[i][j] == 1 && matriz[i + 1][j + 1] == 1 && matriz[i + 2][j + 2] == 1 && matriz[i + 3][j + 3] == 1
                        DIAGONAL ESQUERDA || matriz[i][j] == 1 && matriz[i + 1][j - 1] == 1 && matriz[i + 2][j - 2] == 1 && matriz[i + 3][j - 3] == 1) {
                    vencedor = 1;
                    System.out.println("GANHOU LEK");
                    abrirAlert();
                } else if (DIREITA matriz[i][j] == 2 && matriz[i][j + 1] == 2 && matriz[i][j + 2] == 2 && matriz[i][j + 3] == 2
                        ESQUERDA || matriz[i][j] == 2 && matriz[i - 1][j] == 2 && matriz[i - 2][j] == 2 && matriz[i - 3][j] == 2
                        DIAGONAL DIREITA || matriz[i][j] == 2 && matriz[i + 1][j + 1] == 2 && matriz[i + 2][j + 2] == 2 && matriz[i + 3][j + 3] == 2
                        DIAGONAL ESQUERDA || matriz[i][j] == 2 && matriz[i + 1][j - 1] == 2 && matriz[i + 2][j - 2] == 2 && matriz[i + 3][j - 3] == 2) {
                    vencedor = 2;
                    System.out.println("GANHOU LEK");
                    abrirAlert();
                }
            }
        }
    }*/

    public void abrirAlert(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("VENCEDOR");
        if (vencedor == 1){
            alert.setHeaderText("VENCEDOR DA RODADA: JOGADOR 1");
        }

        else if (vencedor == 2){
            alert.setHeaderText("VENCEDOR DA RODADA: JOGADOR 2");
        }

        alert.setContentText("PLACAR ATUAL: JOGADOR A 1 x 0 JOGADOR B");
        alert.show();
    }


}
