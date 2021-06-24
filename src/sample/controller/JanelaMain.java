package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;
import sample.model.daos.PessoaDao;

import java.awt.*;


public class JanelaMain {

    @FXML
    private Button btPerfil;

    private PessoaDao pessoaDao;
    private JanelaCadastro janelaCadastro;

    public JanelaMain(PessoaDao pessoaDao){
        this.pessoaDao = pessoaDao;
    }

    public JanelaMain(){

    }

   /* public void initialize(){
        String text;
        text = janelaCadastro.retornaNome();

        System.out.println("O NOME DELE É "+text);
    }*/

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
