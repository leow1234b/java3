package br.edu.up.Daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Resumo;

public class GerenciadorDeResumo {

    private String header = "quantidadeDeAlunos;quantosForamAprovados;quantosForamReprovados;menorNotaDaTurma;maiorNota;mediaGeral";

    private String nomeDoArquivo = "src/br/edu/up/Daos/csvs/resumo.csv";

    List<Resumo> listaDeResumos = new ArrayList<>();

    public List<Resumo> getResumos() {

        try {

            File arquivoLeitura = new File(nomeDoArquivo);

            Scanner leitor = new Scanner(arquivoLeitura);

            if (leitor.hasNextLine()) {
                header = leitor.nextLine();
            }

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                int quantidadeDeAlunos = Integer.parseInt(dados[0]);
                int quantosForamAprovados = Integer.parseInt(dados[1]);
                int quantosForamReprovados = Integer.parseInt(dados[2]);
                float menorNotaDaTurma = Float.parseFloat(dados[3]);
                float maiorNota = Float.parseFloat(dados[4]);
                float mediaGeral = Float.parseFloat(dados[5]);

                Resumo resumo = new Resumo(quantidadeDeAlunos, quantosForamAprovados, quantosForamReprovados, menorNotaDaTurma, maiorNota, mediaGeral);
                listaDeResumos.add(resumo);
            }
            leitor.close();

        } catch(Exception e){
            System.out.println("Arquivo Resumo não encontrado!");
        }

        return listaDeResumos;

    }

    public void gravarArquivo() {

        try {

            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (Resumo resumo : listaDeResumos) {
                gravador.println(resumo.toCSV());
            }

            gravador.close();

        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }
    
}