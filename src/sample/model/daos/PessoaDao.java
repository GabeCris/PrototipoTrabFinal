package sample.model.daos;

import sample.model.Pessoa;

import java.sql.SQLException;

public interface PessoaDao {
    
    boolean cadastrar(Pessoa p) throws SQLException;
}
