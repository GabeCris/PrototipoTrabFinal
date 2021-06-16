package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.Main;


public class JanelaMain {

    @FXML
    protected void click(ActionEvent e){
       Main.mudaCena(Main.JANELAOPCOES, (aClass)-> new JanelaOpcoes());

    }
}
