package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.Main;


public class JanelaMain {

    @FXML
    protected void game(ActionEvent e){
       Main.mudaCena(Main.JANELAOPCOES, (aClass)-> new JanelaOpcoes());

    }

    @FXML
    protected void tutorial(ActionEvent e){
        Main.mudaCena(Main.JANELATUTORIAL, (aClass)-> new JanelaTutorial());
    }

    @FXML
    protected void deslogar(ActionEvent e){
        Main.mudaCena(Main.JANELALOGIN, (aClass)-> new JanelaLogin());

    }

}
