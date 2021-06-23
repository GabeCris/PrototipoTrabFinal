package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.Main;
import sample.model.daos.PessoaDao;


public class JanelaMain {

    private PessoaDao pessoaDao;

    public JanelaMain(PessoaDao pessoaDao){
        this.pessoaDao = pessoaDao;
    }

    public JanelaMain(){

    }


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
       Main.carregaLogin();

    }

}
