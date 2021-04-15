import java.util.*;
import java.io.*;
import util.*;


public class main {

	public static void main(String[] args) throws Exception {
		// chiamo il metodo che inizia il conteggio dei secondi 
		SystemData.initTime();
		// creo oggetto della classe Frequenze	
		Frequenze freq = new Frequenze();
		// salvo nelle variabili la lista delle parole e il dizionario attraverso
		// la chiamata degli opportuni metodi
		Map<String,Integer> parole = freq.restituisciMappa();
		Set<String> dizionario = freq.restiruisciSet();
		// creo oggetto della classe TrovaErrori
		TrovaErrori err = new TrovaErrori(parole, dizionario);
		// uso il metodo errori dell'oggetto err
		err.errori(parole, dizionario);		
		// stampo il conteggio dei secondi
		System.out.println("Tempo impiegato " + SystemData.askTime() + " secondi.");
		
	}
}
