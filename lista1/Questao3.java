package lista1;

import java.util.Scanner;

public class Questao3 {
	
	public static void main (String[]args) {
		
		Scanner sc = new Scanner (System.in);
		
		double a,b,c,mp;
		
		System.out.println("Digite a primeira nota: ");
		a = sc.nextDouble();
		System.out.println("Digite a segunda nota: ");
		b = sc.nextDouble();
		System.out.println("Digite a terceira nota: ");
		c = sc.nextDouble();
		
		mp = (a * 1 + b * 2 + c * 2) / 5;
		System.out.println("Sua médida ponderada é: " + mp);
		
		sc.close();
		
	}

}
