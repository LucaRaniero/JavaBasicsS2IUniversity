package javabasics.controller;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import javabasics.service.Service;

public class Controller {
    private Service service;
    
	public Controller() {
		//istanzia il Service
		this.service = Service.getInstance();
	}

	public void start() {
		//do-while-loop per gestione di tutti i comandi fino allo 0
		Scanner scanner = new Scanner(System.in);
        int commandNumber = -1;
        Map<Integer, Runnable> allComandi = service.instanceOfCommands();
        
		do {
			try {

		        stringToPrintPossibleCommands();
		        
				commandNumber = getUserInput(scanner);

				System.out.println("");
				System.out.println("");
				
				service.executeCommand(allComandi, commandNumber);
				
				System.out.println("");
				System.out.println("");

		    } catch (InputMismatchException e) {
		    	stringToPrintInputMismatch();
		        scanner.nextLine();
		    }
			
		} while (commandNumber != 0);
	}


	
    private Integer getUserInput(Scanner scanner) {
    	//restituisce in output il numero inserito. Se non è un numero verrà gestito in start()
        System.out.println("Inserisci il numero:");
        return scanner.nextInt();
    }
    
	private void stringToPrintPossibleCommands() {
		//stampa i possibili comandi 
		System.out.println("Cosa desideri fare?");
		System.out.println(" - Per visualizzare tutti i viaggi dell'interno del sistema, digita 1");
		System.out.println(" - Prenotare un viaggio esistente, digita 2");
		System.out.println(" - Disdire la prenotazione di un viaggio, digita 3");
		System.out.println(" - Aggiungere un nuovo utente, digita 4");
		System.out.println(" - Esportare un file con i viaggi disponibili, digita 5");
		System.out.println(" - Uscire dal programma, digita 0");
	}
    
	private void stringToPrintInputMismatch() {
		//spiega all'utente l'input desiderato
		System.out.println("");
        System.out.println("Puoi inserire solo numeri interi compresi tra 0 e 5!");
		System.out.println("");
	}
}
