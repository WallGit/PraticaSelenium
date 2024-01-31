#language: pt

Funcionalidade: Cadastro de contas

Cenario: Deve inserir uma conta com sucesso
Dado que estou acessando a aplicação
Quando informo o usuário "Eumesmo@Eumesmo"
E a senha "Eusenha"
E seleciono entrar
Então visualizo a página inicial
Quando seleciono Contas
E seleciono Adicionar
E informo a conta "Conta de Teste"
E seleciono Salvar
Então a conta é inserida com sucesso



Cenario: Não deve inserir uma conta sem nome
Dado que estou acessando a aplicação
Quando informo o usuário "Eumesmo@Eumesmo"
E a senha "Eusenha"
E seleciono entrar
Então visualizo a página inicial
Quando seleciono Contas
E seleciono Adicionar
E seleciono Salvar
Então sou notificado que o nome da conta é obrigatório


Cenário: Não deve inserir uma conta com nome já existente
Dado que estou acessando a aplicação
Quando informo o usuário "Eumesmo@Eumesmo"
E a senha "Eusenha"
E seleciono entrar
Então visualizo a página inicial
Quando seleciono Contas
E seleciono Adicionar
E informo a conta "Conta de Teste"
E seleciono Salvar
Então sou notificado que já existe uma conta com esse nome