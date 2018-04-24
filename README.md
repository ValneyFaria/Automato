SIMULADOR DE AFD e AFN
====================================================================================

PROFESSOR: Vinícius Durelli

ALUNOS:
Ana Letícia Neves
Valney Faria

------------------------------------------------------------------------------------

INSTRUÇÕES:

- ENTRADA:
	- entrada.txt:
		Arquivo que contém a estrutura básica do autômato, tal como número de símbolos
		do alfabeto, o alfabeto em si, o número de estados e os estados em si, as
		transições de estados e símbolos, e as definições do estado inicial e dos
		estados finais.
	-
	- Alteração no código:
		A variável String palavra = "babbabababbaba" deverá ser alterado pelo usuário
		para realizar a verificação de aceitação.
	-

	- Abrir o código correspondente ao simulador desejado.
	
	-
-
	
- SAÍDA:
	- O Simulador de AFD irá analisar a estrutura do automato descrita no arquivo de
	entrada "entrada.txt" e a partir dela criar um vetor contendo cada um dos nós 

-

EX DE ENTRADA PARA O AFD:
2 		: Numero de Simbolos do Alfabeto
a 		: Simbolo
b 		: Simbolo
2		: Numero de Estados
q0		: Estado
q1		: Estado
3		: Numero de Transições
q0,a,q1	: Transição
q0,b,q0	: Transição
q1,b,q0	: Transição
q0		: Estado Inicial
2		: Número de Estados Finais
q1		: Estado Final
q0		: Estado Final

EX DE SAÍDA PARA O AFD:

Linha: 2
NumSImbolos: 2
2
a
b
2
q0
q1
3
q0,a,q1
q0,b,q0
q1,b,q0
q0
2
q1
q0
Alfabeto:[a, b]
Nome do No na pos 0: q0
Nome do No na pos 1: q1
Nos:
q0
q1
tam do vetor: 2
No Inicial q0 : 1
No Final q1 : 1


BUSCAS NAS TRANSICOES

Busca: q0
q0
Busca2: q1
q1
Busca: q0
q0
Busca2: q0
q0
Busca: q1
q1
Busca2: q0
q0
q0->q1,a
q0->q0,b
q1->q0,b
q1->q0,b
babbabababbaba
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado
Caracter Validado

VERIFICACAO DE PALAVRAS: 0
SIMBOLO: b
0 NO ATUAL: q0
0 NO DESTINO: q0

VERIFICACAO DE PALAVRAS: 1
SIMBOLO: a
1 NO ATUAL: q0
1 NO DESTINO: q1

VERIFICACAO DE PALAVRAS: 2
SIMBOLO: b
2 NO ATUAL: q1
2 NO DESTINO: q0

VERIFICACAO DE PALAVRAS: 3
SIMBOLO: b
3 NO ATUAL: q0
3 NO DESTINO: q0

VERIFICACAO DE PALAVRAS: 4
SIMBOLO: a
4 NO ATUAL: q0
4 NO DESTINO: q1

VERIFICACAO DE PALAVRAS: 5
SIMBOLO: b
5 NO ATUAL: q1
5 NO DESTINO: q0

VERIFICACAO DE PALAVRAS: 6
SIMBOLO: a
6 NO ATUAL: q0
6 NO DESTINO: q1

VERIFICACAO DE PALAVRAS: 7
SIMBOLO: b
7 NO ATUAL: q1
7 NO DESTINO: q0

VERIFICACAO DE PALAVRAS: 8
SIMBOLO: a
8 NO ATUAL: q0
8 NO DESTINO: q1

VERIFICACAO DE PALAVRAS: 9
SIMBOLO: b
9 NO ATUAL: q1
9 NO DESTINO: q0

VERIFICACAO DE PALAVRAS: 10
SIMBOLO: b
10 NO ATUAL: q0
10 NO DESTINO: q0

VERIFICACAO DE PALAVRAS: 11
SIMBOLO: a
11 NO ATUAL: q0
11 NO DESTINO: q1

VERIFICACAO DE PALAVRAS: 12
SIMBOLO: b
12 NO ATUAL: q1
12 NO DESTINO: q0

VERIFICACAO DE PALAVRAS: 13
SIMBOLO: a
13 NO ATUAL: q0
13 NO DESTINO: q1
Palavra Percorrida e estado atual eh final!
A palavra babbabababbaba eh aceita pelo automato!