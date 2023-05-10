package lista4;

import java.util.Scanner;

public class Questao19 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int [][] matrizA = new int [3][5];
		int [][] matrizB = new int [5][3];
		
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<5; j++) {
				matrizA[i][j]= sc.nextInt();
			}
		}
		
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<5; j++) {
				matrizB[j][i] = matrizA[i][j];
			}
		}
		
		System.out.println("Matriz A:");
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<5;j++) {
				System.out.println(matrizA[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Matriz B: ");
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<3; j++){
				System.out.println(matrizB[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
		
	}

}
