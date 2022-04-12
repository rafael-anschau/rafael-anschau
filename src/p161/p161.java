package p161;

import java.io.IOException;
import java.util.Vector;
import java.util.regex.*;
import java.io.Console;

//Solves problem  1.6.1 from Programming Challenges by Skiena
/*
The 3n + 1 problem
Consider the following algorithm to generate a sequence of numbers. Start with an integer n. If n is even, divide by 2. If n is odd, multiply by 3 and add 1. Repeat this process with the new value of n, terminating when n = 1. For example, the following sequence of numbers will be generated for n = 22:
22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
It is conjectured (but not yet proven) that this algorithm will terminate at n = 1 for every integer n. Still, the conjecture holds for all integers up to at least 1, 000, 000.
For an input n, the cycle-length of n is the number of numbers generated up to and including the 1. In the example above, the cycle length of 22 is 16. Given any two numbers i and j, you are to determine the maximum cycle length over all numbers between i and j, including both endpoints.
Input
The input will consist of a series of pairs of integers i and j, one pair of integers per line. All integers will be less than 1,000,000 and greater than 0.
Output
For each pair of input integers i and j, output i, j in the same order in which they appeared in the input and then the maximum cycle length for integers between and including i and j. These three numbers should be separated by one space, with all three numbers on one line and with one line of output for each line of input.
Sample Input
1 10
100 200
201 210
900 1000
Sample Output
1 10 20
100 200 125
201 210 89
900 1000 174
*/


