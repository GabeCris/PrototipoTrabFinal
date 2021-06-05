import javafx.scene.control.Alert;


public class Jogo extends Exception{
    public static int N_COLS = 7;
    public static int N_LIN = 6;

    public static int[][] matriz;
    public int vez = 0;

    public String nomePlayer1;
    public String nomePlayer2;


    public int p1;
    public int p2;

    public Jogo(){
        matriz = new int[N_COLS][N_LIN];
        inicializaMatriz();

        //System.out.println("Nome player 1: "+nomePlayer1);

        //System.out.println("Nome player 2: "+nomePlayer2);
    }




    public static void inicializaMatriz() {


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

        verificaGanhador();
        vez++;

    }

    public static void colocarPeca(){
        for (int i = 0; i< N_COLS; i++){
            for (int j = 0; j< N_LIN; j++){
                String classe = "";
                switch (matriz[i][j]){
                    case 1:
                        switch (JanelaPreJogo.opcaoP1) {
                            case 1:
                                classe = "vermelho";
                                break;
                            case 2:
                                classe = "verde";
                                break;
                            case 3:
                                classe = "amarelo";
                                break;
                            case 4:
                                classe = "roxo";
                                break;
                            case 5:
                                classe = "cinza";
                                break;
                        }
                        break;

                    case 2:
                        switch (JanelaPreJogo.opcaoP2) {
                            case 1:
                                classe = "vermelho";
                                break;
                            case 2:
                                classe = "verde";
                                break;
                            case 3:
                                classe = "amarelo";
                                break;
                            case 4:
                                classe = "roxo";
                                break;
                            case 5:
                                classe = "cinza";
                                break;
                        }
                        break;

                    case 0: classe="branco";
                        break;

                }
                JanelaJogo.panes[i][j].getStyleClass().removeAll("vermelho","verde","amarelo", "branco", "roxo", "cinza","laranja", "azul");
                JanelaJogo.panes[i][j].getStyleClass().add(classe);

            }
        }
    }
    public static int player =0;


    public void verificaGanhador(){

        if(vez%2==0){
            player = 1;
        }
        else if(vez%2!=0){
            player = 2;
        }

        for(int i = 0; i<matriz.length; i++){
            for (int j = 0;j < matriz[0].length - 3;j++){
                if (matriz[i][j] == player   &&
                        matriz[i][j+1] == player &&
                        matriz[i][j+2] == player &&
                        matriz[i][j+3] == player){
                    System.out.println("GANHOU");
                    placar();

                    JanelaJogo.janelaVencedor();
                }
            }
        }

        for(int i = 0; i<matriz.length -3; i++){
            for (int j = 0;j < matriz[0].length;j++){
                if (matriz[i][j] == player   &&
                        matriz[i+1][j] == player &&
                        matriz[i+2][j] == player &&
                        matriz[i+3][j] == player){
                    System.out.println("GANHOU");
                    placar();
                    JanelaJogo.janelaVencedor();
                }
            }
        }

        for(int i = 3; i<matriz.length; i++){
            for (int j = 0;j < matriz[0].length -3;j++){
                if (matriz[i][j] == player   &&
                        matriz[i-1][j+1] == player &&
                        matriz[i-2][j+2] == player &&
                        matriz[i-3][j+3] == player){
                    System.out.println("GANHOU");
                    placar();
                    JanelaJogo.janelaVencedor();
                }
            }
        }

        for(int i = 0; i<matriz.length -3; i++){
            for (int j = 0;j < matriz[0].length -3;j++){
                if (matriz[i][j] == player   &&
                        matriz[i+1][j+1] == player &&
                        matriz[i+2][j+2] == player &&
                        matriz[i+3][j+3] == player){
                    System.out.println("GANHOU");
                    placar();
                    JanelaJogo.janelaVencedor();
                }
            }
        }

    }

    public int[] placar(){
        System.out.println("ENTROU NO PLACAR");
        if(vez %2 == 0){
            p1++;
        }

       else  if(vez %2 != 0){
            p2++;
        }


        System.out.println("PLACAR PLAYER 1: "+p1);
        System.out.println("PLACAR PLAYER 2: "+p2);

        int placares[];
        placares = new int[2];

        placares[0] = p1;

        placares[1] = p2;

        System.out.println(placares[0]);

        System.out.println(placares[1]);

        return placares;
    }




    public void abrirAlert(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("VENCEDOR");
        alert.setHeaderText("VENCEDOR DA RODADA: JOGADOR "+player);

        alert.setContentText("PLACAR ATUAL: JOGADOR A 1 x 0 JOGADOR B");
        inicializaMatriz();
        alert.show();

    }



}
