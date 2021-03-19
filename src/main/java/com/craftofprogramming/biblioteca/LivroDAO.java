package com.craftofprogramming.biblioteca;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Parses each line of a csv file containing a list of books onto a Book object and runs
 * a simple query against it.
 */
public class LivroDAO {

    public static Path DEFAULT_PATH = Paths.get("src/main/resources/books.csv");
    private List<Livro> biblioteca = new ArrayList<>();

    public List<Livro> obtemListaDeLivrosComputacaoOrganizadaPorTitulo() {
        return biblioteca.stream()
                .filter(b -> b.topico() == Topico.COMPUTACAO)
                .sorted(Comparator.comparing(Livro::titulo))
                .collect(Collectors.toList());
    }

    public Optional<Topico> topicoMaisPopular() {
        return biblioteca.stream()
                .collect(Collectors.groupingBy(Livro::topico, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public Livro obtemLivroComTitulo(String title) {
        for (Livro livro : biblioteca) {
            if (livro.titulo().equals(title)) {
                return livro;
            }
        }
        return null;
    }

    public List<String> obtemTitulosDosLivros() {
        return biblioteca.stream()
                .map(Livro::titulo)
                .collect(Collectors.toList());
    }

    public Map<Topico, List<Livro>> livrosAgrupadosPorTopico() {
        return biblioteca.stream()
                .collect(Collectors.groupingBy(Livro::topico));
    }

    public Map<Topico, Long> contagemDeLivrosPorTopico() {
        return biblioteca.stream()
                .collect(Collectors.groupingBy(Livro::topico, Collectors.counting()));
    }

    public void carregaBiblioteca(Path caminho) {
        this.biblioteca = Utils.carregaBiblioteca(caminho);
    }

    public List<Livro> obtemBiblioteca() {
        return Collections.unmodifiableList(biblioteca);
    }

    public static void main(String[] args) {
        final LivroDAO livroDAO = new LivroDAO();
        livroDAO.carregaBiblioteca(DEFAULT_PATH);
    }

    public int contagemDosLivros() {
        return biblioteca.size();
    }

    public void adiciona(Livro livro) {
        this.biblioteca.add(livro);
    }
}
