# java_animais
Implementação do Jogo animais usando Java + Maven

# Execução
## JAR
Dentro da pasta jogoAnimais:

'''java -jar target/jogoAnimais-1.0-SNAPSHOT.jar'''

# Meu Projeto

Outros projetos, disponíveis na internet, implementam esse jogo, que apesar de não ser um jogo difícil de implementar, requer um certo conhecimento de TAD's não padrões do Java.

Na minha implementação, é necessário entender como: 1) funciona uma Binary Tree, 2) utilizar o design pattern DAO, 3) Estruturas Básicas do JAVA, 4) Básicos de um projeto Maven, 5) o mais importante, entender o porque usamos essas estruturas.

## o Jogo

Neste jogo, o usuário responde uma série de perguntas relacionadas a um animal imaginário.

Assim, é gerada uma àrvore de decisão:
        vive na agua?
        |           |
        Sim         Não
        |
    É um Peixe Palhaço?
        |            |   
        Sim           Não
                    |
                Qual é o Animal?
                    |
                    Baleia
                    |
                Um(a)  Baleia ______ mas um(a) Peixe Palhaço não.

A cada ciclo, vamos construindo uma arvore adicionando ANIMAIS com uma CARACTERISTICA que o animal DEFINIDO(ex.Peixe Palhaço).

Armazenamos então esses ANIMAIS e suas CARACTERISTICAS em uma Arvore Binária.

## Estrutura da Binary Tree

Na minha implementação, um exemplo é:
'''1 - vive na agua?
2 - Cachorro
3 - Peixe Palhaço
4 - Baleia
5 - Peixe Palhaço
6 - Macaco
7 - Cachorro
8 - Zebra
9 - Cachorro
'''

                1
            |       |
            2       3
        |   |       |   |
        6   7         4   5
            |
          |   |
          8   9

## DAO

Seguindo essa lógica, utilizo o design pattern DAO para fazer acesso a classe(ou dominio/ou persistencia/ ou TAD) nodeBinaryTree.

É implementada uma interface Animal, que declara as assinaturas de metodos de acesso(get,set) a BinaryTree. Ela é implementada como um tipo genérico(<T>).

Além disso, na classe App.java, faço a implementação explicita(@Override/ Sobrecarga de métodos) desses metodos e rodo a lógica do jogo.

## Logica do Jogo

O Jogo em si é um laço de repetição que: Gera a Arvore -> Executa as Perguntas -> Armazena os Dados das Respostas -> Executa Perguntas -> Armazena...

# Implementação usando Spring-Boot

Esse projeto pode ser feito utilizando o SpringMVC, só criarmos uma Classe GAMELOGIC e executarmos as regras do jogo na Main() do SpringAplication.