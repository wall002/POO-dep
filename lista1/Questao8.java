package lista1;

import java.util.Scanner;

public class Questao8 {
	
	public static void main (String[]args) {
		
		Scanner sc = new Scanner (System.in);
		
		int a,b,c;
		double d;
		
		System.out.println("Escreva um número: ");
		a = sc.nextInt();		
		System.out.println("Escreva outro número: ");
		b = sc.nextInt();
		
		c = a-b;
		d = Math.pow(c, 2.0);
		System.out.println("O quadrado da diferença entre " +a+ " e " +b+ " é igual a: " +d);
		
		sc.close();	
	}
	
}
