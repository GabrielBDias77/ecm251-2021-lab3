# BackEnd do Projeto Review de Fifa

BackEnd do nosso projeto de review de cartas do Fifa.

## Passo a Passo da Criação:

- Criação do banco de dados.
- Começo do backend (criar as variaveis do banco em models).
- Criar uma conexão ao banco (usando o JDBC).
- Implementação de classes que retiram informações do banco.
- Criação de todo a manipulação do banco usando DAO.
- Criar uma REST API para enviar os dados manipulados pelo banco ao frontend.
- Transformação da informação obtida usando o JSON.
- Criação de rotas para todas as informações necessarias ao projeto.

## Tabelas do Banco:

- Jogador
- Liga
- Equipe
- Avaliacao
- Pais
- Raridade
- Usuario

## Para começar:

- Baixar a máquina virtual 'MariaDB.ova' e iniciá-la
- login: admin / Password: admin
- Observar o IP gerado pela máquina virtual e se necessário alterá-lo no arquivo ConectarDb em src/main/shared/ConectarDd
- Iniciar o arquivo Application.kt na pasta Ktor/FIFA-KTOR/src/main/kotlin/API/Fifa/Application.kt
