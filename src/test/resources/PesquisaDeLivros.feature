# language: pt

Funcionalidade: Pesquisa de livros na minha biblioteca

  Contexto:
    Dado Que a minha biblioteca esta inicializada
    E Que o total de livros carregados e' 10

  Cenário: Pesquisa de um livro dado o titulo
    Quando Eu pesquiso o livro "Effective Java"
    Entao Eu encontro esse livro

  Cenário: Pesquisa do topico mais popular
    Quando Eu pesquiso o topico mais popular
    Entao Eu encontro o topico COMPUTACAO
    Mas Eu nao encontro o topico SCI_FI
    E Eu nao encontro o topico FINANCAS

  Cenário: Exemplo simples de texto opcional
    Entao Eu tenho 5 livros com o topico de COMPUTACAO
    Entao Eu tenho 3 livros com o topico de SCI_FI
    Entao Eu tenho 1 livro com o topico de FINANCAS
    Entao Eu tenho 1 livro com o topico de ROMANCE

  Cenário: Exemplo simples de texto alternativo
    Entao Eu tenho 5 livros com o topico de COMPUTACAO
    Entao Eu tenho 5 titulos com o topico de COMPUTACAO
    Entao Eu tenho 1 livro com o topico de FINANCAS
    Entao Eu tenho 1 titulo com o topico de FINANCAS

  Cenário: Exemplo simples de sequencia de escape
    Dado Exemplo com sequencia de escape (yay!)
