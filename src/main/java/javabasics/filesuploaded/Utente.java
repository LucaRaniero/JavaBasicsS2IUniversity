package javabasics.filesuploaded;
import java.util.Collections;
import java.util.Map;

public class Utente extends Uploader {	
	private Map<Integer, String[]> utenti;
	
	public Utente(String filename, String delimiter) {
		super(filename, delimiter);
		this.utenti  = fileUploadato;
	}


	public Map<Integer, String[]> getUtenti() {
		//restituisce il map del file utenti.csv
		return utenti;
		}

	public void setUtenti(Integer key, String[] values) {
		//setter di un nuovo utente
		utenti.put(key, values);
	}

	public String getId(int key) {	
		//getter dell'id dell'utente
		return utenti.get(key)[0];
		}

	public String getNome(int key) {
		//getter del nome dell'utente
		return utenti.get(key)[1];
		}

	public String getCognome(int key) {
		//getter del cognome dell'utente
		return utenti.get(key)[2];
		}

	public String getDataNascita(int key) {
		//getter della data di nascita dell'utente
		return utenti.get(key)[3];
		}

	public String getIndirizzo(int key) {
		//getter dell'indirizzo dell'utente
		return utenti.get(key)[4];
		}

	public String getDocumentoID(int key) {
		//getter dell'id del docuemnto dell'utente
		return utenti.get(key)[5];
		}
	
	public Integer getMaxKey() {
		//getter del numero massimo della chiave nella Map
		return Collections.max(utenti.keySet());
		}


	@Override
	public String[] listOfValueRecord(int key) {
		//customizzazione listOfValueRecord della padre (classe Uploader)
		String[] listValue = {getId(key), getNome(key), getCognome(key), getDataNascita(key), getIndirizzo(key), getDocumentoID(key)};
		return listValue;		
	}


}