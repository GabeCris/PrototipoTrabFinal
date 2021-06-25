package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.AuthService;
import sample.Main;
import sample.model.Pessoa;
import sample.model.daos.JDBCPessoaDao;
import sample.model.daos.PessoaDao;

import java.sql.SQLException;

import static sample.Main.*;

public class JanelaCadastro {

    @FXML
    private TextField tfNome;

    @FXML
    private PasswordField pfUM;

    @FXML
    private PasswordField pfDOIS;

    private DialogPane dialog;

    public static int flag = 0;
    public static String name;


    private int auxS = 0;
    private int auxL = 0;

    private PessoaDao pessoaDao;
    private AuthService authService;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public JanelaCadastro(PessoaDao pessoaDao){
       this.pessoaDao = pessoaDao;
    }

    public void initialize(){
        dialogSet();
    }


    @FXML
    protected void cancelar(){
        Main.carregaLogin();
    }

    @FXML
    private void cadastrar(){
        verificaLogin();
        verificaSenha();

        String nome = tfNome.getText();
        String senha = pfUM.getText();

        if (auxS == 1 && auxL == 1){
            Pessoa p = new Pessoa(nome, senha);
            try {
                if(pessoaDao.cadastrar(p)){
                    System.out.println("Cadastrado no banco!");
                    alert.setTitle("OKAY");
                    alert.setHeaderText("Cadastrado com sucesso!");
                    alert.setContentText(nome+" foi cadastrado no sistema");
                    alert.showAndWait();
                    flag = 1;
                    name = nome;
                    mudaCena(MENU, (aClass)-> new JanelaMain(pessoaDao));
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }

    }

    private void verificaLogin(){
        String nome = tfNome.getText();

        if(nome.length() >3 && nome.length() < 23){
            auxL = 1;
        }

        else{
            alert.setHeaderText("Nome inválido!");
            alert.setContentText("Informe nome de 4 a 22 caracteres");
            alert.showAndWait();
            tfNome.setText("");

            auxL = 0;
        }

    }

    private void verificaSenha(){
        String senha1 = pfUM.getText();
        String senha2 = pfDOIS.getText();

        if(senha1.equals(senha2)){
            auxS = 1;
        }

        else{
            alert.setHeaderText("Senhas inválidas!");
            alert.setContentText("Informe senhas que correspondem");
            alert.showAndWait();
            pfUM.setText("");
            pfDOIS.setText("");

            auxS = 0;
        }
    }

    private void dialogSet(){
        alert.setTitle("ERROR");
        dialog = alert.getDialogPane();
        dialog.getStylesheets().add(getClass().getResource("/css/interface.css").toString());
        dialog.getStyleClass().add("alerta");
    }


}
