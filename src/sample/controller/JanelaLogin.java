package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import static sample.Main.*;

public class JanelaLogin {

    @FXML
    protected void entrar(ActionEvent e){
        mudaCena(MENU, (aClass)-> new JanelaMain());
    }

    @FXML
    protected void cadastrar(ActionEvent e){
        mudaCena(JANELACADASTRO, (aClass)-> new JanelaCadastro());
    }



}
