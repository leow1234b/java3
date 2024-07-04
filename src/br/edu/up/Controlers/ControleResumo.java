package br.edu.up.Controlers;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.Daos.GerenciadorDeAlunos;
import br.edu.up.Daos.GerenciadorDeResumo;
import br.edu.up.Models.Alunos;
import br.edu.up.Models.Resumo;
import br.edu.up.Utils.Prompt;

public class ControleResumo {

    private List<Alunos> alunos = new ArrayList<>();
    private List<Resumo> resumos = new ArrayList<>();
    private GerenciadorDeAlunos daoAlunos = new GerenciadorDeAlunos();
    private GerenciadorDeResumo daoResumos = new GerenciadorDeResumo();

    private int quantidadeDeAlunos = 0;
    private int quantosForamAprovados = 0;
    private int quantosForamReprovados = 0;
    private float menorNotaDaTurma = 10;
    private float maiorNota = 0;
    private float mediaGeral = 0;

    private float notaTotal = 0;

    private boolean deBug = true;

    public void Programa(){

        alunos = daoAlunos.getAlunos();

        resumos = daoResumos.getResumos();

        if (deBug==true) {
            Prompt.imprimir(listarAlunos());
        }

        for (Alunos aluno : alunos) {

            if (aluno.getMatricula() > 0) {
                quantidadeDeAlunos++;
            }
            
        }

        for (Alunos aluno : alunos) {

            notaTotal+=aluno.getNota();
            
        }

        mediaGeral=(notaTotal/quantidadeDeAlunos);

        for (Alunos aluno : alunos) {

            if (aluno.getNota()<menorNotaDaTurma) {
                menorNotaDaTurma=aluno.getNota();
            } 
            
        }

        for (Alunos aluno : alunos) {

            if (aluno.getNota()>maiorNota) {
                maiorNota=aluno.getNota();
            } 
            
        }

        for (Alunos aluno : alunos) {

            if (aluno.getNota() >= 6) {
                quantosForamAprovados++;
            }else{
                quantosForamReprovados++;
            }
            
        }

        Resumo resumo = new Resumo(quantidadeDeAlunos, quantosForamAprovados, quantosForamReprovados, menorNotaDaTurma, maiorNota, mediaGeral);

        Prompt.imprimir(addResumo(resumo));

        if (deBug==true) {
            Prompt.imprimir(listarResumo());
        }

    }

    public String addResumo(Resumo resumo){

        resumos.add(resumo);
        daoResumos.gravarArquivo();
        return "resumo gerado com sucesso";

    }

    public String listarAlunos(){

        StringBuilder listarAlunos = new StringBuilder();

        if (alunos.isEmpty()) {
            return "Nenhum locação cadastrado";
        }

        for (Alunos aluno : alunos) {

            listarAlunos.append("Matricula: ")
                          .append(aluno.getMatricula())
                          .append(", Nome: ")
                          .append(aluno.getNome())
                          .append(", Nota: ")
                          .append(aluno.getNota())
                          .append("\n");

        }

        return listarAlunos.toString();

    }

    public String listarResumo(){

        StringBuilder listarResumo = new StringBuilder();

        if (resumos.isEmpty()) {
            return "Nenhum locação cadastrado";
        }

        for (Resumo resumo : resumos) {

            listarResumo.append("quantidadeDeAlunos: ")
                          .append(resumo.getQuantidadeDeAlunos())
                          .append(", quantosForamAprovados: ")
                          .append(resumo.getQuantosForamAprovados())
                          .append(", quantosForamReprovados: ")
                          .append(resumo.getQuantosForamReprovados())
                          .append(", menorNotaDaTurma: ")
                          .append(resumo.getMenorNotaDaTurma())
                          .append(", maiorNota: ")
                          .append(resumo.getMaiorNota())
                          .append(", mediaGeral: ")
                          .append(resumo.getMediaGeral())
                          .append("\n");

        }

        return listarResumo.toString();

    }
    
    
}