package sample.model;

import javafx.scene.paint.Color;

public class Jogador {

    private String nome;
    private Color cor;

    public Jogador(String nome, Color cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public Jogador(){
        this("", null);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
        System.out.println("Nome do jogador "+nome);
    }

    public void setCor(Color cor){
        this.cor = cor;
        //System.out.println("Qual cor do jogador"+cor);
    }

    public Color getCor() {
        return cor;
    }
}
