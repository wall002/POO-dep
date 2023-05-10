package lista5;

import java.util.Scanner;

public class Questao8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite seu número de telefone: ");
		String numTel = sc.next();
		
		if(numTel.startsWith("(92)")) {
			System.out.println("O número começa com (92)");
		}else {
			System.out.println("O número não começa com (92)");
		}
		sc.close();
	}

}
