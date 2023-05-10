package lista5;

import java.util.Scanner;

public class Questao10 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma palavra: ");
		String palavra = sc.next();
		
		StringBuilder palavraInvertida = new StringBuilder(palavra).reverse();
		System.out.println("A palavra invertida é: " + palavraInvertida);
		
		sc.close();
	}

}
