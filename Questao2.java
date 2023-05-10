package lista1;

import java.util.Scanner;

public class Questao2 {
	
    public static void main(String[] args){
        
        int a, b, ad, sub, mult, div;
        
        Scanner sc= new Scanner (System.in);
        
        System.out.println("Digite um número: ");
        a = sc.nextInt();
        System.out.println("Digite outro número: ");
        b = sc.nextInt();
        
        ad = a + b;
        sub = a - b;
        mult = a * b;
        div = a / b;
        
        System.out.println("Resultado da adição: " + ad);
        System.out.println("Resultado da subtração: " + sub);
        System.out.println("Resultado da multiplicação: " + mult);
        System.out.println("Resultado da divisão: " + div);
        
        sc.close();
        
    }
	

}
