package personlig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> spillerPosisjon = new ArrayList<Integer>();
	static ArrayList<Integer> pcPosisjon = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		char [][] spillBrett = {{' ', '|', ' ', '|', ' '},
				                {'-', '+', '-', '+', '-'},
		                        {' ', '|', ' ', '|', ' '},
		                        {'-', '+', '-', '+', '-'},
		                        {' ', '|', ' ', '|', ' '}};
		
		printSpillBrett(spillBrett);
		
		while(true) {
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Skriv dinn plassering (1-9):");
			int pos = scan.nextInt();
			
			System.out.println(pos);
			
			
			while(spillerPosisjon.contains(pos) || pcPosisjon.contains(spillerPosisjon)) {
				System.out.println("Posisjonen er tatt! Prøv igjen");
			    pos = scan.nextInt();
			
			plasser(spillBrett, pos, "Player");
			
			String resultat = checkVinner();
			}
			
			Random rand = new Random();
			int pcPos = rand.nextInt(9) + 1;
			while(spillerPosisjon.contains(pcPos) || pcPosisjon.contains(pcPos)) {
				pcPos = rand.nextInt(9) + 1;
			}    
			plasser(spillBrett, pcPos, "PC");
			
			
			System.out.println();
			printSpillBrett(spillBrett);
			
			String resultat = checkVinner();
			System.out.println(resultat);
		}
	}	
		public static void printSpillBrett(char [][] spillBrett) {	
		for(char [] rad : spillBrett) {
			for(char c : rad) {
				System.out.print(c);
			}
			System.out.println();
		}
		

	}
		public static void plasser(char[][] spillBrett, int pos, String bruker) {

			char symbol = ' ';
			
			if(bruker.equals("Spiller")) {
				symbol = 'X';
				spillerPosisjon.add(pos);
			}else if(bruker.equals("PC")) {
				symbol = 'O';
				pcPosisjon.add(pos);
			}
			
			switch(pos) {
				case 1:
					spillBrett[0][0] = symbol;
					break;
				case 2:
					spillBrett[0][2] = symbol;
					break;
				case 3:
					spillBrett[0][4] = symbol;
					break;
				case 4:
					spillBrett[2][0] = symbol;
					break;
				case 5:
					spillBrett[2][2] = symbol;
					break;
				case 6:
					spillBrett[2][4] = symbol;
					break;
				case 7:
					spillBrett[4][0] = symbol;
					break;
				case 8:
					spillBrett[4][2] = symbol;
					break;
				case 9:
					spillBrett[4][4] = symbol;
					break;
				default:
					break;
		}

}
		public static String checkVinner(){
			
			List topRad = Arrays.asList(1,2,3);
			List midRad = Arrays.asList(4,5,6);
			List bunRad = Arrays.asList(7,8,9);
			List venKol = Arrays.asList(1,4,7);
			List midKol = Arrays.asList(2,5,8);
			List høyKol = Arrays.asList(3,6,9);
			List diag1 = Arrays.asList(1,5,9);
			List diag2 = Arrays.asList(7,5,3);
			
			List<List> vinner = new ArrayList<List>();
			vinner.add(topRad);
			vinner.add(midRad);
			vinner.add(bunRad);
			vinner.add(venKol);
			vinner.add(midKol);
			vinner.add(høyKol);
			vinner.add(diag1);
			vinner.add(diag2);
			
			for(List l : vinner) {
				if(spillerPosisjon.containsAll(l)) {
					return "Gratulerer";
				}if (pcPosisjon.containsAll(l)) {
					return "PC vinner";
				}if (spillerPosisjon.size() + pcPosisjon.size() == 9) {
					return "Uavgjort";
				}
			}
			
			
		
		return "";
		}
}
