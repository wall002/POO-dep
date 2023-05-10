package lista1;

import java.util.Scanner;

public class Questao5 {
	
	public static void main (String[]args) {
		
		Scanner sc = new Scanner (System.in);
		
		int c, f;
		
		System.out.println("Informe o número de graus em Celsius: ");
		c = sc.nextInt();
		
		f = (9 * c + 160) / 5;
		System.out.println("O valor de graus Celsius em escala Fahrenheit é igual a: " + f);
		
		sc.close();
		
	}

}
