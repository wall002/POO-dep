package lista1;

import java.util.Scanner;

public class Questao11 {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		double prest, valor, taxa, tempo;
		
		System.out.println("Infome o valor da dívida: ");
		valor = sc.nextDouble();
		System.out.println("Informe a taxa: ");
		taxa = sc.nextDouble();
		System.out.println("Informe o tempo de atraso em dias: ");
		tempo = sc.nextDouble();
		
		prest = valor + (valor*(taxa/100)*tempo);
		System.out.println("O valor da prestação é: " +prest);
		
		sc.close();
	}

}
