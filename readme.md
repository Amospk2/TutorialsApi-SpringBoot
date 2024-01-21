# Tutorial API

Bem-vindo à documentação da **Tutorial API**! Esta API é destinada para gerenciar tutoriais, autenticação de usuários e registro de novos usuários. A seguir, você encontrará informações sobre como utilizar os recursos disponíveis nesta API.

## Recursos Disponíveis

### Autenticação de Usuários

#### Autenticação
Endpoint: `POST /api/auth/signin`

Este endpoint é utilizado para autenticar usuários existentes na plataforma. Envie uma solicitação POST com o corpo contendo o nome de usuário (`username`) e senha (`password`). O sistema retornará um token JWT válido para o usuário autenticado.

Exemplo de corpo da solicitação:
```json
{
  "username": "seu_nome_de_usuario",
  "password": "sua_senha_secreta"
}
```

Exemplo de resposta:
```json
{
  "token": "seu_token_jwt",
  "id": 1,
  "username": "seu_nome_de_usuario",
  "email": "seu_email@example.com",
  "roles": ["ROLE_USER"]
}
```

#### Registro de Usuários
Endpoint: `POST /api/auth/signup`

Este endpoint permite o registro de novos usuários na plataforma. Envie uma solicitação POST com o corpo contendo o nome de usuário (`username`), e-mail (`email`), senha (`password`) e uma lista de funções (`role`) atribuídas ao novo usuário.

Exemplo de corpo da solicitação:
```json
{
  "username": "novo_usuario",
  "email": "novo_usuario@example.com",
  "password": "nova_senha_secreta",
  "role": ["ROLE_USER"]
}
```

Exemplo de resposta:
```json
{
  "message": "Usuário registrado com sucesso!"
}
```

### Gerenciamento de Tutoriais

#### Obter todos os Tutoriais
Endpoint: `GET /api/tutorials`

Este endpoint recupera todos os tutoriais disponíveis. Você pode opcionalmente filtrar por título, adicionando o parâmetro `title` à sua solicitação.

Exemplo de solicitação:
- `GET /api/tutorials?title=SeuTitulo`

Exemplo de resposta:
```json
[
  {
    "id": 1,
    "title": "Título do Tutorial",
    "description": "Descrição do Tutorial",
    "published": true,
    "autor": {
      "id": 1,
      "username": "autor_do_tutorial",
      "email": "autor@example.com",
      "roles": ["ROLE_USER"]
    }
  },
  // Outros tutoriais...
]
```

#### Obter um Tutorial por ID
Endpoint: `GET /api/tutorials/{id}`

Este endpoint recupera um tutorial específico com base no ID fornecido.

Exemplo de solicitação:
- `GET /api/tutorials/1`

Exemplo de resposta:
```json
{
  "id": 1,
  "title": "Título do Tutorial",
  "description": "Descrição do Tutorial",
  "published": true,
  "autor": {
    "id": 1,
    "username": "autor_do_tutorial",
    "email": "autor@example.com",
    "roles": ["ROLE_USER"]
  }
}
```

#### Criar um Novo Tutorial
Endpoint: `POST /api/tutorials`

Este endpoint cria um novo tutorial. Certifique-se de incluir os detalhes do tutorial no corpo da solicitação.

Exemplo de corpo da solicitação:
```json
{
  "title": "Novo Tutorial",
  "description": "Descrição do Novo Tutorial"
}
```

Exemplo de resposta:
```json
{
  "id": 2,
  "title": "Novo Tutorial",
  "description": "Descrição do Novo Tutorial",
  "published": false,
  "autor": {
    "id": 1,
    "username": "autor_do_tutorial",
    "email": "autor@example.com",
    "roles": ["ROLE_USER"]
  }
}
```

#### Atualizar um Tutorial por ID
Endpoint: `PUT /api/tutorials/{id}`

Este endpoint atualiza um tutorial existente com base no ID fornecido. Certifique-se de incluir os detalhes atualizados no corpo da solicitação.

Exemplo de corpo da solicitação:
```json
{
  "title": "Novo Título Atualizado",
  "description": "Nova Descrição Atualizada",
  "published": true
}
```

Exemplo de resposta:
```json
{
  "id": 2,
  "title": "Novo Título Atualizado",
  "description": "Nova Descrição Atualizada",
  "published": true,
  "autor": {
    "id": 1,
    "username": "autor_do_tutorial",
    "email": "autor@example.com",
    "roles": ["ROLE_USER"]
  }
}
```

#### Atualizar o Autor de um Tutorial por ID
Endpoint: `PUT /api/tutorials/change-autor/{id}/{id_user}`

Este endpoint atualiza o autor de um tutorial com base no ID do tutorial e no ID do novo autor fornecidos.

Exemplo de solicitação:
- `PUT /api/tutorials/change-autor/2/3`

Exemplo de resposta:
```json
{
  "id": 2,
  "title": "Novo Título Atualizado",
  "description": "Nova Descrição Atualizada",
  "published": true,
  "autor": {
    "id": 3,
    "username": "novo_autor",
    "email": "novo_autor@example.com",
    "roles": ["ROLE_USER"]
  }
}
