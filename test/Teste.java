
import beans.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.AlunosModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edson Melo de Souza
 * @date 13/04/2020
 *
 */
public class Teste {

    public static void main(String args[]) throws SQLException {
        AlunosModel alunosModel = new AlunosModel();
        // variável para receber os alunos do AlunosModel
        List<Aluno> alunos = new ArrayList();
        // recebendo os alunos enviados
        alunos = alunosModel.listar();

        // listando os alunos (laço de repetição foreach)
        for (Aluno aluno : alunos) {
            System.out.println("ID: " + aluno.getId());
            System.out.println("RA: " + aluno.getRa());
            System.out.println("NOME: " + aluno.getNome());
            System.out.println("CURSO: " + aluno.getCurso());
            System.out.println("");
        }

    }
}