public class p161 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	   //Inicio main		
		int i=1;//temp, pra testes
		int j=2;//temp, pra testes
		
		//Msg inicial
		System.out.println("Digite os pares i,j com espa�o entre um valor e outro aperte enter(0 pra terminar)");
		
		//Declar um VectorPares(vetor de pares ij).	
		Vector<parIJ>VparIJ=new Vector<parIJ>();
		parIJ iparIJ;
		String linha=null;
		
		//Inicio Iterar ler pares, at� ler um zero
		while(true){
			//Ler do teclado, os valores i e j.
			java.io.DataInputStream in =  new java.io.DataInputStream(System.in);
			
			try {
				linha = in.readLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Se a linha for 0(sinal de fim)
			if (linha.equals("0")) {


				//Saia do loop
				break;
			}
			//Inicio Passar express�es regulares na linha para extrair i e j, pegando o n�mero espa�o outro n�mero
			Pattern pattern = Pattern.compile("([0-9]*) ([0-9]*)");
			Matcher matcher = pattern.matcher(linha);
			String match=null;
			boolean found=false;
			while (matcher.find()) {
				match=matcher.group();
				System.out.println("matcher:"+match);
				found=true;
			}			
			if (!found){
					System.out.println("Erro, valores invalidos");			
					System.exit(0);
			}			
			//Fim passar express�es regulares
			//Explodir a string
			String[] ambosValores=match.split(" ");
			
			
			//Converter pra inteiros
			i=Integer.parseInt(ambosValores[0]);
			j=Integer.parseInt(ambosValores[1]);
			
						
			
			//Validar cada i e j(1000000>i e j>0 e i<j)
			if ((j<0)||(i<0)){
				System.out.println("Erro, s� s�o admitidos valores maiores que 1");
				continue;
			}			
			
			//instanciar um parIJ
			iparIJ=new parIJ();
			//Atribuir i e j pra eles
			iparIJ.setI(i);
			iparIJ.setJ(j);
			
			//e jogar pra dentro de um VectorPares
			VparIJ.add(iparIJ);
		
		//Fim iterar ler pares			
		}//while(true)
		
		int k=0;
		int ii,jj;
		//Iterar pares lidos

		for(k=0;k<VparIJ.size();k++){

			//Le os pares dos vetores
			ii=VparIJ.get(k).getI();
			jj=VparIJ.get(k).getJ();
			
			
			gerarResultadoFinal(ii, jj);
			
		//Fim iterar pares lidos
		}//for
		
	   //Fim main	
		
	}//main
	
	//Recebe um n, gera todos ciclos pra ele, e retorna quantos ciclos foram gerados
	public static int contaCiclo(int nn){
	//	System.out.print("n="+nn);//Temp
		int total_ciclo=1;//Inclui n recebido
				
		long n=(long)nn;//converte pra long, pra superar limite do int
		//Iterar
		while(true){
		
			//Se o n=1
			if (n==1) {


					return total_ciclo;
			 }
			
			//Se n for par
			else if (n%2==0){

				n=(n/2);

			}
			
			//Se nao se n for impar
			else {

				n=(n*3)+1;

			}
				
			//Incremente total ciclo em 1
			total_ciclo++;
			
		 
		 
		//Fim iterar
		}//while
						
	}//Conta ciclo
	
	//Buscar o maior valor de ciclos totais contido no intervalo i e j do vetor e o retorna
	private static int buscaMax(Vector<parNTotal> VNTotal){
		
		//Maior=primeiro item[0]
		int maior=VNTotal.get(0).getTotalCiclos();
		int i;
		int totalVarrer=VNTotal.size();
		
		//indice do primeiro item
		int indice_do_maior=0;
		

		//Varrer o vetor
		for(i=0;i<totalVarrer;i++){

			
			//Se V[i]>maior
			if (VNTotal.get(i).getTotalCiclos()>maior){
				//maior=V[i]
				maior=VNTotal.get(i).getTotalCiclos();
			    indice_do_maior=i;
			}
			//Fim se
		}
		//Fim varrer o vetor
		
		//Retornar valor maximo contido no intervalo
		
		
		return indice_do_maior;
	}//BuscaMax
	
	
	//Recebe um vetor de pares do intervalo e gera o resultado final
	private static void gerarResultadoFinal(int i, int j){
	
   

         
		
		  int n;
		  int totalCiclos;
		  int limiteSuperir=j+1;
		  Vector<parNTotal> VparNTotal=new Vector<parNTotal>();
		  
		//Inicio contar ciclos dos elementos do par[i,j]  
			//Iterar n, de i a j inclusive
			for(n=i;n<limiteSuperir;n++){
				
				//contar ciclos de n e atribuir pra m
				totalCiclos=contaCiclo(n);
				
				//Atribuir m e n para um parNTotal
				parNTotal parNT=new parNTotal();
				parNT.setN(n);
				parNT.setTotalCiclos(totalCiclos);
				
				//Atribuir o parNTotal para VparNTotal
				VparNTotal.add(parNT);
			}
			//Fim iterar
		//Fim contar ciclos dos elementos do par i
			
		 //Buscar maximo e atribuir a res
		int indice_do_maior;
		indice_do_maior=buscaMax(VparNTotal);
		
		
		//Escrever a sa�da pedida no enunciado
		System.out.println("i:"+i+" j:"+j+" Total:"+VparNTotal.get(indice_do_maior).getTotalCiclos()+" No numero:"+VparNTotal.get(indice_do_maior).getN());
		
	}//gerar resultado final

	

	//Recebe um n, gera todos ciclos pra ele, e retorna quantos ciclos foram gerados
	public static int contaCiclo(long nn){

		int total_ciclo=1;//Inclui n recebido
				
		long n=(long)nn;//converte pra long, pra superar limite do int
		//Iterar
		while(true){
		
			//Se o n=1
			if (n==1) {
					return total_ciclo;
			 }
			
			//Se n for par
			else if (n%2==0){

				n=(n/2);

			}
			
			//Se nao se n for impar
			else {

				n=(n*3)+1;

			}
				
			//Incremente total ciclo em 1
			total_ciclo++;
			
		 
		 
		//Fim iterar
		}//while
						
	}//Conta ciclo
	
	
}//class
