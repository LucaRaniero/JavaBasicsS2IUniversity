package javabasics.filesuploaded;
import java.util.Map;
import java.util.Map.Entry;

import javabasics.utilies.CSVReaderInJava;
import javabasics.utilies.CommandLineTable;

public abstract class Uploader {
	protected String[] fileUploadatoFirstRow;
	protected Map<Integer, String[]> fileUploadato;

	public Uploader(String filename, String delimiter){
		//classe padre dei caricamenti dei file
		CSVReaderInJava fileReader = new CSVReaderInJava(filename, delimiter);
		this.fileUploadato = fileReader.loadCsv();
		this.fileUploadatoFirstRow = fileReader.loadCsvFirstRow();
	}
	
	//astrazione necessaria per il toString() per avere una stampa custom del file
	public abstract String[] listOfValueRecord(int key);
	
	@Override
	public String toString() {
		//permette la stampa a schermo dell'intero file, customizzata dalla classe CommandLineTable()
		CommandLineTable st = new CommandLineTable();
		st.setShowVerticalLines(true);
		st.setHeaders(fileUploadatoFirstRow);

        for (Entry<Integer, String[]> recordFile : fileUploadato.entrySet()) {
        	try {
    		    Integer keyRecord = recordFile.getKey();
    		    
        		st.addRow(listOfValueRecord(keyRecord));        		
        		
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}
        }
        st.print();
		return "";
  }
}
