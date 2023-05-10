package lista1;

import java.util.Scanner;

public class Questao14 {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		double tempo, vm, dist,lts;
		
		System.out.println("Insira o tempo gasto na viagem em horas: ");
		tempo = sc.nextDouble();
		System.out.println("Insira a velocidade média: ");
		vm = sc.nextDouble();
		
		dist = tempo * vm;
		System.out.println("A distância percorrida durante a viagem foi de: " +dist+ " km/h");
		
		lts = dist/12;
		System.out.println("A quantidade de litros usados durante a viagem foi: " +lts+ " litros");
		
		sc.close();
	}

}
