SIMULADOR DE AFD e AFN
====================================================================================

PROFESSOR:
*	Vinícius Durelli

ALUNOS:
*	Ana Letícia Neves
*	Valney Faria

------------------------------------------------------------------------------------

INSTRUÇÕES:

- ENTRADA:
	- entrada.txt e entradaN.txt:
		*	Arquivo que contém a estrutura básica do autômato, tal como número de símbolos
		do alfabeto, o alfabeto em si, o número de estados e os estados em si, as
		transições de estados e símbolos, e as definições do estado inicial e dos
		estados finais.
		*	Para definir um AFD, basta montá-lo editando o arquivo "entrada.txt".
		*	Para definir um AFN, basta montá-lo editando o arquivo "entradaN.txt".
		
		Seguem-se exemplos para montagem da estrutura:

			EXEMPLO DE ENTRADA PARA UM AFD:
			2 		: Numero de Simbolos do Alfabeto
			a 		: Simbolo
			b 		: Simbolo
			2		: Numero de Estados
			q0		: Estado
			q1		: Estado
			3		: Numero de Transições
			q0,a,q1	: Transição 1
			q0,b,q0	: Transição 2
			q1,b,q0	: Transição 3
			q0		: Estado Inicial
			2		: Número de Estados Finais
			q1		: Estado Final
			q0		: Estado Final

			EXEMPLO DE ENTRADA PARA UM AFN:
			2 		: Numero de Simbolos do Alfabeto
			a 		: Simbolo
			b 		: Simbolo
			2		: Numero de Estados
			q0		: Estado
			q1		: Estado
			3		: Numero de Transições
			q0,a,q1	: Transição 1
			q0,a,q0	: Transição 2
			q1,b,q0	: Transição 3
			q0		: Estado Inicial
			2		: Número de Estados Finais
			q1		: Estado Final
			q0		: Estado Final
	-
		*	O código deverá então ser executado, de preferência em uma IDE como o Eclipse.
			A classe Principal é a que possui a função main().
		*	Após, deve-se selecionar qual tipo de simulador executar. Se a montagem no arquivo "entrada.txt"
			corresponder a um AFD, escolher a opção "1 - AFD". Do contrário, escolher a opção "2 - AFN".
		*	Inserir uma palavra para realizar a simulação do autômato.
	-
-
	
- SAÍDA:
	- O Simulador irá analisar a estrutura do automato descrita no arquivo de
	entrada "entrada.txt" e a partir dela, montará e simulará um AFD ou AFN.
	Ao fim da execução, uma mensagem exibe o resultado, afirmando se a palavra inserida é ou não
	aceita pelo autômato.
-

EXEMPLO DE SAÍDA PARA UM AFD EXECUTANDO A PALAVRA "babbabababbaba":

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