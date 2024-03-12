# BOLICHE
O boliche é um esporte praticado com uma bola pesada e tem como objetivo lançar a bola por uma pista, derrubar 10 pinos do lado oposto da pista dispostos em formação triangular (https://www.infoescola.com/esportes/boliche/).

Esse trabalho foi feito em grupo com o Lucas Omati e Miguel Prates.

## Como jogar

A fórmula da contagem de pontos no boliche tem as seguintes variáveis (https://boliche.com.br/esporte-boliche/contagem-dos-pontos-no-boliche/):

- Os pontos são a soma dos pinos derrubados.
- Exceto quando fizer Strike (derrubar 10 pinos na 1.ª bola) ou Spare (derrubar 10 pinos nas duas bolas jogadas)
- Se fizer Strike ganha bônus nas 2 bolas jogadas a seguir. Se fizer Spare ganha bônus na próxima bola jogada. O bônus é igual ao número de pinos derrubados.
- O total de 1 partida pode variar de zero a 300 pontos.

A pontuação pode ir de zero (quando nenhum pino é derrubado nas dez jogadas ou “frames”) até o máximo possível de 300 pontos, ou seja, 12 “strikes” consecutivos. Supostamente, como cada partida tem 10 “frames” (jogadas), só seriam possíveis 10 “strikes”. Porém, se o jogador derrubar todos os pinos no primeiro arremesso do 10.º “frame”, tem o direito de jogar mais duas bolas, podendo completar 12 “strikes” numa mesma linha.

## Programa

O programa lê a quantidade de pinos derrubados por um praticante de boliche em cada jogada e imprime:

- A sequência de pinos derrubados (de acordo com os exemplos de entrada e saída e as anotações de contagem de pontos - https://boliche.com.br/esporte-boliche/contagem-dos-pontos-no-boliche/);
- A pontuação final do jogador.

Exemplo de entrada e saída:

| Entrada                                  | Saída                                   |
|------------------------------------------|-----------------------------------------|
| 1 4 4 5 6 4 5 5 10 0 1 7 3 6 4 10 2 8 6  | 1 4 \| 4 5 \| 6 / \| 5 / \| X _ \| 0 1 \| 7 / \| 6 / \| X _ \| 2 / 6 \| 133 |
