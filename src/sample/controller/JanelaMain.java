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

    private String name;

    private PessoaDao pessoaDao;
    private JanelaCadastro janelaCadastro;

    public JanelaMain(PessoaDao pessoaDao){
        this.pessoaDao = pessoaDao;
    }

    public JanelaMain(){

    }

    public void initialize(){
        if(JanelaCadastro.flag == 0){
            name = JanelaLogin.nome;
            btPerfil.setText(name);
        }

        else{
            name = JanelaCadastro.name;
            btPerfil.setText(name);
        }
        JanelaCadastro.flag = 0;

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
