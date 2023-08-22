# language: pt
Funcionalidade: : Propondo lances ao leilão

  Cenário: Propondo um unico lance valido
    Dado um lance valido
    Quando propoe ao leilao
    Entao o lance eh aceito


  Cenário: Propondo vários lances válidos
    Dado um lance de 10 reais do usuário "fulano"
    E um lance de 15 reais do usuário "beltrano"
    Quando propoe vários lances ao leilao
    Entao os lances são aceitos

  Esquema do Cenário: Propondo um lance inválido
    Dado um lance inválido de <valor> reais e nome do usuário '<nomeDoUsuario>'
    Quando propoe ao leilao
    Entao o lance não é aceito
    Exemplos:
      | valor | nomeDoUsuario   |
      | 0     | Jean_Heberth    |
      | -1    | Jessica_Jasmine |


  Cenário: Propondo uma sequência de lances
    Dado dois lances
      | valor | nomeDoUsuario |
      | 10.0  | Jean_Heberth  |
      | 15.0  | Jean_Heberth  |
      | 18    | Jean_Heberth  |
    Quando propoe vários lances ao leilao
    Entao o segundo lance não é aceito