# Instzaa API

Um app instantaneo de delivery. 
Promove comodidade para o usuário para realização de pedidos de delivery que nos exemplos de demonstração serão referentes a menus de pizzaria, porém serve para diversos tipos de comercio.


Esta e uma api de serviço para as aplicações Instzaa.
Estas compoem:

[Instzaa App](https://github.com/KayandeSouzaPereira/instzaa-app)

[Instzaa Adm](https://github.com/KayandeSouzaPereira/instzaa-adm)


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
- Criação de lanches customizados com menu a parte.
- Criação e listagem de comentarios.

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

## Demontração
Uma desmonstração do serviço pode ser encontrada no [link](http://ec2-56-124-45-234.sa-east-1.compute.amazonaws.com:8080/swagger-ui/index.html)

Para economia de recursos a nuvem da api não se encontra ligada sempre, caso seja esta a situação utilize o [link](https://6pfgw28ez3.execute-api.sa-east-1.amazonaws.com/default/InstzaaServerPremisse), aguarde um minuto e tente novamente.

## Autores

- [@kayandesouza](https://github.com/KayandeSouzaPereira) Desenvolvedor principal da Aplicação móvel, Aplicação Web e Api.
- [@matheusmarti](https://github.com/Matheus-Marti1) Desenvolvedor responsável pela implementação dos comentários na Aplicação móvel e Api.

