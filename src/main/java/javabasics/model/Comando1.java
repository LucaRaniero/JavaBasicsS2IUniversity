package javabasics.model;
import java.util.Map;
import java.util.Map.Entry;

import javabasics.filesuploaded.Prenotazioni;
import javabasics.filesuploaded.Utente;
import javabasics.filesuploaded.Viaggi;
import javabasics.utilies.CommandLineTable;

public class Comando1{
	//permette la stampa a schemo di tutti i viaggi e i relativi utenti che hanno prenotato i viaggi
	private Prenotazioni prenotazioni;
	private Utente utenti;
	private Viaggi viaggi;

	public Comando1(Prenotazioni prenotazioni, Utente utenti, Viaggi viaggi) {
		this.prenotazioni =  prenotazioni;
		this.utenti = utenti;
		this.viaggi = viaggi;
	}
	
	public void displayTuttiIViaggi() {
		//estrare tutti i viaggi per stamparli a schermo
		CommandLineTable st = new CommandLineTable();
		st.setShowVerticalLines(true);
		st.setHeaders("ID Viaggio", "Nome Utente", "Descrizione", "Data", "Durata", "Luogo", "Disponibile");

		Map<Integer, String[]> viaggiMap = viaggi.getViaggi();

        for (Entry<Integer, String[]> viaggio : viaggiMap.entrySet()) {
        	
    		    Integer keyViaggio = viaggio.getKey();
        		String nomeUtente = "-";
        		String descrizione = "Viaggio libero!";

        		if (viaggi.getDisponibilita(keyViaggio).equals("NO")) {
        			
        			nomeUtente = getNomeUtenteViaggio(keyViaggio);
    				descrizione = "Viaggio prenotato da: " + nomeUtente;
    				
				}
        		
        		st.addRow(
        				viaggi.getId(keyViaggio), 
        				nomeUtente, 
        				descrizione, 
        				viaggi.getData(keyViaggio), 
        				viaggi.getDurata(keyViaggio), 
        				viaggi.getArrivo(keyViaggio), 
        				viaggi.getDisponibilita(keyViaggio));
        		
        }
        st.print();
	}
	
	private String getNomeUtenteViaggio(Integer keyViaggio) {		
		//estrae il nome dell'utente che ha una prenotazione

		String nomeUtente;
		Map<Integer, String[]> prenotazioniMap = prenotazioni.getPrenotazioni();
		
		for (Entry<Integer, String[]> prenotazione : prenotazioniMap.entrySet()) {
		    Integer keyPrenotazione = prenotazione.getKey();

			if (prenotazioni.getIdViaggio(keyPrenotazione).equals(viaggi.getId(keyViaggio))) {

				Integer keyUtente = Integer.parseInt(prenotazioni.getIdUtente(keyPrenotazione));
				nomeUtente = utenti.getNome(keyUtente) + " " + utenti.getCognome(keyUtente);
				
				return nomeUtente;
			}						
		}
		return null;
	}
}
