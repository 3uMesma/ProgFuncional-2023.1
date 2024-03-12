package dados;
/**
Miguel Prates Ferreira de Lima Cantanhede - 13672745
Amanda Kasat Baltor - 13727210
Lucas Issao Omati - 13673090

*/

import java.io.*;
import java.util.*;

class Dado {
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

// compara os Active em ordem decrescente
class ComparatorActive implements Comparator<Dado>{
    @Override
    public int compare(Dado dado1, Dado dado2){
        if(dado1.get_active() > dado2.get_active()){
            return -1;
        }
        return 1;
    }
}

// compara os Confirmed em ordem crescente
class ComparatorConfirmedAscending implements Comparator<Dado> {
    @Override
    public int compare(Dado dado1, Dado dado2){
        if(dado1.get_confirmed() > dado2.get_confirmed()){
            return 1;
        }
        return -1;
    }
}

// compara os Confirmed em ordem decrescente
class ComparatorConfirmedDescending implements Comparator<Dado> {
    @Override
    public int compare(Dado dado1, Dado dado2){
        if(dado1.get_confirmed() > dado2.get_confirmed()){
            return -1;
        }
        return 1;
    }
}

// compara os Country em ordem decrescente
class ComparatorCountry implements Comparator<Dado> {
    @Override
    public int compare(Dado dado1, Dado dado2){
        if(dado1.get_country().compareTo(dado2.get_country()) > 0){
            return 1;
        }
        return -1;
    }
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
	    List<Dado> dados = new ArrayList<>();
	    BufferedReader br = null;
	    String linha;
	    try{
            //faz a leitura do arquivo csv para lista
            br = new BufferedReader(new FileReader(path));
	        while((linha = br.readLine()) != null){
	            dados.add(String_to_dado(linha));
	        }

            //verifica se nao passou do limite do array
            int sizeArray = dados.size();
            if(n2 > sizeArray){
                n2 = sizeArray;
            }
            if(n3 > n2){//n3 deve ser obrigatoriamente menor que n2 e consequentemente menor que Array
                n3 = n2;
            }
            if(n4 > sizeArray){
                n4 = sizeArray;
            }
	        
            //soma de acordo com o confirmed >= n1 e printa
	        int R1 = 0;
	        for(Dado item: dados){
	            if(item.get_confirmed() >= n1){
	                R1 = R1 + item.get_active();
	            }
	        }
	        System.out.println(R1);

            //compara de acordo como o active de maneira decrescente, depois compara de acordo com o confirmed de maneira crescente e printa
	        Collections.sort(dados, new ComparatorActive());
	        Collections.sort(dados.subList(0, n2), new ComparatorConfirmedAscending());
	        for(int i = 0; i < n3; i++){
	            System.out.println(dados.get(i).get_deaths());
	        }
	        
            //compara de acordo com o confirmed de maneira decrescente, organiza em ordem alfabetica e printa
	        Collections.sort(dados, new ComparatorConfirmedDescending());
	        Collections.sort(dados.subList(0, n4), new ComparatorCountry());
	        for(int i = 0; i < n4; i++){
	            System.out.println(dados.get(i).get_country());
	        }
	    }catch(IOException ioe){
	       System.out.println("Deu algum BO aí no meio");
	       System.exit(1);
	    }finally{
            scanner.close();
        }
	}
}
