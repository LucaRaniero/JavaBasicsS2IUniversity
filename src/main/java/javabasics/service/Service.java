package javabasics.service;
import java.util.HashMap;
import java.util.Map;

import javabasics.filesuploaded.Prenotazioni;
import javabasics.filesuploaded.Utente;
import javabasics.filesuploaded.Viaggi;
import javabasics.model.Comando1;
import javabasics.model.Comando2;
import javabasics.model.Comando3;
import javabasics.model.Comando4;
import javabasics.model.Comando5;

public class Service {

	private Utente utenti 				= new Utente("utenti.csv", ";");
	private Prenotazioni prenotazioni 	= new Prenotazioni("prenotazioni.csv", ";");
	private Viaggi viaggi 				= new Viaggi("viaggi.csv", ";");	
	private static Service service;
	
	private Service() {}
	
	public static Service getInstance() {
		//restituisce l'istanza del Service
		if(service == null) {
            service = new Service();
        }
        return service;
		
	}
	
	public Map<Integer, Runnable> instanceOfCommands() {
		//ritorna un Map per eseguire i relativi comandi sulla base del numero immesso dall'utente
		Comando1 comando1 = new Comando1(prenotazioni, utenti, viaggi);
		Comando2 comando2 = new Comando2(prenotazioni, utenti, viaggi);
		Comando3 comando3 = new Comando3(prenotazioni, viaggi);
		Comando4 comando4 = new Comando4(utenti);
		Comando5 comando5 = new Comando5(viaggi);

		Map<Integer, Runnable> allComandi = new HashMap<>();
		allComandi.put(0, () -> System.out.print("Grazie, alla prossima :D"));
		allComandi.put(1, () -> comando1.displayTuttiIViaggi());
		allComandi.put(2, () -> comando2.prenotaViaggio());
		allComandi.put(3, () -> comando3.disdettaViaggio());
		allComandi.put(4, () -> comando4.aggiungiNuovoUtente());
		allComandi.put(5, () -> comando5.writeCsvFile());
		
		return allComandi;
		
	}
	
	public void executeCommand(Map<Integer, Runnable> allComandi, Integer commandNumber) {
		//sulla base dell'input ricevuto, eseguo lo specifico comando istanziato in instanceOfCommands()
		allComandi.getOrDefault(commandNumber, () -> System.out.println("Puoi inserire solo numeri interi compresi tra 0 e 5!")).run();

	}

}
