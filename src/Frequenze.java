import util.ScanDirectory;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Frequenze{ 

    final static String inpDirectory = "C:\\Users\\Chiara\\Desktop\\progettoRomaniJava"; // il directory dei file da scandire 
    final static String delim =" ,.;?!\"\')([]{}:";      // i delimitatori delle parole
    final static String alphabet = "abcdefghilmnopqrstuvzABCDEFGHILMNOPQRSTUVZË‡ÚÈÏ˘Ã»…“¿Ÿ"; //stringa contenente tutte le lettere italiane
    Map<String,Integer> parole = new HashMap<String,Integer>();
	Set<String> dizionario = new HashSet<String>();
    
    public Frequenze(){
    		
    	// scan della cartella in cui ci sono i file 
    	
    	ScanDirectory sd = new ScanDirectory(inpDirectory,".txt");
    	
    	// lettura dei file nella cartella
    	for(String fileName : sd.list()) {
    		
    		if(fileName.equals("DIZIONARIO.txt")) readDictionary(fileName, dizionario);
    		
    		else readFile(fileName, parole);
    	
    	}
    }
	
    // add conta degli elementi 
    public static void add(Map<String,Integer> m, String v){
         Integer o = m.get(v);
         if(o==null) m.put(v,1); 
         else        m.put(v,o+1);	
    }
    
    // restituisce mappa con i token
    public Map<String, Integer> restituisciMappa() {
    	return parole;
    }
    
    // restituisce set con dizionario
    public Set<String> restiruisciSet() {
    	return dizionario;
    }
    
    // metodo che legge il file contenente il dizionario
    public static void readDictionary(String inp, Set<String> d) {
    	try {
    		
    		BufferedReader file_input_dizionario = new BufferedReader(new InputStreamReader(new FileInputStream(inpDirectory+"/"+inp), "UTF-8"));
    		String line = file_input_dizionario.readLine();
    		
    		while(line!=null){
    			d.add(line.toLowerCase());
    			line = file_input_dizionario.readLine();
    		}
    		System.out.println("file "+ inp +": inserite "+ d.size()+" parole");
    		file_input_dizionario.close();
    		
    	} catch(IOException e) {e.printStackTrace();}
    	
    	
    }

    // read lettura di un file e inserzione delle parole
    public static void readFile(String inp, Map<String,Integer> p){
         try {
    	
    		 BufferedReader file_input = new BufferedReader(
    	             new FileReader(inpDirectory+"/"+inp));
    	     String line = file_input.readLine();
    	     while(line!=null){
    	        // salta le righe che non contengono testo			 
    	     	if(line.startsWith("<")) line = file_input.readLine();
    	     	
    	     	else {
    	     		
    	     		StringTokenizer st = new StringTokenizer(line, delim);
        	     	
        	        while(st.hasMoreTokens()){
        	        	String s = st.nextToken();
        	        			 
        	        	boolean flag = true;
        	 					
        	        	for(int i=0; i<s.length(); i++) {
        	 				// esclude parole che non contengono lettere italiane		
        	        		if(!alphabet.contains(s.substring(i,i+1))) {
        	        			flag = false;
        	        			break;
        	        		}
        	 						
        	        	}
        	        	
        	        	// aggiunta delle parole nella mappa
        	        	if(flag) add(p, s.toLowerCase());
        	        			 
        	        }
        	        
        	        line = file_input.readLine();
        	    }			 
    	        
    	     }
    	        	 
    	     file_input.close();
    	     
    	     System.out.println("file "+ inp +": inserite "+ p.size()+" parole");
         
         } catch(IOException e) {e.printStackTrace();}
    }
}