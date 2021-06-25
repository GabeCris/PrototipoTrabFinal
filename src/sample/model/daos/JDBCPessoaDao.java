package sample.model.daos;

import sample.model.FabricaConexoes;
import sample.model.Pessoa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPessoaDao implements PessoaDao{

    private FabricaConexoes fabricaConexoes;

    public JDBCPessoaDao(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public boolean cadastrar(Pessoa p) throws SQLException {
        Connection conn = fabricaConexoes.getConnection();

        String sql = "INSERT INTO users(nome, senha) VALUES(?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, p.getNome());
        pstmt.setString(2,p.getSenha());

        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return true;
    }
}
