/**
Miguel Prates Ferreira de Lima Cantanhede - 13672745
Amanda Kasat Baltor - 13727210
Lucas Issao Omati - 13673090

*/

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;

class Dado{
    private final String country;
    private final int confirmed;
    private final int deaths;
    private final int recovery;
    private final int active;
    Dado(String country,int confirmed, int deaths, int recovery, int active){
        this.country=country;
        this.confirmed=confirmed;
        this.deaths=deaths;
        this.recovery=recovery;
        this.active=active;
    }
    
    /** Getters e setters */
    String get_country(){return country;}
    int get_confirmed(){return confirmed;}
    int get_deaths(){return deaths;}
    int get_recovery(){return recovery;}
    int get_active(){return active;}
}




class Main
{
    static Dado String_to_dado(String line){
        String[] subs = line.split(",");
        int confirmed = Integer.parseInt(subs[1]);
        int deaths = Integer.parseInt(subs[2]);
        int recovery = Integer.parseInt(subs[3]);
        int active = Integer.parseInt(subs[4]);
        return new Dado(subs[0],confirmed,deaths,recovery,active);
    }
	public static void main(String[] args) {
	    
	    /** Faz a leitura dos parâmetros */
	    Scanner scanner = new Scanner(System.in);
	    int n1 = scanner.nextInt();
	    int n2 = scanner.nextInt();
	    int n3 = scanner.nextInt();
	    int n4 = scanner.nextInt();
	    
	    
	    String path = "dados.csv";
	    List<Dado> dados;
	    try{
	        /* O Files.line() gera uma Stream<String>, que é
	        passada por um map para fazer a conversão 
	        para a classe 'Dado'. isso é passado por um collector,
	        que tem o objetivo de fazer uma List<Dado> no final
	        (isso é importante pois vamos utilizar a lista várias vezes
	        no código, e não poderíamos aplicar todos os métodos mais de uma
	        vez na mesma stream)*/
	        dados = Files.lines(Paths.get(path)).map(Main::String_to_dado)
	                .collect(Collectors.toList());
	        
	        /*  Filtra os dados que o confirmed é maior que o n1
	            Aplica um map que transforma o 'Dado' no 'active'
	            aplica um reduce que aplica uma soma em todos os dados*/
	        int R1 = dados.stream().filter(d -> d.get_confirmed() >= n1)
        	                       .map(d -> d.get_active())
        	                       .reduce(0,Integer::sum);
        	System.out.println(R1);
	       
	        /** Aplica um sort reverso comparando os 'actives'
	            limita isso a apenas 'n2' dados
	            aplica outro sort comparando os 'confirmed'
	            limita isso a apenas 'n3' dados
	            aplica um map para verificar o campo 'deaths'
	            printa todos os 'confirmed' usando o forEach */
	       dados.stream().sorted(Comparator.comparing(Dado::get_active).reversed())
	                     .limit(n2)
	                     .sorted(Comparator.comparing(Dado::get_confirmed))
        	             .limit(n3)
        	             .map(d -> d.get_deaths())
        	             .forEach(System.out::println);
           
           /** Aplica um sort reverso comparando os 'confirmeds'
               Limita isso a 4 dados
               Aplica um sort comparando o nome dos países
               Faz um map nos dados para verificar o nome dos países
               Para cada nome, printa ele na tela usando o ForEach*/
           dados.stream().sorted(Comparator.comparing(Dado::get_confirmed).reversed())
                         .limit(n4)
                         .sorted(Comparator.comparing(Dado::get_country))
                         .map(d -> d.get_country())
                         .forEach(System.out::println);
	        
	    }catch(IOException ioe){
	       System.out.println("Deu algum BO aí no meio");
	       System.exit(1);
	    }
	}
}
