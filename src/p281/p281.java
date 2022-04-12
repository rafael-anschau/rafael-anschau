

package p281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/*
//Solves problem 2.8.1 from Programming Challenges
Jolly Jumpers
A sequence of n > 0 integers is called a jolly jumper if the absolute values of the differences between successive elements take on all possible values 1 through n - 1. eg.

1 4 2 3 

is a jolly jumper, because the absolute differences are 3, 2, and 1, respectively. The definition implies that any sequence of a single integer is a jolly jumper. Write a program to determine whether each of a number of sequences is a jolly jumper.

Input sample: Your program should accept as its first argument a path to a filename. Each line in this file is one test case. Each test case will contain an integer n < 3000 followed by n integers representing the sequence. The integers are space delimited.

Output sample:

For each line of input generate a line of output saying 'Jolly' or 'Not jolly
*/

public class p281 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Inicio
		//Declarar vetor de inteiros
		Vector<Integer> vetorEntrada=new Vector<Integer>();
		String entrada;
		//Inicio loop
		while(true){
			//Limpa ventrada
			vetorEntrada.clear();
		//	Ler linha de entrada
			System.out.println("Digite os n�meros(0 para sair):");
			//Ler sequencia de numeros
			  //Ler a string(primeiro direto, depois do teclado).
			  entrada="4 1 4 2 3";//temporario pra testes
			  BufferedReader in = new BufferedReader(new
			  InputStreamReader(System.in));		  
			  try {
				entrada=in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			//implodir a string
			int i;
			String[] arrinput=entrada.split(" ");
			
			
			

			//Converter para inteiros
			//Jogar cada inteiro no vetor de entrada
			for(i=0;i<arrinput.length;i++){
				vetorEntrada.add(Integer.parseInt(arrinput[i]));
				
			}
			
			
			
		   
			   

	 		
		//  se for==0, 
			if (vetorEntrada.get(0)==0){

		//      sair(encerra)
				System.exit(0);
			}//if
		//  senao
			else
		//     aplicar e_joly no vetor de inteiros
				if (e_jolly(vetorEntrada)==true){
					  System.out.println("E jolly");
				  }
				  else {			  
					  System.out.println("N�o e jolly");
				  }
			   
			//fim loop
		}//while

		
		
		
		  		
		

	}

	//Recebe um vetor de inteiros, e reotorna true se for jolly, ou false se n�o for.
	public static boolean e_jolly(Vector ventrada){
		
		//Inicio
		int i,ii,j=1;
		Integer sub1,sub2,diferenca;
		Integer res;
		Vector<Integer> vdif=new Vector<Integer>();
		
		
		//Testa o que esta dentro
		   
		   
		   
		   
		   //fim temporario, pra teste
		
		//obter as diferencas dos numeros de v[1] at� v[numbersOnTheLine] e colocar em vdifs[nntheline-1]
	            				
				for(i=1;i<ventrada.size()-1;i++){
					//subtrair os numeros do vetor, a partir de v[1]
					//pelo seguinte(v[2] aqui) v[0] vezes,
					//e ir colocando em vdifs, a partid e v[1]
					sub1=(Integer)ventrada.get(i);
					System.out.println("sub1:"+sub1);
					
					ii=i+1;
					sub2=(Integer)ventrada.get(ii);
					System.out.println("sub2:"+sub2);
					diferenca=sub1-sub2;
					
					//Obtem o modulo da diferenca, ants de adiciona-la
				    diferenca=Math.abs(diferenca);
					System.out.println("diferenca:"+diferenca);
					vdif.add(diferenca);
					
				}

				//testar o vdif
				
				 for(i=0;i<vdif.size();i++){
					   System.out.println(vdif.get(i));
				   }
				 //fim testar
				
		
		   //<Existe um vetor que guarda as diferen�as das sucessivas divis�es necess�rias para determinar jolly>
		  
		//
		//
			boolean achou=false;
			 //iterar de 1 at� ventrada[0]
				 
			//inicio loc bug
				 for(i=1;i<(Integer)ventrada.get(0);i++){
				    
				 //se  achar o numero iterado
					 for(j=0;j<vdif.size();j++){
					
						 achou=false;
					 
					   if (i==(Integer)vdif.get(j)){
					   
						   
			  //fim loc bug
					      achou=true;
					      
					      //break
					       break;  
						 //<existe uma busca completa de um numero em vdif>
					   }
					   //senao, continue, redundante
					 
					 	
					 }
					 
					 
					 
					 if (achou==false){
						 
						 return false;
					 }
					 

				 }//for
				 
			 //fim iterar 
			 //retorna true
			 
		     
		     return true;
		     
		//Fim buscar
		  
		    //<Existe uma resposta para a pergunta � jolly, ou n�o>
		
		
		
	}
	
	
}
