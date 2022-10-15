<h1 align="center">💻 API Cadastro</h1>
<h3 align="center"><a style="color:black; href="https://pessoas-api-sannyhl.herokuapp.com/pessoa" >Api para cadastramento de pessoas</a></h3>

<div align="center"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" height="40px"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40px"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-plain.svg" height="40px"/></div>


<br><h1 align="center">🎁 Recursos disponíveis</h1>

- [x] Cadastro de pessoa
- [x] Exclusão de cadastro
- [X] Atualização do cadastro
- [X] Busca de cadastro por ID
- [X] Buscar todos os cadastro

<br><h2>🛠 Algumas das tecnologias utilizadas na construção do projeto:</h2>

- <b>Java 17</b> 
- <b>Spring Framework</b>
- <b>Postgres</b>(banco de dados)
- <b>Swagger</b>(utilizado na aplicação como meio de documentar e realizar as operação de CRUD.)
- <b>JUnit</b>(para a realização dos testes)
- <b>JPA</b>(disponibilizou métodos para CRUD)


 <br><h2>⚠ Dados Swagger:</h2>

<h3>🍁 Usuário: api</h3>
<h3>🍁 Senha: 123</h3>

<br><h1 align="center">Utilizar a API 📗</h1><br>

<h2 align="center"><i>🌟 Modelo Json para o Post e o Put</i></h2><br>
<img src="https://user-images.githubusercontent.com/104280692/195988667-c5d24877-5cdc-40b8-893b-bbbee2be83cf.png" height="150px"/><br>
<h4> ⚠O id não precisa ser informado pois é gerado automaticamente.</h4>

<h2>🔎 Buscar, criar, deletar e atualizar cadastro via Swagger:</h2><br>

- Acessar: <https://pessoas-api-sannyhl.herokuapp.com/swagger-ui/index.html#/>
- Informar usuário(api) e senha(123);
- Escolher um dos métodos abaixo: 

<img src="https://user-images.githubusercontent.com/104280692/195988118-9aba171a-3d50-4d64-8f97-d713a21c4393.png" height="300px"/>

<h4>➡ <b>Para buscar todos basta ir no GET Listar todos</b></h4>
<h4>➡ <b>Para buscar por ID deve informar o ID no GET Busca por ID</b></h4>
<h4>➡ <b>Para deletar deve informar o ID no DELETE</b></h4>
<h4>➡ <b>Para criar novo cadastro o Json deverá ser informado no POST</b></h4>
<h4>➡ <b>Para atualizar o cadastro deve informar na requisição PUT o ID e o Json atualizado.</b></h4><br>


<h2>🔎 Buscar, criar, deletar e atualizar cadastro via <a href="https://www.postman.com/downloads/">postman</a> ou outra plataforma para uso de APIs:</h2><br>


- URL para criar novo cadastro via POST: https://pessoas-api-sannyhl.herokuapp.com/pessoa
- URL para buscar todos via GET: https://pessoas-api-sannyhl.herokuapp.com/pessoa
- URL para buscar por ID via GET: https://pessoas-api-sannyhl.herokuapp.com/pessoa/{id}
- URL para deletar por ID via DELETE: https://pessoas-api-sannyhl.herokuapp.com/pessoa/{id}
- URL para atualizar por ID via PUT: https://pessoas-api-sannyhl.herokuapp.com/pessoa/{id}


<br><h2>🔧 Utilização do código da API:</h2>


<h4>📋 Pré-requisitos</h4>

- ➡Ter instalado o Java - a versão utilizada neste projeto foi a 17.
- ➡Um editor para trabalhar com o código como [VSCode](https://code.visualstudio.com/)


<br><h2>🎲 Rodando a API na localmente:</h2>

```bash

➩ Clone este repositório
$ git clone <https://github.com/SannyHL/api_cadastro.git>

➩ Acesse o código com o editor de sua preferência

➩ Utilize a branch development
$ git checkout development

➩ Instale as dependências que estão no pom.xml(normalmente o proprio editor instala as dependências)

➩ Insira no application.properties as configurações do seu banco de dados

➩ Rode a aplicação

➩ O servidor iniciará na porta:8080 por default - acesse <http://localhost:8080>

```

<br><h2> Imagem da API online no Swagger via Heroku:</h2>

<div  align="center"> 
<img src="https://user-images.githubusercontent.com/104280692/195989664-900b62fb-2126-4089-8614-82f320647547.png" height="500px"/>
</div>

### Autora
---

<img src="https://user-images.githubusercontent.com/104280692/194205159-83b3bca2-3f59-40cd-b909-9bb0b8e40825.png" width="250px;" alt=""/>
Criado com ❤️ por Sanny Helen Lima <br>
⭐ Entre em contato!
<br>


[![Linkedin Badge](https://img.shields.io/badge/-SannyHL-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/sannyhelenlima/)](https://www.linkedin.com/in/sannyhelenlima) 
[![Gmail Badge](https://img.shields.io/badge/-sannyhelenlima@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:sannyhelenlima@gmail.com)](mailto:sannyhelenlima@gmail.com)

