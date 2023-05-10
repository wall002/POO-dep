package lista1;

import java.util.Scanner;

public class Questao10 {
	
	public static void main (String[]args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Digite um número inteiro: ");
        int num = sc.nextInt();

        int fatorial = 1;
        for (int i = 2; i <= num; i++) {
            fatorial *= i;
        }

        System.out.printf("%d! = %d.", num, fatorial);
		
		sc.close();
	}

}
