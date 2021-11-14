package com.skai.services;

import java.util.List;

/*
 * Usually we use interface for the api where it is 'injected' this interface 
 * to the caller - like in '@Autowire' in spring or any other DI framework
 * or even plain java - decouple the implementation of the interface from the caller/user 
 * of this interface 
 * 
 */
public interface Reader<T> {
	
	List<T> readAndConvertFile(String personsFileName,String hobiesFileName);
	void print(List<T> list);

}
