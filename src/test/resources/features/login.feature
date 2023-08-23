# language: pt
Funcionalidade: Apenas usuários cadastrados podem se logar

  Cenário: Um usuário válido consegue se logar
    Dado o usuário válido
    Quando realiza login
    Entao é redirecionado para a página de leilões


  Cenário: Um usuário inválido não consegue se logar
    Dado o usuário inválido
    Quando tenta se logar
    Entao continua na página de login

