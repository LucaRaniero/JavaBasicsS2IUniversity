package javabasics.filesuploaded;
import java.util.Collections;
import java.util.Map;

public class Prenotazioni extends Uploader{
	private Map<Integer, String[]> prenotazioni;
	
	public Prenotazioni(String filename, String delimiter) {
		super(filename, delimiter);
		this.prenotazioni = fileUploadato;
	}

	public Map<Integer, String[]> getPrenotazioni() {
		//restituisce il map del file prenotazioni.csv
		return prenotazioni;
		}

	public void setPrenotazione(Integer key, String[] values) {
		//setter di una nuova prenotazione
		prenotazioni.put(key, values);
	}

	public void removePrenotazione(Integer key) {
		//rimozione di una specifica prenotazione
		prenotazioni.remove(key);
	}

	public String getId(int key) {		
		//getter dell'id del record (ragionato come chiave)
		return prenotazioni.get(key)[0];
		}

	public String getIdViaggio(int key) {	
		//getter dell'id viaggio
		return prenotazioni.get(key)[1];
		}

	public String getIdUtente(int key) {		
		//getter dell'id utente
		return prenotazioni.get(key)[2];
		}
	
	public Integer getMaxKey() {
		//getter del numero massimo della chiave nella Map
		return Collections.max(prenotazioni.keySet());
		}
	
	@Override
	public String[] listOfValueRecord(int key) {
		//customizzazione listOfValueRecord della padre (classe Uploader)
		String[] listValue = {getId(key), getIdViaggio(key), getIdUtente(key)};
		return listValue;		
	};

	  

}
