package lista3;
import java.util.Scanner;
public class Questao3 {
	
	public static void main(String [] args) { 
		double a,b,media;
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Informe sua primeira nota: ");
		a = sc.nextDouble();
		System.out.println("Informe sua segunda nota: ");
		b = sc.nextDouble();
		
		media = (a+b/2);
		
	    if (media>=7) {
	    System.out.println("Aprovado por média.");
	    
	   
	    	
	    } else {
	   System.out.println("Não aprovado por média");
	    }
	    
	    sc.close();
	}

}
