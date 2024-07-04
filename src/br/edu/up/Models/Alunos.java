package br.edu.up.Models;

public class Alunos {

    private int matricula;
    private String nome;
    private float nota;
    
    public Alunos() {
    }

    public Alunos(int matricula, String nome, float nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String toCSV() {
        return matricula + ";" + nome + ";" + nota;
    }
     
}