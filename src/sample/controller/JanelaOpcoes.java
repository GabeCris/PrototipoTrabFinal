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
    public RadioButton redP1;

    @FXML
    public RadioButton greenP1;

    @FXML
    public RadioButton yellowP1;

    @FXML
    public RadioButton purpleP1;

    @FXML
    public RadioButton grayP1;

    @FXML
    public RadioButton redP2;

    @FXML
    public RadioButton greenP2;

    @FXML
    public RadioButton yellowP2;

    @FXML
    public RadioButton purpleP2;

    @FXML
    public RadioButton grayP2;


    @FXML
    public ToggleGroup pecaP1;

    @FXML
    public TextArea nomeP1;

    @FXML
    public TextArea nomeP2;

    @FXML
    public Button jogar;

    @FXML
    public Button mainmenu;

    private String nomePLayer1;
    private String nomePLayer2;

    private Color[] cores = {Color.RED, Color.GREEN, Color.YELLOW, Color.PURPLE, Color.GRAY};

    private Jogador jogador1;
    private Jogador jogador2;
    private JanelaJogo janelaJogo;

    public Jogo jogo;

    public JanelaOpcoes(){
        this.jogador1 = new Jogador();
        this.jogador2 = new Jogador();
        this.jogo = new Jogo(jogador1, jogador2);

    }

    public void clicou(MouseEvent event){
        mainmenu.getStyleClass().add("fundoBotao");
        jogar.getStyleClass().add("fundoBotao");
    }

    @FXML
    protected void menu(ActionEvent e){
        jogar.setOnMouseClicked((evt)->clicou(evt));
        Main.mudaCena(Main.MENU, (aClass) -> new JanelaMain());
    }


    @FXML
    public void jogo(ActionEvent e){
        pecaPlayer1();
        pecaPlayer2();
        Main.mudaCena(Main.JANELAJOGO, (aClass) -> new JanelaJogo(jogo));
    }

    public void pecaPlayer1(){


        int opcao =0;

        nomePLayer1 = nomeP1.getText();


       // System.out.println("Nome P1 "+nomePLayer1);


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
        jogador1.setNome(nomePLayer1);


    }

    public void pecaPlayer2(){

        int opcao =0;

        nomePLayer2 = nomeP2.getText();
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
        jogador2.setNome(nomePLayer2);
    }
}
