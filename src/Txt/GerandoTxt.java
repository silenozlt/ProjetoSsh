/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Txt;

/**
 *
 * @author Cassio
 */
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class GerandoTxt {
    public static void main(String[] args) throws IOException {
        //Conteudo inicial.
        String conteudo = "Linha Codigo\n//Comentario"; //conteudo inicial

        //Obtem um path para cada um dos 3 arquivos (inicial ,comentarios e txt do codigo
        Path arquivoInicial = Paths.get("arquivoInicial.txt");
        Path arquivoComentarios = Paths.get("arquivoComentarios.txt");
        Path arquivoCodigo = Paths.get("arquivoCodigo.txt");

        //Escreve o conteudo inicial
        Files.write(arquivoInicial, conteudo.getBytes());

        //Chama a funcao de fitro, pasando o arquivo Origem e os arquivos de destino.
        filtrarComentarios(arquivoInicial, arquivoComentarios, arquivoCodigo);
    }

    /**
     * Filtra o codigo de um arquivo, separando em código e comentarios.
     */
    public static void filtrarComentarios(Path arquivoInicial, Path arquivoComentarios, Path arquivoCodigo) throws IOException {
        //Cria duas listas para armazenar o codigo e comentarios.
        List<String> comentarios = new ArrayList<>();
        List<String> codigo = new ArrayList<>();

        //Itera todas as linhas do arquivoInicial, o método readAllLines de Files retorna uma Lista
        //de String que denota as linhas do arquivo.
        for (String linha : Files.readAllLines(arquivoInicial, StandardCharsets.UTF_8)) {
            //Utiliza o método trim() para que qualquer comentario seja detectado, o método trim() remove todo whitespace(espaco, tabs) do inicio e fim da String.
            if (linha.trim().startsWith("//")) {
                comentarios.add(linha);
            } else {
                codigo.add(linha);
            }
        }

        //Escreve o resultado em cada arquivo.
        Files.write(arquivoComentarios, comentarios);
        Files.write(arquivoCodigo, codigo);
    }
}