# language: pt

  Funcionalidade: Pesquisa de livros usando o Esquema de Cenario

    Esquema do Cenario: Pesquisa dos livros dado o titulo e topico
      Dado Que a minha biblioteca esta inicializada
      E Que o total de livros carregados e' 10
      Quando Eu pesquiso o livro <titulo> e <topico>
      Entao Eu encontro o livro com <titulo>

      Exemplos:
        | titulo                          | topico     |
        | "Effective Java"                | COMPUTACAO |
        | "Design Patterns"               | COMPUTACAO |
        | "Dune"                          | SCI_FI     |
        | "One Hundred Years Of Solitude" | ROMANCE    |