# CRUD de Produtos — Spring Boot, JPA, Thymeleaf e MySQL

Projeto-base da atividade prática. Implementa cadastro, listagem, pesquisa, edição e exclusão de produtos.

## Requisitos
- Java 21
- Maven 3.6.3 ou superior
- XAMPP com MySQL
- VS Code (ou outra IDE Java)

## 1. Criar o banco
1. Abra o XAMPP e inicie MySQL. O Apache também pode ser iniciado para abrir o phpMyAdmin.
2. Acesse http://localhost/phpmyadmin
3. Crie um banco chamado `db_produtos`.
4. Não é necessário criar a tabela: o Hibernate cria/atualiza a tabela `produtos`.

## 2. Abrir e executar
1. Extraia o ZIP.
2. Abra a pasta `CRUD-Produtos-Spring-Boot` no VS Code.
3. Confirme que o MySQL está iniciado.
4. Abra o terminal na pasta que contém `pom.xml`.
5. Execute:

```bash
mvn spring-boot:run
```

6. Quando aparecer `Started CrudProdutosApplication`, abra:
   http://localhost:8080/produtos

No XAMPP padrão, o usuário MySQL é `root` e a senha é vazia. Se você configurou senha, defina a variável de ambiente `DB_PASSWORD` antes de iniciar a aplicação. O usuário pode ser alterado com `DB_USERNAME`.

### Windows PowerShell — senha configurada (se houver)
```powershell
$env:DB_USERNAME="root"
$env:DB_PASSWORD="SUA_SENHA"
mvn spring-boot:run
```

## 3. Teste manual exigido na atividade
1. Clique em **Novo produto**.
2. Cadastre, por exemplo:
   - Teclado Gamer — 159.90 — estoque 10
   - Mouse sem fio — 79.90 — estoque 25
   - Monitor 24 polegadas — 699.90 — estoque 5
3. Confirme que os três aparecem na listagem.
4. Pesquise por `mouse`.
5. Edite um produto e salve.
6. Exclua um produto de teste, se desejar.
7. Reinicie a aplicação e confirme que os registros continuam no banco.
8. No phpMyAdmin, abra `db_produtos` > `produtos` e confira os registros.

## 4. Estrutura principal
```text
src/main/java/br/com/umc/produtos/
  CrudProdutosApplication.java
  controller/ProdutoController.java
  model/Produto.java
  repository/ProdutoRepository.java
  service/ProdutoService.java

src/main/resources/
  application.properties
  templates/produtos/lista.html
  templates/produtos/formulario.html
  static/css/estilo.css
```

## 5. O que cada camada faz
- **Entity (Produto):** representa a tabela e valida os dados.
- **Repository:** acessa o banco usando Spring Data JPA.
- **Service:** concentra as operações da aplicação.
- **Controller:** recebe as requisições e escolhe as páginas.
- **Thymeleaf:** gera as páginas HTML com os dados.

## Observações
- A aplicação usa `spring.jpa.hibernate.ddl-auto=update` para criar/atualizar a tabela.
- Não publique credenciais do banco no GitHub.
- Faça pelo menos três commits com mensagens claras, conforme a atividade.
- Este projeto ainda precisa ser executado no seu computador e conferido no ambiente da faculdade. Não considere os testes ou os prints concluídos até realizar essas verificações.
