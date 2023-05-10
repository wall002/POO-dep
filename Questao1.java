package lista1;

import java.util.Scanner;

public class Questao1 {

	public static void main(String[] args) {

		double a, b, c, media;

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe a primeira nota: ");
		a = sc.nextDouble();
		System.out.println("Informe a segunda nota: ");
		b = sc.nextDouble();
		System.out.println("Informe a terceira nota: ");
		c = sc.nextDouble();

		media = (a + b + c) / 3;

		System.out.println("Media encontrada: " + media);

		sc.close();

	}

}
