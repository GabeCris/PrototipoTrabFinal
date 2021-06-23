package sample.model.daos;

import sample.model.FabricaConexoes;
import sample.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUserDao implements UserDao{

    private FabricaConexoes fabricaConexoes;

    public JDBCUserDao(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    public User login(String username, String password) throws SQLException{
        User user = null;

        Connection conn = fabricaConexoes.getConnection();
        String sql = "SELECT * FROM pessoas WHERE nome=? and senha=?";
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, username);
        pstm.setString(2, password);

        ResultSet rs = pstm.executeQuery();

        if(rs.next()){
            int id = rs.getInt("id");
            user = new User(id,username);
        }

        rs.close();
        pstm.close();
        conn.close();
        return user;
    }

}
