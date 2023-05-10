package lista1;

import java.util.Scanner;
public class MediaPonderada {
	
	public static void main(String [] args) {
		
		double a,b,c,d, media;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe a primeira nota: ");
		a = scanner.nextDouble();
		System.out.println("Informe a segunda nota: ");
		b = scanner.nextDouble();
		System.out.println("Informe a terceira nota: ");
		c = scanner.nextDouble();
		System.out.println("Informe a quarta nota: ");
		d = scanner.nextDouble();
		
		media = (a * 1 + b * 2 + c * 3 + d * 4)/5;
		
		System.out.println("A média ponderada é: " + media);
		scanner.close();
	}
}
