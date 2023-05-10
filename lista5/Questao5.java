package lista5;
import java.util.Random;
public class Questao5 {
	
	public static void main(String[] args) {

		Random rdm = new Random();
		int numAleatorio = rdm.nextInt(10) + 1;
		System.out.println("O número aleatório: " + numAleatorio);
	}

}
