# language: pt

Funcionalidade: Exemplo de uso de tabela de dados

  Cenário: Exemplo de uso de tabela de dados
    Dado Que a minha biblioteca esta inicializada vazia
    E a seguinte tabela de livros:
      | titulo    | Numero de Paginas | Topico     | Data de Publicacao | Autores |
      | LivroUm   | 42                | COMPUTACAO | 2020               | Nilton  |
      | LivroDois | 150               | ROMANCE    | 2021               | Santos  |
    Quando Eu pesquiso o livro "LivroUm" e COMPUTACAO
    Entao Eu encontro o livro com "LivroUm"
    Quando Eu pesquiso o livro "LivroDois" e ROMANCE
    Entao Eu encontro o livro com "LivroDois"
#
#  Cenário: Exemplo de uso de Doc Strings
#    Dado Que a minha biblioteca esta inicializada vazia
#    E a seguinte lista de livros:
#    """lista_de_livros
#      LivroTres   , 200                , COMPUTACAO , 2020               , Cassandra
#      LivroQuatro   , 300                , FINANCAS , 2021               , Miranda
#    """
#    Quando Eu pesquiso o livro "LivroTres" e COMPUTACAO
#    Entao Eu encontro o livro com "LivroTres"
#    Quando Eu pesquiso o livro "LivroQuatro" e FINANCAS
#    Entao Eu encontro o livro com "LivroQuatro"

#  Cenário: Exemplo com tipo definido pelo usuario
#    Dado Que a minha biblioteca esta inicializada vazia
#    Quando Eu adiciono o livro Cucumber, 42, COMPUTACAO, 2021, Nilton
#    Entao Eu encontro o livro com "Cucumber"