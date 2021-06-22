package sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {

    private static final Integer MAX_CON = 5;
    private static final String URL = "jdbc:sqlite:pessoas.sqlite";

    private Connection[] conexoes;

    public FabricaConexoes(){
        conexoes = new Connection[MAX_CON];
    }

    public Connection getConnection() throws SQLException{
        for (int i =0; i< conexoes.length;i++){
            if(conexoes[i] == null || conexoes[i].isClosed()){
                conexoes[i] = DriverManager.getConnection(URL);
                return conexoes[i];
            }
        }
        throw new SQLException("Sem conexoes possiveis");
    }
}
