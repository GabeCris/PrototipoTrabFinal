package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.model.daos.PessoaDao;

import static sample.Main.*;

public class JanelaLogin {

    private PessoaDao pessoaDao;

    public JanelaLogin(PessoaDao pessoaDao){
        this.pessoaDao = pessoaDao;
    }

    @FXML
    protected void entrar(ActionEvent e){
        mudaCena(MENU, (aClass)-> new JanelaMain(pessoaDao));
    }

    @FXML
    protected void cadastrar(ActionEvent e){
        mudaCena(JANELACADASTRO, (aClass)-> new JanelaCadastro(pessoaDao));
    }



}
