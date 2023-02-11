package javabasics.model;
import java.util.InputMismatchException;
import java.util.Scanner;
import javabasics.filesuploaded.Prenotazioni;
import javabasics.filesuploaded.Utente;
import javabasics.filesuploaded.Viaggi;

public class Comando2 {
	
	private Prenotazioni prenotazioni;
	private Utente utenti;
	private Viaggi viaggi;
	Scanner scanner;

	
	public Comando2(Prenotazioni prenotazioni, Utente utenti, Viaggi viaggi) {
		this.prenotazioni =  prenotazioni;
		this.utenti = utenti;
		this.viaggi = viaggi;
		this.scanner = new Scanner(System.in);
	}
	
	public void prenotaViaggio() {
		//permette di prenotare un viaggio
		String stmt;
		
		stmt = "Inserisci l'ID del viaggio che vuoi prenotare: ";
		Integer idViaggioDaPrenotare  = doWhileLoopInteger(stmt, 1);
		
		stmt = "Inserisci il tuo ID utente: ";
		Integer idUtentePrenotato = doWhileLoopInteger(stmt, 2);
		
		Integer maxKey = prenotazioni.getMaxKey() + 1;
		String[] array = {
				Integer.toString(maxKey), 
				Integer.toString(idViaggioDaPrenotare), 
				Integer.toString(idUtentePrenotato)
				};
		
		prenotazioni.setPrenotazione(maxKey, array);
		viaggi.setDisponibilita(idViaggioDaPrenotare, "NO");
		
		}
	
	private Integer doWhileLoopInteger(String stmt, int input) {
		//permette di gestire tutti i do-while-loop che restituiscono degli integer
		Integer intReturn;
		
		do {
			try {

				System.out.println(stmt);	
				intReturn = scanner.nextInt();
				
				if (input == 1) {
					
					if (viaggi.getDisponibilita(intReturn).equals("NO")) {
						
						System.out.println("");
						stmt = "Mi spiace, ma il viaggio che hai selezionato non è disponibile, scegline un altro: ";
						
					} else {
						stmt = "Perfetto, questo viaggio è ancora disponibile!";
						System.out.println(stmt);
						
						return intReturn;
					}
					
				} else if(input == 2) {
					
					stmt = "Ottima scelta, " + utenti.getNome(intReturn) + "!";
					System.out.println(stmt);
					
					return intReturn;
					
					}
				
				} catch (NullPointerException e) {
					
					stmt =  "Mi spiace, ma hai inserito un ID che non esiste, riprova: ";	
					scanner.nextLine();
					
				} catch (InputMismatchException e1) {
				
					System.out.println("Puoi inserire solo numeri interi, riprova: ");
					stmt = "Riprova: ";
					scanner.nextLine();
				} 
			}while (true);

	}

}
