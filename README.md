# Instzaa API

Esta e uma api de serviço para as aplicações Instzaa.
Estas compoem:

[Instzaa App](https://github.com/KayandeSouzaPereira/instzaa-app)

[Instzaa Adm]()

Para o projeto foi empregado o uso de diversas tecnologias baseadas no framework, microserviços em nuvem, ferramentas de analise dos serviços, 2 tipos de bancos de dados e Arquitetura cebola. 

### Ideia do projeto

Uma api de serviço para um app de delivery e uma pagina web de gestão deste delivery. Os serviços encontrados nessa api são:
- Criação (apenas para API) e Autenticação de Usuário.
- Criação, edição, busca e remoção de itens do cardapio.
- Criação (apenas pelo app e api), edição, busca e remoção de itens de pedidos realizados.
- Edição e busca de dados da empresa.
- Criação de pagamento por PIX (implementação de serviço Efipay).
- Criação de pagamento via cartão de credito (implementação de serviço Efipay).
- Listagem de pagamentos por PIX.
- Confirmação de validação de pagamento por PIX.
- Busca de valor em caixa (implementação de serviço Efipay).

## Stack utilizada

- Java (JDK 17)
- Springboot
- MySql


## Instalação local

Utilização do Projeto em sua maquina local.

- E necessario uma configuração de variavel de ambiente JAVA de jdk17 ou maior.


Para rodar o projeto utilize:
```bash
  git clone branch_url
  mvn spring-boot:run
  
```
## Documentação

A documentação Swagger pode ser encontrada ao iniciar o projeto como dev pelo endpoint `/swagger-ui/index.html`.



## Autores

- [@kayandesouza](https://github.com/KayandeSouzaPereira) Desenvolvedor do App

