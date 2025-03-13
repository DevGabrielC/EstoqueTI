# **Sistema de estoque TI**
### Desenvolver um sistema básico e prático para gerenciamento de estoque TI da empresa Lafaete Locações

## Linguagens e tecnologias utilizadas
- JavaFX
- Java JDBC
- SQLite3

#
A ideia desse sistema é ter um controle do estoque de uma empresa. Será um sistema desenvolvido por meio da IDE IntelliJ IDEA, que se encaixa muito bem nesse projeto.

O estoque do sistema está armazenado em um banco de dados SQLite, que tem um ponto forte em não precisar de hospedar um banco localmente ou em nuvem, já que o SGBD utiliza um arquivo com a extensão “.db” como Banco de Dados.

O repositório do projeto está organizado em pastas e subpastas, sendo:

- ‘src’ - Pasta raiz do código;
- ‘application’ - Pasta aonde se encontra o coração do sistema, que faz incializa;
- ‘controllers’ - Controladores do sistema, neles tem diversas funcionalidades, baseados em um sistema CRUD.
- ‘database’ - Está a conexão com o Banco de Dados local (estoqueti.db);
- ‘repositories’ - Entidades, no caso, somente aonde ficam armazenados os materiais do estoque;
- ‘services’ - Fica armazenado um arquivo com as funções que são utilizadas nas demais classes;
- ‘views’ - Fica armazenado todas as telas do sistema, desde Login e Registro até a Adição de Ativos e Uso e consumos.
