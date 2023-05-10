package lista1;

import java.util.Scanner;

public class Questao7 {
	
	public static void main (String [] args) {
	
	Scanner sc = new Scanner (System.in);
	
	int a;
	double b;
	
	System.out.println("Digite um número: ");
	a = sc.nextInt();
	
	b = Math.pow(a, 2.0);
	System.out.println(a +" ao quadrado é igual a: " + b);
	
	sc.close();
	}
		
}
