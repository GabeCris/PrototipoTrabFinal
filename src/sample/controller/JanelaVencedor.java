package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import sample.Main;
import sample.model.Jogo;


public class JanelaVencedor{

    @FXML
    private Text txtVencedor;

    private Jogo jogo;
    public JanelaVencedor(Jogo jogo) {
        this.jogo = jogo;
       // mudaVencedor();
    }



    private void mudaVencedor(){

        System.out.println("BBBBBBBBBB"+jogo.teste());
        System.out.println("MOSTROU O VENCEDOR");
        try {
            String nome;

            nome = jogo.nomeVencedor();
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+nome);
            //txtVencedor.setText(jogo.vencedor);
        }
        catch (NullPointerException e){
            System.out.println("DEU ERRO AQUI");
        }
    }




    @FXML
    protected void menu(ActionEvent e){
        System.out.println("AAAAAAAA FAFA");
        Main.mudaCena(Main.MENU, (aClass)-> new JanelaMain());

    }

    @FXML
    private void game(ActionEvent e){
        Main.mudaCena(Main.JANELAJOGO, (aClass) -> new JanelaJogo(jogo));
        System.out.println("AAAAAAAA FAFA");
    }
}
