package javabasics.model;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import javabasics.filesuploaded.Prenotazioni;
import javabasics.filesuploaded.Viaggi;

public class Comando3 {
	
	private Prenotazioni prenotazioni;
	private Viaggi viaggi;
	private Scanner scanner;

	public Comando3(Prenotazioni prenotazioni, Viaggi viaggi) {
		this.prenotazioni =  prenotazioni;
		this.viaggi = viaggi;
		this.scanner = new Scanner(System.in);
	}
	
	public void disdettaViaggio() {
		//permette di disdire un viaggio
		String newline = System.lineSeparator();
		Integer idViaggioDaDisdire = -1;
		String stmt = "Inserisci l'ID del viaggio da disdire la prenotazione: ";

		do {
			try {

				System.out.println(stmt);	
				idViaggioDaDisdire = scanner.nextInt();
				
				if (viaggi.getDisponibilita(idViaggioDaDisdire).equals("SI")) {
					stmt = newline + 
							"Mi spiace, ma il viaggio che hai selezionato non ha una prenotazione pregressa"
							+ newline 
							+ "Scegline un altro: " + newline;	
					
				} else {
					stmt = newline + 
							"Ok allora disdico il tuo viaggio!"
							+ newline;
					System.out.println(stmt);
					
					break;
				} 
				
			}catch (NullPointerException e) {
				stmt =  newline + 
						"Mi spiace, ma hai inserito un ID che non esiste, riprova: "
						+ newline;
				scanner.nextLine();
				
			} catch (InputMismatchException e1) {
				
				stmt = newline + 
						"Puoi inserire solo numeri interi, riprova: "
						+ newline;
				scanner.nextLine();
			}
		} while (true);
		

		viaggi.setDisponibilita(idViaggioDaDisdire, "SI");
		disdettaPenotazione(idViaggioDaDisdire);
		
		
	}
	
	private void disdettaPenotazione(Integer idViaggioDaDisdire) {
		//rimuove il record prenotazione del viaggio appena disdetto
		Map<Integer, String[]> prenotazioniMap = prenotazioni.getPrenotazioni();

		for (Entry<Integer, String[]> prenotazione : prenotazioniMap.entrySet()) {
		    Integer keyPrenotazione = prenotazione.getKey();

			if (prenotazioni.getIdViaggio(keyPrenotazione).equals(String.valueOf(idViaggioDaDisdire))) {

				prenotazioni.removePrenotazione(keyPrenotazione);
				break;
			}						
		}		
		
	}
	

}
