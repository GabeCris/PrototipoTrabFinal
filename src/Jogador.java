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

    public void setCor(Color cor){
        this.cor = cor;
    }

    public Color getCor() {
        return cor;
    }
}
