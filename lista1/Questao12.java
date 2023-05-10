package lista1;

import java.util.Scanner;

public class Questao12 {
	
	public static void main (String[]args) {
		
		Scanner sc = new Scanner (System.in);
		
		double vol, pi, r, h, quad;
		
		System.out.println("Insira o valor do raio: ");
		r = sc.nextDouble();
		System.out.println("Insira o valor da altura: ");
		h = sc.nextDouble();
		
		pi = 3.1614;
		quad = Math.pow(r, 2.0);
		
		vol = pi * quad * h;
		System.out.printf("O volume da lata de óleo é: %.2f%n" ,vol);
		
		sc.close();
	}

}
