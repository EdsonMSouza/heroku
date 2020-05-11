package utils;

// importação das classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @file DBConnection.java
 * @brief Classe que realiza conexões do tipo Singleton com o banco de dados
 * @author Edson Melo de Souza
 * @date 20/03/2020
 *
 */
public class DBConnection {

    // configurações para conexão com o bando de dados MySQL
    private final String driver = "org.postgresql.Driver";
    private final String url = "postgres://ahqpdcbcqvjwwj:f8e8ea6b7d7efd1a48f611c6b39093f1b26c9fdf16e86afcd4b04abc9f7ff7ba@ec2-3-222-150-253.compute-1.amazonaws.com:5432/d1piqegafp6643";

    // credenciais de acesso
    private final String usuario = "ahqpdcbcqvjwwj";
    private final String senha = "f8e8ea6b7d7efd1a48f611c6b39093f1b26c9fdf16e86afcd4b04abc9f7ff7ba";

    // variável para armazenar a conexão com o banco de dados
    private static DBConnection conexao = null;

    /**
     * Método que prepara a configuração para a conexão
     *
     * @throws SQLException
     */
    private DBConnection() throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new SQLException("driver");
        }
    }

    /**
     * Realiza a conexão, caso tenha sucesso
     *
     * @return Connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return conn;
    }

    /**
     * Retorna uma instância da conexão para utilização (Singleton)
     *
     * @return Connection
     * @throws SQLException
     */
    public static DBConnection getInstance() throws SQLException {
        if (conexao == null) {
            conexao = new DBConnection();
        }
        return conexao;
    }
}
