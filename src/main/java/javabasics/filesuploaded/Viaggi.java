package javabasics.filesuploaded;
import java.util.Map;

public class Viaggi extends Uploader {
	private Map<Integer, String[]> viaggi;
	
	public Viaggi(String filename, String delimiter) {
		super(filename, delimiter);
		this.viaggi  = fileUploadato;
	}

	public Map<Integer, String[]> getViaggi() {
		//getter del map completo dei viaggi
		return viaggi;
		}

	public String[] getViaggioSingolo(Integer key) {
		//getter per avere i valori di uno specifico viaggio
		return viaggi.get(key);
		}

	public void setViaggi(Integer key, String[] values) {
		//setter per aggiungere un nuovo viaggio
		viaggi.put(key, values);
	}

	public String getId(int key) {	
		//getter dell id del viaggio
		return viaggi.get(key)[0];
		}

	public String getData(int key) {	
		//getter della data del viaggio
		return viaggi.get(key)[1];
		}

	public String getDurata(int key) {	
		//getter della durata del viaggio
		return viaggi.get(key)[2];
		}

	public String getPartenza(int key) {		
		//getter della partenza del viaggio
		return viaggi.get(key)[3];
		}

	public String getArrivo(int key) {		
		//getter dell'arrivo del viaggio
		return viaggi.get(key)[4];
		}

	public String getDisponibilita(int key) {		
		//getter della disponibilità di un viaggio
		return viaggi.get(key)[5];
		}

	public void setDisponibilita(int key, String stringa) {	
		//setter della disponibilità di un viaggio
		viaggi.get(key)[5] = stringa;
		}


	@Override
	public String[] listOfValueRecord(int key) {
		//customizzazione listOfValueRecord della padre (classe Uploader)
		String[] listValue = {getId(key), getData(key), getDurata(key), getPartenza(key), getArrivo(key), getDisponibilita(key)};
		return listValue;		
	}

}
