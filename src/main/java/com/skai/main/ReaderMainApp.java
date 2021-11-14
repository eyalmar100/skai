package com.skai.main;

 
import java.util.List;
import com.skai.entities.Person;
import com.skai.services.BigDataCsvFileReader;
import com.skai.services.CSVPersonsReader;
import com.skai.services.Reader;

public class ReaderMainApp {
    
	// could be accepting the name of the file from outside i.e program argument, property file , etc.
	private static final String FILE_LOCATION_PREFIX = "src/main/resources/csv/";

	public static void main(String[] args) {
		Reader<Person> fileReader = new CSVPersonsReader();
		List<Person> persons=fileReader.readAndConvertFile(FILE_LOCATION_PREFIX + "persons.csv",
				FILE_LOCATION_PREFIX + "persons_extend.csv");
		
		fileReader.print(persons);
 	}

}
