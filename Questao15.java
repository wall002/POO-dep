package lista1;

import java.util.Scanner;

public class Questao15 {
	
	public static void main(String[]args0) {
		
		Scanner sc = new Scanner (System.in);
		
		int td, segs, min, h;
		
		System.out.println("Informe o tempo de duração em segundos: ");
		td = sc.nextInt();
		
		h = td / 3600;
		min = (td % 3600) / 60;
		segs = (td % 3600) % 60;
		System.out.println(h + ":" + min + ":" + segs);
		
		sc.close();
	}

}
