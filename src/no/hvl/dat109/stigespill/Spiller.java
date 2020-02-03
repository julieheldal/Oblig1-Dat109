/**
 * 
 */
package no.hvl.dat109.stigespill;

import java.util.Scanner;

/**
 * 
 * Klasse som definerer spillere
 * 
 * @author Julie Marie Heldal
 *
 */
public class Spiller {
	
	private Scanner scanner = new Scanner(System.in);
	private String navn;
	private Brikke brikke;
	
	
	
	/**
	 * 
	 * @param navn
	 * @param brikke
	 */
	public Spiller(String navn, Farge farge, Brett brett) {
		this.navn = navn;
		this.brikke= new Brikke(brett,farge);
		

	} 
	


	public void spillTrekk(Terning terning) {
		
		Integer verdi =0;
		int antallseksere=0;
		
		System.out.println("---------------------------------");
		System.out.println("Det er " + navn + " sin tur");
		System.out.println("Trykk enter for å trille");
			if(scanner.hasNextLine()) {
				terning.trill();
				 verdi = terning.getVerdi();
				System.out.println("Du fikk " +  verdi);
	    
				while(verdi.equals(6) || verdi.equals(12)) {
					System.out.println(navn +" Du fikk 6!!, trill på nytt");
					antallseksere++;
					terning.trill();
					verdi= 6+ terning.getVerdi();
					System.out.println("Du fikk nå " + terning.getVerdi());
					
			
				}
				
					if(antallseksere==3) {
						System.out.println("Du fikk 3 seksere på rad " + navn + " Må tilbake til start");
						verdi =0;
						brikke.flyttStart();
				
					} else {
						brikke.flytt(verdi); 
						
						
				
			} 
					System.out.println("Du er nå på rute " + brikke.getRute().getRuteNr());
					scanner.nextLine();
		}
			
	}



	public String getNavn() {
		return navn;
	}



	public void setNavn(String navn) {
		this.navn = navn;
	}



	public Brikke getBrikke() {
		return brikke;
	}



	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}
	
	

}
