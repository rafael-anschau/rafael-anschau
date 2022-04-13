package p591;

import java.util.Scanner;


//O objetivo dessa classe e resolver o problema 5.9.1 do livro Programming Challenges do Skienna
/*
Children are taught to add multi-digit numbers from right to left, one digit at a time.
Many find the “carry” operation, where a 1 is carried from one digit position to the
next, to be a significant challenge. Your job is to count the number of carry operations
for each of a set of addition problems so that educators may assess their difficulty.

Input
Each line of input contains two unsigned integers less than 10 digits. The last line of
input contains “0 0”.

Output
For each line of input except the last, compute the number of carry operations that
result from adding the two numbers and print them in the format shown below.
*/

public class p591 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Digite um número, tecle enter e depois digite o outro");
		parChrArr pCa=new parChrArr();	
		
		
		while(true) {
		
			//Ler os 2 inteiros
			pCa=lerNumeros();
		
			//Pos condicao:Existem 2 inteiros com menos de 10 digitos lidos nos vetores, sendo o menos significativo a direita.

			char arDe10Termo1[]=pCa.arrCh1;
			char arDe10Termo2[]=pCa.arrCh2;		




			int totalCarry=NdeCarriesDaSoma(arDe10Termo1, arDe10Termo2);


			//Exibe o resultado
			if (totalCarry==0)
				System.out.println("No carry operations.");		

			else if(totalCarry==1) {
				
				System.out.println(totalCarry+" carry operation.");
			}
			
			else
				System.out.println(totalCarry+" carry operations.");
		
		}//while

	}//main

	
	//Esse metodo le os 2 numeros e os retorna em objeto parChrArr
	private static parChrArr lerNumeros() {
		// TODO Auto-generated method stub
		//declarar 3 vetores de inteiros, de 10 elementos cada. termo1, termo2, resultado.
		//(modificado pra vetores de characteres)
			
				String strTermo1;
				String strTermo2;

				
				
				Scanner sc = new Scanner(System.in);
					

				strTermo1 = sc.next();
				strTermo2 = sc.next();


				//se for 0 0
				if (strTermo1.equals("0")) {
					if (strTermo2.equals("0")){
						// terminar o programa
						System.exit(0);
					}
					
				}
				
				//Reverte as strings
				String strTermo1Reversed=new StringBuffer(strTermo1).reverse().toString();
				String strTermo2Reversed=new StringBuffer(strTermo2).reverse().toString();
				

				char[] chrTermo1=strTermo1Reversed.toCharArray();
				char[] chrTermo2=strTermo2Reversed.toCharArray();


				char[] arDe10Termo1=java.util.Arrays.copyOf(chrTermo1, 10);
				char[] arDe10Termo2=java.util.Arrays.copyOf(chrTermo2, 10);

				
				parChrArr pCa=new parChrArr();
								
				pCa.arrCh1=arDe10Termo1;
				pCa.arrCh2=arDe10Termo2;
		
				return pCa;
				
				
	}


	//Soma os numeros dos vetores, e retorna o numero de carries
	private static int NdeCarriesDaSoma(char[] arDe10Termo1, char[] arDe10Termo2) {
		// TODO Auto-generated method stub
		
		
		
		int carry=0;
		int totalCarry=0;
		
		int	i;
		int digitoDeAr1;
		int digitoDeAr2;
		int soma=0;		
		int somaCcarry=0;
		int digitoUsado=0;
		
		char[] arCharResultado=new char[10];
		
		//Adicionar da direita pra esquerda, dos 9 elementos.(0 a 8).
		for(i=0;i<10;i++){
			
			//Parse pra inteiro
			digitoDeAr1=Character.getNumericValue(arDe10Termo1[i]);
			digitoDeAr2=Character.getNumericValue(arDe10Termo2[i]);
			
			
			if (digitoDeAr1==-1){
				digitoDeAr1=0;
				
			}
			
			if (digitoDeAr2==-1){
				digitoDeAr2=0;
				
			}
			
			
			
			//Soma
			soma=digitoDeAr1+digitoDeAr2;
			
			//se soma+carry menor que 10
			if ((soma+carry)<10){
				somaCcarry=soma+carry;			
				
				//colocar resultado no vetor resultado, no mesmo indice,
				arCharResultado[i]=Character.forDigit(somaCcarry, 10);			 


				carry=0;
				
				
			//Poscond:Existe no mesmo indice somado, o resultado final.
			//Poscond: Se vai zero, nao conta, so conta os vai 1
			}
			
			//Senao,(soma+carry=>10)
			else {									

				digitoUsado=soma-10;
				
				//soma o carry,
				somaCcarry=digitoUsado+carry;
				
				//resultado no mesmo indice do vetor,
				arCharResultado[i]=Character.forDigit(somaCcarry, 10);

				carry=1;
	
				totalCarry++;
				//Existe no mesmo indice do vetor, o resultado parcial.(o resto est� no carry).
				//Existe totalCarry incrementado 1.
				
			
			}//else
			
		}//for
		
		//Pos condicao do loop: Para todos digitos dos vetores termo1 e termo2, existe em resultado, no indice correspondente, a soma dos digitos daqueles inidices+carry, quando o resultado da soma for menor que 10, e o resultado da soma-10+carry, sempre que a soma for maior que 10. Existe carry setado, no fim, pra 0 no primeiro caso, e pra 1 no segundo caso.
		
		return totalCarry;
	}//NCarriesDaSoma

}//class


class parChrArr {
	
	static char[] arrCh1;
	static char[] arrCh2;
	
	
}