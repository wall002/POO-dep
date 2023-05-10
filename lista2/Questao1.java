package lista2;

import java.util.Scanner;

public class Questao1 {
	
	public static void main (String[]args) {
		
		int idade;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com a sua idade: ");
		idade = sc.nextInt();
		
		if (idade >= 18 ) {
			System.out.println("O usuário é maior de idade.");
		}else {
			System.out.println("O usuário é menor de idade.");
			
			sc.close();
		}
	}

}
 