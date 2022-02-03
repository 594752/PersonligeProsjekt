package personlig;

import static javax.swing.JOptionPane.*;

public class GjetteTall {
	
	public static void main(String[] args) {
		final int NEDRE = 0;
		final int OVRE = 1000;
		
		String melding = "Tenk på et tall mellom " + NEDRE + " og " + OVRE + ".";
		showMessageDialog(null, melding);
		
		int lav = NEDRE;
		int høy = OVRE;
		int tall = NEDRE-1;
		boolean rettGjetta = false;
		
		
		do { 
			tall = (lav + høy)/2;
			melding = "Tenkte du på " + tall + "?" + " Skriv 0 om tallet er rett, -1 viss tallet du tenker på er lavere eller trykk 1 viss tallet er høyere .";
			int svar = Integer.parseInt(showInputDialog(melding));
			
			rettGjetta = (svar == 0);
			
			if(!rettGjetta) {
				if(svar == - 1) {
					høy = tall - 1;
				}else {
					lav = tall + 1;
				}
			}
		
		}while(!rettGjetta); {
			showMessageDialog(null, "RIKTIG!");
		}

}
}
