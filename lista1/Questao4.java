package lista1;

import java.util.Scanner;

public class Questao4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double a, b, c, d, mp;

		System.out.println("Digite sua primeira nota: ");
		a = sc.nextDouble();
		System.out.println("Digite sua segunda nota: ");
		b = sc.nextDouble();
		System.out.println("Digite sua terceira nota: ");
		c = sc.nextDouble();
		System.out.println("Digite sua quarta nota: ");
		d = sc.nextDouble();

		mp = (a * 1 + b * 2 + c * 3 + d * 4) / 5;
		System.out.println("Sua média ponderada é: " + mp);

		sc.close();

	}

}
