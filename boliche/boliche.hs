-- Trabalho Boliche
-- Amanda Kasat 13727210
-- Lucas Issao Omati 13673090
-- Miguel Prates 13672745

module Main where

-- Fazendo a leitura da linha completa e armazenando os dados em um vetor
array_string_to_int :: [String] -> [Int]
array_string_to_int = map read

-- Fazendo as adaptações necessárias para facilitar a escrita das informações
string_pontuacao :: (Num a, Show a, Eq a)=> [a] -> [Char]
string_pontuacao [] = ""
string_pontuacao [x] = if(x==10) then "X | " else show(x)++" | "
string_pontuacao (x:y:cauda)

    |x==10          = ""++(if(length cauda <2) then "X " else "X _ "++ (if(length cauda ==0) then "" else "| ")) ++string_pontuacao(y:cauda) -- strike de primeira
    |x+y==10        = ""++show(x)++" /"++ (if(length cauda ==1) then " " else " | ") ++string_pontuacao(cauda)                --  spare
    |otherwise      = ""++show(x)++" "++show(y)++" | "++string_pontuacao(cauda)                                              -- não bateu os 10
    
-- Somador dos pontos, considerando os bônus
somador :: [Int] -> Int
somador [] = 0
somador [x] = x
somador (x:y:z:cauda)
    |x == 10        = if(length cauda <1) then x + y + z + somador(cauda) else x + y + z + somador(y:z:cauda) --strike
    |x+y == 10      = if(length cauda == 1) then x + y + 2*z + somador(cauda) else if(length cauda < 1) then x + y + z + somador(cauda) else x + y + z + somador(z:cauda) --spare
    |otherwise      = if(length cauda <2) then x + y + z + somador(cauda) else x + y + somador(z:cauda) -- caso normal

main :: IO ()
main = do
  input <- getLine
  let array_string_numeros = words input
  let array_int_numeros = array_string_to_int array_string_numeros
  let rodadas = string_pontuacao array_int_numeros
  let soma = somador array_int_numeros
  putStr (id rodadas)
  putStr (show soma)