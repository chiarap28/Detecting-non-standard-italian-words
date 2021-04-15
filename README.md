# Detecting-non-standard-italian-words

Lo scopo di questo progetto è quello di individuare la quantità di parole non appartenenti all’italiano standard e di indagare sulla tipologia di queste all’interno di un corpus composto da estratti di pagine di Wikipedia in italiano.
Il programma è utile per investigare le modalità di scrittura degli autori delle pagine di Wikipedia e la presenza di neologismi e/o di anglicismi nella lingua italiana.

Input:
- un corpus composto da testi estratti dalle pagine di Wikipedia in lingua italiana, di dimensione di 2.24 GB, suddiviso in 24 documenti con estensione .txt;
- un formario della lingua italiana, contenente 1.268.440 forme.

In output restituisce un file contenente le parole non riconosciute (ovvero non presenti all’interno del formario), in ordine alfabetico, seguite dalla loro frequenza all’interno dei testi presi in esame.
Il programma ha quindi lo scopo di identificare e quantificare (in tempi brevi) i non-word error – ovvero quegli errori commessi dagli autori dei testi che corrispondono a sequenze di caratteri non riconducibili a una qualsiasi forma della lingua standard – e tutti i termini che possono essere ricondotti ad aree della lingua diverse da quella standard.

Il programma è stato testato ed eseguito su un calcolatore avente un processore Intel(R) Core(TM) i7-8565U e una RAM di dimensione 16 GB. Il tempo stimato per l’esecuzione è, in media, di 112.216 secondi.

Il programma è suddiviso nelle seguenti classi:
1. Main: è la classe principale che, attraverso la chiamata ad altre classi, crea un oggetto di tipo Frequenze e uno di tipo Errori, grazie ai quali sarà possibile avere un listato delle parole non riconosciute all’interno del corpus analizzato.
2. Frequenze: questa classe permette le seguenti azioni:
  a. All’interno del costruttore viene scandita la cartella contente i file da analizzare;
  b. Il metodo readFile permette di leggere i file del corpus. Per ogni file non vengono considerate le righe contenenti metadati (ovvero tag), ma solo quelle contenenti testo. Ogni riga del testo viene tokenizzata, attraverso il tokenizzatore di Java StringTokenizer (al quale vengono passati come parametri la riga del testo e una lista di delimitatori). Successivamente, per ogni token della riga, viene attuata una prima scrematura che elimina quelli che contengono caratteri che non appartengono all’alfabeto italiano. Ogni token viene poi aggiunto, attraverso il metodo add, a una HashMap;
  c. Il metodo readDictionary permette di inserire le forme del formario passato in input all’interno di un Set<String>;
  d. Il metodo add permette di inserire i token all’interno di una HashMap<String, Integer> calcolandone la frequenza;
  e. I metodi restituisciMappa e restituisciSet permettono infine di restituire il set contenente il dizionario e la mappa contenente i token dei testi e le relative frequenze.
3. TrovaErrori: questa classe permette di scandire tutte le parole trovate all’interno dei testi – presenti nella HashMap di cui sopra – e di controllare se ognuna di queste parole sia presente o meno all’interno del formario. Le parole non riconosciute, con la corrispettiva frequenza, sono salvate in una TreeMap<String, Integer> e salvate in un file, la cui estensione è scelta dall’utente.
4. SystemData, del pacchetto util: questa classe permette di calcolare il tempo impiegato dall’esecuzione del programma.
5. ScanDirectory, del pacchetto util: questa classe permette di restituire – attraverso il metodo list – una lista contenente i nomi dei file presenti in una data cartella passata come parametro al costruttore della classe stessa.
