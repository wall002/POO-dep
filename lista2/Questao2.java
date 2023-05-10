package lista2;

import java.util.Scanner;

public class Questao2 {

	public static void main(String[] args) {

		int a, b;

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o primeiro valor: ");
		a = sc.nextInt();

		System.out.println("Informe o segundo valor: ");
		b = sc.nextInt();

		if (b > a) {
			System.out.println("O menor valor é: " + a);
		} else if (a == b) {
			System.out.println("Os valores sâo iguais.");
		} else {
			System.out.println("O menor valor é: " + b);
		}

		sc.close();
	}

}
