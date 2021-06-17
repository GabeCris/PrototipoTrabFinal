package sample.model;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import sample.controller.JanelaJogo;


public class Jogo extends Exception{
    public static int N_COLS = 7;
    public static int N_LIN = 6;

    public static int[][] matriz;
    public int vez = 0;

    private Jogador jogador1;
    private Jogador jogador2;
    private JanelaJogo janelaJogo;

    public int p1 = 0;
    public int p2 = 0;

    public Jogo(Jogador jogador1, Jogador jogador2){
        matriz = new int[N_COLS][N_LIN];
        inicializaMatriz();
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public Jogo(JanelaJogo janelaJogo){
        this.janelaJogo = janelaJogo;
    }


    public Jogador jogadorDaVez(){
        if(vez % 2 ==0){
            return jogador1;
        }
        return jogador2;
    }



    public Color getCor(int i, int j){
        if(matriz[i][j] == 1){
            return jogador1.getCor();
        }
        else if(matriz[i][j] == 2){
            return jogador2.getCor();
        }
        return Color.WHITE;
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
        verificaGanhador();
        vez++;

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
                }
            }
        }

    }

    public void placar(){
        System.out.println("ENTROU NO PLACAR");
        if(vez %2 == 0){
            p1++;
        }

       else  if(vez %2 != 0){
            p2++;
        }

        System.out.println("PLACAR PLAYER 1: "+p1);
        System.out.println("PLACAR PLAYER 2: "+p2);
        //janelaJogo.placar();
        //nomeVencedor();
        //janelaJogo.janelaVencedor();
        inicializaMatriz();
        JanelaJogo.janelaVencedor();
    }




    public void abrirAlert(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("VENCEDOR");
        alert.setHeaderText("VENCEDOR DA RODADA: JOGADOR "+player);

        alert.setContentText("PLACAR ATUAL: JOGADOR A 1 x 0 JOGADOR B");
        inicializaMatriz();
        alert.show();

    }

    public boolean estaVazia(int i, int j){

        return matriz[i][j] != 1 && matriz[i][j] != 2;
    }

    public boolean registraJogada(int i, int j){
        if(j == Jogo.N_LIN -1 || matriz[i][j+1] ==  1 || matriz[i][j+1] == 2) {
            jogadorDaVez(i, j);
            return true;
        }

        return false;
    }

    /*public String nomeVencedor(){
         String vencedor = null;

        if(player == 1){
           vencedor = jogador1.getNome();
        }

        else if(player == 2){
           vencedor =  jogador2.getNome();
        }

        System.out.println(vencedor);
        System.out.println("Era pra mostrar o vencedor em cima");

        return vencedor;
    }
*/
    public int getValor(int i, int j){
        return matriz[i][j];
    }
}
