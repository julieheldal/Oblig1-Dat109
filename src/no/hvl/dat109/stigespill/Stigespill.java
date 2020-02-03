/**
 * 
 */
package no.hvl.dat109.stigespill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * Klasse som definerer spillet og oppretter en simulering av stigespillet
 * 
 * @author Julie Marie Heldal og Vilde Kristine Fossum
 *
 */
public class Stigespill {
	
	private Brett brett;
	private List<Spiller> spillere = new ArrayList<Spiller>();  
	private Terning terning;
	private Scanner scanner = new Scanner(System.in);
	

	/**
	 * Oppretter nytt stigespillobjektet
	 * 
	 * 
	 */
	
	public Stigespill() {
		this.brett = new Brett();
		this.terning = new Terning();
		
		
	}
	/**
	 * Metode som starter spillet.
	 */
	public void startSpill() {
		OpprettSpillere(); 
		while(ikkeVunnet()) {
			spillRunde();
		}
		
			sluttSpill();
		
	}
	/**
	 * Metode som avslutter spillet og kårer en vinner
	 */
	
	public void sluttSpill() {
		
		
		String vinner = spillere.stream()
								.filter(s -> s.getBrikke().getRute().getRuteNr() == 100)
								.map(s -> s.getNavn())
								.collect(Collectors.joining());
		System.out.println( vinner + ", Du har vunnet spillet!!");
		
		System.out.println("Spillet er nå ferdig");
		
			
		
	}
	/**
	 * Metode som utfører en runde.
	 */
	private void spillRunde() {
		for(int i = 0; i < spillere.size(); i++) {
			spillere.get(i).spillTrekk(terning);
			
		}
		
	}
	
	/**
	 * Metode som oppretter Spillere
	 */
	public void OpprettSpillere() {
		 
		String regex = "^[A-ZÆØÅa-zæøå ]+$";
		System.out.println("Oppgi antall spillere");
		int antall = scanner.nextInt();
		
		while (( antall < 2) || (antall > 4)){
			System.out.println("Antall spillere må være mellom 2 og 4, skriv på nytt");
			antall = scanner.nextInt();
		}
		for (int i =1; i <= antall; i++) {
			System.out.println("Oppgi navn på spiller " + i);
			scanner.nextLine();
			String navn = scanner.nextLine();
			
			while(!navn.matches(regex)) {
				System.out.println("Ugyldig navn, prøv på nytt");
				navn = scanner.nextLine();	
			}
			

			System.out.println("Oppgi farge på brikke");
			System.out.println("Oppgi 1:Blå 2:Rød 3:Grønn 4:Gul");
			int svar = scanner.nextInt();
			Farge farge = null; 
			
			switch(svar) {
			case 1: farge = Farge.BLÅ;
			case 2: farge = Farge.RØD;
			case 3: farge = Farge.GRØNN;
			case 4: farge = Farge.GUL;
			
			}
			Spiller spiller = new Spiller(navn, farge, brett);
			spillere.add(spiller);
		}
		
	}
	/**
	 * Sjekker om spilleren har vunnet.
	 * @return returnerer true om spiller står på rute nr 100
	 */
	
	public boolean ikkeVunnet() {
		return !spillere.stream()
						.anyMatch(s -> s.getBrikke().getRute().getRuteNr() == 100);
	}
	

	

}
