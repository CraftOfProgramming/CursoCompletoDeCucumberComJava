package com.craftofprogramming.biblioteca;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Livro {
    private final String titulo;
    private final int nrDePaginas;
    private final Topico topico;
    private final Year dataPublicacao;
    private final List<String> autores;

    public Livro(String titulo, int nrDePaginas, Topico topico, Year dataPublicacao, String... autores) {
        this.titulo = titulo;
        this.nrDePaginas = nrDePaginas;
        this.topico = topico;
        this.dataPublicacao = dataPublicacao;
        this.autores = Arrays.asList(autores);
    }

    public String titulo() {
        return titulo;
    }

    public int nrDePaginas() {
        return nrDePaginas;
    }

    public Topico topico() {
        return topico;
    }

    public Year dataPublicacao() {
        return dataPublicacao;
    }

    public List<String> autores() {
        return autores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nrDePaginas == livro.nrDePaginas &&
                titulo.equals(livro.titulo) &&
                topico == livro.topico &&
                dataPublicacao.equals(livro.dataPublicacao) &&
                autores.equals(livro.autores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, nrDePaginas, topico, dataPublicacao, autores);
    }

    @Override
    public String toString() {
        return "Book{" +
                "titulo='" + titulo + '\'' +
                ", nrDePaginas=" + nrDePaginas +
                ", topico=" + topico +
                ", dataPublicacao=" + dataPublicacao +
                ", autores=" + autores +
                '}';
    }
}
