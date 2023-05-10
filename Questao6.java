package lista1;

import java.util.Scanner;

public class Questao6 {
	
	public static void main (String[]args) {
		
		Scanner sc = new Scanner (System.in);
		
		int c, f;
		
		System.out.println("Informe o número de graus em Fahrenheit: ");
		f = sc.nextInt();
		
		c = (f - 32) * (5 / 9);
		System.out.println("O valor de graus Fahrenheit em escala Celsius é igual a: " + c);
		
		sc.close();
		
	}

}
