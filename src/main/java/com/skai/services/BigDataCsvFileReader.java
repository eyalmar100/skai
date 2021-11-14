package com.skai.services;

import java.util.List;

import com.skai.dao.DBMainEntityRepository;
import com.skai.dao.DBSecondaryRepository;
import com.skai.entities.Person;

/*
 * This is for reading large amount of csv files
 */
public class BigDataCsvFileReader implements Reader<Person> {

	private DBMainEntityRepository<Person> dbRepository;
	private DBSecondaryRepository<Person>  dbSecondaryRepository; 
	
	public BigDataCsvFileReader(DBMainEntityRepository<Person> repository, DBSecondaryRepository<Person>  dbSecondaryRepository) {
		this.dbRepository=repository;
		this.dbSecondaryRepository=dbSecondaryRepository;
	}
	
	/*
	 * read lines from  both tables in bulks according to memory constrains :
	 * read 
	 */
	@Override
	public List<Person> readAndConvertFile(String personsFileName, String hobiesFileName) {
		//make some process here
		// save to both 2 tables in db
		//dbRepository.save(mainEntiry);
		//dbSecondaryRepository.save(secondary);
		
		return null;
	}

	@Override
	public void print(List<Person> list) {
		// fetch all Persons from db and print
		List<Person> persons=dbRepository.sortByAgeAll();
		for(Person p:persons) {
			System.out.println(p);
		}
		 
		
	}

}
