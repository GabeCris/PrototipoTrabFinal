package sample.model;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import sample.controller.JanelaJogo;


public class Jogo{
    public static int LIN = 6;
    public static int COL = 7;
    public int flag;

    public int[][] matriz;
    public int vez = 0;

    private Jogador jogador1;
    private Jogador jogador2;
    private JanelaJogo janelaJogo;

    public Jogo(Jogador jogador1, Jogador jogador2){
        matriz = new int[COL][LIN];
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


        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < LIN; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public int jogadorDaVez(int i, int j){
        if(vez%2==0){
            matriz[i][j] = 1;
        }

        else{
            matriz[i][j] = 2;
        }
        verificaGanhador();
        vez++;
        return vez;
    }

    public static int player =0;


    public void verificaGanhador(){

        if(vez%2==0){
            player = 1;
            flag = player;
        }
        else if(vez%2!=0){
            player = 2;
            flag = player;
        }

        for(int i = 0; i<matriz.length; i++){
            for (int j = 0;j < matriz[0].length - 3;j++){
                if (matriz[i][j] == player   &&
                        matriz[i][j+1] == player &&
                        matriz[i][j+2] == player &&
                        matriz[i][j+3] == player){
                    System.out.println("GANHOU");
                    inicializaMatriz();
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
                    inicializaMatriz();
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
                    inicializaMatriz();
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
                    inicializaMatriz();
                    JanelaJogo.janelaVencedor();
                }
            }
        }

    }

    public boolean estaVazia(int i, int j){

        return matriz[i][j] != 1 && matriz[i][j] != 2;
    }

    public boolean registraJogada(int i, int j){
        if(j == Jogo.LIN -1 || matriz[i][j+1] ==  1 || matriz[i][j+1] == 2) {
            jogadorDaVez(i, j);
            return true;
        }

        return false;
    }

    public int getValor(int i, int j){
        return matriz[i][j];
    }
}
