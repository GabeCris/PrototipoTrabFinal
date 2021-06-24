package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sample.Main;
import sample.model.Jogador;
import sample.model.Jogo;


public class JanelaOpcoes {

    @FXML
    private RadioButton redP1;

    @FXML
    private RadioButton greenP1;

    @FXML
    private RadioButton yellowP1;

    @FXML
    private RadioButton purpleP1;

    @FXML
    private RadioButton grayP1;

    @FXML
    private RadioButton redP2;

    @FXML
    private RadioButton greenP2;

    @FXML
    private RadioButton yellowP2;

    @FXML
    private RadioButton purpleP2;

    @FXML
    private RadioButton grayP2;

    @FXML
    public RadioButton rbGuia;

    public static int flag;

    private DialogPane dialog;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);



    private Color[] cores = {Color.RED, Color.GREEN, Color.YELLOW, Color.PURPLE, Color.GRAY};

    private Jogador jogador1;
    private Jogador jogador2;
    //private JanelaJogo janelaJogo;

    public Jogo jogo;

    public JanelaOpcoes(){
        this.jogador1 = new Jogador();
        this.jogador2 = new Jogador();
        this.jogo = new Jogo(jogador1, jogador2);

    }

    public void initialize(){
        dialogSet();
        rbGuia.setSelected(false);
    }

    @FXML
    protected void menu(ActionEvent e){
        Main.mudaCena(Main.MENU, (aClass) -> new JanelaMain());
    }


    @FXML
    public void jogo(ActionEvent e){
        verificaGuia();
        pecaPlayer1();
        pecaPlayer2();
        verificaPecas();
    }

    public void verificaPecas(){
        if(jogador1.getCor() == jogador2.getCor()){
            alert.setTitle("ERROR");
            alert.setHeaderText("Jogada Inválida!");
            alert.setContentText("Selecionem peças diferentes!");

            alert.showAndWait();
        }

        else{
            Main.mudaCena(Main.JANELAJOGO, (aClass) -> new JanelaJogo(jogo));
        }
    }

    public void verificaGuia(){
        if(rbGuia.isSelected()){
            flag = 1;
            System.out.println("CONTEUDO DE FLAG "+flag);
        }
        else{
            flag = 0;
            System.out.println("CONTEUDO DE FLAG "+flag);

        }

    }

    public void pecaPlayer1(){


        int opcao =0;

        if(redP1.isSelected()){
            opcao = 0;
        }

        if(greenP1.isSelected()){
            opcao = 1;
        }

        if(yellowP1.isSelected()){
            opcao = 2;
        }


        if(purpleP1.isSelected()){
            opcao = 3;
        }

        if(grayP1.isSelected()){
            opcao = 4;
        }

        jogador1.setCor(cores[opcao]);
        jogador1.setVez("1");


    }

    public void pecaPlayer2(){

        int opcao =0;

       // nomePLayer2 = nomeP2.getText();
        //System.out.println("Nome P2 "+nomePLayer2);

        if(redP2.isSelected()){
            opcao = 0;
        }

        if(greenP2.isSelected()){
            opcao = 1;
        }

        if(yellowP2.isSelected()){
            opcao = 2;
        }


        if(purpleP2.isSelected()){
            opcao = 3;
        }

        if(grayP2.isSelected()){
            opcao = 4;
        }

        jogador2.setCor(cores[opcao]);
        jogador2.setVez("2");
    }

    private void dialogSet(){
        alert.setTitle("ERROR");
        dialog = alert.getDialogPane();
        dialog.getStylesheets().add(getClass().getResource("/css/interface.css").toString());
        dialog.getStyleClass().add("alerta");
    }
}
