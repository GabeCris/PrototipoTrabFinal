package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import static sample.Main.*;

public class JanelaCadastro {

    @FXML
    protected void cancelar(ActionEvent e){
        mudaCena(JANELALOGIN, (aClass)-> new JanelaLogin());
    }

    @FXML
    protected void cadastrar(ActionEvent e){
        mudaCena(MENU, (aClass)-> new JanelaMain());
    }


}
