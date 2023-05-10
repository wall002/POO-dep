package lista1;

import java.util.Scanner;

public class Questao9 {
	
	public static void main (String[]args) {
		
		Scanner sc = new Scanner(System.in);
		
		double salfx, ttvendas, salfnl;
		
		System.out.println("Digite o salário fixo mensal: ");
		salfx = sc.nextDouble();
		System.out.println("Digite o total de vendas do mês: ");
		ttvendas = sc.nextDouble();
		
		salfnl = salfx + ttvendas * 0.15;
		System.out.println("O salário final é: " +salfnl);
		
		sc.close();
	}

}
