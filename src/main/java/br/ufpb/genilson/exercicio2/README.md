# Gerenciador de Produtos (Maven)

Projeto demonstrativo para o exercício POO: gerenciamento de produtos.

## Estrutura
- Produto.java: entidade Produto (id auto-gerado, equals/hashCode baseados no id)
- SistemaGerenciadorDeProdutos.java: gerenciador com lista de produtos
- ProdutoDuplicadoException.java: exceção checada para duplicatas
- EstoqueInsuficienteException.java: exceção checada para estoque insuficiente
- TestaProdutos.java: programa principal (leitura de 3 produtos e demonstração)

## Rodando
1. Build:
   mvn compile

2. Rodar a classe principal:
   mvn exec:java -Dexec.mainClass="br.ufpb.genilson.produtos.TestaProdutos"
   (ou execute a partir da sua IDE)

## Observações
- O id de cada produto é gerado automaticamente (static proximoId++) e não é alterado, mesmo após remoção.
- A verificação de duplicidade na adição usa equals/hashCode (baseado no id).
- Exemplos de exceções implementadas: ProdutoDuplicadoException e EstoqueInsuficienteException.
