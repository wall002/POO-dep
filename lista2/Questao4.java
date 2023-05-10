package lista2;

import java.util.Scanner;

public class Questao4 {
	
	public static void main (String[]args) {
		
		Scanner sc = new Scanner(System.in);
		
		double a, b, media;
		
		System.out.println("Informe a primeira nota:");
		a = sc.nextDouble();
		System.out.println("Informe a segunda nota:");
		b = sc.nextDouble();
		
		media = (a+b)/2;
		
		if (media >=7) {
			System.out.println(media +" Aprovado por média :D");
		}else {
			System.out.println(media +" Não aprovado por média :(");
		}
		
		sc.close();
	}

}
