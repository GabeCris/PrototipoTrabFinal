package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.Main;
import sample.model.daos.PessoaDao;

public class JanelaTutorial {

    @FXML
    protected void menu(ActionEvent e){
        Main.mudaCena(Main.MENU, (aClass) -> new JanelaMain());
    }
}
