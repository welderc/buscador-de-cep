## Buscador de CEP com API ViaCEP

Este projeto implementa um buscador de CEP que utiliza a API ViaCEP para consultar e baixar informações de endereços em formato JSON. Ele consome a API, valida os dados, trata erros e salva as informações em um arquivo JSON.

### Sobre

O buscador de CEP oferece as seguintes funcionalidades:

* **Consulta de CEP:** Permite ao usuário inserir um CEP e consultar suas informações através da API ViaCEP.
* **Validação de CEP:** Verifica se o CEP inserido é válido e se a API retornou dados corretamente.
* **Exibição de dados:** Apresenta as informações do endereço, como logradouro, bairro, cidade e estado.
* **Download de JSON:** Permite baixar as informações do CEP em formato JSON para posterior utilização.
* **Tratamento de erros:** Utiliza mecanismos de tratamento de exceções para lidar com erros durante a consulta da API e o download do arquivo JSON.

### Tecnologias

* **Java:** Linguagem de programação utilizada para desenvolver o projeto.
  Versão: 21

* **Gson:** Biblioteca utilizada para converter objetos Java em JSON e vice-versa.
  Versão: 2.11.0

* **API ViaCEP:** API utilizada para consultar informações de CEPs. 
  
* **Scanner:** Classe Java utilizada para obter entrada do usuário.

* **FileWriter:** Classe Java utilizada para gravar arquivos JSON.

### Baixar

1. Certifique-se de ter o baixado a biblioteca Gson
   
### Créditos

Este projeto foi inspirado no curso "Java: consumindo API, gravando arquivos e lidando com erros" da Alura.

### Contribuições

Contribuições são bem-vindas! Você pode contribuir de diversas maneiras:

* **Novas funcionalidades:**  Implemente novas funcionalidades, como a possibilidade de pesquisar por endereço ou de salvar o histórico de consultas.
* **Correções de bugs:** Encontre e corrija bugs que impedem o funcionamento adequado do programa.
* **Documentação:**  Melhore a documentação do projeto, incluindo exemplos de uso mais detalhados e explicando o código.

### Exemplo de Uso

```
Seja Bem-vindo!!

Digite o CEP que deseja consultar:  (CEP)

Deseja ver os dados do CEP? (Sim/Não): Sim

Cep:  (CEP)
Logradouro: (Logradouro)
Complemento:  (Complemento)
Localidade: (Localidade)
UF: (UF)

Deseja consultar outro CEP? (Sim/Não): Não

Deseja baixar em json essa consulta? (Sim/Não): Sim

Deseja sair ou perquisar outro cep? (sair/continuar): sair
```

#### Saída

Arquivo criado:
```
(cep).json
```
```json
{
  "cep": "(CEP)",
  "logradouro": "(Logradouro)",
  "complemento": "(Complemento)",
  "localidade": "(Localidade)",
  "uf": "(UF)"
}
```
## :robot: Tecnologias

![Java](https://img.shields.io/badge/Java-ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
