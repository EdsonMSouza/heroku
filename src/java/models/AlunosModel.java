package models;

import beans.Aluno;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnection;

/**
 *
 * @author Edson Melo de Souza
 * @date 30/03/2020
 *
 * Métodos da classe: inserir, listar, pesquisar, atualizar, excluir
 *
 */
public class AlunosModel implements Serializable {

    // Declaração das variáveis globais
    private Connection conexao = null;
    private String status;

    // Método construtor da classe
    // Método que é executado toda vez que a classe é instanciada
    public AlunosModel() throws SQLException {
        // retorna uma conexão na instância da classe
        this.conexao = DBConnection.getInstance().getConnection();
    }

    /**
     *
     * @param aluno
     * @return
     */
    public List<Aluno> pesquisar(Aluno aluno) {
        List<Aluno> alunos = new ArrayList<>();
        PreparedStatement ps;
        try {

            if (aluno.getRa() != 0) {
                String sql = "SELECT * FROM alunos WHERE ra = ?";
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, aluno.getRa());
            } else {
                String sql = "SELECT * FROM alunos WHERE nome = ?";
                ps = conexao.prepareStatement(sql);
                ps.setString(1, aluno.getNome());
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setRa(rs.getInt("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCurso(rs.getString("curso"));

                alunos.add(aluno);
            }
            return alunos;
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao listar os alunos.", ex);
        }
    }

    /**
     * Método listar() Retorna todos os alunos cadastrados no banco de dados
     *
     * @return List (Aluno)
     */
    public List<Aluno> listar() {
        // variável para receber a lista de objetos Aluno()
        List<Aluno> alunos = new ArrayList<>();

        // prevenindo erros (tratamento de erro)
        try {
            String sql = "SELECT * FROM alunos ORDER BY nome;";

            // tratando erros de conexão
            try (
                    // prepara a instrução SQL para er executada no banco
                    PreparedStatement ps = conexao.prepareStatement(sql);
                    // recuperando os dados enviados pelo banco
                    ResultSet rs = ps.executeQuery()) {

                // percorrendo os dados que foram retornados do banco
                while (rs.next()) {
                    // cria um objeto Aluno() a cada iteração, ou seja,
                    // a cada linha lida do conjunto de dados (rs)
                    Aluno aluno = new Aluno();

                    // atribuir os dados para o objeto Aluno()
                    aluno.setId(rs.getInt("id"));
                    aluno.setRa(rs.getInt("ra"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCurso(rs.getString("curso"));

                    // coloca o objeto criado e populado na lista
                    // de objetos "alunos"
                    alunos.add(aluno);
                }
            }
            // o método retorna a lista de alunos (caso exista(m))
            return alunos;

            // se ocorrer algum erro, será enviada uma mensagem que deverá
            // ser tratada posteriormente no AlunosController
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao listar os alunos.", ex);
        }
    }

    /**
     * Método para inserir um novo aluno(a)
     *
     * @param Aluno
     */
    public void inserir(Aluno aluno) {
        try {
            String sql
                    = "INSERT INTO alunos (id, ra, nome, curso) "
                    + "VALUES (DAFAULT, ?, ?, ?)";

            // prepara a construção do SQL
            PreparedStatement ps = conexao.prepareStatement(sql);

            // atribuir os valores por meio da associação (?)
            ps.setInt(1, aluno.getRa());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getCurso());

            // Executar o SQL para inserir no banco
            ps.execute();

            // Fecha a aconexão
            ps.close();
            conexao.close();

            this.status
                    = "O aluno [" + aluno.getNome()
                    + " ]inserido com sucesso!!!";

        } catch (SQLException ex) {
            this.status
                    = "Erro ao inserir o aluno [" + ex.getMessage() + "]";
        }
    }

    public void atualizar(Aluno aluno) {
        try {
            String sql = "UPDATE alunos SET "
                    + "nome = ?, curso = ? "
                    + "WHERE ra = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            // atribuir os valores para a atualização
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCurso());
            ps.setInt(3, aluno.getRa());
            // executar o comando para efetuar a atualização
            ps.executeUpdate();
            // fecha o ps
            ps.close();
            // fecha a conexão com o banco
            conexao.close();
            status = "Atualizado com sucesso!!!";
        } catch (SQLException ex) {
            status = "Erro ao atualizar.";
        }
    }

    public void excluir(Aluno aluno) {
        try {
            String sql = "DELETE FROM alunos WHERE ra = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, aluno.getRa());
            ps.execute();
            ps.close();
            conexao.close();
            this.status = "Aluno excluído com sucesso!!!";

        } catch (SQLException ex) {
            this.status = "Erro ao excluir [" + ex.getMessage() + "]";
        }
    }

    public String toString() {
        return status;
    }
}
