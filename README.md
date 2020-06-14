# softplan_desafio_tecnico
Repositório contendo os exercícios propostos

# Requisitos
* Java 8
* Maven 3 ou superior

# Rodando

`mvn install`

Caso não queira roda os testes

`mvn install -DskipTests=true`

# Resposta Exercício 1

A classe origianl encontra-se em **[br.com.softplan.exercicio1.GeradorObservacao]** [ir para classe](https://github.com/gtorre2/softplan_desafio_tecnico/blob/master/Desafio/src/main/java/br/com/softplan/exercicio1/GeradorObservacao.java)

A classe de teste encontra-se em **[br.com.softplan.exercicio1.GeradorObservacaoTest]**, [ir para classe](https://github.com/gtorre2/softplan_desafio_tecnico/blob/master/Desafio/src/test/java/br/com/softplan/exercicio1/GeradorObservacaoTest.java)

### Passos que foram feitos para refatoração da classe

1. Retirar os comentários, código bom não precisa de comentários
2. Melhorar o nome das variáveis e métodos, somente o publico não será mudado
3. Identificação de textos iguais e colocá-los em constantes
4. Remoção de Strings mágicas
5. Tipar o List com a classe correta, pois do jeito que estava a lista é de qualquer coisa.
6. Tipando a lista transformando em um Map 
7. Remover o método privado "retornaCodigos"
8. Remoção de atributos criados desnecessáriamente
9. Colocar a visibilidade correta para os atributos
10. Criar vários métodos com algumas lógicas do negócios
11. Criar outro método para saber se o texto vai no singular ou plurar
11. Rodar os testes