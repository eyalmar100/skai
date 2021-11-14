package com.skai.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.skai.entities.Person;
import com.skai.util.FileReaderUtility;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

 
@Data
//@Slf4j
public class CSVPersonsReader implements Reader<Person> {

	public List<Person> readAndConvertFile(String personsFileName,String hobiesFileName) {
		try {
			Map<Integer,Person> map=FileReaderUtility.parseCSVFileToMapOfPersons(personsFileName);
			List<Person> personsByAge = new ArrayList<>(map.values());			
	 	    FileReaderUtility.mergeHobiesWithPersonsFiles(hobiesFileName,map);
	 		Collections.sort(personsByAge);
	 		return personsByAge;
		} catch (IOException e) {
			 // use slf4j logger - problem with ide .. 
		}
		return null;
	}

	@Override
	public void print(List<Person> list) {
		for(Person p:list) {
			// use slf4j logger here ..
			System.out.println(p);
		}
		
	}

}
