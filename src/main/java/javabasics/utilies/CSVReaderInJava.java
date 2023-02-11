package javabasics.utilies;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CSVReaderInJava {
	//classe generica che permette la lettura dei file CSV
  
	private String filename;
	private String delimiter;
    private String[] firstRow;
    private Map<Integer, String[]> records;
    
    public CSVReaderInJava (String filename, String delimiter) {
    	this.delimiter= delimiter;
    	this.filename = filename;
    	this.records = new HashMap<>();
    }


    public Map<Integer, String[]> loadCsv() {
    	//upload del file csv e lo restituisce in un Map<Integer, String[]> in modo che la prima colonna funga da chiave del record
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
            	try {
                    if (count == 0) {
                        count++;
                        continue;
                    }
                    String[] values = line.split(delimiter);
                    int key = Integer.parseInt(values[0]);
                    records.put(key, values);
					
				}  catch (ArrayIndexOutOfBoundsException e) {
					continue;
				} 
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
    
    
    public String[] loadCsvFirstRow() {
    	//restituisce solo l'head del file csv, utile per stampare a schermo in maniera custom tramite la classe CommandLineTable
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            firstRow = br.readLine().split(delimiter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstRow;
    }
    
    }



