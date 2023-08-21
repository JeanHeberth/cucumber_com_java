# language: pt
Funcionalidade: : Propondo lances ao leilão

Cenário: Propondo um unico lance valido
  Dado um lance valido
  Quando propoe ao leilao
  Entao o lance eh aceito


Cenário: Propondo vários lances válidos
  Dado vários lances válidos
  Quando propoe vários lances ao leilao
  Entao os lances são aceitos

Cenário: Propondo vários lances válidos
  Dado um lance de 10 reais do usuário "fulano"
  E um lance de 15 reais do usuário "beltrano"
  Quando propoe vários lances ao leilao
  Entao os lances são aceitos