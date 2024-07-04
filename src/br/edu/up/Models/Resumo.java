package br.edu.up.Models;

public class Resumo {

    private int quantidadeDeAlunos;
    private int quantosForamAprovados;
    private int quantosForamReprovados;
    private float menorNotaDaTurma;
    private float maiorNota;
    private float mediaGeral;

    public Resumo() {
    }

    public Resumo(int quantidadeDeAlunos, int quantosForamAprovados, int quantosForamReprovados, float menorNotaDaTurma,
            float maiorNota, float mediaGeral) {
        this.quantidadeDeAlunos = quantidadeDeAlunos;
        this.quantosForamAprovados = quantosForamAprovados;
        this.quantosForamReprovados = quantosForamReprovados;
        this.menorNotaDaTurma = menorNotaDaTurma;
        this.maiorNota = maiorNota;
        this.mediaGeral = mediaGeral;
    }

    public int getQuantidadeDeAlunos() {
        return quantidadeDeAlunos;
    }

    public void setQuantidadeDeAlunos(int quantidadeDeAlunos) {
        this.quantidadeDeAlunos = quantidadeDeAlunos;
    }

    public int getQuantosForamAprovados() {
        return quantosForamAprovados;
    }

    public void setQuantosForamAprovados(int quantosForamAprovados) {
        this.quantosForamAprovados = quantosForamAprovados;
    }

    public int getQuantosForamReprovados() {
        return quantosForamReprovados;
    }

    public void setQuantosForamReprovados(int quantosForamReprovados) {
        this.quantosForamReprovados = quantosForamReprovados;
    }

    public float getMenorNotaDaTurma() {
        return menorNotaDaTurma;
    }

    public void setMenorNotaDaTurma(float menorNotaDaTurma) {
        this.menorNotaDaTurma = menorNotaDaTurma;
    }

    public float getMaiorNota() {
        return maiorNota;
    }

    public void setMaiorNota(float maiorNota) {
        this.maiorNota = maiorNota;
    }

    public float getMediaGeral() {
        return mediaGeral;
    }

    public void setMediaGeral(float mediaGeral) {
        this.mediaGeral = mediaGeral;
    }

    public String toCSV() {
        return quantidadeDeAlunos + ";" + quantosForamAprovados + ";" + quantosForamReprovados + ";" + menorNotaDaTurma + ";" + maiorNota + ";" + mediaGeral;
    }
    
}