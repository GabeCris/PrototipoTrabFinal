package sample.model.daos;

import sample.model.Pessoa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPessoaDao implements PessoaDao{

    @Override
    public boolean cadastrar(Pessoa p) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:pessoas.sqlite");
        String sql = "INSERT INTO pessoas(nome, senha) VALUES(?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, p.getNome());
        pstmt.setString(2,p.getSenha());

        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return true;
    }
}
