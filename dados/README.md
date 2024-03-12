# Dados
Esse exercício é composto de duas versoões:
1 - implementação em Java, sem utilizar laços, utilizando stream. Nessa versão, a existência de qualquer estrutura de laço no programa acarretará em zero nesse item.
2 - Implementação em Java, sem utilizar stream, utilizando laços. Nessa versão, não se deve utuilizar conceitos de programação funcional.

Para cada versão, o programa lê uma linha com 5 inteiros separados por espaço. Sejam esses inteiros n1, n2, n3 e n4. E imprime as seguintes informações:

- A soma de "Active" de todos os países em que "Confirmed" é maior o igual que n1.
- Dentre os n2 países com maiores valores de "Active", o "Deaths" dos n3 países com menores valores de "Confirmed".
- Os n4 países com os maiores valores de "Confirmed". Os nomes devem estar em ordem alfabética.

# Entrada
O programa deve ler um arquivo "dados.csv". Para teste, uma cópia do arquivo está disponível em https://drive.google.com/file/d/1ejA--Cvw2AeNq5jhcellpwl4TxuXPXFf/view?usp=sharing As colunas do arquivo são: Country, Confirmed, Deaths, Recovery, Active.