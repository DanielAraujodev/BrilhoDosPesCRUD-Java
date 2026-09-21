package br.brilhodospes.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL = "jdbc:h2:mem:estoque_db;DB_CLOSE_DELAY=-1;"
            + "INIT=CREATE TABLE IF NOT EXISTS produtos ("
            + "id INT AUTO_INCREMENT PRIMARY KEY, "
            + "nome VARCHAR(100) NOT NULL, "
            + "tamanho INT NOT NULL, "
            + "cor VARCHAR(50), "
            + "preco DOUBLE NOT NULL, "
            + "quantidade INT NOT NULL)";

    private static final String USER = "sa";
    private static final String PASS = "";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
