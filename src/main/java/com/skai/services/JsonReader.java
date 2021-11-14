package com.skai.services;

import java.util.List;

import com.skai.entities.Person;

/*
 * This is just an example for demonstrating of future extension of reading  files with other
 *   format
 */
public class JsonReader implements Reader<Person> {

	 
	@Override
	public List<Person> readAndConvertFile(String personsFileName, String hobiesFileName) {
		 
		return null;
	}

	@Override
	public void print(List<Person> list) {
		
		
	}

}
