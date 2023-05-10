package lista1;

import java.util.Scanner;

public class Questao13 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		double pi, r, quad, area, per;
		
		pi = 3.1614;
		System.out.println("Dê o valor do raio: ");
		r = sc.nextDouble();
		
		per = 2 * pi * r;
		System.out.printf("O perímetro do círculo é:  %.3f%n" ,per);
		
		quad = Math.pow(r, 2.0);
		
		area = pi * quad;
		System.out.printf("A área do círculo é:  %.3f%n" ,area);
		
		sc.close();
	}

}
