package com.skai.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.skai.entities.Person;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
 
 

@Data
//@Slf4j -- problem with ide ..
public class FileReaderUtility {
	
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	 
	public static Map<Integer, Person> parseCSVFileToMapOfPersons(String filePath) throws IOException {
		Map<Integer, Person> mapPersons = new HashMap<>();
		try {

			FileReader filereader = new FileReader(filePath);
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();

			for (String[] row : allData) {
				Person person = new Person();
				person.setId(Integer.parseInt(row[0]));
				person.setName(row[1]);
				person.setAddress(row[2]);
				person.setDateOfBirth(formatter.parse(row[3]));
				person.setRole(row[4]);
				mapPersons.put(Integer.parseInt(row[0]), person);

			}
		} catch (IOException | ParseException e) {
			// use slf4j logger here ..
			System.out.println("error occured during reading file :" + e);
		}
		return mapPersons;
	}
	 
	 

	public static void mergeHobiesWithPersonsFiles(final String filePath, Map<Integer, Person> map) throws IOException {

		FileReader filereader = new FileReader(filePath);
		CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
		String[] nextRecord;
		while ((nextRecord = csvReader.readNext()) != null) {
			  int id=Integer.parseInt(nextRecord[0]);
			  Person person=map.get(id);
			  if(person==null) {
				  System.out.println(" Person with id "+id +" not exist in main table");
				  continue;
			  }
			  person.setHoby(nextRecord[1]); 
			System.out.println(nextRecord);
		}

	}
 
}
