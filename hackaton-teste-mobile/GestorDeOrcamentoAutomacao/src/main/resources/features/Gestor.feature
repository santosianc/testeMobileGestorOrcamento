#language: pt
#enconding: UTF-8

Funcionalidade: Despesas mobile

Eu como um usuario gostaria de manter minhas despesas despesa.

Cenario: Adicionar novo despesa


Dado que o usuario esteja na pagina principal do app
Quando o usuario selecionar a opcao adicionar uma nova despesa
E inserir um valor "200"
E selecionar uma categoria "Transporte"
E pressionar o botao adicionar 
Dado a despesa "Transporte" "Dispesas diversas" "200"
Quando o usuario selecionar a opcao editar
E alterar o valor da despesa para "75"
E pressionar o botao salvar
E depois deve excluir o item