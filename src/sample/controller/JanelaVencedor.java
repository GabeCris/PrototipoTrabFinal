package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import sample.Main;
import sample.model.Jogador;
import sample.model.Jogo;

import java.awt.*;


public class JanelaVencedor{

    @FXML
    private Rectangle rtg;

    private Jogo jogo;
    private JanelaJogo janelaJogo;

    public JanelaVencedor(Jogo jogo) {
        this.jogo = jogo;
        //mudaRTG();
    }

    public JanelaVencedor(JanelaJogo janelaJogo){

    }



    private void mudaRTG(){
        rtg.setFill(janelaJogo.rtg.getFill());

    }




    @FXML
    protected void menu(ActionEvent e){
        System.out.println("AAAAAAAA FAFA");
        Main.mudaCena(Main.MENU, (aClass)-> new JanelaMain());

    }

    @FXML
    private void game(ActionEvent e){
        Main.mudaCena(Main.JANELAJOGO, (aClass) -> new JanelaJogo(jogo));
    }
}
