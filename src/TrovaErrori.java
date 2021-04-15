import java.io.*;
import java.util.*;

public class TrovaErrori {
	
	Map<String,Integer> parole = new HashMap<String,Integer>();
	Set<String> dizionario = new HashSet<String>();
	static Map<String, Integer> err = new TreeMap<String, Integer>();
	
	// costruttore della classe TrovaErrori
	public TrovaErrori(Map<String,Integer> m, Set<String> d){
		parole = m;
		dizionario = d;
	}
	
	// metodo che trova le parole che non sono presenti nel dizionario
	public static void errori(Map<String,Integer> p, Set<String> d) {
		
		try {
			
			FileWriter fos = new FileWriter("C:\\Users\\Chiara\\Desktop\\progettoRomaniJava\\output.txt");
			PrintWriter dos = new PrintWriter(fos);
						
			// controllo se la parola non è presente nel dizionario
			for (Map.Entry<String, Integer> e : p.entrySet()) {
				
				if(/*e.getValue()<=3 &&*/ !d.contains(e.getKey())) 
					err.put(e.getKey(), e.getValue());
				
			}			
			
			// stampa le parole non presenti nel dizionario ovvero potenziali errori
			for(Map.Entry<String, Integer> e : err.entrySet())
				dos.println(e.getKey() + "\t" + e.getValue());
			
			System.out.println("Parole non riconosciute: " + err.size());
			
			dos.close();
			fos.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
