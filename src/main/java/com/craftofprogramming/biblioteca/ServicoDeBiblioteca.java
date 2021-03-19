package com.craftofprogramming.biblioteca;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ServicoDeBiblioteca {

    public static ServicoDeBiblioteca obtemServico() {
        return new ImplementacaoServicoDeBiblioteca(true);
    }

    public static ServicoDeBiblioteca obtemServico(boolean carregaBibioteca) {
        return new ImplementacaoServicoDeBiblioteca(carregaBibioteca);
    }

    Livro pesquisaLivroPorTitulo(String titulo);

    List<Livro> pesquisaLivrosDeComputacaoAgrupadosPorTitulo();

    Optional<Topico> topicoMaisPopular();

    List<String> pesquisaTitulosDosLivros();

    Map<Topico, List<Livro>> livrosAgrupadosPorTopico();

    Map<Topico, Long> contagemDosLivrosPorTopico();

    int contagemDosLivros();

    void adiciona(Livro livro);
}
