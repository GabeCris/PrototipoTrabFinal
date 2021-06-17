package sample.model;

import javafx.scene.paint.Color;

public class Jogador {

    private Color cor;

    public Jogador(Color cor) {
        this.cor = cor;
    }

    public Jogador(){
        this(null);
    }



    public void setCor(Color cor){
        this.cor = cor;
        //System.out.println("Qual cor do jogador"+cor);
    }

    public Color getCor() {
        return cor;
    }
}
