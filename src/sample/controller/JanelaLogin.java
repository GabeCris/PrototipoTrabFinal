package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import sample.AuthService;
import sample.Main;
import sample.model.daos.PessoaDao;

import java.awt.*;
import java.sql.SQLException;

import static sample.Main.*;

public class JanelaLogin {

    @FXML
    private TextField tfUser;

    @FXML
    private PasswordField pfSenha;

    private PessoaDao pessoaDao;
    private AuthService authService;

    private DialogPane dialog;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void initialize(){
        dialogSet();
    }

    public JanelaLogin(AuthService authService){
        this.authService = authService;
    }

    @FXML
    private void entrar(){
        String username = tfUser.getText();
        String password = pfSenha.getText();

        try {
            if(authService.login(username, password)){
                Main.carregaPrincipal();
                return;
            }
        }catch (SQLException e){
            e.getMessage();
        }

        alert.setTitle("ERROR");
        alert.setHeaderText("Login inválido!");
        alert.setContentText("Usuário ou senha inválidos");
        alert.showAndWait();
    }

    private void dialogSet(){
        alert.setTitle("ERROR");
        dialog = alert.getDialogPane();
        dialog.getStylesheets().add(getClass().getResource("/css/interface.css").toString());
        dialog.getStyleClass().add("alerta");
    }

    @FXML
    protected void cadastrar(ActionEvent e){

        Main.carregaCadastro();
    }



}
