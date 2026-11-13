# CRUD de Produtos — UMC

**Aluno:** Bruno Santos  
**RGM:** 112521000895  
**Tema:** Produto

## Objetivo
Aplicação web para cadastrar, listar, pesquisar, editar e excluir produtos, usando Spring Boot, Spring Data JPA, MySQL e Thymeleaf.

## Tecnologias
- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA / Hibernate
- MySQL
- Thymeleaf
- Bean Validation
- Maven

## Como executar
1. Inicie o MySQL no XAMPP.
2. No phpMyAdmin, crie o banco `db_produtos`.
3. Abra esta pasta no VS Code, no mesmo nível deste `pom.xml`.
4. No terminal, execute `mvn spring-boot:run`.
5. Acesse http://localhost:8080/produtos.

No XAMPP padrão, o usuário MySQL costuma ser `root` e a senha vazia. Se sua instalação tiver senha, configure `DB_USERNAME` e `DB_PASSWORD` como variáveis de ambiente. Não publique senhas no GitHub.

## Estrutura
- `model/Produto.java`: entidade e validações.
- `repository/ProdutoRepository.java`: acesso aos dados e pesquisa por nome.
- `service/ProdutoService.java`: operações de negócio.
- `controller/ProdutoController.java`: rotas web.
- `templates/produtos`: páginas Thymeleaf.
- `static/css/estilo.css`: estilos.

## Testes manuais para a atividade
Cadastre três produtos de teste, confira a listagem e a tabela `produtos` no phpMyAdmin. Teste pesquisa, edição e exclusão. Reinicie a aplicação e confirme que os registros permanecem.

**Nota:** os testes e as capturas de tela devem ser feitos no computador do aluno. Este README não afirma que os testes foram executados.
