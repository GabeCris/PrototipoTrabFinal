package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import sample.Main;
import sample.model.Jogador;
import sample.model.Jogo;
import sample.model.daos.PessoaDao;

import java.awt.*;


public class JanelaVencedor{

    @FXML
    private Rectangle rtg;

    @FXML
    private Text txtVencedor;

    private Jogo jogo;
    private PessoaDao pessoaDao;
    private Color cor;

    public JanelaVencedor(Jogo jogo) {
        this.jogo = jogo;
        this.pessoaDao = pessoaDao;
    }

    public void initialize(){
        txtVencedor.setText("PLAYER "+jogo.flag);
        Jogador jogador = jogo.jogadorDaVez();
        rtg.setFill(jogador.getCor());
    }


    @FXML
    protected void menu(ActionEvent e){
        System.out.println("AAAAAAAA FAFA");
        Main.mudaCena(Main.MENU, (aClass)-> new JanelaMain(pessoaDao));

    }

    @FXML
    private void game(ActionEvent e){
        Main.mudaCena(Main.JANELAJOGO, (aClass) -> new JanelaJogo(jogo));
    }
}
