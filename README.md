# **Sistema de estoque TI**

## Linguagens e tecnologias utilizadas
- Java (versão 23) - Linguagem principal para a lógica do sistema.
- JavaFX (versão 23) - Responsável pela interface gráfica do usuário.
- Java JDBC - Para conexão e manipulação do banco de dados.
- SQLite3 - Sistema de gerenciamento de banco de dados leve e eficiente.

# Visão Geral

O Sistema de Estoque TI foi desenvolvido para oferecer um controle eficiente e prático do estoque de TI da empresa local. O sistema permite o gerenciamento completo dos materiais, incluindo adição, remoção e consulta de ativos.

## Estrutura do Projeto

- ‘src’ - Pasta raiz do código-fonte;
- ‘application’ - Contém a classe principal que inicializa o sistema;
- ‘controllers’ - Contém os controladores responsáveis pela lógica das telas e funcionalidades CRUD.
- ‘database’ - Responsável pela conexão com o Banco de Dados SQLite (estoqueti.db);
- ‘repositories’ - Entidades, no caso, somente aonde ficam armazenados os materiais do estoque;
- ‘services’ - Fica armazenado um arquivo com as funções que são utilizadas nas demais classes;
- ‘views’ - Fica armazenado todas as telas do sistema, desde Login e Registro até a Adição de Ativos e Uso e consumos.

## Funcionalidades Principais

- Cadastro de Materiais: Permite adicionar novos itens ao estoque.
- Consulta de Estoque: Exibe uma lista detalhada dos materiais armazenados.
- Atualização de Itens: Possibilidade de editar informações dos materiais.
- Remoção de Materiais: Exclusão de itens do sistema.
- Gerenciamento de Usuários: Controle de acesso ao sistema por meio de login e registro.

## Como executar o Projeto?
Requisitos:
- IntelliJ IDEA (ou outra IDE compatível com JavaFX)
- JDK 23 instalado
- Dependências JavaFX configuradas no projeto

### Passos:
1. Clone o repositório:
2. git clone https://github.com/DevGabrielC/EstoqueTI.git
3. Abra o projeto na sua IDE de preferência (Neste projeto, eu utilizei o InteliJ IDEA).
4. Certifique-se de que as dependências do JavaFX estão corretamente configuradas.
6. Execute a classe principal localizada em application/Main.java.

# Este projeto está sob a licença MIT - consulte o arquivo LICENSE para mais detalhes.
