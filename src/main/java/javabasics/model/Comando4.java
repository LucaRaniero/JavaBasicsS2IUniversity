package javabasics.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import javabasics.filesuploaded.Utente;

public class Comando4 {
	
	private Utente utenti;
	Scanner scanner;

	
	public Comando4(Utente utenti) {
		this.utenti = utenti;
		this.scanner = new Scanner(System.in);
	}
	
	public void aggiungiNuovoUtente() {
		//permette di creare un nuovo utente e assegna in automatico una nuova chiave non esistente 
		String newline = System.lineSeparator();
		
		String stmt = "Un nuovo utente, ciao!" + newline + "Dimmi il tuo nome: ";
		String newNome = doWhileLoopString(stmt, false);

		stmt = "Dimmi il tuo cognome: ";
		String newCognome = doWhileLoopString(stmt, false);

		stmt = "La tua data di nascita (formato DD/MM/YYYY): ";
		String newDataNascita = doWhileLoopString(stmt, true);
		
		stmt = "Il tuo indirizzo: ";
		String newIndirizzo = doWhileLoopString(stmt, false);

		stmt = "Il tuo ID del documento: ";
		String newDocumentoId = doWhileLoopString(stmt, false);
		
		Integer maxKey = utenti.getMaxKey() + 1;
		String[] datiUtente = {
				Integer.toString(maxKey), 
				newNome,
				newCognome,
				newDataNascita,
				newIndirizzo,
				newDocumentoId
				};
		
		utenti.setUtenti(maxKey, datiUtente);
		
		System.out.println("Segnati il tuo ID personale e non perderlo: " + maxKey);
	
	}
	
	
	private String doWhileLoopString(String stmt, boolean checkDate) {
		//gestisce tutti gli input necessari (sono tutti String)
		String strReturn;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALIAN);
		
		do {
			try {

				System.out.println(stmt);	
				strReturn = scanner.nextLine();
				
				if (checkDate) {
					LocalDate.parse(strReturn, formatter);
				}
				
				break;
				
			} catch (InputMismatchException e1) {
				
				stmt = "Inserisci una parola alfanumerica, riprova: ";
				System.out.println("");	
				
			} catch (DateTimeParseException e) {

				System.out.println("Il formato della data è errato, questo è un esempio di come lo devi scrivere -> 01/12/1995");
				stmt = "Riprova: ";
				System.out.println("");	
			}
		} while (true);
		
		return strReturn;

	}
	

}
