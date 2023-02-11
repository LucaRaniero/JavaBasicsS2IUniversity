package javabasics.model;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javabasics.filesuploaded.Viaggi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Comando5 {

	  private static final String NEW_LINE_SEPARATOR = "\n";
	  private static final String COMMA_DELIMITER = ";";	  
	  private Viaggi viaggi;
	  
	  public Comando5(Viaggi viaggi) {
		this.viaggi = viaggi;
	}
	  
	  public void writeCsvFile() {
		//crea e scrive un file csv di campi custom dei soli viaggi disponibili
		FileWriter fileWriter = null;
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
		String fileName = "viaggi_" + today.format(formatter) + ".csv";
		Map<Integer, String[]> viaggiMap = viaggi.getViaggi();
		
		try {
		  fileWriter = new FileWriter(fileName);
		
		  // Write header
		  fileWriter.append("ID");
		  fileWriter.append(COMMA_DELIMITER);
		  fileWriter.append("Data");
		  fileWriter.append(COMMA_DELIMITER);
		  fileWriter.append("Durata");
		  fileWriter.append(COMMA_DELIMITER);
		  fileWriter.append("Partenza");
		  fileWriter.append(COMMA_DELIMITER);
		  fileWriter.append("Arrivo");
		  fileWriter.append(NEW_LINE_SEPARATOR);
		
		  for (Entry<Integer, String[]> viaggio : viaggiMap.entrySet()) {
			  Integer keyViaggio = viaggio.getKey();
			  
			  
			  if (viaggi.getDisponibilita(keyViaggio).equals("SI")) {
				  String[] array = {
							viaggi.getId(keyViaggio),
							viaggi.getData(keyViaggio),
							viaggi.getDurata(keyViaggio),
							viaggi.getPartenza(keyViaggio),
							viaggi.getArrivo(keyViaggio)				
							}; 
				  List<String[]> datiViaggioInScope = new ArrayList<String[]>();
				  
				  datiViaggioInScope.add(array);
				  
				  for (String[] line : datiViaggioInScope) {
					  
					  for (int i = 0; i < line.length; i++) {
						  
						  fileWriter.append(line[i]);
						  
						  if (i < line.length - 1) {
							  fileWriter.append(COMMA_DELIMITER);
							  }
						  }
					  fileWriter.append(NEW_LINE_SEPARATOR);
					  }
				  } else {continue;}
			
			
			  }
		
		  System.out.println("Il CSV è stato creato con successo");
		  
		} catch (Exception e) {
			
		  System.out.println("Errore in CsvFileWriter");
		  
		} finally {
		  try {
			  
		    fileWriter.flush();
		    fileWriter.close();
		    
		  } catch (IOException e) {
			  
		    System.out.println("Errore durante il flushing/closing del fileWriter");
		      }
	    }
	  }
}