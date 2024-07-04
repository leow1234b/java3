package br.edu.up.Daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Alunos;

public class GerenciadorDeAlunos {

    private String header = "matricula;nome;nota";

    private String nomeDoArquivo = "src/br/edu/up/Daos/csvs/alunos.csv";

    List<Alunos> listaDeAlunos = new ArrayList<>();

    public List<Alunos> getAlunos() {

        try {

            File arquivoLeitura = new File(nomeDoArquivo);

            Scanner leitor = new Scanner(arquivoLeitura);

            if (leitor.hasNextLine()) {
                header = leitor.nextLine();
            }

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                int matricula = Integer.parseInt(dados[0]);
                String nome = dados[1];
                float nota = Float.parseFloat(dados[2].replace(',', '.'));

                Alunos aluno = new Alunos(matricula, nome, nota);
                listaDeAlunos.add(aluno);
            }
            leitor.close();

        } catch(Exception e){
            System.out.println("Arquivo Alunos não encontrado!");
        }

        return listaDeAlunos;

    }

    public void gravarArquivo() {

        try {

            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (Alunos alunos : listaDeAlunos) {
                gravador.println(alunos.toCSV());
            }

            gravador.close();

        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }
    
}