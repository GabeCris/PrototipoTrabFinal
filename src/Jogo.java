import javafx.scene.paint.Color;

public class Jogo{
    public static int N_LIN = 7;
    public static int N_COL = 6;

    public int[][] matriz;
    public int vez = 0;

    public Jogo(){
        matriz = new int[N_LIN][N_COL];
        inicializaMatriz();

    }

    public void inicializaMatriz() {
        for (int i = 0; i < N_LIN; i++) {
            for (int j = 0; j < N_COL; j++) {
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
        for (int i = 0; i< N_LIN; i++){
            for (int j = 0; j< N_COL; j++){
                String classe="";
                switch (matriz[i][j]){
                    case 1: classe="vermelho";
                        System.out.println("ENTROU KKKK");
                        break;
                    case 0: classe="verde";
                        System.out.println("ENTROU KKKK");
                        break;
                    case 2:classe="amarelo";
                        System.out.println("ENTROU KKKK");
                        break;
                }
                Janela.panes[i][j].getStyleClass().removeAll("vermelho","verde","amarelo");
                Janela.panes[i][j].getStyleClass().add(classe);

            }
        }
    }


}
