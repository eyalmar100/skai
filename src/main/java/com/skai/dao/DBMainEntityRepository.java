package com.skai.dao;

import java.util.List;

/*
 * In real app we usually use some db , so we must have object that has access to it
 * this is for the 'main' file - with all the details
 */
public interface DBMainEntityRepository<T> {
	
	void save(T entity);
	List<T> sortByAgeAll();

}
