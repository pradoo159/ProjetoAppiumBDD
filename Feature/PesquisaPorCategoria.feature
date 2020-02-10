#language: pt
#coding: utf-8
@PesquisaPorCategoria
Funcionalidade: Pesquisa por categoria
  Eu como usuario
  Desejo pesquisar um produto pela tela principal

  Contexto: 
    Dado que eu esteja com o app aberto

  @Valido
  Cenario: Pesquisa por categoria valida
    Quando eu clicar em uma categoria
    E clicar no produto desejado
    Entao a tela do produto deverá ser exibida

  @Invalido
  Cenario: Pesquisa por categoria valida
    Quando eu clicar em uma categoria
    E clicar no produto desejado
    Entao o titulo do produto será diferente
