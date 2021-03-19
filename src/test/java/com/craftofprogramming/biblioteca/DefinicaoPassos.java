package com.craftofprogramming.biblioteca;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Mas;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DefinicaoPassos {

    private Livro livro;
    private Optional<Topico> topico;
    private ServicoDeBiblioteca biblioteca;

    @Dado("Que a minha biblioteca esta inicializada")
    public void queAMinhaBibliotecaEstaInicializada() {
        biblioteca = ContextoDeTeste.INSTANCIA.obtemServico(true);
    }

    @Dado("Que a minha biblioteca esta inicializada vazia")
    public void queAMinhaBibliotecaEstaInicializadaVazia() {
        biblioteca = ContextoDeTeste.INSTANCIA.obtemServico(false);
    }

    @Quando("Eu pesquiso o livro {string}")
    public void euPesquisoOLivro(String bookTitle) {
        livro = biblioteca.pesquisaLivroPorTitulo(bookTitle);
    }

    @Entao("Eu encontro esse livro")
    public void euEncontroEsseLivro() {
        Assert.assertNotNull(livro);
    }

    @Quando("Eu pesquiso o topico mais popular")
    public void euPesquisoOTopicoMaisPopular() {
        topico = biblioteca.topicoMaisPopular();
    }

    @Entao("Eu encontro o topico {Topico}")
    public void euEncontroOTopico(Topico topicoEncontrado) {
        assertEquals(topicoEncontrado, topico.get());
    }

    @E("Que o total de livros carregados e' {int}")
    public void queOTotalDeLivrosCarregadosE(int totalDeLivros) {
        assertThat(biblioteca.contagemDosLivros(), is(equalTo(totalDeLivros)));
    }

    @Mas("Eu nao encontro o topico {Topico}")
    public void euNaoEncontroOTopico(Topico topico) {
        Assert.assertNotSame(biblioteca.topicoMaisPopular()
                .get(), topico);
    }

    @Quando("Eu pesquiso o livro {string} e {Topico}")
    public void euPesquisoOLivroTituloETopico(String titulo, Topico topico) {
        final Livro livro = biblioteca.pesquisaLivroPorTitulo(titulo);
        assertNotNull(livro);
        assertEquals(topico, livro.topico());
    }

    @Entao("Eu encontro o livro com {string}")
    public void euEncontroOLivroComTitulo(String titulo) {
        final Livro livro = biblioteca.pesquisaLivroPorTitulo(titulo);
        assertNotNull(livro);
    }

    @Dado("a seguinte tabela de livros")
    public void aSeguinteTabelaDeLivros(Map<String, List<String>> livros) {
        System.out.println("livros = " + livros);
    }

    @Entao("Eu tenho {int} livro(s)/titulo(s) com o topico de {}")
    public void euTenhoLivrosComOTopicoDeCOMPUTACAO(int nrDeLivros, Topico topico) {
        final Map<Topico, List<Livro>> livrosAgrupadosPorTopico =
                biblioteca.livrosAgrupadosPorTopico();
        assertThat(livrosAgrupadosPorTopico.get(topico).size(), is(equalTo(nrDeLivros)));
    }

    @Dado("Exemplo com sequencia de escape \\(yay!)")
    public void exemploComSequenciaDeEscapeYay() {
        System.out.println("livro = " + livro);
    }
}
