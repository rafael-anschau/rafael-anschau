
package p381;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//Resolve o problema 3.8.1 do Livro "Programming Challenges" de Skiena
/*
A common typing error is to place your hands on the keyboard one row to the right
of the correct position. Then “Q” is typed as “W” and “J” is typed as “K” and so on.
Your task is to decode a message typed in this manner.

Input
Input consists of several lines of text. Each line may contain digits, spaces, uppercase
letters (except “Q”, “A”, “Z”), or punctuation shown above [except back-quote (‘)].
Keys labeled with words [Tab, BackSp, Control, etc.] are not represented in the input.

Output
You are to replace each letter or punctuation symbol by the one immediately to its left
on the QWERTY keyboard shown above. Spaces in the input should be echoed in the
output.
*/

public class p381 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		   
		  //Inicializar dicionario
		  HashMap meumapa=null;
		  meumapa=inicializar_dicionario(meumapa);
		  
		  String src=null,res=null;
		 
		  while(true){
			System.out.println("Digite uma frase(somente letras minusculas), Q para sair");  
		   //Ler a string src
			  BufferedReader in = new BufferedReader(new
			  InputStreamReader(System.in));		  
			  try {
					src=in.readLine();
			  }catch (IOException e) {
						// TODO Auto-generated catch block
				    System.out.println("catch!");
					e.printStackTrace();
			  }

		   //    Se a string for Q
			     if (src.equals("Q")) {
		     //      Quebrar
			    	System.out.println("Q, break");
			  		break;
			     }
			      
		     //  senao
			     else {
		      //    Decifre a string e coloque o resultado em res
			    	res=decifrar(src, meumapa); 
		      //    Escrever a string res
			    	System.out.println("final:"+res);
			     }
		     //  fim senao
			
			  
		  //  FIm enquanto
		  }//while
		  
		//Fim
	}//main
	
	
	//Inicializa o dicionario a ser usado e o retorna
	public static HashMap inicializar_dicionario(HashMap meumapa){

		   //Gerar mapa de chars src e dest
		   //Declara-lo
			HashMap meuMapa = new HashMap();
			
			
		   //Inicializa-lo
			meuMapa.put('w', 'q');
			meuMapa.put('s', 'a');
			meuMapa.put('x', 'z');
			
			meuMapa.put('e', 'w');
			meuMapa.put('d', 's');
			meuMapa.put('c', 'x');
			
			meuMapa.put('r', 'e');
			meuMapa.put('f', 'd');
			meuMapa.put('v', 'c');
						
			meuMapa.put('t', 'r');
			meuMapa.put('g', 'f');
			meuMapa.put('b', 'v');
			
			meuMapa.put('y', 't');
			meuMapa.put('h', 'g');
			meuMapa.put('n', 'b');
						
			meuMapa.put('u', 'y');
			meuMapa.put('j', 'h');
			meuMapa.put('m', 'n');
			
			meuMapa.put('i', 'u');
			meuMapa.put('k', 'j');
			meuMapa.put(',', 'm');
			
			meuMapa.put('o', 'i');
			meuMapa.put('l', 'k');
			meuMapa.put('.', ',');
			
			meuMapa.put('p', 'o');
			meuMapa.put('�', 'l');
			meuMapa.put('.', ',');
			
			meuMapa.put('�', 'p');
			meuMapa.put('~', '�');
			meuMapa.put(';', '.');
			
			meuMapa.put('[', '�');
			meuMapa.put(']', '~');
			meuMapa.put('/', ';');
			
			
			meuMapa.put(' ', ' ');
			
			meuMapa.put('1', '\'');
			meuMapa.put('2', '1');
			meuMapa.put('3', '2');
			meuMapa.put('4', '3');
			meuMapa.put('5', '4');
			meuMapa.put('6', '5');
			meuMapa.put('7', '6');
			meuMapa.put('8', '7');
			meuMapa.put('9', '8');
			meuMapa.put('0', '9');
			meuMapa.put('-', '0');
			meuMapa.put('=', '-');
			
			
		 
			return meuMapa;
		
	}//inicializar_dicionario	
	
	
	//Recebe uma string src, o dicionario(referencia) decifra, e retorna a string dest
	static String decifrar(String src, HashMap meuMapa){
		//Inicio string dest decifrar(string src, dic)
		//  Declara string dest
		String dest=null;
		int i;
		char cdest;
		
		//Para cada char src da string src
		for(i=0;i<src.length();i++){
		
		  //char cdest recebe par do map de char src;
		  char temp=(src.charAt(i));	
		  
		  Object temp2=meuMapa.get(temp);

		
		  
		  //string dest recebe o append de char cdest
		  //Na primeira passada, substitui o null
		  if(i==0){
			  dest=temp2.toString();
			  continue;
		  }//if
		  
		  //Na segunda passada em diante, append
		  dest=dest+temp2;

			
		// Fim para       
		}//for
		
		//returna string dest
		return dest; 
		//Fim
		
		
		
	}//decifrar

}//class
