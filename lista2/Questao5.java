package lista2;

import java.util.Scanner;

public class Questao5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double nota1, nota2, mediafin;

		System.out.println("Informe sua nota do bimestre: ");
		nota1 = sc.nextDouble();

		if (nota1 >= 6) {
			System.out.println("Parabéns você está aprovado!");
		} else {
			System.out.println("Poxa, vocÊ está de recuperação :(");
			System.out.println("Informe sua nota obtida na recuperação: ");
			nota2 = sc.nextDouble();
			mediafin = (nota1 + nota2) / 2;
			if (mediafin >= 5) {
				System.out.println("Aluno aprovado na recuperação");
			} else {
				System.out.println("Reprovado");
			}
		}
		sc.close();

	}

}
