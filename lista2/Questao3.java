package lista2;

import java.util.Scanner;

public class Questao3 {
	
	public static void main(String[]args) {
		
		Scanner sc = new Scanner (System.in);
		int idade;
		String sexo;
		
		System.out.println("Entre com seu sexo: -f para feminino e m para masculino");
		sexo = sc.next();
		
		System.out.println("Entre com sua idade: ");
		idade = sc.nextInt();
		
		if(idade > 60 && sexo.equalsIgnoreCase("F")){
			System.out.println("Você pode se aposentar.");
		}else if (idade > 65 && sexo.equalsIgnoreCase("M"))
		{System.out.println("Você pode se aposentar.");
		}else {
			System.out.println("Você não pode se aposentar.");
		}
		sc.close();
	}

}
