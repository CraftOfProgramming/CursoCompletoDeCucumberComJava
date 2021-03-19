package com.craftofprogramming.biblioteca;

import io.cucumber.java.DataTableType;
import io.cucumber.java.DocStringType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DefinicaoPassosComArgumentos {

    @DataTableType
    public Livro definicaoLivro(Map<String, String> entrada) {
        return new Livro(
                entrada.get("titulo"),
                Integer.parseInt(entrada.get("Numero de Paginas").trim()),
                Topico.valueOf(entrada.get("Topico").trim()),
                Year.parse(entrada.get("Data de Publicacao").trim()),
                entrada.get("Autores"));
    }

    @DocStringType(contentType = "lista_de_livros")
    public List<Livro> definicaoDeListaDeLivros(String docString) {
        List<Livro> livros = new ArrayList<>();
        Arrays.stream(docString.split("\\n")).forEach(e->{
            final String[] split = e.split(",");
            livros.add(new Livro(
                    split[0].trim(),
                    Integer.parseInt(split[1].trim()),
                    Topico.valueOf(split[2].trim()),
                    Year.parse(split[3].trim()),
                    split[4].trim()
            ));
        });
        return livros;
    }

    @E("a seguinte tabela de livros:")
    public void aSeguinteTabelaDeLivros(List<Livro> livros) {
        final ServicoDeBiblioteca biblioteca = ContextoDeTeste.INSTANCIA.biblioteca();
        livros.forEach(livro -> biblioteca.adiciona(livro));
    }

    @E("a seguinte lista de livros:")
    public void aSeguinteListaDeLivros(List<Livro> livros) {
        final ServicoDeBiblioteca biblioteca = ContextoDeTeste.INSTANCIA.biblioteca();
        livros.forEach(livro -> biblioteca.adiciona(livro));
    }

    @ParameterType(".*")
    public Livro livro(String descricaoLivro) {
        final String[] split = descricaoLivro.split(",");
        return new Livro(
                split[0].trim(),
                Integer.parseInt(split[1].trim()),
                Topico.valueOf(split[2].trim()),
                Year.parse(split[3].trim()),
                split[4].trim()
        );
    }

    @ParameterType("COMPUTACAO|SCI_FI|FINANCAS|ROMANCE")
    public Topico Topico(String topico) {
        return Topico.valueOf(topico);
    }

    @Quando("Eu adiciono o livro {livro}")
    public void euAdicionoOLivro(Livro livro) {
        ContextoDeTeste.INSTANCIA.biblioteca().adiciona(livro);
    }
}
